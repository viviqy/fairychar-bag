package com.fairychar.bag.properties;

import com.fairychar.bag.domain.annotions.MethodLock;
import com.fairychar.bag.domain.annotions.RequestLog;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

/**
 * Created with IDEA <br>
 * User: qiyue <br>
 * Date: 2020/04/11 <br>
 * time: 17:39 <br>
 *
 * @author qiyue <br>
 */
@Getter
@Setter
public class AopProperties {
    private Log log;
    private Lock lock;


    @Getter
    @Setter
    public static class Log {
        private boolean enable;
        private RequestLog.Level globalLevel = RequestLog.Level.INFO;
        private String globalBefore;
        private String globalAfter;
    }

    @Getter
    @Setter
    public static class Lock {
        /**
         * 使用启用lock切面
         */
        private boolean enable;
        /**
         * 全局超时时间,默认1
         */
        private int globalTimeout = 1;

        /**
         * 全局超时时间单位设置
         */
        private TimeUnit timeUnit = TimeUnit.SECONDS;
        /**
         * 全局锁类型,默认使用本地锁,不能配置为DEFAULT
         */
        private MethodLock.Type defaultLock = MethodLock.Type.LOCAL;
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