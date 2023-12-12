package com.fairychar.bag.domain.annotations;

import java.lang.annotation.*;

/**
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

    boolean enable() default true;

    /**
     * @return Level.NONE=使用全局日志级别
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
