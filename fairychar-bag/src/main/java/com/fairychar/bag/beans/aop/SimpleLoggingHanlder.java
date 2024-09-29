package com.fairychar.bag.beans.aop;

import com.fairychar.bag.utils.RequestUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>基础接口访问记录handler</p>
 * 记录<Strong>ip</strong>,访问<Strong>URI</Strong>,访问<Strong>时间戳</Strong>
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@Slf4j
public class SimpleLoggingHanlder implements LoggingHandler {
    @Override
    public void accept(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> pointClass = joinPoint.getTarget().getClass();
        String uri = RequestUtil.obtainUri(signature);
        HttpServletRequest request = RequestUtil.getCurrentRequest();
        String ip = RequestUtil.getIpAddress(request);
        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logs = String.format("%s request %s at %s", ip, uri, datetime);
        LoggingHelper.log(pointClass, LoggingHelper.getLevel(signature), logs);
    }


}
