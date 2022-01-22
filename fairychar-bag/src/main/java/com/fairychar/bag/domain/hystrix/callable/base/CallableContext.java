package com.fairychar.bag.domain.hystrix.callable.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.function.Consumer;

/**
 * Datetime: 2022/1/18 21:35 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CallableContext<T> {
    private T context;
    private Consumer<T> contextConsumer;

    public void doConsume() {
        this.contextConsumer.accept(this.context);
    }
}
