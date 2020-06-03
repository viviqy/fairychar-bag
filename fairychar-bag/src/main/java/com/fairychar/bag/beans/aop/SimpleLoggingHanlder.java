package com.fairychar.bag.beans.aop;

import com.fairychar.bag.domain.annotions.RequestLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/5/12 <br>
 * time: 10:59 <br>
 *
 * <p>基础接口访问记录handler</p>
 * 记录<Strong>ip</strong>,访问<Strong>URI</Strong>,访问<Strong>时间戳</Strong>
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@Slf4j
public class SimpleLoggingHanlder implements LoggingHandler {
    @Override
    public void then(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String uri = obtainUri(signature);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String ip = getIpAddress(request);
        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logs = String.format("%s request %s at %s", ip, uri, datetime);
        RequestLog requestLog = signature.getMethod().getAnnotation(RequestLog.class);
        showLog(requestLog.loggingLevel(), logs);
    }

    private void showLog(RequestLog.Level level, String logs) {
        switch (level) {
            case TRACE:
                log.trace("{}", logs);
                break;
            case DEBUG:
                log.debug("{}", logs);
                break;
            case INFO:
                log.info("{}", logs);
                break;
            case ERROR:
                log.error("{}", logs);
                break;
        }
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        String unknown = "unknown";
        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }
        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }
        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    private static String obtainUri(MethodSignature signature) {
        String methodUri = "";
        if (signature.getMethod().getAnnotation(RequestMapping.class) != null) {
            methodUri = signature.getMethod().getAnnotation(RequestMapping.class).value()[0];
        } else if (signature.getMethod().getAnnotation(PostMapping.class) != null) {
            methodUri = signature.getMethod().getAnnotation(PostMapping.class).value()[0];
        } else if (signature.getMethod().getAnnotation(GetMapping.class) != null) {
            methodUri = signature.getMethod().getAnnotation(GetMapping.class).value()[0];
        } else if (signature.getMethod().getAnnotation(PutMapping.class) != null) {
            methodUri = signature.getMethod().getAnnotation(PutMapping.class).value()[0];
        } else if (signature.getMethod().getAnnotation(DeleteMapping.class) != null) {
            methodUri = signature.getMethod().getAnnotation(DeleteMapping.class).value()[0];
        } else if (signature.getMethod().getAnnotation(PatchMapping.class) != null) {
            methodUri = signature.getMethod().getAnnotation(PatchMapping.class).value()[0];
        }
        String classUri = "";
        if (signature.getDeclaringType().getAnnotation(RequestMapping.class) != null) {
            classUri = ((RequestMapping) signature.getDeclaringType().getAnnotation(RequestMapping.class)).value()[0];
        }
        String uri = classUri.concat(methodUri.startsWith("/") ? methodUri : "/" + methodUri);
        return uri;
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