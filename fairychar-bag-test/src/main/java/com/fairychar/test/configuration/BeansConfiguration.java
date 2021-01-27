package com.fairychar.test.configuration;

import com.fairychar.bag.beans.aop.LoggingHandler;
import com.fairychar.bag.beans.aop.SwaggerLoggingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Datetime: 2021/1/22 11:59 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Configuration
public class BeansConfiguration {
//    @Bean
//    Redisson redisson(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(0);
//
//    }

    @Bean
    LoggingHandler swagger(){
        return new SwaggerLoggingHandler();
    }
}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~||3333|  |   | |
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