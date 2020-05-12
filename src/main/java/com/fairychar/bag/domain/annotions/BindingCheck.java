package com.fairychar.bag.domain.annotions;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/4/10 <br>
 * time: 16:01 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BindingCheck {
    String value() default "";

    @AliasFor("value")
    boolean enable() default true;
}
