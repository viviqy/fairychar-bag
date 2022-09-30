package com.fairychar.bag.domain.validator.rest;

import cn.hutool.core.util.PhoneUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Datetime: 2022/2/16 14:31 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class PhoneValidator implements ConstraintValidator<MustPhone, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return PhoneUtil.isPhone(value);
    }

}
