package com.fairychar.bag.domain.annotations;

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
     * 默认为DEFAULT,如果为DEFAULT代表使用全局设置
     *
     * @return {@link Type}
     */
    Type lockType() default Type.DEFAULT;

    /**
     * 使用启用
     *
     * @return 默认启用
     */
    boolean enable() default true;

    /**
     * 最大等待时间,-1为使用全局设置
     *
     * @return 超时时长
     */
    int timeout() default -1;

    /**
     * 是否使用乐观锁
     *
     * @return true=使用,false=不使用
     */
    boolean optimistic() default false;

    /**
     * 仅在乐观锁或分布式锁情况下使用,TimeUnit.NANOSECONDS为使用全局默认(应该不会有纳秒锁的业务)
     *
     * @return {@link TimeUnit}
     */
    TimeUnit timeUnit() default TimeUnit.NANOSECONDS;

    /**
     * 本地锁名称或者分布式锁节点名称,Spel表达式
     *
     * @return 分布式锁情况下默认使用全路径类名+方法名+参数类型,本地锁情况下指定则优先根据此值获取锁
     */
    String nameExpression() default "";


    /**
     * 分布式节点前缀
     *
     * @return 默认为<Strong>fairychar:lock:</Strong>
     */
    String distributedPrefix() default "fairychar:lock:";

    enum Type {
        DEFAULT(),
        LOCAL(),
        REDIS(),
        ZK()
    }
}
