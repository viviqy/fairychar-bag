package com.fairychar.bag.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/5/7 <br>
 * time: 15:41 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Data
public class NettyServerClientProperties {
    @NestedConfigurationProperty
    private ServerProperties server;
    @NestedConfigurationProperty
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