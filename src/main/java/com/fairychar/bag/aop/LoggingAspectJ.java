package com.fairychar.bag.aop;

import com.fairychar.bag.domain.annotions.RequestLog;
import com.fairychar.bag.domain.exceptions.ParamErrorException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

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
public class LoggingAspectJ {


    @Before("execution(* *..web.controller..*.*(..))  && @annotation(requestLog)")
    public void bindingCheck(JoinPoint joinPoint, RequestLog requestLog) throws ParamErrorException {
        if (!requestLog.enable()) {
            return;
        }
        switch (requestLog.loggingLevel()) {

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
    }

    private String format(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return null;
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