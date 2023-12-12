package com.fairychar.bag.domain.annotations;

import java.lang.annotation.*;

/**
 * <p>netty指定事件拦截器</p>
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
