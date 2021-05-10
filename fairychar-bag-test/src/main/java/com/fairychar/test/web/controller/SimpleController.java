package com.fairychar.test.web.controller;

import com.fairychar.bag.domain.annotions.BindingCheck;
import com.fairychar.bag.domain.annotions.RequestLog;
import com.fairychar.bag.domain.param.LongBody;
import com.fairychar.test.pojo.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
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
@Api(tags = "简单接口")
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

    @PostMapping("/binding")
    @BindingCheck
    @RequestLog
    @ApiOperation("参数检查")
    public ResponseEntity<Object> binding(@Validated @RequestBody Customer body, BindingResult bindingResult) throws Exception{
//        HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String name2;
//        try {
//            name2 = ServletRequestUtils.getStringParameter(request1, "name");
//        } catch (ServletRequestBindingException e) {
////            e.printStackTrace();
//        }
        return ResponseEntity.ok("xxx");
    }

    @PostMapping("/binding1")
    @ApiOperation("参数检查")
    @BindingCheck
    public ResponseEntity<Object> binding1(@Validated @RequestBody Customer body) throws Exception{
//        HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String name2;
//        try {
//            name2 = ServletRequestUtils.getStringParameter(request1, "name");
//        } catch (ServletRequestBindingException e) {
////            e.printStackTrace();
//        }
        System.out.println(body);
        return ResponseEntity.ok("xxx");
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