package com.fairychar.bag.domain.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Created with IDEA
 * User: LMQ
 * Date: 2019/04/03
 * time: 15:54
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
        Windows(), Linux(), MacOSX(), IOS();
    }
}
