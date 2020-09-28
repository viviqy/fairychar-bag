package com.fairychar.bag.domain.conditional;

import com.fairychar.bag.beans.conditional.OnPingHostCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Datetime: 2020/9/28 17:09 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(value = OnPingHostCondition.class)
public @interface ConditionalOnPingHost {
    /**
     * @return 主机地址
     */
    String host();

    /**
     * @return ping测结果
     */
    boolean result();

    /**
     * @return 超时时间(毫秒)
     */
    int timeout() default 1000;
}
