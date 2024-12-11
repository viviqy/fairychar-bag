package com.fairychar.bag.function;

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
     * @throws RuntimeException 运行时异常
     */
    void doAction() throws RuntimeException;


}
