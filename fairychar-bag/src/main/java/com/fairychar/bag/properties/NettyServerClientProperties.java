package com.fairychar.bag.properties;

import lombok.Data;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/5/7 <br>
 * time: 15:41 <br>
 * <br>
 * <p>netty服务参数</p>
 * 提供netty核心参数,但不自动配置任何组件,提供于需要获取netty相关参数配置的组件
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@Data
public class NettyServerClientProperties {
    private ServerProperties server;
    private ClientProperties client;

    @Data
    public static class ClientProperties {
        private String host;
        private int port;
        private int eventLoopSize;
    }

    @Data
    public static class ServerProperties {
        private int port;
        private int bossSize;
        private int workerSize;
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