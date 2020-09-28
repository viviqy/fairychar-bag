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
@Conditional(OnDateTimeCondition.class)
public @interface ConditionalOnDateTime {
    String lower();

    String upper();

    String pattern() default "yyyy-MM-dd HH:mm:ss";
}
