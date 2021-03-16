package com.fairychar.uaa.pojo.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Role)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("RoleQuery")
public class RoleQuery implements Serializable {

    @ApiModelProperty("")
    private Integer id;
    @ApiModelProperty("角色名声")
    private String name;


}