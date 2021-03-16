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
 * (Authority)表实体类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("authority")
@ApiModel("Authority")
public class Authority extends Model<Authority> {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("")
    @TableField(value = "`id`")
    private Integer id;
    @ApiModelProperty("")
    @TableField(value = "`name`")
    private String name;


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

}