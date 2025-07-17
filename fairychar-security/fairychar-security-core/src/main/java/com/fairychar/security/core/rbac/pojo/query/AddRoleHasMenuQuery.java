package com.fairychar.security.core.rbac.pojo.query;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色菜单关联(RoleHasMenu)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddRoleHasMenuQuery")
public class AddRoleHasMenuQuery implements Serializable {

    /**
     * 角色id
     */
    @Schema(description = "角色id")
    @NotNull
    private Integer roleId;
    /**
     * 菜单id
     */
    @Schema(description = "菜单id")
    @NotNull
    private Integer menuId;

}
