package com.fairychar.bag.extension.action;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chiyo <br>
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public class ParentActionCondition {
    private Class<? extends ActionFlow> parentClass;
    private boolean condition;

    @Override
    public int hashCode() {
        return parentClass.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ParentActionCondition param = (ParentActionCondition) obj;
        return param.parentClass.equals(this.parentClass);
    }
}
