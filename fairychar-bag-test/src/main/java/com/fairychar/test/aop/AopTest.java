package com.fairychar.test.aop;

import com.fairychar.test.domain.LockTest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Datetime: 2020/6/2 16:23 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Component
@Aspect
@Slf4j
public class AopTest {

    @Around("@annotation(lockTest)")
    public Object locking(JoinPoint joinPoint, LockTest lockTest) throws InterruptedException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        synchronized (methodSignature.getMethod()) {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName()+ " method hashcode=" + methodSignature.getMethod().hashCode());
        }
        return new Object();
    }

}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/