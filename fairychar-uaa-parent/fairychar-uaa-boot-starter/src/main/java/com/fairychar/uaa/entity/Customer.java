package com.fairychar.uaa.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("customer")
@ApiModel("Customer")
public class Customer extends Model<Customer> {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    @TableField(value = "`id`")
    private Integer id;
    @ApiModelProperty("用户名")
    @TableField(value = "`name`")
    private String name;
    @ApiModelProperty("密码")
    @TableField(value = "`password`")
    private String password;
    @ApiModelProperty("手机号")
    @TableField(value = "`tel`")
    private String tel;
    @ApiModelProperty("邮箱")
    @TableField(value = "`email`")
    private String email;
    @ApiModelProperty("生日")
    @TableField(value = "`birthday`")
    private Date birthday;
    @ApiModelProperty("是否启用")
    @TableField(value = "`enabled`")
    private Integer enabled;
    @ApiModelProperty("乐观锁")
    @TableField(value = "`version`")
    @Version()
    private Long version;
    @ApiModelProperty("是否逻辑逻辑删除")
    @TableField(value = "`flag`")
    private Integer flag;


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
     * name
     */
    public final static String NAME = "name";

    /**
     * password
     */
    public final static String PASSWORD = "password";

    /**
     * tel
     */
    public final static String TEL = "tel";

    /**
     * email
     */
    public final static String EMAIL = "email";

    /**
     * birthday
     */
    public final static String BIRTHDAY = "birthday";

    /**
     * enabled
     */
    public final static String ENABLED = "enabled";

    /**
     * version
     */
    public final static String VERSION = "version";

    /**
     * flag
     */
    public final static String FLAG = "flag";

}