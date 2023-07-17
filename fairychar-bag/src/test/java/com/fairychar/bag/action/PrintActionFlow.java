package com.fairychar.bag.action;

import com.fairychar.bag.extension.action.AbstractActionFlow;
import com.fairychar.bag.extension.action.ActionFlow;
import com.fairychar.bag.extension.action.ParentActionCondition;
import com.google.common.collect.Sets;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author chiyo <br>
 * @since 1.0.0
 */
public class PrintActionFlow extends AbstractActionFlow<LocalDate,Void> {
    @Override
    protected Void nextParam(LocalDate current) {
        return null;
    }

    @Override
    public boolean compute(LocalDate context) {

        return false;
    }

    @Override
    public Set<ParentActionCondition> parent() {
        return Sets.newHashSet(
                new ParentActionCondition(CalculateActionFlow.class,true)
                ,new ParentActionCondition(VertifyActionFlow.class,false)
        );
    }
}
