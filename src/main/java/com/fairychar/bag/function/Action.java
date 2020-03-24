package com.fairychar.bag.function;

import java.util.concurrent.TimeoutException;

/**
 * Created with IDEA
 * User: LMQ
 * Date: 2019/03/14
 * time: 15:32
 *
 * @author chiyo
 */
@FunctionalInterface
public interface Action {
    void doAction() throws InterruptedException, TimeoutException;
}
