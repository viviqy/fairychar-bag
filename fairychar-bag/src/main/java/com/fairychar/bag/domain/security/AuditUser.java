package com.fairychar.bag.domain.security;

import java.io.Serializable;

/**
 * Datetime: 2021/12/16 23:15
 *
 * @author chiyo
 * @since 1.0
 */
public interface AuditUser extends TenantUser {


    /**
     * 得到用户id
     *
     * @return {@link Serializable}
     */
    Serializable getUserId();
}
