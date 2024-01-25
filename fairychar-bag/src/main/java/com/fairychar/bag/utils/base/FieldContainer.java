package com.fairychar.bag.utils.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.lang.reflect.Field;

/**
 * <p>Field容器</p>
 * 包含Field与其对应Object
 *
 * @author chiyo
 * @since 1.0.2
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class FieldContainer {

    /**
     * 目标对象
     */
    private Object targetObject;
    /**
     * 字段
     */
    private Field field;

    /**
     * 字段全路径,如A.b.c.name
     */
    private String path;
}
