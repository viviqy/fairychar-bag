package com.fairychar.uaa.pojo.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Authority)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("AuthorityQuery")
public class AuthorityQuery implements Serializable {

    @ApiModelProperty("")
    private Integer id;
    @ApiModelProperty("")
    private String name;
    @ApiModelProperty("")
    private String authoritycol;


}