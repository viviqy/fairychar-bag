package com.fairychar.bag.pojo.ao;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * http前端响应树接口AO类
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "MappingObjectAO", description = "前端Map渲染对象")
@SuppressWarnings("spotbugs:EI_EXPOSE_REP2")
public class MappingObjectAO<K, V> implements Serializable {
    private K key;
    private long count;
    private List<V> values;
}
