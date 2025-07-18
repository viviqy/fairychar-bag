package com.fairychar.security.core.rbac.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("user_has_role")
@Schema(description = "UserHasRole")
public class UserHasRole extends Model<UserHasRole> {

    @Schema(description = "")
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @TableField(value = "`user_id`")
    private Integer userId;
    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    @TableField(value = "`role_id`")
    private Integer roleId;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    @TableField(value = "`create_by`", fill = FieldFill.INSERT)
    private Long createBy;
    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称")
    @TableField(value = "`create_name`", fill = FieldFill.INSERT)
    private String createName;
    /**
     * 修改人
     */
    @Schema(description = "修改人")
    @TableField(value = "`update_by`", fill = FieldFill.UPDATE)
    private Long updateBy;
    /**
     * 更新人名称
     */
    @Schema(description = "更新人名称")
    @TableField(value = "`update_name`", fill = FieldFill.UPDATE)
    private String updateName;
    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(value = "`create_time`")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    @TableField(value = "`update_time`")
    private LocalDateTime updateTime;
    /**
     * 分组匹配字符
     */
    @TableField(exist = false)
    @Schema(description = "分组数量匹配字段,和原表无关")
    private Integer groupByCount;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }


    /**
     * id -
     */
    public static final String ID = "id";

    /**
     * user_id - 用户ID
     */
    public static final String USER_ID = "user_id";

    /**
     * role_id - 角色ID
     */
    public static final String ROLE_ID = "role_id";

    /**
     * create_by - 创建人
     */
    public static final String CREATE_BY = "create_by";

    /**
     * create_name - 创建人名称
     */
    public static final String CREATE_NAME = "create_name";

    /**
     * update_by - 修改人
     */
    public static final String UPDATE_BY = "update_by";

    /**
     * update_name - 更新人名称
     */
    public static final String UPDATE_NAME = "update_name";

    /**
     * create_time - 创建时间
     */
    public static final String CREATE_TIME = "create_time";

    /**
     * update_time - 修改时间
     */
    public static final String UPDATE_TIME = "update_time";

}
