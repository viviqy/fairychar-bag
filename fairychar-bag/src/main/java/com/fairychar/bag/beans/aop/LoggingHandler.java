package com.fairychar.bag.beans.aop;

import org.aspectj.lang.JoinPoint;

/**
 * <p>web request 日志处理</p>
 *
 * @author qiyue <br>
 */
public interface LoggingHandler {
    void accept(JoinPoint joinPoint);
}
