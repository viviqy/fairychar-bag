package com.fairychar.bag.domain.validator.rest;

import jakarta.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chiyo
 * @since 1.0.2
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InValidator.class)
public @interface NotIn {
    String[] value() default {};

    String message() default "not in array";

    Class<?>[] groups() default {};
}
