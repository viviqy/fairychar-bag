package com.fairychar.bag.beans.redis;

import cn.hutool.core.lang.Assert;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.Charset;

/**
 * 固定前缀StringRedisSerializer
 * @author chiyo <br>
 * @since 1.0
 */
public class PrefixStringSerializer extends StringRedisSerializer {
    private final String prefix;

    public PrefixStringSerializer(String prefix) {
        super();
        this.prefix = prefix;
    }

    public PrefixStringSerializer(Charset charset, String prefix) {
        super(charset);
        Assert.notNull(prefix, () -> new BeanCreationException("Prefix string must not be null"));
        this.prefix = prefix;
    }


    @Override
    public String deserialize(byte[] bytes) {
        return super.deserialize(bytes);
    }

    @Override
    public byte[] serialize(String string) {
        String keyWithPrefix = this.prefix.concat(string);
        return super.serialize(keyWithPrefix);
    }
}
