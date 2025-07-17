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
 * 数据字典详情(SysDict)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysDictDTO")
public class SysDictDTO implements Serializable {

    /**
     * ID
     */
    @Schema(description = "ID")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;
    /**
     * 字典uid
     */
    @Schema(description = "字典uid")
    private Long uid;
    /**
     * 字典标签
     */
    @Schema(description = "字典标签")
    private String label;
    /**
     * 字典值
     */
    @Schema(description = "字典值")
    private String labelValue;
    /**
     * 描述
     */
    @Schema(description = "描述")
    private String description;
    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer dictSort;
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
     * 修改人名称
     */
    @Schema(description = "修改人名称")
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
