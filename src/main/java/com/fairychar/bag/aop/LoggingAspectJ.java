package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.beans.aop.LoggingHandler;
import com.fairychar.bag.domain.annotions.RequestLog;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Optional;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/4/11 <br>
 * time: 22:13 <br>
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@Aspect
@Slf4j
@EnableConfigurationProperties(value = {FairycharBagProperties.class})
public class LoggingAspectJ implements InitializingBean {

    @Autowired
    private FairycharBagProperties properties;


    @Before("execution(public * *..web.controller..*.*(..))  && @annotation(requestLog)")
    public void beforeLogging(JoinPoint joinPoint, RequestLog requestLog) {
        if (!requestLog.enable()) {
            return;
        }
        Optional<String> handler = Optional.ofNullable(requestLog.beforeHandler()).filter(s -> !s.isEmpty());
        if (handler.isPresent()) {
            handle(handler.get(), joinPoint);
        } else {
            Optional.ofNullable(properties.getAop().getLog().getGlobalBefore()).filter(s -> !Strings.isNullOrEmpty(s))
                    .ifPresent(h -> handle(h, joinPoint));
        }

    }


    @Around("execution(* *..web.controller..*.*(..))  && @annotation(requestLog)")
    public void aroundLogging(JoinPoint joinPoint, RequestLog requestLog) {
        if (!requestLog.enable()) {
            return;
        }
        Optional<String> handler = Optional.ofNullable(requestLog.aroundHandler()).filter(s -> !s.isEmpty());
        if (handler.isPresent()) {
            handle(handler.get(), joinPoint);
        } else {
            Optional.ofNullable(properties.getAop().getLog().getGlobalAround()).filter(s -> !Strings.isNullOrEmpty(s))
                    .ifPresent(h -> handle(h, joinPoint));
        }
    }

    @After("execution(* *..web.controller..*.*(..))  && @annotation(requestLog)")
    public void afterLogging(JoinPoint joinPoint, RequestLog requestLog) {
        if (!requestLog.enable()) {
            return;
        }
        Optional<String> handler = Optional.ofNullable(requestLog.afterHandler()).filter(s -> !s.isEmpty());
        if (handler.isPresent()) {
            handle(handler.get(), joinPoint);
        } else {
            Optional.ofNullable(properties.getAop().getLog().getGlobalAfter()).filter(s -> !Strings.isNullOrEmpty(s))
                    .ifPresent(h -> handle(h, joinPoint));
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(properties.getAop().getLog().getGlobalLevel(), "global log level cant be null");
    }

    private void handle(String handlerName, JoinPoint joinPoint) {
        try {
            LoggingHandler bean = SpringContextHolder.getInstance().getBean(handlerName, LoggingHandler.class);
            bean.then(joinPoint);
        } catch (NoSuchBeanDefinitionException e) {
            log.error("cant find loggingHandler bean by name {}", handlerName);
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