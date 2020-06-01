package com.fairychar.bag.beans.aop;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

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
    public void then(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint;
        ApiOperation apiOperation = methodSignature.getMethod().getAnnotation(ApiOperation.class);
        Api api = (Api) methodSignature.getDeclaringType().getAnnotation(Api.class);
        log.info("request {}", api.tags()[0].concat(apiOperation.value()));
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