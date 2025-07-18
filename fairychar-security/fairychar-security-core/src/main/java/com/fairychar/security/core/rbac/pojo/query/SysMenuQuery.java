package com.fairychar.security.core.rbac.pojo.query;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统菜单(SysMenu)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysMenuQuery")
public class SysMenuQuery implements Serializable {

    /**
     * ID
     */
    @Schema(description = "ID")
    private Integer id;
    /**
     * 上级菜单ID(0代表root)
     */
    @Schema(description = "上级菜单ID(0代表root)")
    private Integer pid;
    /**
     * 菜单类型(预留字段)
     */
    @Schema(description = "菜单标识code(唯一)")
    private String code;
    /**
     * 菜单标题
     */
    @Schema(description = "菜单标题")
    private String title;
    /**
     * 组件名称
     */
    @Schema(description = "组件名称")
    private String componentName;
    /**
     * 组件内容
     */
    @Schema(description = "组件内容")
    private String componentData;
    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sort;
    /**
     * 图标
     */
    @Schema(description = "图标")
    private String icon;
    /**
     * 链接地址
     */
    @Schema(description = "链接地址")
    private String path;
    /**
     * 是否外链
     */
    @Schema(description = "是否外链")
    private Boolean iFrame;
    /**
     * 缓存
     */
    @Schema(description = "缓存")
    private Boolean cache;
    /**
     * 隐藏
     */
    @Schema(description = "隐藏")
    private Boolean hidden;
    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Long createBy;
    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称")
    private String createName;
    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private Long updateBy;
    /**
     * 更新人名称
     */
    @Schema(description = "更新人名称")
    private String updateName;
    /**
     * 创建日期
     */
    @Schema(description = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 分页请求参数
     */
    @Schema(description = "分页参数")
    private Page pageQuery = new Page();

}
