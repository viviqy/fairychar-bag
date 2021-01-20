package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.annotions.MethodLock;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.fairychar.bag.template.CacheOperateTemplate;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
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
        MethodLock.Type lockType = methodLock.lockType() == MethodLock.Type.DEFAULT ? fairycharBagProperties.getAop().getLock().getType() : methodLock.lockType();
        switch (lockType) {
            case LOCAL:
                return doLocalLock(methodSignature, methodLock, proceedingJoinPoint);
            case REDIS:
                return doRedisLock(methodSignature, methodLock, proceedingJoinPoint);
            case ZK:
                return doZookeeperLock(methodSignature, methodLock, proceedingJoinPoint);
            default:
                return null;
        }
    }

    private Object doZookeeperLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) {
        throw new NotImplementedException();
    }

    private Object doRedisLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Assert.notNull(methodLock.distributedPath(), "节点路径不能为null");
        Assert.notNull(methodLock.distributedPrefix(), "节点路径前缀不能为null");
        Redisson redisson = SpringContextHolder.getInstance().getBean(Redisson.class);
        Method method = methodSignature.getMethod();
        RLock redissonLock = redisson.getLock(methodLock.distributedPrefix().concat(!Strings.isNullOrEmpty(methodLock.distributedPath())
                ? methodLock.distributedPath() : getMethodFullPath(method)));
        if (methodLock.optimistic()) {
            try {
                if (redissonLock.tryLock(methodLock.timeout(), methodLock.timeUnit())) {
                    return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
                } else {
                    throw new TimeoutException();
                }
            } catch (InterruptedException | TimeoutException e) {
                throw e;
            } catch (Throwable throwable) {
                throw throwable;
            } finally {
                redissonLock.unlock();
            }
        } else {
            try {
                redissonLock.lock();
                return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            } catch (Exception e) {
                throw e;
            } finally {
                redissonLock.unlock();
            }
        }
    }

    private String getMethodFullPath(Method method) {
        String methodName = method.getDeclaringClass().getName()
                .concat(method.getName());
        String returnName = method.getReturnType().getName();
        String parameterName = "";
        for (Class<?> parameterType : method.getParameterTypes()) {
            parameterName = parameterName.concat(parameterType.getName()).concat(",");
        }
        return methodName.concat(":").concat(returnName).concat(":").concat(parameterName.substring(0, parameterName.length() - 1));
    }

    private Object doLocalLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = methodSignature.getMethod();
        ReentrantLock reentrantLock = createOrGetLocalLock(method);
        if (methodLock.optimistic()) {
            int timeout = methodLock.timeout();
            try {
                if (reentrantLock.tryLock(timeout, methodLock.timeUnit())) {
                    return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
                } else {
                    throw new TimeoutException();
                }
            } catch (InterruptedException | TimeoutException e) {
                throw e;
            } catch (Throwable throwable) {
                throw throwable;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            reentrantLock.lockInterruptibly();
            try {
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
        ReentrantLock lock = CacheOperateTemplate.get(() -> lockMap.get(method)
                , ReentrantLock::new
                , l -> lockMap.put(method, l), method);
        return lock;
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