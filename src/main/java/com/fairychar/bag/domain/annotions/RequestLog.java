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
 * @since 1.0
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RequestLog {
    boolean value();

    @AliasFor(value = "value")
    boolean enable() default true;

    Level loggingLevel();

    String beforeHandler();

    String afterHandler();

    String aroudHandler();

    enum Level {
        TRACE(),
        DEBUG(),
        INFO(),
        ERROR();
    }

}
