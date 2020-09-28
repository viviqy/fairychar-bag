package com.fairychar.bag.domain.conditional;

import com.fairychar.bag.beans.conditional.OnDateTimeCondition;
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
public @interface ConditionalOnSystemOS {
    OS os();

    boolean condition();

    enum OS {
        Windows(), Linux(), MacOSX(), IOS();
    }
}
