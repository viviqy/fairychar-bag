package com.fairychar.security.core.properties;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
public enum TokenType {
    /**
     * 采用redis存储用户会话信息
     */
    REDIS,
    /**
     * 使用jwt令牌存储用户会话信息(暂未支持)
     */
    JWT,

    /**
     * 基于jvm内存(暂未支持)
     */
    MEM,

    /**
     * 基于MySQL(暂未支持)
     */
    MYSQL,
    ;
}
