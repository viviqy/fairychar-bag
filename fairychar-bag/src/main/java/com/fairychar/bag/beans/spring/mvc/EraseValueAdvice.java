package com.fairychar.bag.beans.spring.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.reflect.Field;

/**
 * <p>{@link EraseValue}请求解析器</p>
 *
 * @author chiyo
 * @since 1.0.2
 */
@ControllerAdvice
public class EraseValueAdvice extends PropertyValueAdvice<EraseValue> {
    public EraseValueAdvice() {
        super(EraseValue.class);
    }

    @Override
    protected void handle(Object body, Field objectField, EraseValue propertyAnnotation, EraseValue parameterAnnotation) {
        if (matchesGroups(propertyAnnotation.value(), parameterAnnotation.value())) {
            super.eraseValue(body, objectField);
        }
    }
}
