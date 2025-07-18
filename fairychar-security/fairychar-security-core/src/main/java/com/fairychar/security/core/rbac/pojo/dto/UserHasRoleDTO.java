package com.fairychar.security.core.rbac.pojo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Schema(description = "UserHasRoleDTO")
public class UserHasRoleDTO implements Serializable {


    @Schema(description = "")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Long userUid;
    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    private Integer roleId;
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
     * 修改人
     */
    @Schema(description = "修改人")
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
     * 修改时间
     */
    @Schema(description = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


}
