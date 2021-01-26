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
     *
     * @throws InterruptedException 打断触发
     * @throws TimeoutException     超时触发
     */
    void doAction() throws InterruptedException, TimeoutException;


}
