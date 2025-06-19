package com.fairychar.security.core.properties;

import lombok.Data;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
@Data
public class PluginsProperties {
    private TenantProperties tenant;
    private AuditProperties audit;
}
