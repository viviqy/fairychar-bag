package com.fairychar.bag.domain.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 基于时间的Bean条件判断器,仅当当前时间在区间内的情况下Bean才会初始化
 *
 * @author chiyo
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(OnDateTimeCondition.class)
public @interface ConditionalOnDateTime {
    /**
     * 开始时间
     *
     * @return {@link String}
     */
    String lower();

    /**
     * 结束时间
     *
     * @return {@link String}
     */
    String upper();

    /**
     * 时间格式
     *
     * @return {@link String}
     */
    String pattern() default "yyyy-MM-dd HH:mm:ss";
}
