package com.fairychar.bag.domain.hystrix.callable;

import com.fairychar.bag.domain.hystrix.callable.base.CallableContext;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Datetime: 2022/1/18 21:38
 *
 * @author chiyo
 * @since 1.0
 */
@AllArgsConstructor
public class SharedContextCallable<T> implements Callable<T> {

    private final Callable<T> source;
    private final List<CallableContext<?>> callableContexts;

    @Override
    public T call() throws Exception {
        this.callableContexts.forEach(CallableContext::doConsume);
        return this.source.call();
    }
}
