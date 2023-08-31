package com.fairychar.bag.extension.action.condition.bool;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽象操作流</br>
 *
 * @author chiyo <br>
 * @since 1.0.0
 */

@NoArgsConstructor
@Slf4j
public abstract class AbstractActionFlow<C, N> implements ActionFlow<C, N> {
    /**
     * compute结果为true时call的下一流
     */
    @Setter
    @Getter
    private AbstractActionFlow trueFlow;
    /**
     * compute结果为false时call的下一流
     */
    @Getter
    @Setter
    private AbstractActionFlow falseFlow;

    /**
     * compute then callNext flow
     *
     * @param context 上下文
     */
    @Override
    public void callNext(C context) {
        boolean condition = this.compute(context);
        log.debug("{} compute result={}", this.getClass().getName(), condition);
        AbstractActionFlow child = condition ? trueFlow : falseFlow;
        if (child != null) {
            child.callNext(getNextParam(context));
        }
    }

}
