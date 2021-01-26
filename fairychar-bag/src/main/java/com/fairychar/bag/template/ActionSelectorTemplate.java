package com.fairychar.bag.template;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.abstracts.AbstractScheduleAction;
import com.fairychar.bag.domain.enums.State;
import com.fairychar.bag.extension.concurrent.ActionSchedule;
import com.fairychar.bag.function.Action;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Datetime: 2021/1/26 10:32 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@NoArgsConstructor
@Slf4j
public class ActionSelectorTemplate {

    private Map<String, ActionSchedule> selector = new ConcurrentHashMap<>(8);
    private ExecutorService boss = Executors.newSingleThreadExecutor();
    @Setter
    private long timePause = 100;
    @Setter
    private ExecutorService worker = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private State state = State.UN_INITIALIZE;

    public void start() {
        state = State.WORKING;
        boss.execute(() -> {
            while (true) {
                selector.values().iterator().forEachRemaining(c -> {
                    long executeTimestamp = c.getLastExecuteTime() + c.getPeriod();
                    if (System.currentTimeMillis() > executeTimestamp) {
                        if (log.isInfoEnabled()) {
                            log.info("executing actionSchedule task name={}", c.getTaskName());
                        }
                        c.setLastExecuteTime(System.currentTimeMillis());
                        worker.execute(() -> {
                            try {
                                c.setWorking(true);
                                c.getAction().doAction0();
                                c.setWorking(false);
                            } catch (InterruptedException e) {
                                log.info("打断任务:{}", c.getTaskName());
                            } catch (TimeoutException e) {
                                log.error("任务超时:{}", e.getMessage());
                            }
                        });
                    }
                });
                try {
                    TimeUnit.MILLISECONDS.sleep(timePause);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
    }

    @PreDestroy
    public void shutdownGracefully() {
        checkState(this.state != State.WORKING, "actionSchedules not started");
        this.state = State.STOPPING;
        log.info("{}", "shutting down actionSchedules");
        if (worker.isShutdown()) {
            return;
        }
        boss.shutdown();
        worker.shutdown();
        this.state = State.STOPPED;
    }

    public void shutdownNow() {
        checkState(this.state != State.WORKING, "actionSchedules not started");
        if (worker.isShutdown()) {
            return;
        }
        boss.shutdownNow();
        worker.shutdownNow();
        this.state = State.STOPPED;
    }

    public void remove(String taskName) {
        this.remove(taskName, true);
    }

    public void remove(String taskName, boolean isInterrupt) {
        ActionSchedule actionSchedule = selector.get(taskName);
        if (actionSchedule == null) {
            return;
        }
        if (isInterrupt) {
            actionSchedule.getAction().interruptAll();
        }
        this.selector.remove(taskName);
    }

    public void put(String taskName, long period, AbstractScheduleAction action) {
        checkState(this.state == State.STOPPING, "cant add new task when on stopping state");
        ActionSchedule actionSchedule = new ActionSchedule(taskName, period, action);
        checkArgs(actionSchedule);
        selector.put(actionSchedule.getTaskName(), actionSchedule);
    }

    private void checkState(boolean b, String s) {
        if (b) {
            throw new UnsupportedOperationException(s);
        }
    }


    public void put(String taskName, long period, Action action) {
        ActionSchedule actionSchedule = new ActionSchedule(taskName, period, new AbstractScheduleAction() {
            @Override
            public void doAction() throws InterruptedException, TimeoutException {
                action.doAction();
            }
        });
        checkArgs(actionSchedule);
        selector.put(actionSchedule.getTaskName(), actionSchedule);
    }

    public void put(ActionSchedule actionSchedule) {
        checkArgs(actionSchedule);
        selector.put(actionSchedule.getTaskName(), actionSchedule);
    }

    private void checkArgs(ActionSchedule actionSchedule) {
        if (selector.keySet().contains(actionSchedule.getTaskName())) {
            throw new IllegalArgumentException("任务名称重复");
        }
        Assert.isTrue(actionSchedule.getPeriod() > 0, "执行周期必须大于0");
        Assert.notNull(actionSchedule.getAction(), "任务不能为null");
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