package com.fairychar.test.netty.advice;

import com.fairychar.bag.domain.annotions.CauseHandler;
import com.fairychar.bag.domain.annotions.NettyCauseAdvice;
import com.fairychar.test.netty.handler.ThrowExHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created with IDEA <br>
 * Date: 2021/06/24 <br>
 * time: 22:40 <br>
 *
 * @author chiyo <br>
 */
@NettyCauseAdvice
public class OutAdvice {

    @CauseHandler(value = ArrayIndexOutOfBoundsException.class)
    public void handle(ChannelHandlerContext ctx, ArrayIndexOutOfBoundsException e) {
        System.out.println("in array");
        System.out.println(e);
    }

    @CauseHandler(value = ArrayIndexOutOfBoundsException.class, handler = ThrowExHandler.class)
    public void handle1(ChannelHandlerContext ctx, ArrayIndexOutOfBoundsException e) {
        System.out.println("in array1");
        System.out.println(e);
    }

    @CauseHandler(value = ArrayIndexOutOfBoundsException.class, handler = ThrowExHandler.class, methodName = "m1")
    public void handle2(ChannelHandlerContext ctx, ArrayIndexOutOfBoundsException e) {
        System.out.println("in array2");
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