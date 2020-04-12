package com.fairychar.bag.domain.aop;

import org.aspectj.lang.JoinPoint;

/**
 * Created with IDEA <br>
 * User: qiyue <br>
 * Date: 2020/04/12 <br>
 * time: 21:25 <br>
 *
 * @author qiyue <br>
 */
public interface LoggingHandler {
    void then(JoinPoint joinPoint);
}
