package com.fairychar.bag.configuration.properties;

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

}
