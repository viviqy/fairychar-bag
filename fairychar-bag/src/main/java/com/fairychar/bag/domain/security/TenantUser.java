package com.fairychar.bag.domain.security;

import java.io.Serializable;

/**
 * Datetime: 2021/12/2 23:10 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public interface TenantUser extends Serializable {

    String getTenantId();
}
