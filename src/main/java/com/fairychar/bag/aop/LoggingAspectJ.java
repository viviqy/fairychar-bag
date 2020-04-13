package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.annotions.RequestLog;
import com.fairychar.bag.domain.aop.LoggingHandler;
import com.fairychar.bag.domain.exceptions.ParamErrorException;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Optional;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2020/4/11 <br>
 * time: 22:13 <br>
 *
 * @author lmq <br>
 * @since 1.0
 */
@Aspect
@Slf4j
@EnableConfigurationProperties(value = {FairycharBagProperties.class})
public class LoggingAspectJ implements InitializingBean {

    @Autowired
    private FairycharBagProperties properties;

    @Before("execution(* *..web.controller..*.*(..))  && @annotation(requestLog)")
    public void bindingCheck(JoinPoint joinPoint, RequestLog requestLog) throws ParamErrorException {
        if (!requestLog.enable()) {
            return;
        }
        RequestLog.Level level = Optional.ofNullable(requestLog.loggingLevel())
                .orElse(properties.getAopProperties().getLog().getGlobalLevel());
        switch (level) {
            case TRACE:
                log.trace(format(joinPoint));
                break;
            case DEBUG:
                log.debug(format(joinPoint));
                break;
            case INFO:
                log.info(format(joinPoint));
                break;
            case ERROR:
                log.error(format(joinPoint));
                break;
            default:
                break;
        }
        Optional.ofNullable(requestLog.beforeHandler()).ifPresent(b -> {
            Object bean = SpringContextHolder.getInstance().getBean(b);
            if (bean instanceof LoggingHandler) {
                
            }
        });
    }

    private String format(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(properties.getAopProperties().getLog().getGlobalLevel(), "global log level cant be null");
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