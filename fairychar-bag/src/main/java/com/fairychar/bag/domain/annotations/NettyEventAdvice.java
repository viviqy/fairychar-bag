package com.fairychar.bag.domain.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Datetime: 2021/6/24 17:43 <br>
 * <p>
 * netty全局异常处理器,配合{@link EventHandler}使用
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Component
public @interface NettyEventAdvice {
}
