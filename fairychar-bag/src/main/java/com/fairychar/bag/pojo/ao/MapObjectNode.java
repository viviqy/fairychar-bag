package com.fairychar.bag.pojo.ao;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * http前端树形父子接口渲染类
 *
 * @author chiyo
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class MapObjectNode<T> {
    private String name;
    private long count;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MapObjectNode<T>> child;
}
