package com.fairychar.bag.domain.validator.rest;

import com.fairychar.bag.domain.validator.rest.abstracts.AbstractPatternValidator;

import javax.validation.ConstraintValidatorContext;

/**
 * 语言验证程序
 *
 * @author chiyo
 * @since 1.0.2
 */
public class LanguageValidator extends AbstractPatternValidator<Language, String> {

    private Language.LanguageType languageType;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regex = languageType.getRegex();
        return super.match(regex, value);
    }

    @Override
    public void initialize(Language constraintAnnotation) {
        super.initialize(constraintAnnotation);
        this.languageType = constraintAnnotation.value();
    }
}
