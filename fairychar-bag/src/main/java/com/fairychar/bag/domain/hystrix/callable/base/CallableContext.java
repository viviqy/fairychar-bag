package com.fairychar.bag.domain.hystrix.callable.base;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Datetime: 2022/1/18 21:35
 *
 * @author chiyo
 * @since 1.0
 */
@RequiredArgsConstructor
@Accessors(chain = true)
public class CallableContext<T> {
    private final Supplier<T> contextSupplier;
    private T context;
    private final Consumer<T> contextConsumer;


    public void doSupply() {
        this.context = this.contextSupplier.get();
    }

    public void doConsume() {
        this.contextConsumer.accept(this.context);
    }
}
