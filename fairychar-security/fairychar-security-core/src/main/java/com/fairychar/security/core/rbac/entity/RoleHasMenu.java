package com.fairychar.security.core.rbac.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 角色菜单关联(RoleHasMenu)表实体类
 *
 * @author chiyo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("role_has_menu")
@Schema(description = "RoleHasMenu")
public class RoleHasMenu extends Model<RoleHasMenu> {
    /**
     * ${column.comment}
     */
    @Schema(description = "")
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    /**
     * 角色id
     */
    @Schema(description = "角色id")
    @TableField(value = "`role_id`")
    private Integer roleId;
    /**
     * 菜单id
     */
    @Schema(description = "菜单id")
    @TableField(value = "`menu_id`")
    private Integer menuId;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    @TableField(value = "`create_by`")
    private Long createBy;
    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称")
    @TableField(value = "`create_name`")
    private String createName;
    /**
     * 更新人
     */
    @Schema(description = "更新人")
    @TableField(value = "`update_by`")
    private Long updateBy;
    /**
     * 更新人名称
     */
    @Schema(description = "更新人名称")
    @TableField(value = "`update_name`")
    private String updateName;
    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(value = "`create_time`")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
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
     * role_id - 角色id
     */
    public static final String ROLE_ID = "role_id";

    /**
     * menu_id - 菜单id
     */
    public static final String MENU_ID = "menu_id";

    /**
     * create_by - 创建人
     */
    public static final String CREATE_BY = "create_by";

    /**
     * create_name - 创建人名称
     */
    public static final String CREATE_NAME = "create_name";

    /**
     * update_by - 更新人
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
     * update_time - 更新时间
     */
    public static final String UPDATE_TIME = "update_time";

}
