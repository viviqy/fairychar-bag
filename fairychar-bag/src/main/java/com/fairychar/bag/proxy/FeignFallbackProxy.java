package com.fairychar.bag.proxy;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.pojo.vo.HttpResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Datetime: 2021/5/27 17:50 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class FeignFallbackProxy {

    /**
     * 代理feignclient的方法,代理后的方法返回{@link HttpResult}.fallback()
     * @param feignClient feignClient
     * @param <I>
     * @return jdk动态代理后的FeignClient
     */
    public static <I> I createDefault(Class<I> feignClient,Throwable cause){
        Assert.isTrue(feignClient.isInterface());
        I proxiededFeignClient = (I) Proxy.newProxyInstance(FeignFallbackProxy.class.getClassLoader(), new Class[]{feignClient}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (Object.class.equals(method.getDeclaringClass())) {
                    return method.invoke(this, args);
                }
                return new ResponseEntity(HttpResult.fallback(cause), HttpStatus.SERVICE_UNAVAILABLE);
            }
        });
        return proxiededFeignClient;
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