package com.fairychar.bag.utils;

import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 字符串工具处理类
 *
 * @author chiyo
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {

    public static String defaultText(String source, String text) {
        return Strings.isNullOrEmpty(source) ? text : source;
    }
}
