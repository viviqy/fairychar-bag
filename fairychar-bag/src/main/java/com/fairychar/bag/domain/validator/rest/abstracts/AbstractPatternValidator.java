package com.fairychar.bag.domain.validator.rest.abstracts;

import javax.validation.ConstraintValidator;
import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 抽象模式验证器
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
public abstract class AbstractPatternValidator<A extends Annotation, T> implements ConstraintValidator<A, T> {


    protected boolean match(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
