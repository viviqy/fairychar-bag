package com.fairychar.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
@Data
@ConfigurationProperties(prefix = "fairychar.security")
public class FairycharSecurityProperties {
    private TokenType tokenType = TokenType.REDIS;
    @NestedConfigurationProperty
    private StandardTokenProperties standard = new StandardTokenProperties();
    @NestedConfigurationProperty
    private SmsVerifyProperties verify = new SmsVerifyProperties();
    @NestedConfigurationProperty
    private PluginsProperties plugins = new PluginsProperties();
    @NestedConfigurationProperty
    private UrlProperties url = new UrlProperties();
}
