package com.fairychar.security.core.rbac.pojo.query;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色表(SystemRole)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SystemRoleQuery")
public class SystemRoleQuery implements Serializable {

    /**
     * ID
     */
    @Schema(description = "ID")
    private Integer id;
    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;
    /**
     * 角色级别(0代表root)
     */
    @Schema(description = "角色级别(0代表root)")
    private Integer level;
    /**
     * 描述
     */
    @Schema(description = "描述")
    private String description;
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
    /**
     * 分页请求参数
     */
    @Schema(description = "分页参数")
    private Page pageQuery = new Page();

}
