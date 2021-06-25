package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.domain.annotions.MethodLock;
import com.fairychar.bag.domain.exceptions.FailToGetLockException;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.fairychar.bag.template.CacheOperateTemplate;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
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

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
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
    private Map<String, ReentrantLock> lockMap = new ConcurrentHashMap<>(32);

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
        MethodLock.Type lockType = methodLock.lockType() == MethodLock.Type.DEFAULT ? fairycharBagProperties.getAop().getLock().getDefaultLock() : methodLock.lockType();
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

    private Object doLocalLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = methodSignature.getMethod();
        ReentrantLock reentrantLock = createOrGetLocalLock(methodLock.name().isEmpty() ? getMethodFullPath(method) : methodLock.name());
        if (methodLock.optimistic()) {
            try {
                if (reentrantLock.tryLock(getTimeout(methodLock), getTimeUnit(methodLock))) {
                    return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
                }
                throw new TimeoutException();
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

    private Object doRedisLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Redisson redisson = SpringContextHolder.getInstance().getBean(Redisson.class);
        Method method = methodSignature.getMethod();
        RLock redissonLock = redisson.getLock(methodLock.distributedPrefix().concat(!Strings.isNullOrEmpty(methodLock.name())
                ? methodLock.name() : getMethodFullPath(method)));
        if (methodLock.optimistic()) {
            boolean hold = false;
            try {
                if (redissonLock.tryLock(getTimeout(methodLock), getTimeUnit(methodLock))) {
                    hold = true;
                    return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
                } else {
                    throw new FailToGetLockException();
                }
            } catch (InterruptedException | TimeoutException e) {
                throw e;
            } catch (Throwable throwable) {
                throw throwable;
            } finally {
                if (hold) {
                    redissonLock.unlock();
                }
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

    private Object doZookeeperLock(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CuratorFramework curatorFramework = SpringContextHolder.getInstance().getBean(CuratorFramework.class);
        String path = methodLock.distributedPrefix().concat(methodLock.name().isEmpty()
                ? getMethodFullPath(methodSignature.getMethod()) : methodLock.name());
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, path.startsWith("/") ? path : "/".concat(path));
        if (methodLock.optimistic()) {
            try {
                if (lock.acquire(getTimeout(methodLock), getTimeUnit(methodLock))) {
                    return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
                }
                throw new FailToGetLockException();
            } catch (TimeoutException e) {
                log.info("get zookeeper lock timeout methodName={} path={}", methodSignature.getName(), methodLock.distributedPrefix().concat(methodLock.name()));
                throw e;
            } catch (Exception e) {
                throw e;
            } catch (Throwable throwable) {
                throw throwable;
            } finally {
                if (lock.isAcquiredInThisProcess()) {
                    lock.release();
                }
            }
        } else {
            try {
                lock.acquire();
                return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            } catch (Exception e) {
                throw e;
            } finally {
                if (lock.isAcquiredInThisProcess()) {
                    lock.release();
                }
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
        return methodName.concat(":").concat(returnName).concat(":")
                .concat(parameterName.isEmpty() ? Consts.NONE : parameterName.substring(0, parameterName.length() - 1));
    }

    private int getTimeout(MethodLock methodLock) {
        if (methodLock.timeout() == -1) {
            //use global
            return fairycharBagProperties.getAop().getLock().getGlobalTimeout();
        } else {
            int timeout = methodLock.timeout();
            Assert.isTrue(timeout >= 0, "乐观锁超时时间必须不小于0");
            return timeout;
        }
    }

    private TimeUnit getTimeUnit(MethodLock methodLock) {
        if (methodLock.timeUnit().equals(TimeUnit.NANOSECONDS)) {
            //use global
            return fairycharBagProperties.getAop().getLock().getTimeUnit();
        } else {
            return methodLock.timeUnit();
        }
    }

    private ReentrantLock createOrGetLocalLock(String key) {
        ReentrantLock lock = CacheOperateTemplate.get(() -> lockMap.get(key)
                , ReentrantLock::new
                , l -> lockMap.put(key, l), key);
        return lock;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(fairycharBagProperties.getAop().getLock().getDefaultLock(), "全局方法锁不能为null");
        Assert.notNull(fairycharBagProperties.getAop().getLock().getTimeUnit(), "时间单位不能为null");
        Assert.isTrue(fairycharBagProperties.getAop().getLock().getGlobalTimeout() >= 0, "乐观锁超时时间必须不小于0");
        Assert.isFalse(fairycharBagProperties.getAop().getLock().getDefaultLock().equals(MethodLock.Type.DEFAULT), "默认锁类型不能为DEFAULT");
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