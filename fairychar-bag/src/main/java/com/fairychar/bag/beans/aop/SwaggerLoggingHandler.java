package com.fairychar.bag.beans.aop;

import com.fairychar.bag.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IDEA <br>
 * User: qiyue <br>
 * Date: 2020/04/12 <br>
 * time: 21:33 <br>
 *
 * @author qiyue <br>
 */
@Slf4j
public class SwaggerLoggingHandler implements LoggingHandler {
    @Override
    public void accept(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint;
        ApiOperation apiOperation = methodSignature.getMethod().getAnnotation(ApiOperation.class);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        Api api = (Api) methodSignature.getDeclaringType().getAnnotation(Api.class);
        log.info("request uri={},uriName={} at {} from {}"
                , request.getRequestURI()
                , api.tags()[0].concat("-").concat(apiOperation.value())
                , LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                , RequestUtil.getIpAddress(request)
        );
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