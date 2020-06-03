package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.annotions.MethodLock;
import com.fairychar.bag.properties.FairycharBagProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Datetime: 2020/6/2 11:08 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Aspect
@EnableConfigurationProperties(FairycharBagProperties.class)
@Order
@Slf4j
public class MethodLockAspectJ implements InitializingBean {
    @Autowired
    private FairycharBagProperties fairycharBagProperties;
    private Map<Method, ReentrantLock> lockMap = new ConcurrentHashMap<>(32);

    @Around("@annotation(methodLock)")
    public Object locking(JoinPoint joinPoint, MethodLock methodLock) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        if (!methodLock.enable()) {
            return null;
        }
        return switchLock(methodSignature, methodLock, proceedingJoinPoint);
    }

    private Object switchLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodLock.Type lockType = methodLock.lockType() == MethodLock.Type.NONE ? fairycharBagProperties.getAop().getLock().getType() : methodLock.lockType();
        switch (lockType) {
            case LOCAL:
                return doLocalLock(methodSignature, methodLock, proceedingJoinPoint);
            case REDIS:
                return doRedisLock(methodSignature, methodLock, proceedingJoinPoint);
            case ZOOKEEPER:
                return doZookeeperLock(methodSignature, methodLock, proceedingJoinPoint);
            default:
                return null;
        }
    }

    private Object doZookeeperLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) {
        throw new NotImplementedException();
    }

    private Object doRedisLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) {
        throw new NotImplementedException();
    }

    private Object doLocalLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = methodSignature.getMethod();
        ReentrantLock reentrantLock = createOrGetLocalLock(method);
        if (methodLock.optimistic()) {
            int timeout = methodLock.timeout();
            try {
                reentrantLock.tryLock(timeout, TimeUnit.MILLISECONDS);
                return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            } catch (InterruptedException e) {
                throw e;
            } catch (Throwable throwable) {
                throw throwable;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            try {
                reentrantLock.lockInterruptibly();
                return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            } catch (InterruptedException e) {
                throw e;
            } catch (Throwable e) {
                throw e;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private ReentrantLock createOrGetLocalLock(Method method) {
        ReentrantLock result;
        ReentrantLock cache = lockMap.get(method);
        if (cache == null) {
            synchronized (method) {
                ReentrantLock cacheConfirm = lockMap.get(method);
                if (cacheConfirm != null) {
                    result = cacheConfirm;
                } else {
                    ReentrantLock reentrantLock = new ReentrantLock();
                    lockMap.put(method, reentrantLock);
                    result = reentrantLock;
                }
            }
        } else {
            result = cache;
        }
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(fairycharBagProperties.getAop().getLock().getType(), "全局方法锁不能为null");
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