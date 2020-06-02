package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.annotions.MethodLock;
import com.fairychar.bag.properties.FairycharBagProperties;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;

/**
 * Datetime: 2020/6/2 11:08 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Aspect
@EnableConfigurationProperties(FairycharBagProperties.class)
@Order
public class MethodLockAspectJ implements InitializingBean {
    @Autowired
    private FairycharBagProperties fairycharBagProperties;

    @Around("@annotation(methodLock)")
    public void locking(JoinPoint joinPoint, MethodLock methodLock) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (!methodLock.enable()) {
            return;
        }
        switchLock(methodSignature, methodLock);
    }

    private void switchLock(MethodSignature methodSignature, MethodLock methodLock) {
        MethodLock.Type lockType = methodLock.lockType() == MethodLock.Type.NONE ? fairycharBagProperties.getAop().getLock().getType() : methodLock.lockType();
        switch (lockType) {
            case NONE:
                break;
            case LOCAL: {
                doLocalLock(methodSignature, methodLock);
            }
            break;
            case REDIS:
                break;
            case ZOOKEEPER:
                break;
        }
    }

    private void doLocalLock(MethodSignature methodSignature, MethodLock methodLock) {
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