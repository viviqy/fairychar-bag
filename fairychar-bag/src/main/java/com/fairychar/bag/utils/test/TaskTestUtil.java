package com.fairychar.bag.utils.test;

import com.fairychar.bag.function.Action;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 线程测试工具类
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TaskTestUtil {


    /**
     * 并发运行异步
     *
     * @param actions         行动
     * @param executorService 线程池
     */
    public static void concurrentRunAsync(List<Action> actions, ExecutorService executorService) {
        CountDownLatch countDownLatch = new CountDownLatch(actions.size());
        List<? extends Future<?>> futures = actions.stream().map(a -> executorService.submit(() -> {
            countDownLatch.countDown();
            try {
                a.doAction();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        })).collect(Collectors.toList());
        futures.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * 并发运行异步
     *
     * @param actions 行动
     */
    public static void concurrentRunAsync(List<Action> actions) {
        ExecutorService executorService = createThreadPool("concurrentRunAsync", actions.size());
        concurrentRunAsync(actions, executorService);
        executorService.shutdown();
    }


    /**
     * 创建线程池
     *
     * @param poolName 池名称
     * @param size     大小
     * @return {@link ExecutorService}
     */
    public static ExecutorService createThreadPool(String poolName, int size) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(size
                , size
                , 1, TimeUnit.MINUTES
                , new LinkedBlockingQueue<>(1024)
                , new ThreadFactoryBuilder().setNameFormat(poolName + "-pool-%d").build());
        return executor;
    }


    /**
     * 按 CPU 内核创建线程池
     *
     * @param poolName 池名称
     * @return {@link ExecutorService}
     */
    public static ExecutorService createThreadPoolByCpuCore(String poolName) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()
                , Runtime.getRuntime().availableProcessors()
                , 1, TimeUnit.MINUTES
                , new LinkedBlockingQueue<>(1024)
                , new ThreadFactoryBuilder().setNameFormat(poolName + "-pool-%d").build());
        return executor;
    }

    /**
     * 按 CPU 内核创建线程池
     *
     * @param poolName 池名称
     * @param multi    倍数
     * @return {@link ExecutorService}
     */
    public static ExecutorService createThreadPoolByCpuCore(String poolName, int multi) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()
                , Runtime.getRuntime().availableProcessors() * multi
                , 1, TimeUnit.MINUTES
                , new LinkedBlockingQueue<>(1024)
                , new ThreadFactoryBuilder().setNameFormat(poolName + "-pool-%d").build());
        return executor;
    }

    /**
     * 批量运行同步任务
     *
     * @param actions         行动
     * @param executorService 遗嘱执行人服务
     * @return long
     */
    public static long batchRunSync(List<Action> actions, ExecutorService executorService) {
        long begin = System.currentTimeMillis();
        List<? extends Future<?>> futures = actions.stream().map(a -> executorService.submit(() -> {
            try {
                a.doAction();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        })).collect(Collectors.toList());
        futures.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        long end = System.currentTimeMillis();
        return end - begin;
    }

    /**
     * 批量运行异步任务
     *
     * @param actions         行动
     * @param executorService 遗嘱执行人服务
     */
    public static void batchRunAsync(List<Action> actions, ExecutorService executorService) {
        for (Action action : actions) {
            executorService.execute(() -> {
                try {
                    action.doAction();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    /**
     * 批量运行同步任务
     *
     * @param action          行动
     * @param round           多少轮
     * @param executorService 线程池
     * @return long
     */
    public static long batchRunSync(Action action, int round, ExecutorService executorService) {
        long begin = System.currentTimeMillis();
        List<? extends Future<?>> futureList = IntStream.range(0, round).boxed()
                .map(i -> executorService.submit(() -> {
                    try {
                        action.doAction();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (TimeoutException e) {
                        throw new RuntimeException(e);
                    }
                })).collect(Collectors.toList());
        futureList.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        long end = System.currentTimeMillis();
        return end - begin;
    }


    /**
     * 批量运行异步任务
     *
     * @param action          行动
     * @param round           多少轮
     * @param executorService 线程池
     */
    public static void batchRunAsync(Action action, int round, ExecutorService executorService) {
        for (int i = 0; i < round; i++) {
            executorService.execute(() -> {
                try {
                    action.doAction();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    /**
     * 获取任务花费毫秒数
     *
     * @param task  任务
     * @param round 圆
     * @return long
     * @throws InterruptedException 中断异常
     * @throws TimeoutException     超时异常
     */
    public static long getWasteMillis(Action task, int round) throws InterruptedException, TimeoutException {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < round; i++) {
            task.doAction();
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }
}
