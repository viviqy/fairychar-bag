package com.fairychar.bag.extension.action.condition.bool;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 父类flow条件与对应class的映射类
 *
 * @author chiyo
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public class ParentActionCondition {
    /**
     * 父ActionFlow class
     */
    private Class<? extends ActionFlow> parentClass;
    /**
     * 父类走到当前子类的条件
     */
    private boolean condition;

    @Override
    public int hashCode() {
        return parentClass.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParentActionCondition that = (ParentActionCondition) obj;
        return Objects.equals(parentClass, that.parentClass);
    }
}
