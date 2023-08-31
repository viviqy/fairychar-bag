package com.fairychar.bag.beans.spring.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashSet;

/**
 * <p>{@link EraseValue}请求解析器</p>
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@ControllerAdvice
public class EraseValueAdvice extends PropertyValueAdvice<EraseValue> {
    @Override
    protected void handle(Object body, Field objectField, EraseValue propertyAnnotation, EraseValue parameterAnnotation) {
        Class<?>[] propertyGroups = propertyAnnotation.groups();
        Class<?>[] parameterGroups = parameterAnnotation.groups();
        int totalLength = propertyGroups.length + parameterGroups.length;
        HashSet<Object> set = new HashSet<>(totalLength);
        for (Class<?> propertyGroup : propertyGroups) {
            set.add(propertyGroup);
        }
        for (Class<?> parameterGroup : parameterGroups) {
            set.add(parameterGroup);
        }
        //至少包含group之一
        if (set.size() > 0 && set.size() < (totalLength)) {
            //erase value
            super.eraseValue(body, objectField);
        } else {
        }
    }
}
