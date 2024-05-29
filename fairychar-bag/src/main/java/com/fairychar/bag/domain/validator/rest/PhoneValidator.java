package com.fairychar.bag.domain.validator.rest;

import cn.hutool.core.util.PhoneUtil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Datetime: 2022/2/16 14:31
 *
 * @author chiyo
 * @since 1.0
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return PhoneUtil.isPhone(value);
    }

}
