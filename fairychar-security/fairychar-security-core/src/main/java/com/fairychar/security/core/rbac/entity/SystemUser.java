package com.fairychar.security.core.rbac.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统用户(SystemUser)表实体类
 *
 * @author chiyo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("system_user")
@Schema(description = "SystemUser")
public class SystemUser extends Model<SystemUser> {
    /**
     * ID
     */
    @Schema(description = "ID")
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;
    /**
     * uid
     */
    @Schema(description = "uid")
    @TableField(value = "`uid`")
    private Long uid;
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @TableField(value = "`username`")
    private String username;
    /**
     * 昵称
     */
    @Schema(description = "昵称")
    @TableField(value = "`nick_name`")
    private String nickName;
    /**
     * 性别
     */
    @Schema(description = "性别")
    @TableField(value = "`gender`")
    private String gender;
    /**
     * 手机号码
     */
    @Schema(description = "手机号码")
    @TableField(value = "`phone`")
    private String phone;
    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @TableField(value = "`email`")
    private String email;
    /**
     * 头像路径
     */
    @Schema(description = "头像路径")
    @TableField(value = "`avatar_path`")
    private String avatarPath;
    /**
     * 密码
     */
    @Schema(description = "密码")
    @TableField(value = "`password`")
    private String password;
    /**
     * 状态：1启用、0禁用
     */
    @Schema(description = "状态：1启用、0禁用")
    @TableField(value = "`enabled`")
    private Boolean enabled;
    /**
     * 修改密码的时间
     */
    @Schema(description = "修改密码的时间")
    @TableField(value = "`pwd_reset_time`")
    private LocalDateTime pwdResetTime;
    /**
     * 是否过期
     */
    @Schema(description = "是否过期")
    @TableField(value = "`is_expired`")
    private Boolean expired;
    /**
     * 是否被冻结
     */
    @Schema(description = "是否被冻结")
    @TableField(value = "`is_locked`")
    private Boolean locked;
    /**
     * 排序
     */
    @Schema(description = "排序")
    @TableField(value = "`sort`")
    private Integer sort;
    /**
     * 系统用户标识(如功能端,后台端)
     */
    @Schema(description = "系统用户标识(如功能端,后台端)")
    @TableField(value = "`sys_mark`")
    private String sysMark;
    /**
     * 创建者
     */
    @Schema(description = "创建者")
    @TableField(value = "`create_by`", fill = FieldFill.INSERT)
    private Long createBy;
    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称")
    @TableField(value = "`create_name`", fill = FieldFill.INSERT)
    private String createName;
    /**
     * 更新者
     */
    @Schema(description = "更新者")
    @TableField(value = "`update_by`", fill = FieldFill.UPDATE)
    private Long updateBy;
    /**
     * 更新人名称
     */
    @Schema(description = "更新人名称")
    @TableField(value = "`update_name`", fill = FieldFill.UPDATE)
    private String updateName;
    /**
     * 创建日期
     */
    @Schema(description = "创建日期")
    @TableField(value = "`create_time`")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @TableField(value = "`update_time`")
    private LocalDateTime updateTime;
    /**
     * 分组匹配字符
     */
    @TableField(exist = false)
    @Schema(description = "分组数量匹配字段,和原表无关")
    private Integer groupByCount;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }


    /**
     * id - ID
     */
    public static final String ID = "id";

    /**
     * uid - uid
     */
    public static final String UID = "uid";

    /**
     * username - 用户名
     */
    public static final String USERNAME = "username";

    /**
     * nick_name - 昵称
     */
    public static final String NICK_NAME = "nick_name";

    /**
     * gender - 性别
     */
    public static final String GENDER = "gender";

    /**
     * phone - 手机号码
     */
    public static final String PHONE = "phone";

    /**
     * email - 邮箱
     */
    public static final String EMAIL = "email";

    /**
     * avatar_path - 头像路径
     */
    public static final String AVATAR_PATH = "avatar_path";

    /**
     * password - 密码
     */
    public static final String PASSWORD = "password";

    /**
     * enabled - 状态：1启用、0禁用
     */
    public static final String ENABLED = "enabled";

    /**
     * pwd_reset_time - 修改密码的时间
     */
    public static final String PWD_RESET_TIME = "pwd_reset_time";

    /**
     * is_expired - 是否过期
     */
    public static final String IS_EXPIRED = "is_expired";

    /**
     * is_locked - 是否被冻结
     */
    public static final String IS_LOCKED = "is_locked";

    /**
     * sort - 排序
     */
    public static final String SORT = "sort";

    /**
     * sys_mark - 系统用户标识(如功能端,后台端)
     */
    public static final String SYS_MARK = "sys_mark";

    /**
     * create_by - 创建者
     */
    public static final String CREATE_BY = "create_by";

    /**
     * create_name - 创建人名称
     */
    public static final String CREATE_NAME = "create_name";

    /**
     * update_by - 更新者
     */
    public static final String UPDATE_BY = "update_by";

    /**
     * update_name - 更新人名称
     */
    public static final String UPDATE_NAME = "update_name";

    /**
     * create_time - 创建日期
     */
    public static final String CREATE_TIME = "create_time";

    /**
     * update_time - 更新时间
     */
    public static final String UPDATE_TIME = "update_time";

}
