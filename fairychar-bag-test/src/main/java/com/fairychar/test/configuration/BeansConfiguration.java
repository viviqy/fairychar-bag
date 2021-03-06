package com.fairychar.test.configuration;

import com.fairychar.bag.beans.aop.LoggingHandler;
import com.fairychar.bag.beans.aop.SwaggerLoggingHandler;
import com.fairychar.bag.properties.FairycharBagProperties;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Datetime: 2021/1/22 11:59 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(FairycharBagProperties.class)
public class BeansConfiguration {
//    @Bean
//    Redisson redisson(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(0);
//
//    }

    @Bean
    LoggingHandler swagger() {
        return new SwaggerLoggingHandler();
    }

    @Autowired
    private FairycharBagProperties bagProperties;

//    @Bean
//    SimpleNettyServer simpleNettyServer(){
//        NettyServerClientProperties.ServerProperties properties = bagProperties.getServerClient().getServer();
//        SimpleNettyServer simpleNettyServer = new SimpleNettyServer(properties.getWorkerSize(), properties.getPort());
//        return simpleNettyServer;
//        // 在需要的spring bean加载完成后执行start方法
//    }
//
//    @Bean
//    SimpleNettyClient simpleNettyClient(){
//        NettyServerClientProperties.ClientProperties client = bagProperties.getServerClient().getClient();
//        SimpleNettyClient simpleNettyClient = new SimpleNettyClient(client.getEventLoopSize(), client.getPort(), client.getHost());
//        return simpleNettyClient;
//        // 在需要的spring bean加载完成后执行start方法
//    }
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