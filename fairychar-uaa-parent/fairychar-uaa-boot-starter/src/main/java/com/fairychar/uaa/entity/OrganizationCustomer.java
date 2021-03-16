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
 * (OrganizationCustomer)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("organization_customer")
@ApiModel("OrganizationCustomer")
public class OrganizationCustomer extends Model<OrganizationCustomer> {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    @TableField(value = "`id`")
    private Integer id;
    @ApiModelProperty("")
    @TableField(value = "`customer_id`")
    private Integer customerId;
    @ApiModelProperty("")
    @TableField(value = "`organization_id`")
    private Integer organizationId;


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
     * organization_id
     */
    public final static String ORGANIZATION_ID = "organization_id";

}