package com.fairychar.bag.utils;

import com.fairychar.bag.domain.exceptions.FBException;
import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 字符串工具处理类
 *
 * @author chiyo
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {

    /**
     * 使用gzip压缩字符串
     *
     * @param data 数据
     * @return {@link byte[] }
     * @throws IOException io异常
     */
    public static byte[] compressByGzip(String data) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             GZIPOutputStream gzip = new GZIPOutputStream(bos)) {
            gzip.write(data.getBytes(StandardCharsets.UTF_8));
            gzip.finish();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new FBException(e);
        }
    }

    /**
     * 使用gzip解压缩byte[]为字符串
     *
     * @param compressedData 数据
     * @return {@link byte[] }
     * @throws IOException io异常
     */
    public static String decompressByGzip(byte[] compressedData) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(compressedData);
             GZIPInputStream gzip = new GZIPInputStream(bis);
             BufferedReader br = new BufferedReader(new InputStreamReader(gzip, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new FBException(e);
        }
    }

    /**
     * 从开头开始填充字符串到固定长度
     * {@link Strings#padStart(String, int, char)}
     *
     * @param source 源字符串
     * @param c      填充字符
     * @param length 到固定的长度
     * @return {@link String }
     */
    @Deprecated
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
     * {@link Strings#padEnd(String, int, char)}
     *
     * @param source 源字符串
     * @param c      填充字符
     * @param length 到固定的长度
     * @return {@link String }
     */
    @Deprecated
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
