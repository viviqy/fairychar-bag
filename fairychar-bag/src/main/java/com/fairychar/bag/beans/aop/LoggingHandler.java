package com.fairychar.bag.beans.aop;

import org.aspectj.lang.JoinPoint;

/**
 * <p>web request 日志处理</p>
 *
 * @author qiyue
 */
public interface LoggingHandler {
    void before(JoinPoint joinPoint);

    void after(JoinPoint joinPoint, Object result);
}
