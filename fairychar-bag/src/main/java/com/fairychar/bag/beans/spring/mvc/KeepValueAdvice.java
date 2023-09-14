package com.fairychar.bag.beans.spring.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashSet;

/**
 * <p>{@link KeepValue}处理解析器</p>
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@ControllerAdvice
public class KeepValueAdvice extends PropertyValueAdvice<KeepValue> {
    @Override
    protected void handle(Object body, Field objectField, KeepValue propertyAnnotation, KeepValue parameterAnnotation) {
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
            //keep value
        } else {
            super.eraseValue(body, objectField);
        }
    }
}
