package com.fairychar.bag.domain.validator.rest;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Datetime: 2022/2/16 14:32 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdCardValidator.class)
public @interface MustIdCard {

    String message() default "not id card number";

    Class<?>[] groups() default {};
}
