package com.fairychar.bag.pojo.ao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 前端key-value渲染AO类
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class MappingAO<K, V> implements Serializable {
    private K key;
    private V value;
}
