package com.fairychar.bag.domain.annotions;

import java.lang.annotation.*;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2020/4/10 <br>
 * time: 16:01 <br>
 *
 * @author lmq <br>
 * @since 1.0
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BindingCheck {
    boolean value() default true;
}
