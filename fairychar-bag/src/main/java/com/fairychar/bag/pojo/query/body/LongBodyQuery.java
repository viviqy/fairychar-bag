package com.fairychar.bag.pojo.query.body;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Datetime: 2020/9/27 10:35
 *
 * @author chiyo
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "LongBody", description = "Long类型Json请求体")
public class LongBodyQuery implements Serializable {
    private Long body;
}
