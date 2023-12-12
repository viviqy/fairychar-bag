package com.fairychar.bag.beans.spring.mvc;

import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.utils.ReflectUtil;
import com.fairychar.bag.utils.base.FieldContainer;
import com.google.common.base.Strings;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 脱敏注解{@link FuzzyResult},{@link FuzzyValue},在接口响应参数返回中的具体解析实现
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@ControllerAdvice
public class FuzzyValueAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getMethod().getAnnotation(FuzzyResult.class) != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        FuzzyResult fuzzyResult = methodParameter.getMethod().getAnnotation(FuzzyResult.class);
        Object analyzeObject = o;
        String fieldWrapper = fuzzyResult.field();
        if (!fieldWrapper.isEmpty()) {
            String[] tree = fieldWrapper.split("\\.");
            try {
                for (String child : tree) {
                    Field childField = analyzeObject.getClass().getDeclaredField(child);
                    childField.setAccessible(true);
                    analyzeObject = childField.get(analyzeObject);
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        Map<Class<? extends Annotation>, List<FieldContainer>> containerMap = ReflectUtil.recursiveSearchFieldValueByAnnotations(analyzeObject, Arrays.asList(FuzzyValue.class));
        List<FieldContainer> fieldContainers = containerMap.get(FuzzyValue.class);
        if (!fieldContainers.isEmpty()) {
            for (FieldContainer fieldContainer : fieldContainers) {
                if (fieldContainer.getField().getType() == String.class) {
                    wrapProperty(fieldContainer);
                }
            }
        }
        return o;
    }

    private void wrapProperty(FieldContainer fieldContainer) {
        Field field = fieldContainer.getField();//accessible yet
        FuzzyValue fuzzyValue = field.getAnnotation(FuzzyValue.class);
        String sourceText = null;
        String replaceText;
        try {
            sourceText = (String) field.get(fieldContainer.getSourceObject());
        } catch (IllegalAccessException ignore) {
        }
        if (fuzzyValue.processor().length == 0) {
            String middle = Strings.repeat(fuzzyValue.replaceSymbol(), fuzzyValue.endAt() - fuzzyValue.beginAt());
            replaceText = sourceText.substring(0, fuzzyValue.beginAt())
                    .concat(middle)
                    .concat(sourceText.substring(fuzzyValue.endAt(), sourceText.length()));
        } else {
            FuzzyValueProcessor fuzzyValueProcessor = SpringContextHolder.getInstance().getBean(fuzzyValue.processor()[0]);
            replaceText = fuzzyValueProcessor.fuzzyValue(sourceText);
        }
        try {
            field.set(fieldContainer.getSourceObject(), replaceText);
        } catch (IllegalAccessException ignore) {
        }
    }
}
