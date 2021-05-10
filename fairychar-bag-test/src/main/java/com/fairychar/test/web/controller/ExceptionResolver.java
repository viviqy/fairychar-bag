package com.fairychar.test.web.controller;

import com.fairychar.bag.domain.exceptions.ParamErrorException;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fairychar.bag.utils.BindingResultUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Datetime: 2021/3/9 17:40 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@RestControllerAdvice
public class ExceptionResolver {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResult> param(MethodArgumentNotValidException e) throws BindException {
        BindingResult bindingResult = e.getBindingResult();
        try {
            BindingResultUtil.checkBindingErrors(bindingResult);
        } catch (ParamErrorException paramErrorException) {
            return ResponseEntity.ok(HttpResult.ok(paramErrorException.getMessage()));
        }
        return null;
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<HttpResult> param(BindException e){
        return ResponseEntity.ok(HttpResult.ok(e.getMessage()));
    }
    @ExceptionHandler(ParamErrorException.class)
    public ResponseEntity<HttpResult> param(ParamErrorException e){
        return ResponseEntity.ok(HttpResult.ok(e.getMessage()));
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