package com.fairychar.security.core.rbac.pojo.dto;


import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Schema(description = "RoleHasMenuDTO")
public class RoleHasMenuDTO implements Serializable {

    /**
     * ${column.comment}
     */
    @Schema(description = "")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;
    /**
     * 角色id
     */
    @Schema(description = "角色id")
    private Integer roleId;
    /**
     * 菜单id
     */
    @Schema(description = "菜单id")
    private Integer menuId;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private Long createBy;
    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称")
    private String createName;
    /**
     * 更新人
     */
    @Schema(description = "更新人")
    private Long updateBy;
    /**
     * 更新人名称
     */
    @Schema(description = "更新人名称")
    private String updateName;
    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


}
