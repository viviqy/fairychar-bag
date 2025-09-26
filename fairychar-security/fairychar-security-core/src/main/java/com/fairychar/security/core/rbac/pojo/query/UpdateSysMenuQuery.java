package com.fairychar.security.core.rbac.pojo.query;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@Schema(description = "UpdateSysMenuQuery")
public class UpdateSysMenuQuery implements Serializable {
    @Schema(description = "id")
    @NotNull(message = "id不能为null")
    private Integer id;
    /**
     * 上级菜单ID(0代表root)
     */
    @Schema(description = "上级菜单ID(0代表root)")
    @NotNull
    private Integer pid;
    /**
     * 菜单类型(预留字段)
     */
    @Schema(description = "菜单标识code(唯一)")
    @NotNull
    private String code;
    /**
     * 是否启用
     */
    @Schema(description = "是否启用")
    private Boolean enable;
    /**
     * 菜单标题
     */
    @Schema(description = "菜单标题")
    @NotEmpty
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
    private Integer sort = 0;
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

}
