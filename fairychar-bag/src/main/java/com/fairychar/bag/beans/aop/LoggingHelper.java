package com.fairychar.bag.beans.aop;

import com.fairychar.bag.domain.annotations.RequestLog;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/**
 * Datetime: 2021/1/27 14:29
 *
 * @author chiyo
 * @since 1.0
 */
@Slf4j
class LoggingHelper {
    private static final String FQCN = LoggingHelper.class.getName();  // 📌 包装器自己的 FQCN

    public static RequestLog.Level getLevel(MethodSignature methodSignature) {
        RequestLog requestLog = methodSignature.getMethod().getAnnotation(RequestLog.class);
        FairycharBagProperties properties = SpringContextHolder.getInstance().getBean(FairycharBagProperties.class);
        return requestLog.loggingLevel() == RequestLog.Level.NONE ?
                properties.getAop().getLog().getGlobalLevel() : requestLog.loggingLevel();
    }

    public static void log(Class poinClass, String methodName, RequestLog.Level level, String logs) {
        LocationAwareLogger lal =
                (LocationAwareLogger) LoggerFactory.getLogger(poinClass);
        switch (level) {
            case NONE:
                break;
            case TRACE:
                lal.log(null, FQCN, LocationAwareLogger.TRACE_INT, logs, null, null);
                break;
            case DEBUG:
                lal.log(null, FQCN, LocationAwareLogger.DEBUG_INT, logs, null, null);
                break;
            case INFO:
                lal.log(null, FQCN, LocationAwareLogger.INFO_INT, logs, null, null);
                break;
            case WARN:
                lal.log(null, FQCN, LocationAwareLogger.WARN_INT, logs, null, null);
                break;
            case ERROR:
                lal.log(null, FQCN, LocationAwareLogger.ERROR_INT, logs, null, null);
                break;
        }
    }
}
