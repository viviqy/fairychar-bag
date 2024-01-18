package com.fairychar.bag.beans.netty.client;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.enums.State;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 简单Netty客户端
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@Slf4j
public class SimpleNettyClient {
    private final static ChannelInitializer<SocketChannel> CHILD_LOGGING_HANDLER;

    static {
        LoggingHandler loggingHandler = new LoggingHandler();
        CHILD_LOGGING_HANDLER = new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(loggingHandler);
            }
        };
    }

    @Getter
    private final int workerSize;
    @Getter
    private final int port;
    @Getter
    private final String host;
    @Getter
    private ChannelInitializer<SocketChannel> childHandlers;
    @Getter
    private State state = State.UN_INITIALIZE;
    @Getter
    @Setter
    private int maxShutdownWaitSeconds = Integer.MAX_VALUE;
    private Bootstrap bootstrap;
    @Getter
    private Channel channel;
    private NioEventLoopGroup worker;

    public SimpleNettyClient(int workerSize, int port, String host) {
        this.workerSize = workerSize;
        this.port = port;
        this.host = host;
        this.childHandlers = CHILD_LOGGING_HANDLER;
    }

    public SimpleNettyClient(int workerSize, int port, String host, ChannelInitializer<SocketChannel> childHandlers) {
        this.workerSize = workerSize;
        this.port = port;
        this.host = host;
        this.childHandlers = childHandlers;
    }

    public void start() {
        this.checkArgs();
        this.worker = new NioEventLoopGroup(this.workerSize);
        this.bootstrap = new Bootstrap();
        this.state = State.STARTING;
        try {
            this.channel = this.bootstrap.group(this.worker)
                    .channel(NioSocketChannel.class)
                    .handler(this.childHandlers)
                    .connect(this.host, this.port)
                    .sync()
                    .channel();
            log.info("client connected to {}:{}", this.host, this.port);
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            this.state = State.STOPPED;
        }
        this.state = State.STARTED;
    }

    @PreDestroy
    public void stop() {
        log.info("client disconnecting....");
        this.state = State.STOPPING;
        try {
            this.channel.close().get(this.maxShutdownWaitSeconds, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.worker.shutdownGracefully();
        }
        log.info("client disconnected");
        this.state = State.STOPPED;
    }


    private void checkArgs() {
        Assert.notNull(this.host, "host cant be null");
        Assert.isTrue(this.workerSize > 0, "workerSize must bigger than zero");
        Assert.isTrue(this.port > 0 && this.port < 65535, "port must between zero and 65535");
        Assert.isTrue(this.maxShutdownWaitSeconds > 0 && this.port < Integer.MAX_VALUE, "port must between 0 and 2147483647");
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