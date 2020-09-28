package com.fairychar.bag.domain.annotions;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Datetime: 2020/6/2 10:37 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodLock {
    /**
     * <p>使用锁类型local=本地锁,redis=redis分布式锁,ZK=zookeeper分布式锁</p>
     * 默认为NONE,如果为NONE代表使用全局设置
     *
     * @return {@link Type}
     */
    Type lockType() default Type.NONE;

    /**
     * 使用启用
     *
     * @return 默认启用
     */
    boolean enable() default true;

    /**
     * 最大等待时间
     *
     * @return 超时时长
     */
    int timeout() default 0;

    /**
     * 是否使用乐观锁
     *
     * @return true=使用,false=不使用
     */
    boolean optimistic() default false;

    /**
     * 仅在乐观锁或分布式锁情况下使用
     *
     * @return {@link TimeUnit}
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    /**
     * 分布式锁节点名称
     *
     * @return 默认使用全路径类名+方法名+参数类型
     */
    String distributedPath() default "";


    enum Type {
        NONE(),
        LOCAL(),
        REDIS(),
        ZK();
    }
}
