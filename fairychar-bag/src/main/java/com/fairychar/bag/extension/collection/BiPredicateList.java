package com.fairychar.bag.extension.collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;

/**
 * Date: 2020/03/05
 * time: 18:12
 *
 * @author qiyue
 */
public class BiPredicateList<T> extends ArrayList<T> {
    private BiPredicate<T, T> biPredicate;

    public BiPredicateList(Collection<? extends T> c, BiPredicate<T, T> biPredicate) {
        super(c);
        this.biPredicate = biPredicate;
    }

    @Override
    public boolean add(T t) {
        if (super.isEmpty()) {
            super.add(t);
        }
        AtomicInteger matchIndex = new AtomicInteger(-1);
        this.forEach(e -> {
            if (this.biPredicate.test(t, e)) {
                matchIndex.set(this.indexOf(e));
            }
        });
        if (matchIndex.get() != -1) {
            super.set(matchIndex.get(), t);
        } else {
            super.add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            this.add(t);
        }
        return true;
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }


}
