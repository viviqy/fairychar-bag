package com.fairychar.bag.domain.validator.rest;

import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.domain.validator.rest.abstracts.AbstractPatternValidator;

import jakarta.validation.ConstraintValidatorContext;

/**
 * IP 验证器
 *
 * @author chiyo
 * @since 1.0.2
 */
public class IpValidator extends AbstractPatternValidator<IP, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return super.match(Consts.Regex.IP, value);
    }
}
