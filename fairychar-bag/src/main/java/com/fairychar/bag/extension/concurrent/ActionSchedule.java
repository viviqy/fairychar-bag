package com.fairychar.bag.extension.concurrent;

import com.fairychar.bag.domain.abstracts.AbstractScheduleAction;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 周期调度型任务,配合{@link com.fairychar.bag.template.ActionSelectorTemplate}使用
 * Datetime: 2021/1/26 10:18 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@RequiredArgsConstructor
@Data
public class ActionSchedule implements Comparable<ActionSchedule> {
    /**
     * 任务名称(默认当前线程名称)
     */
    @NonNull
    private String taskName;
    private boolean isWorking;
    @NonNull
    private long period;
    private long lastExecuteTime = System.currentTimeMillis();
    @NonNull
    private AbstractScheduleAction action;


    /**
     * 根据任务名称判断
     *
     * @param o 定时任务执行器
     * @return
     */
    @Override
    public int compareTo(ActionSchedule o) {
        return this.taskName.equals(o.taskName) ? 1 : 0;
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