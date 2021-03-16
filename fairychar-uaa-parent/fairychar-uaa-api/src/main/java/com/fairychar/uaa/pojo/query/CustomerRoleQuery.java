package com.fairychar.uaa.pojo.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (CustomerRole)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("CustomerRoleQuery")
public class CustomerRoleQuery implements Serializable {

    @ApiModelProperty("")
    private Integer id;
    @ApiModelProperty("用户表id")
    private Integer customerId;
    @ApiModelProperty("角色表id")
    private Integer roleId;


}