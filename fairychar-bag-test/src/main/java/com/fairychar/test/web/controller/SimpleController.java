package com.fairychar.test.web.controller;

import com.fairychar.bag.domain.param.LongBody;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Datetime: 2020/7/8 19:07 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@RestController
public class SimpleController {
    @GetMapping("/params")
    public ResponseEntity<Object> testParams(@RequestParam("name") String name, HttpServletRequest request){
        Object pwd = request.getAttribute("pwd");
        HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String name2;
        try {
             name2 = ServletRequestUtils.getStringParameter(request1, "name");
        } catch (ServletRequestBindingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(name);
    }

    @GetMapping("/binding")
    public ResponseEntity<Object> binding(@Validated LongBody body, BindingResult bindingResult){
        HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String name2;
        try {
            name2 = ServletRequestUtils.getStringParameter(request1, "name");
        } catch (ServletRequestBindingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(null);
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