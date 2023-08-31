package com.fairychar.bag.extension.action.condition.bool;

import org.apache.commons.lang.NotImplementedException;

import java.util.Set;

/**
 * </p>Root节点流程,仅作为一个流的root标识</p>
 * 为什么需要: </br>
 * 1. 唯一的入口点 </br>
 * 2. 对于有循环的流程,可以区分入口 </br>
 *
 * @author chiyo <br>
 * @since 1.0.0
 */
public class RootAction implements ActionFlow {

    @Override
    public boolean compute(Object context) {
        throw new NotImplementedException();
    }

    @Override
    public void callNext(Object context) {
        throw new NotImplementedException();
    }

    @Override
    public Object getNextParam(Object context) {
        throw new NotImplementedException();
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return null;
    }

    @Override
    public ActionFlow instanceBean() {
        return Singleton.INSTANCE.getInstance();
    }

    public static ParentActionCondition getCondition() {
        return new ParentActionCondition(RootAction.class, false);
    }

    private enum Singleton {
        INSTANCE;

        private final RootAction instance;

        Singleton() {
            this.instance = new RootAction();
        }

        public RootAction getInstance() {
            return INSTANCE.instance;
        }
    }
}
