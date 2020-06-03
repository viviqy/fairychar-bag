package com.fairychar.test.service;

import com.fairychar.test.domain.LockTest;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Datetime: 2020/6/2 16:25 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Service
public class LockTestService {
    @LockTest
    public void run1(){
        System.out.println("aaaa");
    }

    @LockTest
    public void run1(String s){
        System.out.println(s);
    }

    private ReentrantLock lock=new ReentrantLock();

    public void run2(){
        try {
            lock.lock();
            System.out.println("bbb");
        } finally {
            lock.unlock();
        }
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