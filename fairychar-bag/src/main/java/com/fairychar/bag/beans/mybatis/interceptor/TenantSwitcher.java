package com.fairychar.bag.beans.mybatis.interceptor;

import lombok.AllArgsConstructor;

/**
 * @author chiyo <br>
 * @since 1.0.2
 */
@AllArgsConstructor
public class TenantSwitcher implements ITenantSwitcher {
    private boolean useTenant;

    @Override
    public boolean use() {
        return useTenant;
    }
}
