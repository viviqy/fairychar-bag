package com.fairychar.bag.properties;

import com.fairychar.bag.domain.annotions.RequestLog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

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
    @NestedConfigurationProperty
    private Log log;
    @NestedConfigurationProperty
    private Binding binding;

    @Getter
    @Setter
    public static class Binding {
        private boolean enable;
    }

    @Getter
    @Setter
    public static class Log {
        private boolean enable;
        private RequestLog.Level globalLevel = RequestLog.Level.INFO;
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