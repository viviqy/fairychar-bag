package com.fairychar.bag.domain.validator.rest;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Datetime: 2022/2/16 14:32
 *
 * @author chiyo
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    String message() default "not phone number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
