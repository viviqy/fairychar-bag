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
 * 数据字典详情(SysDict)表实体类
 *
 * @author chiyo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("sys_dict")
@Schema(description = "SysDict")
public class SysDict extends Model<SysDict> {
    /**
     * ID
     */
    @Schema(description = "ID")
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    /**
     * 字典uid
     */
    @Schema(description = "字典uid")
    @TableField(value = "`uid`")
    private Long uid;
    /**
     * 字典标签
     */
    @Schema(description = "字典标签")
    @TableField(value = "`label`")
    private String label;
    /**
     * 字典值
     */
    @Schema(description = "字典值")
    @TableField(value = "`label_value`")
    private String labelValue;
    /**
     * 描述
     */
    @Schema(description = "描述")
    @TableField(value = "`description`")
    private String description;
    /**
     * 排序
     */
    @Schema(description = "排序")
    @TableField(value = "`dict_sort`")
    private Integer dictSort;
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
     * 修改人名称
     */
    @Schema(description = "修改人名称")
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
     * uid - 字典uid
     */
    public static final String UID = "uid";

    /**
     * label - 字典标签
     */
    public static final String LABEL = "label";

    /**
     * label_value - 字典值
     */
    public static final String LABEL_VALUE = "label_value";

    /**
     * description - 描述
     */
    public static final String DESCRIPTION = "description";

    /**
     * dict_sort - 排序
     */
    public static final String DICT_SORT = "dict_sort";

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
     * update_name - 修改人名称
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
