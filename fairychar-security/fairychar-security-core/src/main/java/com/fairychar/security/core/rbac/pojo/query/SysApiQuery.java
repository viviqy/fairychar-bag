package com.fairychar.security.core.rbac.pojo.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (SysApi)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysApiQuery")
public class SysApiQuery implements Serializable {

    /**
     * ${column.comment}
     */
    @Schema(description = "")
    private Integer id;
    /**
     * http请求方法默认(*)代表所有请求方式
     */
    @Schema(description = "http请求方法默认(*)代表所有请求方式")
    private String httpMethod;
    /**
     * 请求接口路径,使用antMatch方式
     */
    @Schema(description = "请求接口路径,使用antMatch方式")
    private String uri;
    /**
     * 接口描述
     */
    @Schema(description = "接口描述")
    private String description;
    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sort;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private Long creataBy;
    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称")
    private String createName;
    /**
     * 更新人
     */
    @Schema(description = "更新人")
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
