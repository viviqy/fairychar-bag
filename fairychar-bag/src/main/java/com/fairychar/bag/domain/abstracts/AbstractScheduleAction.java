package com.fairychar.bag.domain.abstracts;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.fairychar.bag.function.Action;

import java.util.Set;
import java.util.concurrent.TimeoutException;

/**
 * Datetime: 2021/1/26 16:09 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public abstract class AbstractScheduleAction implements Action {
    private Set<Thread> executeThreads = new ConcurrentHashSet<>(1);

    /**
     * 任务逻辑
     *
     * @throws InterruptedException 打断触发
     * @throws TimeoutException     超时触发
     */
    @Override
    public abstract void doAction() throws InterruptedException, TimeoutException;

    /**
     * 任务
     */
    public void doAction0() throws TimeoutException, InterruptedException {
        this.executeThreads.add(Thread.currentThread());
        doAction();
        this.executeThreads.remove(Thread.currentThread());
    }


    /**
     * 打断指定线程
     *
     * @param thread
     */
    public synchronized void interrupt(Thread thread) {
        if (this.executeThreads.contains(thread)) {
            this.executeThreads.removeIf(t -> t == thread);
            thread.interrupt();
        }
    }

    public synchronized void interruptAll() {
        this.executeThreads.removeIf(t -> {
            t.interrupt();
            return true;
        });
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