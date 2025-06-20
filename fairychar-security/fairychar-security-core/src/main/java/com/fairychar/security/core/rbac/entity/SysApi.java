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
 * (SysApi)表实体类
 *
 * @author chiyo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("sys_api")
@Schema(description = "SysApi")
public class SysApi extends Model<SysApi> {
    /**
     * ${column.comment}
     */
    @Schema(description = "")
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    /**
     * http请求方法默认(*)代表所有请求方式
     */
    @Schema(description = "http请求方法默认(*)代表所有请求方式")
    @TableField(value = "`http_method`")
    private String httpMethod;
    /**
     * 请求接口路径,使用antMatch方式
     */
    @Schema(description = "请求接口路径,使用antMatch方式")
    @TableField(value = "`uri`")
    private String uri;
    /**
     * 接口描述
     */
    @Schema(description = "接口描述")
    @TableField(value = "`description`")
    private String description;
    /**
     * 排序
     */
    @Schema(description = "排序")
    @TableField(value = "`sort`")
    private Integer sort;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    @TableField(value = "`creata_by`")
    private Long creataBy;
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
     * http_method - http请求方法默认(*)代表所有请求方式
     */
    public static final String HTTP_METHOD = "http_method";

    /**
     * uri - 请求接口路径,使用antMatch方式
     */
    public static final String URI = "uri";

    /**
     * description - 接口描述
     */
    public static final String DESCRIPTION = "description";

    /**
     * sort - 排序
     */
    public static final String SORT = "sort";

    /**
     * creata_by - 创建人
     */
    public static final String CREATA_BY = "creata_by";

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
