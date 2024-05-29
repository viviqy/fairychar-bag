package com.fairychar.bag.pojo.query;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * http泛型参数接收实体(feign下不可用泛型)
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class SimpleTypeQuery<T> implements Serializable {
    @NotNull
    private T value;
}