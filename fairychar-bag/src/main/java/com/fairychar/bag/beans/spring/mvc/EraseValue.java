package com.fairychar.bag.beans.spring.mvc;

import java.lang.annotation.*;

/**
 * spring mvc 请求参数property抹除值
 * @author chiyo <br>
 * @since 1.0.2
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface EraseValue {

    Class<?>[] groups() default {};


}
