package com.fairychar.uaa.pojo.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Organization)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("OrganizationQuery")
public class OrganizationQuery implements Serializable {

    @ApiModelProperty("")
    private Integer id;
    @ApiModelProperty("机构名称")
    private String name;


}