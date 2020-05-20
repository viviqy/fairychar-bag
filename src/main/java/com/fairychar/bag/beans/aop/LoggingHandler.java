package com.fairychar.bag.beans.aop;

import org.aspectj.lang.JoinPoint;

/**
 * Created with IDEA <br>
 * User: qiyue <br>
 * Date: 2020/04/12 <br>
 * time: 21:25 <br>
 * <br>
 * <p>web request 日志处理</p>
 * @author qiyue <br>
 */
public interface LoggingHandler {
    void then(JoinPoint joinPoint);
}
