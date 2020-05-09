package com.fairychar.bag.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2019/12/3 <br>
 * time: 14:36 <br>
 *
 * @author lmq <br>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Builder
public class HttpResult<T> {
    private int code;
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

    public static HttpResult ok() {
        return new HttpResult(200, null, "success");
    }


    public static <T> HttpResult<T> ok(T data) {
        return new HttpResult(200, data, "success");
    }

    public static <T> HttpResult<T> fail(T data) {
        return new HttpResult<>(400, data, "fail");
    }

    public static <T> HttpResult<T> fail() {
        return fail(null);
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