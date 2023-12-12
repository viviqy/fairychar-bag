package com.fairychar.bag.domain.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 基于系统参数的Bean条件判断器,仅当系统参数对应值相同时才会配置Bean
 *
 * @author chiyo
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    String name() default "";

    String value() default "";
}
