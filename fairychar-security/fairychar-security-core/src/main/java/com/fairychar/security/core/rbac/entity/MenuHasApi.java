package com.fairychar.security.core.rbac.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * (MenuHasApi)表实体类
 *
 * @author chiyo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("menu_has_api")
@Schema(description = "MenuHasApi")
public class MenuHasApi extends Model<MenuHasApi> {
    /**
     * 主键
     */
    @Schema(description = "主键")
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    /**
     * 关联菜单id
     */
    @Schema(description = "关联菜单id")
    @TableField(value = "`menu_id`")
    private Integer menuId;
    /**
     * 关联接口id
     */
    @Schema(description = "关联接口id")
    @TableField(value = "`api_id`")
    private Integer apiId;
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
     * 更新人
     */
    @Schema(description = "更新人")
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
     * id - 主键
     */
    public static final String ID = "id";

    /**
     * menu_id - 关联菜单id
     */
    public static final String MENU_ID = "menu_id";

    /**
     * api_id - 关联接口id
     */
    public static final String API_ID = "api_id";

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
