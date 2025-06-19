package com.fairychar.security.core.properties;

import lombok.Data;

import java.util.Collections;
import java.util.Set;

/**
 * @author chiyo <br>
 * @since
 */
@Data
public class TenantProperties {
    private boolean enable;
    private Set<String> ignoreTables = Collections.emptySet();
    private String columnName = "tenant_id";
}
