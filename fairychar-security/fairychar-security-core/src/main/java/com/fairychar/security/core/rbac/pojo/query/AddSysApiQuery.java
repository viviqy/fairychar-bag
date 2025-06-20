package com.fairychar.security.core.rbac.pojo.query;


import com.fairychar.bag.domain.validator.rest.In;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@Schema(description = "AddSysApiQuery")
public class AddSysApiQuery implements Serializable {

    /**
     * http请求方法默认(*)代表所有请求方式
     */
    @Schema(description = "http请求方法默认(*)代表所有请求方式")
    @NotEmpty(message = "请求方法不能为空")
    @In(value = {"GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE"}, message = "http请求方式错误")
    private String httpMethod;
    /**
     * 请求接口路径,使用antMatch方式
     */
    @Schema(description = "请求接口路径,使用antMatch方式")
    @NotEmpty(message = "请求uri不能为空")
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
    private Integer sort = 0;

}
