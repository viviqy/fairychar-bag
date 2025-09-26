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
 * 角色表(SystemRole)表实体类
 *
 * @author chiyo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("system_role")
@Schema(description = "SystemRole")
public class SystemRole extends Model<SystemRole> {
    /**
     * ID
     */
    @Schema(description = "ID")
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    /**
     * 角色标识唯一code标识
     */
    @Schema(description = "角色标识唯一code标识")
    @TableField(value = "`role_code`")
    private String roleCode;
    /**
     * 名称
     */
    @Schema(description = "名称")
    @TableField(value = "`name`")
    private String name;
    /**
     * 角色级别(0代表root)
     */
    @Schema(description = "角色级别(0代表root)")
    @TableField(value = "`level`")
    private Integer level;
    /**
     * 是否启用
     */
    @Schema(description = "是否启用")
    @TableField(value = "`enable`")
    private Boolean enable;
    /**
     * 描述
     */
    @Schema(description = "描述")
    @TableField(value = "`description`")
    private String description;
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
     * role_code - 角色标识唯一code标识
     */
    public static final String ROLE_CODE = "role_code";

    /**
     * name - 名称
     */
    public static final String NAME = "name";

    /**
     * level - 角色级别(0代表root)
     */
    public static final String LEVEL = "level";

    /**
     * enable - 是否启用
     */
    public static final String ENABLE = "enable";

    /**
     * description - 描述
     */
    public static final String DESCRIPTION = "description";

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
