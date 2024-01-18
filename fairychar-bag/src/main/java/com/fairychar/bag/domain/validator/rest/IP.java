package com.fairychar.bag.domain.validator.rest;

import javax.validation.Constraint;
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
@Constraint(validatedBy = IpValidator.class)
public @interface IP {
    String value() default "";

    String message() default "not ip address";

    Class<?>[] groups() default {};
}
