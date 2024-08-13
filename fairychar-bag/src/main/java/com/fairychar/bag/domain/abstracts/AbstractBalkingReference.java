package com.fairychar.bag.domain.abstracts;

import com.fairychar.bag.domain.concurrent.IBalkingReference;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 任务属性状态追踪
 *
 * @author chiyo
 */
@Slf4j
public abstract class AbstractBalkingReference<T> implements IBalkingReference<T> {
    protected AtomicBoolean isChanged = new AtomicBoolean(true);
    protected T t;

    public AbstractBalkingReference(T t) {
        this.t = t;
    }

    @Override
    public synchronized boolean save() {
        if (isChanged.get()) {
            boolean b = doSave();
            if (!b) {
                return false;
            }
            log.debug("save success");
            isChanged.set(false);
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean change(T t) {
        if (!this.isChanged.get()) {
            this.t = t;
            this.isChanged.set(true);
            return true;
        }
        return false;
    }

    public abstract boolean doSave();
}
