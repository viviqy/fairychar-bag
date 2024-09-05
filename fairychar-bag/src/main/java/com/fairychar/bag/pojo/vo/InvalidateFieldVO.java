package com.fairychar.bag.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author chiyo <br>
 * @since 1.3.2
 */
@AllArgsConstructor
@Getter
@Schema(description = "InvalidateFieldVO")
public class InvalidateFieldVO implements Serializable {
    private String fieldName;
    private String errorMessage;
}
