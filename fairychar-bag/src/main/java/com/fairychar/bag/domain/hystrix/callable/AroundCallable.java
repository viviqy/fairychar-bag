package com.fairychar.bag.domain.hystrix.callable;

import com.fairychar.bag.function.Action;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/**
 * Datetime: 2022/1/18 18:05 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@AllArgsConstructor
public class AroundCallable<T> implements Callable<T> {
    private final Callable<T> source;
    private final List<Action> beforeCallActions;
    private final List<Action> afterCallActions;

    @Override
    public T call() throws Exception {
        this.beforeCallActions.forEach(a -> {
            try {
                a.doAction();
            } catch (InterruptedException | TimeoutException ignore) {
            }
        });
        T call = this.source.call();
        this.afterCallActions.forEach(a -> {
            try {
                a.doAction();
            } catch (InterruptedException | TimeoutException ignore) {
            }
        });
        return call;
    }
}
