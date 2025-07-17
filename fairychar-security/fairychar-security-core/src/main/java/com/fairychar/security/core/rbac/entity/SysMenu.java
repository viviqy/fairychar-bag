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
 * 系统菜单(SysMenu)表实体类
 *
 * @author chiyo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("sys_menu")
@Schema(description = "SysMenu")
public class SysMenu extends Model<SysMenu> {
    /**
     * ID
     */
    @Schema(description = "ID")
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    /**
     * 上级菜单ID(0代表root)
     */
    @Schema(description = "上级菜单ID(0代表root)")
    @TableField(value = "`pid`")
    private Integer pid;
    /**
     * 菜单类型(预留字段)
     */
    @Schema(description = "菜单类型(预留字段)")
    @TableField(value = "`type`")
    private String type;
    /**
     * 菜单标题
     */
    @Schema(description = "菜单标题")
    @TableField(value = "`title`")
    private String title;
    /**
     * 组件名称
     */
    @Schema(description = "组件名称")
    @TableField(value = "`component_name`")
    private String componentName;
    /**
     * 组件内容
     */
    @Schema(description = "组件内容")
    @TableField(value = "`component_data`")
    private String componentData;
    /**
     * 排序
     */
    @Schema(description = "排序")
    @TableField(value = "`sort`")
    private Integer sort;
    /**
     * 图标
     */
    @Schema(description = "图标")
    @TableField(value = "`icon`")
    private String icon;
    /**
     * 链接地址
     */
    @Schema(description = "链接地址")
    @TableField(value = "`path`")
    private String path;
    /**
     * 是否外链
     */
    @Schema(description = "是否外链")
    @TableField(value = "`i_frame`")
    private Boolean iFrame;
    /**
     * 缓存
     */
    @Schema(description = "缓存")
    @TableField(value = "`cache`")
    private Boolean cache;
    /**
     * 隐藏
     */
    @Schema(description = "隐藏")
    @TableField(value = "`hidden`")
    private Boolean hidden;
    /**
     * 创建者
     */
    @Schema(description = "创建者")
    @TableField(value = "`create_by`", fill = FieldFill.INSERT)
    private Long createBy;
    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称")
    @TableField(value = "`create_name`", fill = FieldFill.INSERT)
    private String createName;
    /**
     * 更新者
     */
    @Schema(description = "更新者")
    @TableField(value = "`update_by`", fill = FieldFill.UPDATE)
    private Long updateBy;
    /**
     * 更新人名称
     */
    @Schema(description = "更新人名称")
    @TableField(value = "`update_name`", fill = FieldFill.UPDATE)
    private String updateName;
    /**
     * 创建日期
     */
    @Schema(description = "创建日期")
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
     * id - ID
     */
    public static final String ID = "id";

    /**
     * pid - 上级菜单ID(0代表root)
     */
    public static final String PID = "pid";

    /**
     * type - 菜单类型(预留字段)
     */
    public static final String TYPE = "type";

    /**
     * title - 菜单标题
     */
    public static final String TITLE = "title";

    /**
     * component_name - 组件名称
     */
    public static final String COMPONENT_NAME = "component_name";

    /**
     * component_data - 组件内容
     */
    public static final String COMPONENT_DATA = "component_data";

    /**
     * sort - 排序
     */
    public static final String SORT = "sort";

    /**
     * icon - 图标
     */
    public static final String ICON = "icon";

    /**
     * path - 链接地址
     */
    public static final String PATH = "path";

    /**
     * i_frame - 是否外链
     */
    public static final String I_FRAME = "i_frame";

    /**
     * cache - 缓存
     */
    public static final String CACHE = "cache";

    /**
     * hidden - 隐藏
     */
    public static final String HIDDEN = "hidden";

    /**
     * create_by - 创建者
     */
    public static final String CREATE_BY = "create_by";

    /**
     * create_name - 创建人名称
     */
    public static final String CREATE_NAME = "create_name";

    /**
     * update_by - 更新者
     */
    public static final String UPDATE_BY = "update_by";

    /**
     * update_name - 更新人名称
     */
    public static final String UPDATE_NAME = "update_name";

    /**
     * create_time - 创建日期
     */
    public static final String CREATE_TIME = "create_time";

    /**
     * update_time - 更新时间
     */
    public static final String UPDATE_TIME = "update_time";

}
