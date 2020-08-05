package com.fairychar.test.aop;

import com.fairychar.test.domain.LockTest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

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

    private Map<Method, ReentrantLock> lockMap = new ConcurrentHashMap<>(32);

    @Around("@annotation(lockTest)")
    public Object locking(JoinPoint joinPoint, LockTest lockTest) throws InterruptedException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        ReentrantLock reentrantLock = createOrGetLock(methodSignature.getMethod());
        System.out.println(Thread.currentThread().getName() + " lock : " + reentrantLock.hashCode());
        reentrantLock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + " method hashcode=" + methodSignature.getMethod().hashCode());
            proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return new Object();
    }

    @Around(value = "execution(public * com.fairychar.test.controller.*.*(..)) && args(String)")
    public Object controllerTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String file = (String) proceedingJoinPoint.getArgs()[0];
        log.info("aop切到了{}", file);
        return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
    }


    private ReentrantLock createOrGetLock(Method method) {
        ReentrantLock lock = lockMap.get(method);
        if (lock == null) {
            synchronized (method) {
                ReentrantLock lock1 = lockMap.get(method);
                if (lock1 != null) {
                    return lock1;
                } else {
                    ReentrantLock reentrantLock = new ReentrantLock();
                    lockMap.put(method, reentrantLock);
                    return reentrantLock;
                }
            }
        } else {
            return lock;
        }

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