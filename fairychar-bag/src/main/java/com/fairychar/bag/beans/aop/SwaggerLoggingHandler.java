package com.fairychar.bag.beans.aop;

import com.fairychar.bag.utils.RequestUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>swagger接口访问记录handler</p>
 * 记录<Strong>URI</strong>,访问<Strong>接口名称,基于{@link Operation#operationId()}</Strong>,访问<Strong>时间戳</Strong>,访问<Strong>ip</Strong>
 *
 * @author qiyue
 */
public class SwaggerLoggingHandler implements LoggingHandler {
    @Override
    public void accept(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Operation apiOperation = methodSignature.getMethod().getAnnotation(Operation.class);
        Class<?> pointClass = joinPoint.getTarget().getClass();
        HttpServletRequest request = RequestUtil.getCurrentRequest();
        Tag api = (Tag) methodSignature.getDeclaringType().getAnnotation(Tag.class);
        String logs = String.format("request uri=%s,uriName=%s at %s from %s"
                , request.getRequestURI()
                , api.name().concat("-").concat(apiOperation.operationId())
                , LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                , RequestUtil.getIpAddress(request)
        );
        LoggingHelper.log(pointClass, LoggingHelper.getLevel(methodSignature), logs);

    }
}
