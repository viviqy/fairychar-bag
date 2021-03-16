package com.fairychar.uaa.pojo.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (Customer)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("CustomerQuery")
public class CustomerQuery implements Serializable {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("手机号")
    private String tel;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("是否启用")
    private Integer enabled;
    @ApiModelProperty("乐观锁")
    private Long version;
    @ApiModelProperty("是否逻辑逻辑删除")
    private Integer flag;


}