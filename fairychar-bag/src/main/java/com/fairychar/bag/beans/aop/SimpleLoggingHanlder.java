package com.fairychar.bag.beans.aop;

import com.fairychar.bag.utils.RequestUtil;
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
    public void accept(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String uri = RequestUtil.obtainUri(signature);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String ip = RequestUtil.getIpAddress(request);
        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logs = String.format("%s request %s at %s", ip, uri, datetime);
        LoggingHelper.log(LoggingHelper.getLevel(signature), logs);
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