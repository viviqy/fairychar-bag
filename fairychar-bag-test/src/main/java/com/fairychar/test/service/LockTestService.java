package com.fairychar.test.service;

import com.fairychar.bag.domain.annotions.MethodLock;
import com.fairychar.test.domain.LockTest;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
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
    public void run1() {
        System.out.println("aaaa");
    }

    @LockTest
    public void run1(String s) {
        System.out.println(s);
    }


    private ReentrantLock lock = new ReentrantLock();

    public void run2() {
        try {
            lock.lock();
            System.out.println("bbb");
        } finally {
            lock.unlock();
        }
    }


    @MethodLock(lockType = MethodLock.Type.LOCAL)
    public String getTom() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "tom";
    }

    @MethodLock(optimistic = true, lockType = MethodLock.Type.REDIS
            , timeout = 1, timeUnit = TimeUnit.SECONDS
            , distributedPrefix = "fairychar:device:", distributedPath = "collector")
    public String getJerry() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "jerry";
    }


    @MethodLock(optimistic = true, lockType = MethodLock.Type.ZK
            , timeUnit = TimeUnit.SECONDS, timeout = 1)
    public String getHuruta() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "huruta";
    }


    /**
     * 全局配置的redis锁,默认代表这个方法会使用基于redis实现的分布式锁,
     * 锁类型为悲观锁,锁路径如果缺省则为全类名+返回值类名+方法名+参数名(避免重载方法重复)
     * @param word
     * @return
     * @throws Exception
     */
    @MethodLock
    public String global(String word) throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return word;
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