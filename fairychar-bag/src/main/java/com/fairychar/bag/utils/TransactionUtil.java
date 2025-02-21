package com.fairychar.bag.utils;

import com.fairychar.bag.domain.exceptions.FBException;
import com.fairychar.bag.function.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 数据库事务操作工具类
 *
 * @author chiyo <br>
 * @since 1.3.2
 */
@Slf4j
public class TransactionUtil {

    public static Future<?> doWithTransactionAsync(Action action, AtomicBoolean isAllSuccess, CyclicBarrier cyclicBarrier
            , ExecutorService executor, TransactionTemplate transactionTemplate) {
        return doWithTransactionAsync(action, isAllSuccess, cyclicBarrier, executor, transactionTemplate, 60);
    }

    public static Future<?> doWithTransactionAsync(Action action, AtomicBoolean isAllSuccess, CyclicBarrier cyclicBarrier
            , ExecutorService executor, TransactionTemplate transactionTemplate, int timeoutSeconds) {
        return executor.submit(() -> transactionTemplate.executeWithoutResult(ts -> {
            try {
                log.debug("do operate begin");
                action.doAction();
                log.debug("do operate end");
            } catch (Exception e) {
                log.error("do operate error", e);
                isAllSuccess.set(false);
                throw new FBException(e);
            } finally {
                try {
                    log.debug("cyclicBarrier waiting={}", cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await(timeoutSeconds, TimeUnit.SECONDS);
                } catch (Exception e) {
                    log.error("cyclic barrier error", e.getMessage());
                    throw new FBException(e);
                }
                if (!isAllSuccess.get()) {
                    ts.setRollbackOnly();
                }
            }
        }));
    }
}
