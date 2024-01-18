package com.fairychar.bag.pojo.vo;

import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

/**
 * restful响应体
 *
 * @author chiyo
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Builder
public class HttpResult<T> {
    private final static HttpResult CACHED_OK = new HttpResult(200, null, "success");
    private final static HttpResult CACHED_FAIL = new HttpResult<>(400, null, "fail");
    private int code;
    /**
     * 返回数据
     * <p>{@link FuzzyValue}添加模糊化参数支持</p>
     */
    @FuzzyValue
    private T data;
    private String msg;

    public static <T> HttpResult<T> response(HttpStatus httpStatus, T data) {
        return new HttpResult(httpStatus.value(), data, httpStatus.getReasonPhrase());
    }


    public static <T> HttpResult<T> response(int code, T data, String msg) {
        return new HttpResult(code, data, msg);
    }

    public static HttpResult response(int code, String msg) {
        return new HttpResult(code, null, msg);
    }


    public static HttpResult fallback() {
        return response(HttpStatus.SERVICE_UNAVAILABLE.value(), null, "service unavailable");
    }

    public static HttpResult fallback(Throwable cause) {
        return response(HttpStatus.SERVICE_UNAVAILABLE.value(), cause.getMessage(), "service unavailable");
    }

    public static HttpResult ok() {
        return CACHED_OK;
    }


    public static <T> HttpResult<T> ok(T data) {
        return new HttpResult(200, data, "success");
    }

    public static <T> HttpResult<T> fail(T data) {
        return new HttpResult<>(400, data, "fail");
    }

    public static <T> HttpResult<T> fail() {
        return CACHED_FAIL;
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