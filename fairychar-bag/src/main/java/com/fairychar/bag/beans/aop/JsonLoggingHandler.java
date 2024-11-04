package com.fairychar.bag.beans.aop;

import cn.hutool.json.JSONUtil;
import com.fairychar.bag.domain.annotations.RequestLog;
import com.fairychar.bag.utils.RequestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author chiyo <br>
 * @since
 */
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class JsonLoggingHandler implements LoggingHandler {
    private ObjectMapper objectMapper;

    private static final String TRACE_ID = "TRACE_ID";

    @Override
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Class<?> pointClass = joinPoint.getTarget().getClass();
        String uri = RequestUtil.obtainUri(methodSignature);
        HttpServletRequest request = RequestUtil.getCurrentRequest();
        String ip = RequestUtil.getIpAddress(request);
        String traceId = request.getHeader(TRACE_ID);
        if (Strings.isNullOrEmpty(traceId)) {
            traceId = UUID.randomUUID().toString();
            request.setAttribute(TRACE_ID, traceId);
        }
        Object[] copiedArgs = copyArgs(joinPoint);
        JsonLoggingObject loggingObject = new JsonLoggingObject("request", traceId, ip, uri
                , copiedArgs.length > 1 ? copiedArgs : copiedArgs[0]);
        RequestLog.Level level = LoggingHelper.getLevel(methodSignature);
        if (this.objectMapper == null) {
            String jsonStr = JSONUtil.toJsonStr(loggingObject);
            LoggingHelper.log(pointClass, level, jsonStr);
        } else {
            try {
                String jsonStr = this.objectMapper.writeValueAsString(loggingObject);
                LoggingHelper.log(pointClass, level, jsonStr);
            } catch (JsonProcessingException e) {
                log.warn("requestBody={},errorMsg={}", loggingObject, e.getMessage());
            }
        }
    }


    @Override
    public void after(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Class<?> pointClass = joinPoint.getTarget().getClass();
        String uri = RequestUtil.obtainUri(methodSignature);
        HttpServletRequest request = RequestUtil.getCurrentRequest();
        String ip = RequestUtil.getIpAddress(request);
        String traceId = request.getHeader(TRACE_ID);
        if (Strings.isNullOrEmpty(traceId)) {
            traceId = (String) request.getAttribute(TRACE_ID);
        }
        JsonLoggingObject loggingObject = new JsonLoggingObject("response", traceId, ip, uri, result);
        RequestLog.Level level = LoggingHelper.getLevel(methodSignature);
        if (this.objectMapper == null) {
            String jsonStr = JSONUtil.toJsonStr(loggingObject);
            LoggingHelper.log(pointClass, level, jsonStr);
        } else {
            try {
                String jsonStr = this.objectMapper.writeValueAsString(loggingObject);
                LoggingHelper.log(pointClass, level, jsonStr);
            } catch (JsonProcessingException e) {
                log.warn("responseBody={},errorMsg={}", loggingObject, e.getMessage());
            }
        }
    }

    private Object[] copyArgs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object[] logArgs = Arrays.copyOf(args, args.length);
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof MultipartFile mf) {
                //处理multipart类型的打印日志为文件名
                logArgs[i] = mf.getOriginalFilename();
            }
        }
        return logArgs;
    }
}
