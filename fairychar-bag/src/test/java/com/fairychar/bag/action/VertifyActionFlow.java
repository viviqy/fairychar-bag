package com.fairychar.bag.action;

import com.fairychar.bag.extension.action.AbstractActionFlow;
import com.fairychar.bag.extension.action.ActionFlow;
import com.fairychar.bag.extension.action.ParentActionCondition;
import com.fairychar.bag.extension.action.RootAction;
import com.fairychar.bag.pojo.dto.NameValueDTO;
import com.fairychar.bag.pojo.query.TimeBetweenQuery;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

/**
 * @author chiyo <br>
 * @since 1.0.0
 */
public class VertifyActionFlow extends AbstractActionFlow<TimeBetweenQuery, NameValueDTO<LocalDateTime>> {
    @Override
    protected NameValueDTO<LocalDateTime> nextParam(TimeBetweenQuery current) {
        return new NameValueDTO(current.getFrom().getMonth().name(), current.getTo());
    }

    @Override
    public boolean compute(TimeBetweenQuery context) {
        return context.getFrom().getYear() >= 2023;
    }

    @Override
    public Set<ParentActionCondition> parent() {
        return RootAction.ROOT_SET;
    }
}
