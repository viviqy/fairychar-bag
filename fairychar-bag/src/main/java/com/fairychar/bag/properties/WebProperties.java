package com.fairychar.bag.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Datetime: 2022/10/1 01:01
 *
 * @author chiyo
 * @since 0.0.1
 */
@Data
public class WebProperties {

    @NestedConfigurationProperty
    private Advice advice;

    @NestedConfigurationProperty
    private PropertyProcessor propertyProcessor;


    /**
     * http request body property处理器
     * {@link com.fairychar.bag.beans.spring.mvc.KeepValueAdvice},
     * {@link com.fairychar.bag.beans.spring.mvc.EraseValueAdvice},
     * {@link com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice}
     *
     * @author chiyo
     * @date 2023/09/01
     */
    @Data
    public static class PropertyProcessor {
        private boolean enable;
    }

    /**
     * http hibernate validator exception advice
     *
     * @author chiyo
     * @date 2023/09/01
     */
    @Data
    public static class Advice {
        private boolean enable;
    }
}
