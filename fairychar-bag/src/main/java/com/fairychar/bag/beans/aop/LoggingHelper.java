package com.fairychar.bag.beans.aop;

import com.fairychar.bag.domain.annotations.RequestLog;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Datetime: 2021/1/27 14:29 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Slf4j
class LoggingHelper {

    public static RequestLog.Level getLevel(MethodSignature methodSignature) {
        RequestLog requestLog = methodSignature.getMethod().getAnnotation(RequestLog.class);
        FairycharBagProperties properties = SpringContextHolder.getInstance().getBean(FairycharBagProperties.class);
        return requestLog.loggingLevel() == RequestLog.Level.NONE ?
                properties.getAop().getLog().getGlobalLevel() : requestLog.loggingLevel();
    }

    public static void log(RequestLog.Level level, String logs) {
        switch (level) {
            case NONE:
                break;
            case TRACE:
                if (log.isTraceEnabled()) {
                    log.trace("{}", logs);
                }
                break;
            case DEBUG:
                if (log.isDebugEnabled()) {
                    log.debug("{}", logs);
                }
                break;
            case INFO:
                if (log.isInfoEnabled()) {
                    log.info("{}", logs);
                }
                break;
            case WARN:
                if (log.isWarnEnabled()) {
                    log.warn("{}", logs);
                }
                break;
            case ERROR:
                if (log.isErrorEnabled()) {
                    log.error("{}", logs);
                }
                break;
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