package com.fairychar.bag.domain.annotions;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Date: 2021/06/24 <br>
 * time: 21:31 <br>
 *
 * 使用方式和{@link org.springframework.web.bind.annotation.ExceptionHandler}一样
 * @author chiyo <br>
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Component
public @interface CauseHandler {
    /**
     * 拦截异常类
     * @return
     */
    Class value();

    /**
     * 标识抛出异常的handler类
     * @return
     */
    Class handler() default Void.class;

    /**
     * 标识最先抛出异常的方法名称
     * @return
     */
    String methodName() default "";

    /**
     * 标识最先抛出异常的方法的参数类型(区分重载)
     * @return
     */
    Class[] args() default {Void.class};
}
