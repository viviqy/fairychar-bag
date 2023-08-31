package flow.sample;

import com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow;
import com.fairychar.bag.extension.action.condition.bool.ActionFlow;
import com.fairychar.bag.extension.action.condition.bool.ParentActionCondition;
import com.fairychar.bag.extension.action.condition.bool.RootAction;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author chiyo <br>
 * @since 1.0.2
 */
public class StringFlow extends AbstractActionFlow<String, Integer> {
    @Override
    public ActionFlow<String, Integer> instanceBean() {
        return new StringFlow();
    }

    @Override
    public boolean compute(String context) {
        return context.isEmpty();
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return Sets.newHashSet(RootAction.getCondition());
    }

    @Override
    public Integer getNextParam(String context) {
        return Integer.valueOf(context);
    }
}
