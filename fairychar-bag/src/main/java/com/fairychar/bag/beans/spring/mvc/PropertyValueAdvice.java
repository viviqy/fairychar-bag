package com.fairychar.bag.beans.spring.mvc;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * http请求体property代理解析器
 *
 * @author chiyo
 * @since 1.0.2
 */
@Slf4j
@AllArgsConstructor
public abstract class PropertyValueAdvice<T extends Annotation> extends RequestBodyAdviceAdapter {


    protected Class<T> annotation;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasParameterAnnotation(annotation);
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter
            , Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        Field[] objectFields = body.getClass().getDeclaredFields();
        for (int i = 0; i < objectFields.length; i++) {
            Field objectField = objectFields[i];
            if (Modifier.isStatic(objectField.getModifiers()) || Modifier.isFinal(objectField.getModifiers())) {
                continue;
            }
            T propertyAnnotation = objectField.getAnnotation(annotation);
            if (propertyAnnotation != null) {
                handle(body, objectField, propertyAnnotation, parameter.getParameterAnnotation(annotation));
            } else {
                handleUnannotatedField(body, objectField);
            }
        }
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    protected abstract void handle(Object body, Field objectField, T propertyAnnotation, T parameterAnnotation);

    protected void handleUnannotatedField(Object body, Field objectField) {
    }

    protected boolean matchesGroups(Class<?>[] propertyGroups, Class<?>[] parameterGroups) {
        if (propertyGroups.length == 0 && parameterGroups.length == 0) {
            return true;
        }
        for (Class<?> propertyGroup : propertyGroups) {
            for (Class<?> parameterGroup : parameterGroups) {
                if (propertyGroup == parameterGroup) {
                    return true;
                }
            }
        }
        return false;
    }


    protected void eraseValue(Object body, Field objectField) {
        String objectFieldName = objectField.getName();
        try {
            //field赋值
            objectField.setAccessible(true);
            Object defaultValue = objectField.getType().isPrimitive()
                    ? Array.get(Array.newInstance(objectField.getType(), 1), 0) : null;
            objectField.set(body, defaultValue);
        } catch (IllegalAccessException e) {
            log.warn("erase property value failed,field={},obj={}", objectFieldName, body);
        }
    }

}
