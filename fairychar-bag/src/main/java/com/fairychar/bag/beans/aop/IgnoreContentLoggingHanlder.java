package com.fairychar.bag.beans.aop;

import com.fairychar.bag.utils.RequestUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 忽略请求和响应参数
 *
 * @author chiyo
 * @since 1.3.2
 */
@Slf4j
public class IgnoreContentLoggingHanlder implements LoggingHandler {
    @Override
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> pointClass = joinPoint.getTarget().getClass();
        String uri = RequestUtil.obtainUri(signature);
        HttpServletRequest request = RequestUtil.getCurrentRequest();
        String ip = RequestUtil.getIpAddress(request);
        String logs = String.format("%s request %s,body=[ignore]", ip, uri);
        LoggingHelper.log(pointClass, LoggingHelper.getLevel(signature), logs);
    }


    @Override
    public void after(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Class<?> pointClass = joinPoint.getTarget().getClass();
        String uri = RequestUtil.obtainUri(methodSignature);
        HttpServletRequest request = RequestUtil.getCurrentRequest();
        String ip = RequestUtil.getIpAddress(request);
        String logs = String.format("%s request %s,response=[ignore]", ip, uri);
        LoggingHelper.log(pointClass, LoggingHelper.getLevel(methodSignature), logs);
    }
}
