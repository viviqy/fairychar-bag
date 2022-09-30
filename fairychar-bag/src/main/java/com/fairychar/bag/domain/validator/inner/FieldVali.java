package com.fairychar.bag.domain.validator.inner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Datetime: 2022/3/30 01:43 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldVali {

    Class<?>[] groups() default {};


    int order() default 0;
}
