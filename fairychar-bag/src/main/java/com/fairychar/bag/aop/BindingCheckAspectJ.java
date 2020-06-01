package com.fairychar.bag.aop;

import com.fairychar.bag.domain.annotions.BindingCheck;
import com.fairychar.bag.domain.exceptions.ParamErrorException;
import com.fairychar.bag.utils.BindingResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/4/10 <br>
 * time: 16:35 <br>
 * <p>
 * mvc参数aop校验,切*..web.controller..*包下的所有方法上包含
 * {@link BindingCheck}注解的方法
 * </p>
 * 使用hibernate validator方式校验前端参数参数实体类<br>
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOTl
 */
@Aspect
@Order(1)
public class BindingCheckAspectJ {

    @Before("execution(public * *..web.controller..*.*(..))  && @annotation(bindingCheck))")
    public void bindingCheck(JoinPoint joinPoint, BindingCheck bindingCheck) throws ParamErrorException {
        if (!bindingCheck.enable()) {
            return;
        }
        List<BindingResult> errors = Stream.of(joinPoint.getArgs()).filter(arg -> arg instanceof BindingResult)
                .map(b -> ((BindingResult) b))
                .collect(Collectors.toList());
        BindingResultUtil.checkBindingErrors(errors);
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