package com.fairychar.bag.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Datetime: 2021/12/2 23:01 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Data
public class SecretProperties {

    @NestedConfigurationProperty
    private Aes aes;
    @NestedConfigurationProperty
    private Rsa rsa;

    @Data
    public static class Aes {
        private String key;
    }

    @Data
    public static class Rsa {
        private String pubKey;
        private String priKey;
    }
}
