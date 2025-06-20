package com.fairychar.security.core.rbac.pojo.query;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "排除的ids")
    private List<Long> ids;
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
     * 分页请求参数
     */
    @Schema(description = "分页参数")
    private Page pageQuery = new Page();

}
