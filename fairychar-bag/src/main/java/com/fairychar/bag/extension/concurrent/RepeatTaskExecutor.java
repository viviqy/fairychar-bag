package com.fairychar.bag.extension.concurrent;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.function.Action;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * <p>
 * 任务编排循环执行工具
 * <p>
 * 传入任务列表后,将会根据批次无限循环执行
 * </p>
 *
 * @author chiyo
 */
@Slf4j
public final class RepeatTaskExecutor {
    private final CyclicBarrier cyclicBarrier;
    private final List<Action> runnables;
    private final ExecutorService executorService;
    private final AtomicLong executeTimes;

    private RepeatTaskExecutor(List<Action> runnables, String taskName) {
        Assert.notBlank(taskName);
        this.cyclicBarrier = new CyclicBarrier(runnables.size());
        this.runnables = runnables;
        this.executeTimes = new AtomicLong(0);
        this.executorService = new ThreadPoolExecutor(runnables.size(), runnables.size()
                , 60, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1024), new ThreadFactoryBuilder()
                .setNameFormat(taskName + "-pool-%d").build());
    }

    /**
     * 创建任务批次执行工具类
     *
     * @param tasklist 任务列表
     * @return {@link RepeatTaskExecutor}
     */
    public static RepeatTaskExecutor createCycle(List<Action> tasklist, String taskName) {
        return new RepeatTaskExecutor(tasklist, taskName);
    }


    /**
     * 使用默认参数启动任务执行
     */
    public void start() {
        start(null, null, null, Integer.MAX_VALUE);
    }


    /**
     * 启动任务执行
     *
     * @param onInterrupted 当任务被打断时的异常处理
     * @param onTimeout     当任务超时时的异常处理
     * @param onBroken      当任务被终止时的异常处理
     * @param waitMillis    当前批次中执行完的任务等待未执行完的任务的最长毫秒数(超时会触发{@link BrokenBarrierException})
     */
    public void start(Consumer<InterruptedException> onInterrupted, Consumer<TimeoutException> onTimeout, Consumer<BrokenBarrierException> onBroken, long waitMillis) {
        runnables.forEach(action -> executorService.execute(() -> {
            while (true) {
                try {
                    if (this.cyclicBarrier.isBroken()) {
                        return;
                    }
                    action.doAction();
                    this.cyclicBarrier.await(waitMillis, TimeUnit.MILLISECONDS);
                    this.executeTimes.incrementAndGet();
                } catch (InterruptedException e) {
                    Optional.ofNullable(onInterrupted).ifPresent(interruptedExceptionConsumer -> interruptedExceptionConsumer.accept(e));
                    return;
                } catch (TimeoutException e) {
                    Optional.ofNullable(onTimeout).ifPresent(timeoutExceptionConsumer -> timeoutExceptionConsumer.accept(e));
                    return;
                } catch (BrokenBarrierException e) {
                    Optional.ofNullable(onBroken).ifPresent(brokenBarrierExceptionConsumer -> brokenBarrierExceptionConsumer.accept(e));
                    return;
                } finally {
                }
            }
        }));
    }

    /**
     * 获取已执行任务次数
     *
     * @return 已执行次数
     */
    public long getExecutedTimes() {
        return this.executeTimes.get();
    }


    /**
     * 停止
     */
    public void stop() {
        this.cyclicBarrier.reset();
    }
}