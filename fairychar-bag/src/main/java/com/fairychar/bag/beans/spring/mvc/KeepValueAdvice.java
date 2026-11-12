package com.fairychar.bag.beans.spring.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.reflect.Field;

/**
 * <p>{@link KeepValue}处理解析器</p>
 *
 * @author chiyo
 * @since 1.0.2
 */
@ControllerAdvice
public class KeepValueAdvice extends PropertyValueAdvice<KeepValue> {

    public KeepValueAdvice() {
        super(KeepValue.class);
    }

    @Override
    protected void handle(Object body, Field objectField, KeepValue propertyAnnotation, KeepValue parameterAnnotation) {
        if (!matchesGroups(propertyAnnotation.value(), parameterAnnotation.value())) {
            super.eraseValue(body, objectField);
        }
    }

    @Override
    protected void handleUnannotatedField(Object body, Field objectField) {
        super.eraseValue(body, objectField);
    }
}
