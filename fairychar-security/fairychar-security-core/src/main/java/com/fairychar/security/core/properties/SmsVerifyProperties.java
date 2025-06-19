package com.fairychar.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
@Data
public class SmsVerifyProperties {
    @NestedConfigurationProperty
    private AliyunSmsProperties aliyun = new AliyunSmsProperties();

    @Data
    public static class AliyunSmsProperties {
        private String from;
        private String templateCode;
        private String codeParam;
        private String expireTimeParam;
        private String appKey;
        private String appSecret;
    }
}
