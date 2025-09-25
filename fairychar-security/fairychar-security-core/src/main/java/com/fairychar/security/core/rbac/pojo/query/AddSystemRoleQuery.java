package com.fairychar.security.core.rbac.pojo.query;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Schema(description = "AddSystemRoleQuery")
public class AddSystemRoleQuery implements Serializable {

    /**
     * 名称
     */
    @Schema(description = "名称")
    @NotNull
    @NotBlank
    private String name;
    /**
     * 角色级别(0代表root)
     */
    @Schema(description = "角色级别(0代表root)")
    @NotNull
    @Min(0)
    private Integer level;
    /**
     * 描述
     */
    @Schema(description = "描述")
    @NotNull
    @NotBlank
    private String description;

}
