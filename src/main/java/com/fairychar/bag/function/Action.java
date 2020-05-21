package com.fairychar.bag.function;

import java.util.concurrent.TimeoutException;

/**
 * Created with IDEA
 * User: chiyo
 * Date: 2019/03/14
 * time: 15:32
 *
 * @author chiyo
 */
@FunctionalInterface
public interface Action {
    /**
     * 执行任务
     * @throws InterruptedException
     * @throws TimeoutException
     */
    void doAction() throws InterruptedException, TimeoutException;
}
