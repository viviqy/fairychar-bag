package com.fairychar.bag.pojo.query.body;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Datetime: 2020/9/27 10:24
 *
 * @author chiyo
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "ShortList", description = "Short类型Json请求集合")
public final class ShortListQuery implements Serializable {
    private List<Short> list;
}
