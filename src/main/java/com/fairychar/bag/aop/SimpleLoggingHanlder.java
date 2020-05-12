package com.fairychar.bag.aop;

import com.fairychar.bag.beans.aop.LoggingHandler;
import com.fairychar.bag.domain.annotions.RequestLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Patch;
import java.util.Optional;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2020/5/12 <br>
 * time: 10:59 <br>
 *
 * @author lmq <br>
 * @since 1.0
 */
@Slf4j
public class SimpleLoggingHanlder implements LoggingHandler {
    @Override
    public void then(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        String uri = obtainUri(signature);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String ip = getIpAdrress(request);
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

    public static String getIpAdrress(HttpServletRequest request) {
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
        String uri;
        if (signature.getMethod().getAnnotation(RequestMapping.class) != null) {
            uri = signature.getMethod().getAnnotation(RequestMapping.class).value()[0];
            return uri;
        }
        if (signature.getMethod().getAnnotation(PostMapping.class) != null) {
            uri = signature.getMethod().getAnnotation(PostMapping.class).value()[0];
            return uri;
        }
        if (signature.getMethod().getAnnotation(GetMapping.class) != null) {
            uri = signature.getMethod().getAnnotation(GetMapping.class).value()[0];
            return uri;
        }
        if (signature.getMethod().getAnnotation(PutMapping.class) != null) {
            uri = signature.getMethod().getAnnotation(PutMapping.class).value()[0];
            return uri;
        }
        if (signature.getMethod().getAnnotation(DeleteMapping.class) != null) {
            uri = signature.getMethod().getAnnotation(DeleteMapping.class).value()[0];
            return uri;
        }
        if (signature.getMethod().getAnnotation(PatchMapping.class) != null) {
            uri = signature.getMethod().getAnnotation(PatchMapping.class).value()[0];
            return uri;
        }
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