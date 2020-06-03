package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.annotions.MethodLock;
import com.fairychar.bag.properties.FairycharBagProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
    public Object locking(JoinPoint joinPoint, MethodLock methodLock) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (!methodLock.enable()) {
            return null;
        }
        return switchLock(methodSignature, methodLock);
    }

    private Object switchLock(MethodSignature methodSignature, MethodLock methodLock) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        MethodLock.Type lockType = methodLock.lockType() == MethodLock.Type.NONE ? fairycharBagProperties.getAop().getLock().getType() : methodLock.lockType();
        switch (lockType) {
            case NONE:
                break;
            case LOCAL: {
                return doLocalLock(methodSignature, methodLock);
            }
            case REDIS:
                break;
            case ZOOKEEPER:
                break;
        }
        return null;
    }

    private Object doLocalLock(MethodSignature methodSignature, MethodLock methodLock) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        Method method = methodSignature.getMethod();
        ReentrantLock reentrantLock = createOrGetLocalLock(method);
        reentrantLock.lockInterruptibly();
        try {
            Object invoke = method.invoke(method.getParameters());
            return invoke;
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("method invocation failed {}", e.getMessage());
            throw e;
        } finally {
            reentrantLock.unlock();
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