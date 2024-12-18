package com.fairychar.bag.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author chiyo <br>
 * @since 1.3.2
 */
@AllArgsConstructor
@Getter
@Schema(description = "InvalidateFieldVO")
@ToString
public class InvalidateFieldVO implements Serializable {
    @Schema(description = "异常字段名称")
    private String fieldName;
    @Schema(description = "异常信息")
    private String errorMessage;
}
