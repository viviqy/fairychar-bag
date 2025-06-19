package com.fairychar.security.core.auth;

import java.io.Serializable;

/**
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
