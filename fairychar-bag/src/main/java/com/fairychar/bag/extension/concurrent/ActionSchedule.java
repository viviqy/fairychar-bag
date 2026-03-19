package com.fairychar.bag.extension.concurrent;

import com.fairychar.bag.domain.abstracts.AbstractScheduleAction;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 周期调度型任务,配合{@link com.fairychar.bag.template.ActionSelectorTemplate}使用
 *
 * @author chiyo
 * @since 1.0
 */
@RequiredArgsConstructor
@Data
public final class ActionSchedule implements Comparable<ActionSchedule> {
    /**
     * 任务名称(默认当前线程名称)
     */
    @NonNull
    private String taskName;
    
    /**
     * 任务执行状态，使用AtomicBoolean确保线程安全和原子操作
     */
    private final AtomicBoolean working = new AtomicBoolean(false);
    
    @NonNull
    private long period;
    
    /**
     * 上次执行时间，使用AtomicLong确保线程安全
     */
    private final AtomicLong lastExecuteTime = new AtomicLong(System.currentTimeMillis());
    
    @NonNull
    private AbstractScheduleAction action;
    
    /**
     * 获取任务执行状态
     * @return true表示正在执行
     */
    public boolean isWorking() {
        return working.get();
    }
    
    /**
     * 获取AtomicBoolean引用，用于CAS操作
     * @return AtomicBoolean实例
     */
    public AtomicBoolean getWorkingAtomic() {
        return working;
    }
    
    /**
     * 获取上次执行时间
     * @return 时间戳
     */
    public long getLastExecuteTime() {
        return lastExecuteTime.get();
    }
    
    /**
     * 获取AtomicLong引用，用于原子操作
     * @return AtomicLong实例
     */
    public AtomicLong getLastExecuteTimeAtomic() {
        return lastExecuteTime;
    }


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
