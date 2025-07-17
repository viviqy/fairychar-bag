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
 * 数据字典详情(SysDict)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "UpdateSysDictQuery")
public class UpdateSysDictQuery implements Serializable {

    /**
     * ID
     */
    @Schema(description = "ID")
    private Integer id;
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

}
