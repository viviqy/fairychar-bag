package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.Consts;
import com.fairychar.bag.domain.annotations.MethodLock;
import com.fairychar.bag.domain.exceptions.FailToGetLockException;
import com.fairychar.bag.domain.spring.expression.LockEvaluationContext;
import com.fairychar.bag.domain.spring.expression.LockExpressionRootObject;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.fairychar.bag.template.CacheOperateTemplate;
import com.fairychar.bag.utils.StringUtil;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这个类是一个切面，用于基于注解提供方法锁定功能。
 * 它支持不同类型的锁，如本地锁、Redis锁和ZooKeeper锁。
 * 该切面拦截使用@MethodLock注解的方法，并应用指定的锁类型。
 * 它使用一个Map来存储本地锁，并在不存在时创建一个新的锁。
 * 对于Redis锁，它使用RedissonClient来获取和释放锁。
 * 对于ZooKeeper锁，它使用CuratorFramework来创建和释放锁。
 * 该切面还处理乐观锁，通过检查在超时期间是否可以获取到锁。
 * 它使用FairycharBagProperties类来获取配置属性。
 * 该切面使用AspectJ实现，并按顺序在其他切面之后执行。
 *
 * @author chiyo
 * @since 1.0
 */
@Aspect
@EnableConfigurationProperties(FairycharBagProperties.class)
@Order
@Slf4j
public class MethodLockAspectJ implements InitializingBean {
    @Autowired
    private FairycharBagProperties fairycharBagProperties;
    private final SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
    private Map<String, ReentrantLock> lockMap = new ConcurrentHashMap<>(32);
    private final ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

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
        String expressionValue = this.resolveNameExpression(methodSignature, methodLock, proceedingJoinPoint);
        ReentrantLock reentrantLock = createOrGetLocalLock(expressionValue.isEmpty() ? getMethodFullPath(method) : expressionValue);
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
        Method method = methodSignature.getMethod();
        String expressionValue = this.resolveNameExpression(methodSignature, methodLock, proceedingJoinPoint);
        RedissonClient redissonClient = SpringContextHolder.getInstance().getBean(RedissonClient.class);
        RLock redissonLock = redissonClient.getLock(methodLock.distributedPrefix().concat(!Strings.isNullOrEmpty(expressionValue)
                ? expressionValue : getMethodFullPath(method)));
        if (methodLock.optimistic()) {
            try {
                if (redissonLock.tryLock(getTimeout(methodLock), getTimeUnit(methodLock))) {
                    return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
                } else {
                    throw new FailToGetLockException();
                }
            } catch (InterruptedException | TimeoutException e) {
                throw e;
            } catch (Throwable throwable) {
                throw throwable;
            } finally {
                if (redissonLock.isLocked()) {
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
        String expressionValue = this.resolveNameExpression(methodSignature, methodLock, proceedingJoinPoint);
        String path = methodLock.distributedPrefix().concat(expressionValue.isEmpty()
                ? getMethodFullPath(methodSignature.getMethod()) : expressionValue);
        CuratorFramework curatorFramework = SpringContextHolder.getInstance().getBean(CuratorFramework.class);
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, path.startsWith("/") ? path : "/".concat(path));
        if (methodLock.optimistic()) {
            try {
                if (lock.acquire(getTimeout(methodLock), getTimeUnit(methodLock))) {
                    return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
                }
                throw new FailToGetLockException();
            } catch (TimeoutException e) {
                log.info("get zookeeper lock timeout methodName={} path={}", methodSignature.getName(), methodLock.distributedPrefix().concat(expressionValue));
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

    private String resolveNameExpression(MethodSignature methodSignature, MethodLock methodLock, ProceedingJoinPoint proceedingJoinPoint) {
        String nameExpression = methodLock.nameExpression();
        String expressionString = null;
        Expression parseExpression = this.spelExpressionParser.parseExpression(nameExpression);
        if (!nameExpression.contains("#")) {
            expressionString = String.valueOf(parseExpression.getValue());
        } else {
            EvaluationContext evaluationContext = this.createEvaluationContext(methodSignature.getMethod(), proceedingJoinPoint.getArgs());
            expressionString = String.valueOf(parseExpression.getValue(evaluationContext));
        }
        return StringUtil.defaultText(expressionString, Consts.EMPTY_STR);
    }


    public EvaluationContext createEvaluationContext(Method method, Object[] args) {
        LockExpressionRootObject rootObject = new LockExpressionRootObject(method, args);
        LockEvaluationContext evaluationContext = new LockEvaluationContext(rootObject, method, args, this.parameterNameDiscoverer);
        return evaluationContext;
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