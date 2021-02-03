package com.fairychar.bag.utils;

import cn.hutool.core.lang.Assert;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * Date: 2020/5/20 <br>
 * time: 16:46 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CircularTaskUtil {


    /**
     * @param task      执行任务
     * @param condition 成功条件
     * @return True为执行成功, false为失败
     */
    public static boolean run(Future<Boolean> task, boolean condition) throws ExecutionException {
        return run(task, condition, 0, 0);
    }


    /**
     * 循环执行任务,当匹配条件相等,或者超过最大循环次数或超过最大执行时间时退出
     *
     * @param task      执行任务
     * @param condition 成功条件
     * @param maxRound  最大循环次数(0为无限)
     * @param maxMillis 最大执行时间,无法根据时间打断supplier方法体,仅在下一次重新循环时计算时间(单位毫秒)(0为无限)
     * @return True为执行成功, false为失败
     */
    public static boolean run(Future<Boolean> task, boolean condition, int maxRound, int maxMillis) throws ExecutionException {
        boolean result = false;
        Assert.isTrue(maxRound >= 0 && maxMillis >= 0, "round and millis must greater than -1");
        int currentRound = 0;
        long start = System.currentTimeMillis();
        while (true) {
            if (maxRound > 0) {
                if (currentRound > maxRound) {
                    result = false;
                    break;
                } else {
                    currentRound++;
                }
            }
            if (maxMillis > 0) {
                if (System.currentTimeMillis() - start > maxMillis) {
                    result = false;
                    break;
                }
            }
            try {
                if (task.get() == condition) {
                    result = true;
                    break;
                }
            } catch (InterruptedException e) {
                break;
            } catch (ExecutionException e) {
                throw e;
            }
        }
        return result;
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