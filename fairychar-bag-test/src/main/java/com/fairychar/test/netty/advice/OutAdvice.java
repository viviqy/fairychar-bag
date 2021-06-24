package com.fairychar.test.netty.advice;

import com.fairychar.bag.domain.annotions.CauseHandler;
import com.fairychar.bag.domain.annotions.NettyAdvice;

/**
 * Created with IDEA <br>
 * Date: 2021/06/24 <br>
 * time: 22:40 <br>
 *
 * @author chiyo <br>
 */
@NettyAdvice
public class OutAdvice {

    @CauseHandler(ArrayIndexOutOfBoundsException.class)
    public void handle(ArrayIndexOutOfBoundsException e){
        System.out.println("in array");
        System.out.println(e);
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