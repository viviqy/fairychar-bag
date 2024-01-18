package com.fairychar.bag.domain.validator.rest;

import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.domain.validator.rest.abstracts.AbstractPatternValidator;

import javax.validation.ConstraintValidatorContext;

/**
 * URL 验证器
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
public class UrlValidator extends AbstractPatternValidator<Url, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return super.match(Consts.Regex.URL, value);
    }
}
