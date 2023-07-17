package com.fairychar.bag.extension.action;

import org.apache.commons.lang.NotImplementedException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chiyo <br>
 * @since 1.0.0
 */
public class RootAction implements ActionFlow {
    public static HashSet<ParentActionCondition> ROOT_SET;

    static {
        ROOT_SET = new HashSet<>(1);
        ROOT_SET.add(new ParentActionCondition(RootAction.class, false));
    }

    @Override
    public boolean compute(Object context) {
        throw new NotImplementedException();
    }

    @Override
    public Set<ParentActionCondition> parent() {
        return ROOT_SET;
    }
}
