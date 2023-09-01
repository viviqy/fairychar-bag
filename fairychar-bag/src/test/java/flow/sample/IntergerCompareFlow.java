package flow.sample;

import com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow;
import com.fairychar.bag.extension.action.condition.bool.ActionFlow;
import com.fairychar.bag.extension.action.condition.bool.ParentActionCondition;

import java.util.Set;

/**
 * @author chiyo <br>
 * @since
 */
public class IntergerCompareFlow extends AbstractActionFlow<Integer, Integer> {
    @Override
    public ActionFlow<Integer, Integer> instanceBean() {
        return new IntergerCompareFlow();
    }

    @Override
    public boolean compute(Integer context) {
        return context > 1;
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return null;
    }

    @Override
    public Integer getNextParam(Integer context) {
        return context + 1;
    }
}
