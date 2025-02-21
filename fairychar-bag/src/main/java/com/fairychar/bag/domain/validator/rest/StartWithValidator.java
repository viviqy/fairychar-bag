package com.fairychar.bag.domain.validator.rest;

import com.fairychar.bag.domain.exceptions.FBException;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.google.common.base.Strings;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chiyo
 * @since 1.0.2
 */
@Slf4j
public class StartWithValidator implements ConstraintValidator<StartWith, Object> {
    private StartWith annotation;

    @Override
    public void initialize(StartWith constraintAnnotation) {
        String[] value = constraintAnnotation.value();
        if (value == null || value.length == 0) {
            log.error("StartWith validator value is empty");
            throw new FBException(RestErrorCode.SYSTEM_ERROR.getCode(), RestErrorCode.SYSTEM_ERROR.getMessage());
        }
        for (String item : value) {
            if (Strings.isNullOrEmpty(item)) {
                log.error("StartWith validator contains empty item");
                throw new FBException(RestErrorCode.SYSTEM_ERROR.getCode(), RestErrorCode.SYSTEM_ERROR.getMessage());
            }
        }
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String text = String.valueOf(value);
        if (Strings.isNullOrEmpty(text)) {
            return false;
        }
        String[] textArray = annotation.value();
        if (annotation.ignoreCase()) {
            text = text.toLowerCase();
            for (String item : textArray) {
                if (text.startsWith(item.toLowerCase())) {
                    return true;
                }
            }
        } else {
            for (String item : textArray) {
                if (text.startsWith(item)) {
                    return true;
                }
            }
        }
        return false;
    }

}
