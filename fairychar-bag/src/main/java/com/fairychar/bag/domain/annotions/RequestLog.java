package com.fairychar.bag.domain.annotions;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/4/10 <br>
 * time: 16:29 <br>
 * <br>
 * <p>接口请求日志拦截</p>
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

    /**
     * @return 全局日志级别
     */
    Level loggingLevel() default Level.NONE;

    /**
     * 日志前置处理器{@link com.fairychar.bag.beans.aop.LoggingHandler}的实现类bean
     *
     * @return loggingHandler bean name
     */
    String beforeHandler() default "";

    /**
     * 日志后置处理器{@link com.fairychar.bag.beans.aop.LoggingHandler}的实现类bean
     *
     * @return loggingHandler bean name
     */
    String afterHandler() default "";


    enum Level {
        NONE(),
        TRACE(),
        DEBUG(),
        INFO(),
        WARN(),
        ERROR();
    }

}
