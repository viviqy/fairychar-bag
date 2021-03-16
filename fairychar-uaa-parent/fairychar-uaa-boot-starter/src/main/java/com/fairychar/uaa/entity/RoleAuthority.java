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
 * (RoleAuthority)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("role_authority")
@ApiModel("RoleAuthority")
public class RoleAuthority extends Model<RoleAuthority> {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    @TableField(value = "`id`")
    private Integer id;
    @ApiModelProperty("权限表id")
    @TableField(value = "`authority_id`")
    private Integer authorityId;
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
     * authority_id
     */
    public final static String AUTHORITY_ID = "authority_id";

    /**
     * role_id
     */
    public final static String ROLE_ID = "role_id";

}