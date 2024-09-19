package com.fairychar.bag.template;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.redisson.api.RLock;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 缓存操作template
 *
 * @author chiyo
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CacheOperateTemplate {
    /**
     * 单体缓存读取(不适用与集群环境)
     *
     * @param fromCache 缓存数据提供者
     * @param fromDb    数据库数据提供者
     * @param putCache  数据库数据到缓存数据消费者
     * @param lock      本地lock
     * @param <C>       返回类泛型
     * @return
     */
    public static <C> C get(Supplier<C> fromCache, Supplier<C> fromDb, Consumer<C> putCache, Object lock) {
        C cacheValue = fromCache.get();
        if (cacheValue == null) {
            synchronized (lock) {
                return getAndPutCacheIfNeeded(fromCache, fromDb, putCache);
            }
        }
        return cacheValue;
    }

    /**
     * redis分布式缓存读取(悲观锁方式)
     *
     * @param fromCache 缓存数据提供者
     * @param fromDb    数据库数据提供者
     * @param putCache  数据库数据到缓存数据消费者
     * @param lock      分布式lock实现者
     * @param <C>       返回类泛型
     * @return {@link C}
     */
    public static <C> C get(Supplier<C> fromCache, Supplier<C> fromDb, Consumer<C> putCache, RLock lock) {
        C cacheValue = fromCache.get();
        if (cacheValue == null) {
            try {
                lock.lock();
                return getAndPutCacheIfNeeded(fromCache, fromDb, putCache);
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
        return cacheValue;
    }

    private static <C> C getAndPutCacheIfNeeded(Supplier<C> fromCache, Supplier<C> dataSupplier, Consumer<C> putCache) {
        C cacheValue = fromCache.get();
        if (cacheValue != null) {
            return cacheValue;
        } else {
            C dbValue = dataSupplier.get();
            if (dbValue == null) {
                return null;
            } else {
                putCache.accept(dbValue);
                return dbValue;
            }
        }
    }

}
