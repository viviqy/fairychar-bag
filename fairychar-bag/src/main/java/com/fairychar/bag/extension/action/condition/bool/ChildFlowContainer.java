package com.fairychar.bag.extension.action.condition.bool;

import java.util.HashMap;
import java.util.Map;

/**
 * Datetime: 2023/7/18 09:57 <br>
 *
 * @author chiyo <br>
 * @since 1.0.0
 */
public class ChildFlowContainer {
    private Map<Boolean, ActionFlow> container = new HashMap<>(2);

    public <T, C> ActionFlow<T, C> get(boolean condition) {
        return container.get(condition);
    }

    public void add(boolean condition, ActionFlow flow) {
        if (container.put(condition, flow) != null) {
            throw new IllegalArgumentException(String.format("multiple same condition action flow found,condition=%s flow=%s", condition, flow.getClass().getName()));
        }
    }

    public <T, C> ActionFlow<T, C> remove(boolean condition) {
        return container.remove(condition);
    }

    public void clear() {
        this.container.clear();
    }
}
