package com.fairychar.bag.domain.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 基于系统的Bean条件判断器,仅当当前运行系统匹配时才会初始化Bean
 *
 * @author chiyo
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(OnSystemOsCondition.class)
public @interface ConditionalOnSystemOS {
    /**
     * @return 系统类型
     */
    OS os();

    /**
     * @return 是否匹配
     */
    boolean condition();

    enum OS {
        Windows(), Linux(), MacOSX(),
        ;
    }
}
