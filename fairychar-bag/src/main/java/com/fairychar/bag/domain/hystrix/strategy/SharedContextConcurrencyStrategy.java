package com.fairychar.bag.domain.hystrix.strategy;

import com.fairychar.bag.domain.hystrix.callable.SharedContextCallable;
import com.fairychar.bag.domain.hystrix.callable.base.CallableContext;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Datetime: 2021/12/14 16:54
 *
 * @author chiyo
 * @since 1.0
 */
@AllArgsConstructor
public class SharedContextConcurrencyStrategy extends HystrixConcurrencyStrategy {
    private HystrixConcurrencyStrategy existingConcurrencyStrategy;
    private List<CallableContext<?>> callableContexts;


    @Override
    public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
        return this.existingConcurrencyStrategy != null
                ? this.existingConcurrencyStrategy.getBlockingQueue(maxQueueSize)
                : super.getBlockingQueue(maxQueueSize);
    }

    @Override
    public <T> HystrixRequestVariable<T> getRequestVariable(
            HystrixRequestVariableLifecycle<T> rv) {
        return this.existingConcurrencyStrategy != null
                ? this.existingConcurrencyStrategy.getRequestVariable(rv)
                : super.getRequestVariable(rv);
    }

    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
                                            HystrixProperty<Integer> corePoolSize,
                                            HystrixProperty<Integer> maximumPoolSize,
                                            HystrixProperty<Integer> keepAliveTime, TimeUnit unit,
                                            BlockingQueue<Runnable> workQueue) {
        return this.existingConcurrencyStrategy != null
                ? this.existingConcurrencyStrategy.getThreadPool(threadPoolKey, corePoolSize,
                maximumPoolSize, keepAliveTime, unit, workQueue)
                : super.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize,
                keepAliveTime, unit, workQueue);
    }

    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
                                            HystrixThreadPoolProperties threadPoolProperties) {
        return this.existingConcurrencyStrategy != null
                ? this.existingConcurrencyStrategy.getThreadPool(threadPoolKey,
                threadPoolProperties)
                : super.getThreadPool(threadPoolKey, threadPoolProperties);
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        this.callableContexts.forEach(CallableContext::doSupply);
        return this.existingConcurrencyStrategy != null
                ? this.existingConcurrencyStrategy
                .wrapCallable(new SharedContextCallable<T>(callable, this.callableContexts))
                : super.wrapCallable(new SharedContextCallable<T>(callable, this.callableContexts));
    }
}
