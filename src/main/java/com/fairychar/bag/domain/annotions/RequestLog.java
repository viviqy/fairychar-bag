package com.fairychar.bag.domain.annotions;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/4/10 <br>
 * time: 16:29 <br>
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RequestLog {
    String value() default "";

    @AliasFor(value = "value")
    boolean enable() default true;

    Level loggingLevel() default Level.INFO;

    String beforeHandler() default "";

    String afterHandler() default "";

    String aroundHandler() default "";

    enum Level {
        TRACE(),
        DEBUG(),
        INFO(),
        ERROR();
    }

}
