package com.fairychar.bag.extension.action.condition.bool;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author chiyo <br>
 * @since 1.0.0
 */

@NoArgsConstructor
public abstract class AbstractActionFlow<C, N> implements ActionFlow<C, N> {
    @Setter
    @Getter
    private ChildFlowContainer childFlowContainer;

    @Override
    public void callNext(C context) {
        boolean condition = this.compute(context);
        ActionFlow child = childFlowContainer.get(condition);
        if (child != null) {
            child.callNext(getNextParam(context));
        }
    }


}
