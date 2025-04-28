package com.fairychar.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
@Data
@ConfigurationProperties(prefix = "fairychar.bag")
public class FairycharSecurityProperties {

    @NestedConfigurationProperty
    private SmsVerifyProperties verify = new SmsVerifyProperties();
}
