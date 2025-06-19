package com.fairychar.security.core.properties;

import lombok.Data;

/**
 * @author chiyo <br>
 * @since
 */
@Data
public class AuditProperties {
    private boolean enable;
    private String createBy = "createBy";
    private String createName = "createName";
    private String createTime = "createTime";
    private String updateBy = "updateBy";
    private String updateName = "updateName";
    private String updateTime = "updateTime";
}
