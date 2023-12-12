package com.fairychar.bag.domain.annotations;

import io.netty.channel.ChannelHandler;

import java.lang.annotation.*;

/**
 * netty指定异常拦截器,配合{@link NettyCauseAdvice}使用
 * <p>
 * 使用方式和{@link org.springframework.web.bind.annotation.ExceptionHandler}一样
 *
 * @author chiyo <br>
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CauseHandler {
    /**
     * 拦截异常类
     *
     * @return
     */
    Class<? extends Throwable> value();

    /**
     * 标识抛出异常的handler类
     *
     * @return
     */
    Class<? extends ChannelHandler> handler() default ChannelHandler.class;

    /**
     * 标识最先抛出异常的方法名称
     *
     * @return
     */
    String methodName() default "";

}
