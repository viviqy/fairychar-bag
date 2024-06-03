package com.fairychar.bag.domain.enums;

/**
 * 状态通用枚举
 *
 * @author qiyue
 */
public enum State {
    /**
     * 无状态
     */
    NONE,
    /**
     * 未初始化
     */
    UN_INITIALIZE,
    /**
     * 启动中
     */
    STARTING,
    /**
     * 启动完成
     */
    STARTED,
    /**
     * 工作中
     */
    WORKING,
    /**
     * 正在停止
     */
    STOPPING,
    /**
     * 停止完成
     */
    STOPPED;
}
