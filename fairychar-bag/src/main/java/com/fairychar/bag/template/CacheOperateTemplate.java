package com.fairychar.bag.template;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created with IDEA <br>
 * Date: 2020/5/18 <br>
 * time: 09:10 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CacheOperateTemplate {
    /**
     * 单体缓存读取(不适用与集群环境)
     *
     * @param cache   缓存数据提供者
     * @param db      数据库数据提供者
     * @param toCache 数据库数据到缓存数据消费者
     * @param lock    本地lock
     * @param <C>     返回类泛型
     * @return
     */
    public static <C> C get(Supplier<C> cache, Supplier<C> db, Consumer<C> toCache, Object lock) {
        C cacheValue = cache.get();
        if (cacheValue == null) {
            synchronized (lock) {
                return dbToCacheAndGet(cache, db, toCache);
            }
        }
        return cacheValue;
    }

    /**
     * 分布式缓存读取(悲观锁方式)
     *
     * @param cache   缓存数据提供者
     * @param db      数据库数据提供者
     * @param toCache 数据库数据到缓存数据消费者
     * @param lock    分布式lock实现者
     * @param <C>     返回类泛型
     * @return {@link C}
     */
    public static <C> C get(Supplier<C> cache, Supplier<C> db, Consumer<C> toCache, Lock lock) {
        C cacheValue = cache.get();
        if (cacheValue == null) {
            try {
                lock.lockInterruptibly();
                return dbToCacheAndGet(cache, db, toCache);
            } catch (InterruptedException ignore) {
            } finally {
                lock.unlock();
            }
        }
        return cacheValue;
    }

    private static <C> C dbToCacheAndGet(Supplier<C> cache, Supplier<C> db, Consumer<C> toCache) {
        C secondCacheValue = cache.get();
        if (secondCacheValue != null) {
            return secondCacheValue;
        } else {
            C dbValue = db.get();
            if (dbValue == null) {
                return null;
            } else {
                toCache.accept(dbValue);
                return dbValue;
            }
        }
    }

}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/