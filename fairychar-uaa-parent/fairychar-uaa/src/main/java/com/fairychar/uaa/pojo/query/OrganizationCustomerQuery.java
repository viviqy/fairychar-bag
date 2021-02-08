package com.fairychar.uaa.pojo.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (OrganizationCustomer)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("OrganizationCustomerQuery")
public class OrganizationCustomerQuery implements Serializable {

    @ApiModelProperty("")
    private Integer id;
    @ApiModelProperty("")
    private Integer customerId;
    @ApiModelProperty("")
    private Integer organizationId;


}