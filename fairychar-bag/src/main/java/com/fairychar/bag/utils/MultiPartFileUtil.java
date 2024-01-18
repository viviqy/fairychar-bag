package com.fairychar.bag.utils;

import cn.hutool.core.lang.Assert;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 引入了hutools,这个类没用了
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Deprecated
public final class MultiPartFileUtil {
    public static String getSuffix(String fileName) {
        Assert.notNull(fileName);
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    public static String getNameWithOutSuffix(String fileName) {
        Assert.notNull(fileName);
        return fileName.substring(0, fileName.lastIndexOf('.'));
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