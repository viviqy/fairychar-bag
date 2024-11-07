package com.fairychar.bag.domain.validator.rest;

import com.fairychar.bag.domain.Consts;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日期范围校验
 *
 * @author chiyo
 * @since 1.3.2
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeValidator.class)
public @interface TimeBetween {

    String message() default "time not in range";


    /**
     * 匹配方式
     *
     * @return {@link String }
     */
    String pattern() default Consts.SIMPLE_DATETIME_FORMAT;

    /**
     * 最小时间,now代表当前时间
     *
     * @return {@link String }
     */
    String min() default "1976-01-01 00:00:01";

    /**
     * 最大时间,now代表当前时间
     *
     * @return {@link String }
     */
    String max() default "2099-12-31 23:59:59";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
