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

    /**
     * 实例化当前flow
     *
     * @return {@link ActionFlow}<{@link T}, {@link C}>
     */
    ActionFlow<T, C> instanceBean();

    /**
     * 流程计算
     *
     * @param context 参数上下文
     * @return boolean
     */
    boolean compute(T context);

    /**
     * 获取父类ActionFlow条件与对应实现类
     *
     * @return {@link Set}<{@link ParentActionCondition}>
     */
    Set<ParentActionCondition> getParentClassSet();

    /**
     * 当前流程的组别,可以通过设置不同的组名区分流程</br>
     * 同一个流程可以设置多个组别被公用
     *
     * @return {@link Set}<{@link String}>
     */
    default Set<String> group() {
        return Sets.newHashSet("default");
    }

    /**
     * call下一个流程
     *
     * @param context 参数上下文
     */
    void callNext(T context);

    /**
     * 获取下一个流程需要传递的参数
     *
     * @param context 参数上下文
     * @return {@link C}
     */
    C getNextParam(T context);


}
