package com.fairychar.bag.function;

import java.util.concurrent.TimeoutException;

/**
 * 动作Function,常用语lamda表达式
 *
 * @author chiyo
 */
@FunctionalInterface
public interface Action {
    /**
     * 执行任务
     *
     * @throws InterruptedException 打断触发
     * @throws TimeoutException     超时触发
     * @throws RuntimeException     运行时异常
     */
    void doAction() throws InterruptedException, TimeoutException, RuntimeException;


}
