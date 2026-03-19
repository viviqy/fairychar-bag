package com.fairychar.bag.template;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.domain.abstracts.AbstractScheduleAction;
import com.fairychar.bag.domain.enums.RunState;
import com.fairychar.bag.extension.concurrent.ActionSchedule;
import com.fairychar.bag.function.Action;
import jakarta.annotation.PreDestroy;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

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
    private volatile RunState runState = RunState.UN_INITIALIZE;


    public ActionSelectorTemplate(ExecutorService boss, ExecutorService worker) {
        this.boss = boss;
        this.worker = worker;
    }

    public void start() {
        this.runState = RunState.WORKING;
        this.boss.execute(() -> {
            while (true) {
                this.selector.values().iterator().forEachRemaining(c -> {
                    long executeTimestamp = c.getLastExecuteTime() + c.getPeriod();
                    if (System.currentTimeMillis() > executeTimestamp) {
                        // 使用CAS原子操作尝试获取执行权
                        // 只有成功将working从false改为true，才提交任务
                        if (c.getWorkingAtomic().compareAndSet(false, true)) {
                            log.info("executing actionSchedule task name={}", c.getTaskName());
                            // 更新最后执行时间（在任务提交后更新，确保时间准确）
                            c.getLastExecuteTimeAtomic().set(System.currentTimeMillis());
                            this.worker.execute(() -> {
                                try {
                                    c.getAction().doAction0();
                                } catch (InterruptedException e) {
                                    log.info("打断任务:{}", c.getTaskName());
                                } catch (TimeoutException e) {
                                    log.error("任务超时:{}", e.getMessage());
                                } finally {
                                    // 任务完成或异常后，释放执行权
                                    c.getWorkingAtomic().set(false);
                                }
                            });
                        } else {
                            // CAS失败，说明任务正在执行中，跳过本次调度
                            log.debug("任务正在执行中，跳过本次调度: taskName={}", c.getTaskName());
                        }
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
        this.checkState(this.runState != RunState.WORKING, "actionSchedules not started");
        this.runState = RunState.STOPPING;
        log.info("{}", "shutting down actionSchedules");
        if (this.worker.isShutdown()) {
            return;
        }
        this.boss.shutdown();
        this.worker.shutdown();
        this.runState = RunState.STOPPED;
    }

    public void shutdownNow() {
        this.checkState(this.runState != RunState.WORKING, "actionSchedules not started");
        if (this.worker.isShutdown()) {
            return;
        }
        this.boss.shutdownNow();
        this.worker.shutdownNow();
        this.runState = RunState.STOPPED;
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
        this.checkState(this.runState == RunState.STOPPING, "cant add new task when on stopping state");
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
            public void doAction() throws RuntimeException {
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
