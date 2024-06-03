package com.fairychar.bag.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 转换器属性配置
 *
 * @author chiyo
 */
@Getter
@Setter
public class ConvertProperties {
    private Mvc mvc;


    @Getter
    @Setter
    public static class Mvc {
        private boolean enable;

    }
}
