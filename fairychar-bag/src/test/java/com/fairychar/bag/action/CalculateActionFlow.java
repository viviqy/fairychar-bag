package com.fairychar.bag.action;

import com.fairychar.bag.extension.action.AbstractActionFlow;
import com.fairychar.bag.extension.action.ActionFlow;
import com.fairychar.bag.extension.action.ParentActionCondition;
import com.fairychar.bag.pojo.dto.NameValueDTO;
import com.google.common.collect.Sets;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author chiyo <br>
 * @since 1.0.0
 */
public class CalculateActionFlow extends AbstractActionFlow<NameValueDTO<LocalDateTime>, LocalDate> {
    @Override
    protected LocalDate nextParam(NameValueDTO<LocalDateTime> current) {
        return current.getValue().toLocalDate();
    }

    @Override
    public boolean compute(NameValueDTO<LocalDateTime> context) {
        return context.getValue().getSecond() > 30;
    }

    @Override
    public Set<ParentActionCondition> parent() {
        return Sets.newHashSet(new ParentActionCondition(VertifyActionFlow.class,true));
    }
}
