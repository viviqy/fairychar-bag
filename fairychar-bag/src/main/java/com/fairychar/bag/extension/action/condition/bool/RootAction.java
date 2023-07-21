package com.fairychar.bag.extension.action.condition.bool;

import org.apache.commons.lang.NotImplementedException;

import java.util.Set;

/**
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
    public Object getNextParam(Object current) {
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
