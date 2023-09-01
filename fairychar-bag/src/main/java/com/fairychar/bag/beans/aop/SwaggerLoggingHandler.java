package com.fairychar.bag.beans.aop;

import com.fairychar.bag.utils.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>swagger接口访问记录handler</p>
 * 记录<Strong>URI</strong>,访问<Strong>接口名称,基于{@link ApiOperation#value()}</Strong>,访问<Strong>时间戳</Strong>,访问<Strong>ip</Strong>
 *
 * @author qiyue <br>
 */
public class SwaggerLoggingHandler implements LoggingHandler {
    @Override
    public void accept(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ApiOperation apiOperation = methodSignature.getMethod().getAnnotation(ApiOperation.class);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        Api api = (Api) methodSignature.getDeclaringType().getAnnotation(Api.class);
        String logs = String.format("request uri=%s,uriName=%s at %s from %s"
                , request.getRequestURI()
                , api.tags()[0].concat("-").concat(apiOperation.value())
                , LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                , RequestUtil.getIpAddress(request)
        );
        LoggingHelper.log(LoggingHelper.getLevel(methodSignature), logs);

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