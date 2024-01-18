package com.fairychar.bag.domain.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 基于ping指定host的Bean条件判断器,仅当host能ping成功的情况下才会初始化Bean
 *
 * @author chiyo
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(value = OnPingHostCondition.class)
public @interface ConditionalOnPingHost {
    /**
     * @return 主机地址
     */
    String host();

    /**
     * @return ping测结果
     */
    boolean result();

    /**
     * @return 超时时间(毫秒)
     */
    int timeout() default 1000;
}
