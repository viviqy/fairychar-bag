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

    @SuppressWarnings("RV_ABSOLUTE_VALUE_OF_HASHCODE")
    default int calculateHash(P shardingBy) {
        return Math.abs(shardingBy.hashCode());
    }
}
