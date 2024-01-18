package com.fairychar.bag.domain.validator.rest;

import cn.hutool.core.util.IdcardUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Datetime: 2022/2/16 14:31
 *
 * @author chiyo
 * @since 1.0
 */
public class IdCardValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return IdcardUtil.isValidCard(value);
    }

}
