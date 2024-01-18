package com.fairychar.bag.domain.validator.rest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 语言验证程序
 *
 * @author chiyo
 * @since 1.0.2
 */
public class LanguageValidator implements ConstraintValidator<Language, String> {

    private Language.LanguageType languageType;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regex = languageType.getRegex();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    @Override
    public void initialize(Language constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.languageType = constraintAnnotation.value();
    }
}
