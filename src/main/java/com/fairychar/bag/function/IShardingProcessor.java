package com.fairychar.bag.function;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2020/3/24 <br>
 * time: 13:31 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@FunctionalInterface
public interface IShardingProcessor<R, P> {
    R calculate(P shardingBy);

    default int calculateHash(P shardingBy) {
        return Math.abs(shardingBy.hashCode());
    }
}
