package com.fairychar.security.core.rbac.pojo.query;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户角色关联(UserHasRole)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddUserHasRoleQuery")
public class AddUserHasRoleQuery implements Serializable {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @NotNull
    private Long userUid;
    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    @NotNull
    private Integer roleId;

}
