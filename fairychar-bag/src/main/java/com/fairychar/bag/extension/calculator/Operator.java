package com.fairychar.bag.extension.calculator;

/**
 * @author chiyo
 * @since
 */
public enum Operator {
    /**
     * 等于
     */
    EQUAL,
    /**
     * 不等于
     */
    NOT_EQUAL,
    /**
     * 包含所有
     */
    CONTAIN_ALL,
    /**
     * 包含
     */
    CONTAIN,
    /**
     * 在里面
     */
    IN,
    /**
     * 不在里面
     */
    NOT_IN,
    /**
     * 小于
     */
    LESS_THAN,
    /**
     * 小于等于
     */
    LESS_EQUAL,
    /**
     * 大于
     */
    GREATER_THAN,
    /**
     * 大于等于
     */
    GREATER_EQUAL,


    /**
     * 任何一个元素在集合内
     */
    IN_ANY,

    /**
     * 包含任何一个元素
     */
    CONTAIN_ANY;
}
