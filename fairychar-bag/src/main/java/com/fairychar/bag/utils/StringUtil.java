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

    /**
     * 从开头开始填充字符串到固定长度
     *
     * @param source 源字符串
     * @param c      填充字符
     * @param length 到固定的长度
     * @return {@link String }
     */
    public static String fillBegin(String source, char c, int length) {
        if (source.length() >= length) {
            return source;
        }
        int appendLength = length - source.length();
        String prefix = Strings.repeat(String.valueOf(c), appendLength);
        return prefix.concat(source);
    }


    /**
     * 从后面开始填充字符串到固定长度
     *
     * @param source 源字符串
     * @param c      填充字符
     * @param length 到固定的长度
     * @return {@link String }
     */
    public static String fillEnd(String source, char c, int length) {
        if (source.length() >= length) {
            return source;
        }
        int appendLength = length - source.length();
        String suffix = Strings.repeat(String.valueOf(c), appendLength);
        return source.concat(suffix);
    }

    /**
     * 当原文本为空或null的时候,返回默认文本,否则原文本
     *
     * @param source 源文本
     * @param text   默认文本
     * @return {@link String }
     */
    public static String defaultText(String source, String text) {
        return Strings.isNullOrEmpty(source) ? text : source;
    }
}
