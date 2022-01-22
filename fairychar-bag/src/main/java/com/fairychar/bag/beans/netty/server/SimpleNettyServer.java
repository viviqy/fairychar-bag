package com.fairychar.bag.beans.netty.server;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.enums.State;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/5/7 <br>
 * time: 16:02 <br>
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@Slf4j
public class SimpleNettyServer {
    private final static ChannelInitializer<ServerSocketChannel> LOGGING_HANDLER;
    private final static ChannelInitializer<SocketChannel> CHILD_LOGGING_HANDLER;

    static {
        LoggingHandler loggingHandler = new LoggingHandler();
        LOGGING_HANDLER = new ChannelInitializer<ServerSocketChannel>() {
            @Override
            protected void initChannel(ServerSocketChannel serverSocketChannel) throws Exception {
                serverSocketChannel.pipeline().addLast(loggingHandler);
            }
        };
        CHILD_LOGGING_HANDLER = new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(loggingHandler);
            }
        };
    }

    @Getter
    private final int bossSize = 1;
    @Getter
    private final int workerSize;
    @Getter
    private final int port;
    @Getter
    private ChannelInitializer<ServerSocketChannel> handlers;
    @Getter
    private ChannelInitializer<SocketChannel> childHandlers;
    @Getter
    private State state = State.UN_INITIALIZE;
    @Getter
    @Setter
    private int maxShutdownWaitSeconds = Integer.MAX_VALUE;
    private ServerBootstrap serverBootstrap;
    private Channel channel;
    private NioEventLoopGroup boss;
    private NioEventLoopGroup worker;

    public SimpleNettyServer(int workerSize, int port) {
        this.workerSize = workerSize;
        this.port = port;
        this.handlers = LOGGING_HANDLER;
        this.childHandlers = CHILD_LOGGING_HANDLER;
    }

    public SimpleNettyServer(int workerSize, int port, ChannelInitializer<ServerSocketChannel> handlers, ChannelInitializer<SocketChannel> childHandlers) {
        this.workerSize = workerSize;
        this.port = port;
        this.handlers = handlers;
        this.childHandlers = childHandlers;
    }

    public SimpleNettyServer(int workerSize, int port, ChannelInitializer<SocketChannel> childHandlers) {
        this.workerSize = workerSize;
        this.port = port;
        this.childHandlers = childHandlers;
    }

    public void start() {
        this.checkArgs();
        this.boss = new NioEventLoopGroup(this.bossSize);
        this.worker = new NioEventLoopGroup(this.workerSize);
        this.serverBootstrap = new ServerBootstrap();
        this.state = State.STARTING;
        try {
            ServerBootstrap channel = this.serverBootstrap.group(this.boss, this.worker)
                    .channel(NioServerSocketChannel.class);
            Optional.ofNullable(this.handlers).ifPresent(h -> channel.handler(h));
            this.channel = channel.childHandler(this.childHandlers)
                    .bind(this.port).channel();
            log.info("server start at {}", this.port);
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            this.stop();
        }
        this.state = State.STARTED;
    }

    @PreDestroy
    public void stop() {
        log.info("server stopping....");
        this.state = State.STOPPING;
        try {
            this.channel.close().get(this.maxShutdownWaitSeconds, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.boss.shutdownGracefully();
            this.worker.shutdownGracefully();
        }
        log.info("server stopped");
        this.state = State.STOPPED;
    }


    private void checkArgs() {
        Assert.isTrue(this.bossSize > 0, "bossSize must bigger than zero");
        Assert.isTrue(this.workerSize > 0, "workerSize must bigger than zero");
        Assert.isTrue(this.port > 0 && this.port < 65535, "port must bigger than zero and less than 65535");
        Assert.isTrue(this.maxShutdownWaitSeconds > 0 && this.port < Integer.MAX_VALUE, "port must bigger than zero and less than 2147483647");
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