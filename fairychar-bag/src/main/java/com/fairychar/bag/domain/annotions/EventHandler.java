package com.fairychar.bag.domain.annotions;

import java.lang.annotation.*;

/**
 * Datetime: 2021/7/8 17:44 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface EventHandler {
    Class value() default Void.class;
}
