package com.fairychar.bag.domain.hystrix.callable;

import lombok.AllArgsConstructor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

/**
 * Datetime: 2021/12/14 16:59 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@AllArgsConstructor
public class RequestContextCallable<T> implements Callable<T> {

    private final RequestAttributes requestAttribute;
    private final Callable<T> source;


    @Override
    public T call() throws Exception {
        RequestContextHolder.setRequestAttributes(this.requestAttribute);
        return this.source.call();
    }
}
