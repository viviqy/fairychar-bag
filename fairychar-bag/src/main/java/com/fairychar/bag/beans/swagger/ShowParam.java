package com.fairychar.bag.beans.swagger;

import java.lang.annotation.*;

/**
 * @author chiyo <br>
 * @since 1.0.2
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ShowParam {

    Class[] value() default {};
}
