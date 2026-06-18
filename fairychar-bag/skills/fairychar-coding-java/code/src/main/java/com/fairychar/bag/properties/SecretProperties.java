package com.fairychar.bag.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Datetime: 2021/12/2 23:01
 *
 * @author chiyo
 * @since 1.0
 */
@Data
public class SecretProperties {

    @NestedConfigurationProperty
    private AesProperties aes;
    @NestedConfigurationProperty
    private RsaProperties rsa;

    @Data
    public static class AesProperties {
        private String key;
    }

    @Data
    public static class RsaProperties {
        private String pubKey;
        private String priKey;
    }
}
