package com.fairychar.bag.properties;

import lombok.Data;

/**
 * <p>netty服务参数</p>
 * 提供netty核心参数,但不自动配置任何组件,提供于需要获取netty相关参数配置的组件
 *
 * @author chiyo
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
