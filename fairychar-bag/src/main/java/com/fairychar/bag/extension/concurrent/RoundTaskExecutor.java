package com.fairychar.bag.extension.concurrent;

import com.fairychar.bag.function.Action;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * <p>任务批量执行器</p>
 * 多个任务链将会同一下标的任务统一一起执行,全部执行成功后才会又执行下一个下标的任务
 *
 * @author chiyo
 */
@Slf4j
public final class RoundTaskExecutor {
    private final Phaser phaser;
    private final List<List<Action>> taskList;
    /**
     * 总任务执行轮数
     */
    @Getter
    private final AtomicInteger executeRound;
    /**
     * 已执行完成的任务数量
     */
    @Getter
    private final AtomicInteger executedTaskCount;
    /**
     * 目前执行到的任务轮数
     */
    @Getter
    private final AtomicInteger executedRound;
    private final ExecutorService executorService;

    private RoundTaskExecutor(@NotNull List<List<Action>> taskList, int executeRound) {
        assert taskList != null;
        this.phaser = new Phaser(taskList.size());
        this.taskList = taskList;
        this.executorService = Executors.newFixedThreadPool(taskList.size());
        this.executeRound = new AtomicInteger(executeRound);
        this.executedRound = new AtomicInteger(0);
        this.executedTaskCount = new AtomicInteger(0);
    }

    public static RoundTaskExecutor boxedTaskList(@NotNull List<List<Action>> tasklist) {
        return boxedTaskList(tasklist, 0);
    }

    public static RoundTaskExecutor boxedTaskList(@NotNull List<List<Action>> tasklist, int round) {
        Integer max = tasklist.stream().map(List::size).max(Integer::compareTo).get();
        tasklist.forEach(l -> {
            for (int i = l.size(); i < max; i++) {
                l.add(() -> {
                    //do nothing
                });
            }
        });
        return new RoundTaskExecutor(Collections.unmodifiableList(tasklist), round);
    }

    public void start(Consumer<InterruptedException> onInterrupted, Consumer<TimeoutException> onTimeout) {
        this.taskList.forEach(list -> executorService.execute(() -> list.forEach(task -> {
            try {
                int current = this.executedRound.get();
                task.doAction();
                this.executedTaskCount.incrementAndGet();
                this.phaser.arriveAndAwaitAdvance();
                this.executedRound.compareAndSet(current, current + 1);
            } catch (InterruptedException e) {
                Optional.ofNullable(onInterrupted).ifPresent(interruptedExceptionConsumer -> interruptedExceptionConsumer.accept(e));
                this.phaser.arriveAndDeregister();
            } catch (TimeoutException e) {
                Optional.ofNullable(onTimeout).ifPresent(timeoutExceptionConsumer -> timeoutExceptionConsumer.accept(e));
                this.phaser.arriveAndDeregister();
            }
        })));
    }

    public void start() {
        start(null, null);
    }


    public void awaitTaskDone() {
        this.phaser.register();
        this.phaser.arriveAndAwaitAdvance();
    }

    public void stop() {
        this.phaser.forceTermination();
    }
}
