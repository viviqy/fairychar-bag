package com.fairychar.bag.pojo.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 键值对 DTO
 *
 * @author chiyo
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(description = "key-value格式数据")
public class KeyValuePair<K, V> implements Serializable {

    private K name;
    private V value;
}
