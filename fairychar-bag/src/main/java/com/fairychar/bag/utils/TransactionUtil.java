package com.fairychar.bag.utils;

import com.fairychar.bag.domain.exceptions.FBException;
import com.fairychar.bag.function.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 数据库事务操作工具类 - 支持多线程并行事务统一提交/回滚
 * <p>
 * 实现原理：两阶段提交（2PC简化版）
 * 阶段1：各线程并行执行业务逻辑，事务挂起不提交
 * 阶段2：所有线程完成后，根据整体结果统一提交或回滚
 * <p>
 * 注意：事务挂起期间会持有数据库连接和锁，不适合长时间操作
 *
 * @author chiyo
 * @since 1.3.3
 */
@Slf4j
public class TransactionUtil {

    /**
     * 并行执行多个带事务的操作，统一提交或回滚
     * <p>
     * 执行流程：
     * 1. 为每个操作创建独立事务
     * 2. 并行执行业务逻辑
     * 3. 等待所有操作完成
     * 4. 如果全部成功则统一提交，否则全部回滚
     *
     * @param actions         业务操作列表
     * @param executor        线程池
     * @param txManager       事务管理器
     * @param timeoutSeconds  超时时间（秒）
     * @return 各操作执行结果
     */
    public static List<Boolean> executeParallelWithTransaction(
            List<Action> actions,
            ExecutorService executor,
            PlatformTransactionManager txManager,
            int timeoutSeconds) {
        
        if (actions == null || actions.isEmpty()) {
            return new ArrayList<>();
        }
        
        // 第一阶段：为每个操作创建事务并并行执行
        List<TransactionStatus> transactionStatuses = new ArrayList<>();
        List<CompletableFuture<ExecutionResult>> futures = new ArrayList<>();
        
        for (int i = 0; i < actions.size(); i++) {
            final int index = i;
            final Action action = actions.get(i);
            
            // 创建新事务
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            TransactionStatus status = txManager.getTransaction(def);
            transactionStatuses.add(status);
            
            // 提交异步执行
            CompletableFuture<ExecutionResult> future = CompletableFuture.supplyAsync(() -> {
                try {
                    log.debug("开始执行业务操作[{}]", index);
                    action.doAction();
                    log.debug("业务操作[{}]执行成功", index);
                    return new ExecutionResult(index, true, null);
                } catch (Exception e) {
                    log.error("业务操作[{}]执行失败: {}", index, e.getMessage(), e);
                    return new ExecutionResult(index, false, e);
                }
            }, executor);
            
            futures.add(future);
        }
        
        // 第二阶段：等待所有操作完成，统一决策
        try {
            // 等待所有任务完成
            CompletableFuture<Void> allDone = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
            );
            allDone.get(timeoutSeconds, TimeUnit.SECONDS);
            
            // 检查是否有失败
            boolean allSuccess = futures.stream()
                .allMatch(f -> {
                    try {
                        return f.get().isSuccess();
                    } catch (Exception e) {
                        return false;
                    }
                });
            
            // 第三阶段：统一提交或回滚
            if (allSuccess) {
                log.info("所有操作执行成功，统一提交事务");
                for (TransactionStatus status : transactionStatuses) {
                    try {
                        txManager.commit(status);
                    } catch (Exception e) {
                        log.error("提交事务失败", e);
                        // 继续提交其他事务
                    }
                }
            } else {
                log.warn("部分操作执行失败，统一回滚所有事务");
                List<ExecutionResult> failedResults = new ArrayList<>();
                for (CompletableFuture<ExecutionResult> future : futures) {
                    try {
                        ExecutionResult result = future.get();
                        if (!result.isSuccess()) {
                            failedResults.add(result);
                        }
                    } catch (Exception ignored) {}
                }
                
                for (TransactionStatus status : transactionStatuses) {
                    try {
                        if (!status.isCompleted()) {
                            txManager.rollback(status);
                        }
                    } catch (Exception e) {
                        log.error("回滚事务失败", e);
                    }
                }
                
                // 抛出包含所有失败信息的异常
                String errorMsg = buildErrorMessage(failedResults);
                throw new FBException(errorMsg);
            }
            
            // 返回执行结果列表
            List<Boolean> results = new ArrayList<>();
            for (CompletableFuture<ExecutionResult> future : futures) {
                results.add(future.get().isSuccess());
            }
            return results;
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            rollbackAll(txManager, transactionStatuses);
            throw new FBException("事务执行被中断", e);
        } catch (TimeoutException e) {
            rollbackAll(txManager, transactionStatuses);
            throw new FBException("事务执行超时", e);
        } catch (ExecutionException e) {
            rollbackAll(txManager, transactionStatuses);
            throw new FBException("事务执行异常", e.getCause());
        }
    }
    
    /**
     * 回滚所有事务（用于异常处理）
     */
    private static void rollbackAll(PlatformTransactionManager txManager, 
                                     List<TransactionStatus> statuses) {
        log.warn("发生异常，回滚所有事务");
        for (TransactionStatus status : statuses) {
            try {
                if (!status.isCompleted()) {
                    txManager.rollback(status);
                }
            } catch (Exception e) {
                log.error("回滚事务失败", e);
            }
        }
    }
    
    /**
     * 构建错误信息
     */
    private static String buildErrorMessage(List<ExecutionResult> failedResults) {
        StringBuilder sb = new StringBuilder("以下操作执行失败：\n");
        for (ExecutionResult result : failedResults) {
            sb.append("操作[").append(result.getIndex()).append("]: ");
            if (result.getException() != null) {
                sb.append(result.getException().getMessage());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    /**
     * 执行结果封装
     */
    private static class ExecutionResult {
        private final int index;
        private final boolean success;
        private final Exception exception;
        
        public ExecutionResult(int index, boolean success, Exception exception) {
            this.index = index;
            this.success = success;
            this.exception = exception;
        }
        
        public int getIndex() { return index; }
        public boolean isSuccess() { return success; }
        public Exception getException() { return exception; }
    }
    
    // ==================== 旧方法（保留向后兼容，但标记为不推荐）====================
    
    /**
     * 旧的异步事务方法（已弃用）
     * <p>
     * 注意：此方法存在事务一致性问题，不建议使用。
     * 请使用 {@link #executeParallelWithTransaction} 替代
     *
     * @deprecated 使用 {@link #executeParallelWithTransaction} 替代
     */
    @Deprecated
    public static Future<?> doWithTransactionAsync(Action action, AtomicBoolean isAllSuccess, 
            CyclicBarrier cyclicBarrier, ExecutorService executor, 
            TransactionTemplate transactionTemplate) {
        return doWithTransactionAsync(action, isAllSuccess, cyclicBarrier, executor, 
                transactionTemplate, 60);
    }
    
    /**
     * 旧的异步事务方法（已弃用）
     * <p>
     * 注意：此方法存在以下问题：
     * 1. 无法保证所有事务原子性提交/回滚
     * 2. CyclicBarrier 可能导致死锁
     * 3. 事务状态判断存在竞态条件
     * <p>
     * 请使用 {@link #executeParallelWithTransaction} 替代
     *
     * @deprecated 使用 {@link #executeParallelWithTransaction} 替代
     */
    @Deprecated
    public static Future<?> doWithTransactionAsync(Action action, AtomicBoolean isAllSuccess, 
            CyclicBarrier cyclicBarrier, ExecutorService executor, 
            TransactionTemplate transactionTemplate, int timeoutSeconds) {
        log.warn("使用已弃用的 doWithTransactionAsync 方法，建议迁移到 executeParallelWithTransaction");
        
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
                    isAllSuccess.set(false);
                    throw new FBException(e);
                }
                if (!isAllSuccess.get()) {
                    ts.setRollbackOnly();
                }
            }
        }));
    }
}
