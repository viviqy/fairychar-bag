package com.fairychar.uaa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (CustomerRole)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("customer_role")
@ApiModel("CustomerRole")
public class CustomerRole extends Model<CustomerRole> {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    @TableField(value = "`id`")
    private Integer id;
    @ApiModelProperty("用户表id")
    @TableField(value = "`customer_id`")
    private Integer customerId;
    @ApiModelProperty("角色表id")
    @TableField(value = "`role_id`")
    private Integer roleId;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }


    /**
     * id
     */
    public final static String ID = "id";

    /**
     * customer_id
     */
    public final static String CUSTOMER_ID = "customer_id";

    /**
     * role_id
     */
    public final static String ROLE_ID = "role_id";

}