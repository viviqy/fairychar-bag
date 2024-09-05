package com.fairychar.bag.proxy;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.pojo.vo.HttpResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * FeignFallback简单通用返回代理
 *
 * @author chiyo
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FeignFallbackProxy {

    /**
     * 代理feignclient的方法,代理后的方法返回{@link HttpResult}.fallback()
     *
     * @param feignClient feignClient
     * @param <I>
     * @return jdk动态代理后的FeignClient
     */
    public static <I> I createDefault(Class<I> feignClient, Throwable cause) {
        return createDefault(feignClient, cause, HttpResult.fail(RestErrorCode.FALLBACK, cause.getMessage()));
    }


    public static <I> I createDefault(Class<I> feignClient, Throwable cause, HttpResult result) {
        Assert.isTrue(feignClient.isInterface());
        I proxyFeignClient = (I) Proxy.newProxyInstance(FeignFallbackProxy.class.getClassLoader(), new Class[]{feignClient}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (Object.class.equals(method.getDeclaringClass())) {
                    return method.invoke(this, args);
                }
                return new ResponseEntity(result, HttpStatus.SERVICE_UNAVAILABLE);
            }
        });
        return proxyFeignClient;
    }
}
