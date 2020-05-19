package com.fairychar.bag.template;

import com.sun.org.apache.regexp.internal.RE;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
    public static <C> C get(Supplier<C> cache, Supplier<C> db, Consumer<C> toCache, Object lock) {
        C cacheValue = cache.get();
        if (cacheValue == null) {
            synchronized (lock) {
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
        return cacheValue;
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