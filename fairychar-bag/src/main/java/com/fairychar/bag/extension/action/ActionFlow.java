package com.fairychar.bag.extension.action;

import java.util.Set;

/**
 * @author chiyo <br>
 * @since 1.0.0
 */
public interface ActionFlow<T> {


    boolean compute(T context);

    Set<ParentActionCondition> parent();


    default String group(){
        return "default";
    }
}
