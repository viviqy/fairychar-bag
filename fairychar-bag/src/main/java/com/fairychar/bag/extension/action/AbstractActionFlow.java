package com.fairychar.bag.extension.action;

import java.util.Map;
import java.util.Set;

/**
 * @author chiyo <br>
 * @since 1.0.0
 */
public abstract class AbstractActionFlow<T, C> implements ActionFlow<T> {
    private Set<AbstractActionFlow> childs;

    protected void dispatch(T context) {
        boolean condition = this.compute(context);
        for (AbstractActionFlow child : childs) {
            if (child.parentCondition() == condition) {
                child.dispatch(nextParam(context));
            }
        }
    }


    protected abstract C nextParam(T current);

}
