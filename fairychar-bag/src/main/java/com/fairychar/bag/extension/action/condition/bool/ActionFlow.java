package com.fairychar.bag.extension.action.condition.bool;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 操作流
 * <p>
 * T: 当前操作流入参类型
 * N: 下一个操作流入参类型
 *
 * @author chiyo <br>
 * @since 1.0.0
 */
public interface ActionFlow<T, C> {

    ActionFlow<T, C> instanceBean();

    boolean compute(T context);

    Set<ParentActionCondition> getParentClassSet();

    default Set<String> group() {
        return Sets.newHashSet("default");
    }

    void callNext(T context);

    C getNextParam(T current);


}
