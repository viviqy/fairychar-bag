package com.fairychar.bag.function;

/**
 * 分散处理器
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@FunctionalInterface
public interface IShardingProcessor<R, P> {
    R calculate(P shardingBy);

    default int calculateHash(P shardingBy) {
        long hash = (long) shardingBy.hashCode();
        hash = Math.abs(hash);
        return ((int) hash);
    }
}
