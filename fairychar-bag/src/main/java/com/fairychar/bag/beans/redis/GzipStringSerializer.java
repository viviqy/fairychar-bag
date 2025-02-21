package com.fairychar.bag.beans.redis;

import com.fairychar.bag.utils.StringUtil;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Gzip压缩StringRedisSerializer
 *
 * @author chiyo <br>
 * @since 1.0
 */
@NoArgsConstructor
public class GzipStringSerializer extends StringRedisSerializer {


    @Override
    public String deserialize(byte[] bytes) {
        return StringUtil.decompressByGzip(bytes);
    }

    @Override
    public byte[] serialize(String string) {
        byte[] key = StringUtil.compressByGzip(string);
        return key;
    }
}
