package com.fairychar.security.core.rbac.pojo.query;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 角色表(SystemRole)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "UpdateSystemRoleQuery")
public class UpdateSystemRoleQuery implements Serializable {

    /**
     * ID
     */
    @Schema(description = "ID")
    @NotNull
    private Integer id;
    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;
    /**
     * 角色级别(0代表root)
     */
    @Schema(description = "角色级别(0代表root)")
    private Integer level;
    /**
     * 描述
     */
    @Schema(description = "描述")
    private String description;

}
