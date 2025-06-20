package com.fairychar.security.core.rbac.pojo.dto;


import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 系统用户(SystemUser)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SystemUserDTO")
public class SystemUserDTO implements Serializable {

    /**
     * ID
     */
    @Schema(description = "ID")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;
    /**
     * uid
     */
    @Schema(description = "uid")
    private Long uid;
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;
    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickName;
    /**
     * 性别
     */
    @Schema(description = "性别")
    private String gender;
    /**
     * 手机号码
     */
    @Schema(description = "手机号码")
    private String phone;
    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;
    /**
     * 头像路径
     */
    @Schema(description = "头像路径")
    private String avatarPath;
    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;
    /**
     * 状态：1启用、0禁用
     */
    @Schema(description = "状态：1启用、0禁用")
    private Boolean enabled;
    /**
     * 修改密码的时间
     */
    @Schema(description = "修改密码的时间")
    private LocalDateTime pwdResetTime;
    /**
     * 是否过期
     */
    @Schema(description = "是否过期")
    private Boolean expired;
    /**
     * 是否被冻结
     */
    @Schema(description = "是否被冻结")
    private Boolean locked;
    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sort;
    /**
     * 系统用户标识(如功能端,后台端)
     */
    @Schema(description = "系统用户标识(如功能端,后台端)")
    private String sysMark;
    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Long createBy;
    /**
     * 创建人名称
     */
    @Schema(description = "创建人名称")
    private String createName;
    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private Long updateBy;
    /**
     * 更新人名称
     */
    @Schema(description = "更新人名称")
    private String updateName;
    /**
     * 创建日期
     */
    @Schema(description = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


}
