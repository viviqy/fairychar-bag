package com.fairychar.test.domain;

import java.lang.annotation.*;

/**
 * Datetime: 2020/6/2 16:24 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface LockTest {
}
