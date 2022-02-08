package com.fairychar.test.configuration;

import com.fairychar.bag.beans.aop.LoggingHandler;
import com.fairychar.bag.beans.aop.SwaggerLoggingHandler;
import com.fairychar.bag.beans.netty.server.SimpleNettyServer;
import com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.fairychar.test.netty.handler.ThrowExHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
    GlobalInboundCauseAdvice globalCauseAdvice() {
        return new GlobalInboundCauseAdvice();
    }

    @Bean
    LoggingHandler swagger() {
        return new SwaggerLoggingHandler();
    }

    @Autowired
    private FairycharBagProperties bagProperties;


    @Bean
    @ConditionalOnMissingBean
    SimpleNettyServer simpleNettyServer() {
//        NettyServerClientProperties.ServerProperties properties = bagProperties.getServerClient().getServer();
        SimpleNettyServer simpleNettyServer = new SimpleNettyServer(1, 10000, new ChannelInitializer<ServerSocketChannel>() {
            @Override
            protected void initChannel(ServerSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new io.netty.handler.logging.LoggingHandler());
            }
        }, new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringDecoder())
                        .addLast(new ThrowExHandler())
                        .addLast(BeansConfiguration.this.globalCauseAdvice());
            }
        });
        simpleNettyServer.start();
        return simpleNettyServer;
        // 在需要的spring bean加载完成后执行start方法
    }

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