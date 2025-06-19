package com.fairychar.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author chiyo <br>
 */
@Data
public class StandardTokenProperties {
    private String tokenHeaderName = "token";
    private int maxSession = 3;

    @NestedConfigurationProperty
    private FilterProperties filter = new FilterProperties();

}
