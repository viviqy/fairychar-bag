package com.fairychar.bag.extension.collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiPredicate;

/**
 * @author qiyue
 */
public class BiPredicateList<T> extends ArrayList<T> {
    private BiPredicate<T, T> biPredicate;

    public BiPredicateList(Collection<? extends T> c, BiPredicate<T, T> biPredicate) {
        super(c);
        this.biPredicate = biPredicate;
    }

    @Override
    public boolean add(T item) {
        for (int i = 0; i < super.size(); i++) {
            T existing = super.get(i);
            if (biPredicate.test(item, existing)) {
                super.set(i, item);  // 替换旧元素
                return true;
            }
        }
        return super.add(item);  // 没有等价项，新增
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean modified = false;
        for (T item : collection) {
            if (this.add(item)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public T set(int index, T element) {
        return super.set(index, element);
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
