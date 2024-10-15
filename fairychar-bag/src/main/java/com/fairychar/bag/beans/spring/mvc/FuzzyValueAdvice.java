package com.fairychar.bag.beans.spring.mvc;

import cn.hutool.core.collection.CollectionUtil;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.utils.ReflectUtil;
import com.fairychar.bag.utils.base.FieldContainer;
import com.google.common.base.Strings;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
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
import java.util.Stack;

/**
 * 脱敏注解{@link FuzzyResult},{@link FuzzyValue},在接口响应参数返回中的具体解析实现
 *
 * @author chiyo
 * @since 3.0.1
 */
@ControllerAdvice
@Order(100)
public class FuzzyValueAdvice implements ResponseBodyAdvice<Object> {
    @Override
    @SuppressFBWarnings(value = "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        FuzzyResult fuzzyResult = returnType.getMethod() != null ? returnType.getMethod().getAnnotation(FuzzyResult.class) : null;
        return fuzzyResult != null;
    }

    @Override
    @SuppressFBWarnings(value = "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType
            , Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null) {
            return null;
        }
        FuzzyResult fuzzyResult = returnType.getMethod().getAnnotation(FuzzyResult.class);
        Object analyzeObject = body;
        String fieldWrapper = fuzzyResult.field();
        if (!Strings.isNullOrEmpty(fieldWrapper)) {
            //如果是嵌套字段,解析嵌套字段对应的值
            String[] tree = fieldWrapper.split("\\.");
            Stack<FieldContainer> paramStack = new Stack<>();
            paramStack.push(new FieldContainer(body, null, null));
            try {
                for (String child : tree) {
                    Field childField = analyzeObject.getClass().getDeclaredField(child);
                    childField.setAccessible(true);
                    Object nodeObject = childField.get(analyzeObject);
                    paramStack.add(new FieldContainer(analyzeObject, childField, null));
                    analyzeObject = nodeObject;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            //预先处理如果字段类型是String,List,Map的字段,如果为这3类字段则直接渲染,无需在走下面的查找对象注解流程解析
            Object preProcessedBody = this.preProcess(body, analyzeObject, paramStack);
            if (preProcessedBody != null) {
                //不为null代表当前字段为String,List,Map字段,直接返回渲染后的值
                return preProcessedBody;
            }
        }

        //查找对象字段注解流程
        Map<Class<? extends Annotation>, List<FieldContainer>> containerMap =
                ReflectUtil.recursiveSearchFieldValueByAnnotations(analyzeObject, Arrays.asList(FuzzyValue.class));
        List<FieldContainer> fieldContainers = containerMap.get(FuzzyValue.class);
        if (!CollectionUtil.isEmpty(fieldContainers)) {
            for (FieldContainer fieldContainer : fieldContainers) {
                Field currentField = fieldContainer.getField();
                if (currentField.getType() == String.class) {
                    //处理字段类型为String的
                    wrapProperty(fieldContainer);
                } else if (currentField.getType() == List.class
                        || Arrays.asList(currentField.getType().getInterfaces()).stream().anyMatch(c -> c == List.class)) {
                    //处理是List类型
                    List list = null;
                    try {
                        list = (List) currentField.get(fieldContainer.getTargetObject());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    FuzzyValue fuzzyValue = currentField.getAnnotation(FuzzyValue.class);
                    processList(list, fuzzyValue);
                } else if (currentField.getType() == Map.class
                        || Arrays.asList(currentField.getType().getInterfaces()).stream().anyMatch(c -> c == Map.class)) {
                    //处理是Map类型
                    Map map = null;
                    try {
                        map = (Map) currentField.get(fieldContainer.getTargetObject());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    FuzzyValue fuzzyValue = currentField.getAnnotation(FuzzyValue.class);
                    this.processMap(map, fuzzyValue);
                }
            }
        }
        return body;
    }

    /**
     * 预处理字段类型为String,List,Map的字段,这类字段直接解析
     *
     * @param body          身体
     * @param analyzeObject 分析对象
     * @param paramStack    参数堆栈
     * @return {@code Object }
     */
    private Object preProcess(Object body, Object analyzeObject, Stack<FieldContainer> paramStack) {
        FieldContainer current = paramStack.pop();
        Field currentField = current.getField();
        currentField.setAccessible(true);
        FuzzyValue fuzzyValue = currentField.getAnnotation(FuzzyValue.class);
        if (fuzzyValue == null) {
            return body;
        }
        if (analyzeObject.getClass() == String.class) {
            this.wrapProperty(current);
            return body;
        } else if (analyzeObject instanceof List analyzeObjectList) {
            processList(analyzeObjectList, fuzzyValue);
        } else if (analyzeObject instanceof Map analyzeObjectMap) {
            processMap(analyzeObjectMap, fuzzyValue);
        }
        return null;
    }

    /**
     * 处理Map内value仅仅为String.class的item
     *
     * @param map        地图
     * @param fuzzyValue 模糊值
     */
    private void processMap(Map<Object, Object> map, FuzzyValue fuzzyValue) {
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                String replaceText = this.processText(fuzzyValue, (String) value);
                entry.setValue(replaceText);
            }
        }
    }

    /**
     * <p>处理List内item仅仅为String.class的item</p>
     *
     * @param list       列表
     * @param fuzzyValue 模糊值
     */
    private void processList(List list, FuzzyValue fuzzyValue) {
        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            if (item.getClass() == String.class) {
                String replaceText = this.processText(fuzzyValue, String.valueOf(item));
                list.set(i, replaceText);
            }
        }
    }

    private void wrapProperty(FieldContainer fieldContainer) {
        Field field = fieldContainer.getField();//accessible yet
        FuzzyValue fuzzyValue = field.getAnnotation(FuzzyValue.class);
        String sourceText = null;
        String replaceText;
        try {
            sourceText = (String) field.get(fieldContainer.getTargetObject());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        replaceText = this.processText(fuzzyValue, sourceText);
        try {
            field.set(fieldContainer.getTargetObject(), replaceText);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析脱敏文本
     *
     * @param fuzzyValue 模糊值
     * @param sourceText 源文本
     * @return {@code String }
     */
    private String processText(FuzzyValue fuzzyValue, String sourceText) {
        String replaceText;
        if (fuzzyValue.processor().length == 0) {
            String middle = Strings.repeat(fuzzyValue.replaceSymbol(), fuzzyValue.endAt() - fuzzyValue.beginAt());
            replaceText = sourceText.substring(0, fuzzyValue.beginAt())
                    .concat(middle)
                    .concat(sourceText.substring(fuzzyValue.endAt(), sourceText.length()));
        } else {
            FuzzyValueProcessor fuzzyValueProcessor = SpringContextHolder.getInstance().getBean(fuzzyValue.processor()[0]);
            replaceText = fuzzyValueProcessor.fuzzyValue(sourceText, fuzzyValue);
        }
        return replaceText;
    }
}
