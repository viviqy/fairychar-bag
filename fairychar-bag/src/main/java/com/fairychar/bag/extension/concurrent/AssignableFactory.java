package com.fairychar.bag.extension.concurrent;

import com.fairychar.bag.function.Action;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <p>
 * 任务权重分配工具类
 * </p>
 * <p>
 * 分配工人数多少并没有加快任务执行速度,
 * 分配意义在于如一个资源访问能接收3个
 * 流请求,A任务会建立2个流,B任务会建立
 * 一个流,限制A任务分配2个连接,B任务分配
 * 1个连接,则AB任务可同时运行,而2个B任务
 * 会其他一个进入等待队列之后运行
 * </p>
 *
 * @author chiyo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AssignableFactory {
    private ExecutorService executor;
    private Semaphore semaphore;

    /**
     * 初始化工厂
     *
     * @param workers  招募的工人数
     * @param executor 执行线程池
     * @return {@link AssignableFactory}
     */
    public static AssignableFactory recruitWorkers(int workers, ExecutorService executor) {
        AssignableFactory assignableFactory = new AssignableFactory();
        assignableFactory.semaphore = new Semaphore(workers);
        assignableFactory.executor = executor;
        return assignableFactory;
    }

    /**
     * 初始化工厂
     *
     * @param workers 招募的工人数
     * @return
     */
    public static AssignableFactory recruitWorkers(int workers) {
        AssignableFactory assignableFactory = new AssignableFactory();
        assignableFactory.semaphore = new Semaphore(workers);
        assignableFactory.executor = Executors.newCachedThreadPool();
        return assignableFactory;
    }

    /**
     * 执行一个任务,默认分配一个工人
     *
     * @param action 任务
     */
    public void doWork(Action action) {
        this.doWork(action, 1, null);
    }

    /**
     * 执行任务
     *
     * @param action  任务
     * @param workers 分配的工人数
     */
    public void doWork(Action action, int workers) {
        this.doWork(action, workers, null);
    }

    /**
     * 执行任务
     *
     * @param action          任务
     * @param workers         分配工人数
     * @param timeoutCallback 超时回调函数
     */
    public void doWork(Action action, int workers, Consumer<Exception> timeoutCallback) {
        executor.execute(() -> {
            try {
                this.semaphore.acquire(workers);
                action.doAction();
            } catch (InterruptedException ignore) {
            } catch (TimeoutException e) {
                Optional.ofNullable(timeoutCallback).ifPresent(t -> t.accept(e));
            } finally {
                this.semaphore.release(workers);
            }
        });
    }

    /**
     * 阻塞方法执行任务,并等待返回结果
     *
     * @param supplier 任务提供
     * @param workers  分配工人数
     * @param <T>      返回泛型
     * @return <T> T
     * @throws ExecutionException   {@link ExecutionException}
     * @throws InterruptedException {@link InterruptedException}
     */
    public <T> T doWork(Supplier<T> supplier, int workers) throws ExecutionException, InterruptedException {
        Future<T> future = this.doWorkFuture(supplier, workers);
        return future.get();
    }

    /**
     * 异步执行任务
     *
     * @param supplier 任务提供
     * @param workers  分配工人数
     * @param <T>
     * @return {@link Future}
     * @throws ExecutionException   {@link ExecutionException}
     * @throws InterruptedException {@link InterruptedException}
     */
    public <T> Future<T> doWorkFuture(Supplier<T> supplier, int workers) throws ExecutionException, InterruptedException {
        Future<T> future = executor.submit(() -> {
            try {
                this.semaphore.acquire(workers);
                T t = supplier.get();
                return t;
            } catch (InterruptedException ignore) {
            } finally {
                this.semaphore.release(workers);
            }
            return null;
        });
        return future;
    }

    /**
     * 获取可用工人数
     *
     * @return 可用工人数
     */
    public int getAvailableWorkers() {
        return this.semaphore.availablePermits();
    }
}
