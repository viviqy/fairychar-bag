package com.fairychar.bag.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Servlet请求工具类
 *
 * @author chiyo <br>
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestUtil {


    /**
     * 向当前thread的request设置属性
     *
     * @param keyName   键名
     * @param attribute 属性
     */
    public static <T> void putAttribute(String keyName, T attribute) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        requestAttributes.getRequest().setAttribute(keyName, attribute);
    }

    /**
     * 从当前thread的request获取属性
     *
     * @param keyName 键名
     * @param tClass  t类
     * @return {@link T}
     */
    public static <T> T getAttribute(String keyName, Class<T> tClass) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object attribute = requestAttributes.getRequest().getAttribute(keyName);
        return (T) attribute;
    }

    /**
     * 获取远端访问ip地址
     *
     * @param request request
     * @return 真实的访问ip
     */
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

    /**
     * 通过反射获取请求请求地址
     *
     * @param signature {@link MethodSignature}
     * @return 访问路径
     */
    public static String obtainUri(MethodSignature signature) {
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