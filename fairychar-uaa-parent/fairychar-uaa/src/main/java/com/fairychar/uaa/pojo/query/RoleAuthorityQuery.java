package com.fairychar.uaa.pojo.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (RoleAuthority)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("RoleAuthorityQuery")
public class RoleAuthorityQuery implements Serializable {

    @ApiModelProperty("")
    private Integer id;
    @ApiModelProperty("权限表id")
    private Integer authorityId;
    @ApiModelProperty("角色表id")
    private Integer roleId;


}