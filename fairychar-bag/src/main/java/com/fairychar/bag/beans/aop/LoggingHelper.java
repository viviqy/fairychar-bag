package com.fairychar.bag.beans.aop;

import com.fairychar.bag.domain.annotations.RequestLog;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Datetime: 2021/1/27 14:29
 *
 * @author chiyo
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
                log.trace("{}", logs);
                break;
            case DEBUG:
                log.debug("{}", logs);
                break;
            case INFO:
                log.info("{}", logs);
                break;
            case WARN:
                log.warn("{}", logs);
                break;
            case ERROR:
                log.error("{}", logs);
                break;
        }
    }
}
