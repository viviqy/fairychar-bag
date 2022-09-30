package com.fairychar.bag.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Datetime: 2022/10/1 01:01 <br>
 *
 * @author chiyo <br>
 * @since 0.0.1
 */
@Data
public class WebProperties {

    @NestedConfigurationProperty
    private Advice advice;

    @Data
    public static class Advice {
        private boolean enable;
    }
}
