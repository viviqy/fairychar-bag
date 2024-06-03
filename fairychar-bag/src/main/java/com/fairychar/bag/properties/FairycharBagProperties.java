package com.fairychar.bag.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Fairychar Bag 属性配置
 *
 * @author qiyue
 */
@ConfigurationProperties(prefix = "fairychar.bag")
@Getter
@Setter
public class FairycharBagProperties {
    @NestedConfigurationProperty
    private AopProperties aop;
    @NestedConfigurationProperty
    private NettyServerClientProperties serverClient;
    @NestedConfigurationProperty
    private ConvertProperties convert;
    @NestedConfigurationProperty
    private SecretProperties secret;
    @NestedConfigurationProperty
    private HystrixProperties hystrix;
    @NestedConfigurationProperty
    private WebProperties web;

}
