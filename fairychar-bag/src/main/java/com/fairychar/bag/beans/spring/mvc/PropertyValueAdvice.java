package com.fairychar.bag.beans.spring.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * http请求体property代理解析器
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@Slf4j
public abstract class PropertyValueAdvice<T extends Annotation> extends RequestBodyAdviceAdapter {
    private final static String SETTER_METHOD_NAME = "set";

    protected Class<T> annotation;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasParameterAnnotation(annotation);
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        Field[] objectFields = body.getClass().getDeclaredFields();
        for (int i = 0; i < objectFields.length; i++) {
            Field objectField = objectFields[i];
            T propertyAnnotation = objectField.getAnnotation(annotation);
            if (propertyAnnotation != null) {
                handle(body, objectField, propertyAnnotation, parameter.getParameterAnnotation(annotation));
            }
        }
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    protected abstract void handle(Object body, Field objectField, T propertyAnnotation, T parameterAnnotation);


    protected void eraseValue(Object body, Field objectField) {
        String objectFieldName = objectField.getName();
        String firstWordToUpperCase = objectFieldName.indexOf(0) + objectFieldName.substring(0, objectFieldName.length() - 1);
        try {
            Method setter = body.getClass().getMethod(SETTER_METHOD_NAME + firstWordToUpperCase);
            if (setter != null && setter.isAccessible()) {
                //setter方法赋值
                setter.invoke(body, null);
            } else {
                //field赋值
                objectField.set(body, objectField);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.warn("erase property value failed,field={},obj={}", objectFieldName,body);
        }
    }

}
