package com.fairychar.security.core.rbac.pojo.query;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (MenuHasApi)表实体类
 *
 * @author chiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddMenuHasApiQuery")
public class AddMenuHasApiQuery implements Serializable {


    /**
     * 关联菜单id
     */
    @Schema(description = "关联菜单id")
    @NotNull
    private Integer menuId;
    /**
     * 关联接口id
     */
    @Schema(description = "关联接口id")
    @NotNull
    private Integer apiId;

}
