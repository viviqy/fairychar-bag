package com.fairychar.bag.domain.annotions;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Datetime: 2021/6/24 17:43 <br>
 *
 * netty全局异常处理器
 * @author chiyo <br>
 * @since 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Component
public @interface NettyAdvice {
}
