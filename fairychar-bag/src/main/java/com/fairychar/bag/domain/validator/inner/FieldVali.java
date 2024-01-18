package com.fairychar.bag.domain.validator.inner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 没啥用,移除了
 *
 * @author chiyo
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface FieldVali {

    Class<?>[] groups() default {};


    int order() default 0;
}
