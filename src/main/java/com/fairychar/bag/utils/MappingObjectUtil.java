package com.fairychar.bag.utils;

import com.fairychar.bag.pojo.ao.MappingObjectAO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2020/4/22 <br>
 * time: 12:51 <br>
 *
 * @author lmq <br>
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MappingObjectUtil {
    public final static <K, V> List<MappingObjectAO<K, V>> mapping(Map<K, List<V>> maps) {
        return maps.entrySet().stream()
                .map(e -> new MappingObjectAO<K, V>(e.getKey(), e.getValue().size(), e.getValue()))
                .collect(Collectors.toList());
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