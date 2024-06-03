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
 * Datetime: 2021/1/26 10:32
 *
 * @author chiyo
 * @since 1.0
 */
@NoArgsConstructor
@Slf4j
public class ActionSelectorTemplate {


    private Map<String, ActionSchedule> selector = new ConcurrentHashMap<>(32);
    private ExecutorService boss = Executors.newSingleThreadExecutor();
    @Setter
    private long timePause = 100;

    private ExecutorService worker = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private State state = State.UN_INITIALIZE;


    public ActionSelectorTemplate(ExecutorService boss, ExecutorService worker) {
        this.boss = boss;
        this.worker = worker;
    }

    public void start() {
        this.state = State.WORKING;
        this.boss.execute(() -> {
            while (true) {
                this.selector.values().iterator().forEachRemaining(c -> {
                    long executeTimestamp = c.getLastExecuteTime() + c.getPeriod();
                    if (System.currentTimeMillis() > executeTimestamp) {
                        log.info("executing actionSchedule task name={}", c.getTaskName());
                        c.setLastExecuteTime(System.currentTimeMillis());
                        this.worker.execute(() -> {
                            try {
                                c.setWorking(true);
                                c.getAction().doAction0();
                            } catch (InterruptedException e) {
                                log.info("打断任务:{}", c.getTaskName());
                            } catch (TimeoutException e) {
                                log.error("任务超时:{}", e.getMessage());
                            } finally {
                                c.setWorking(false);
                            }
                        });
                    }
                });
                try {
                    TimeUnit.MILLISECONDS.sleep(this.timePause);
                } catch (InterruptedException e) {
                    log.info("boss thread interrupted at {}", System.currentTimeMillis());
                    break;
                }
            }
        });
    }

    @PreDestroy
    public void shutdownGracefully() {
        this.checkState(this.state != State.WORKING, "actionSchedules not started");
        this.state = State.STOPPING;
        log.info("{}", "shutting down actionSchedules");
        if (this.worker.isShutdown()) {
            return;
        }
        this.boss.shutdown();
        this.worker.shutdown();
        this.state = State.STOPPED;
    }

    public void shutdownNow() {
        this.checkState(this.state != State.WORKING, "actionSchedules not started");
        if (this.worker.isShutdown()) {
            return;
        }
        this.boss.shutdownNow();
        this.worker.shutdownNow();
        this.state = State.STOPPED;
    }

    public void remove(String taskName) {
        this.remove(taskName, true);
    }

    public void remove(String taskName, boolean isInterrupt) {
        ActionSchedule actionSchedule = this.selector.get(taskName);
        if (actionSchedule == null) {
            return;
        }
        if (isInterrupt) {
            actionSchedule.getAction().interruptAll();
        }
        this.selector.remove(taskName);
    }

    public void put(String taskName, long period, AbstractScheduleAction action) {
        this.checkState(this.state == State.STOPPING, "cant add new task when on stopping state");
        ActionSchedule actionSchedule = new ActionSchedule(taskName, period, action);
        this.checkArgs(actionSchedule);
        this.selector.put(actionSchedule.getTaskName(), actionSchedule);
    }

    private void checkState(boolean condition, String errorMsg) {
        if (condition) {
            throw new UnsupportedOperationException(errorMsg);
        }
    }


    public void put(String taskName, long period, Action action) {
        ActionSchedule actionSchedule = new ActionSchedule(taskName, period, new AbstractScheduleAction() {
            @Override
            public void doAction() throws InterruptedException, TimeoutException {
                action.doAction();
            }
        });
        this.checkArgs(actionSchedule);
        this.selector.put(actionSchedule.getTaskName(), actionSchedule);
    }

    public void put(ActionSchedule actionSchedule) {
        this.checkArgs(actionSchedule);
        this.selector.put(actionSchedule.getTaskName(), actionSchedule);
    }

    private void checkArgs(ActionSchedule actionSchedule) {
        if (this.selector.keySet().contains(actionSchedule.getTaskName())) {
            throw new IllegalArgumentException("任务名称重复");
        }
        Assert.isTrue(actionSchedule.getPeriod() > 0, "执行周期必须大于0");
        Assert.notNull(actionSchedule.getAction(), "任务不能为null");
    }


}
