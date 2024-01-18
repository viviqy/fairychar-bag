package com.fairychar.bag.extension.collection;

import java.util.*;
import java.util.function.Predicate;

/**
 * Datetime: 2021/7/6 11:06
 *
 * @author chiyo
 * @since 1.0
 */
public class FastReadWriteList<E> extends ArrayList<E> {
    private HashSet<Integer> removedIndexes;

    public FastReadWriteList(int initialCapacity) {
        super(initialCapacity);
        this.removedIndexes = new HashSet<>(initialCapacity);
    }

    public FastReadWriteList() {
        super();
        this.removedIndexes = new HashSet<>(1024);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return this.removedIndexes.size() == this.size();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                if (current < size()) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                do {
                    if (!removedIndexes.contains(current) && current < size()) {
                        E result = get(current++);
                        return result;
                    }
                } while (current++ < size());
                return null;
            }
        };
        return iterator;
    }

    @Override
    public E remove(int index) {
        this.removedIndexes.add(index);
        return this.get(index);
    }


    @Override
    public boolean remove(Object o) {
        return this.removedIndexes.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            int indexOf = indexOf(o);
            this.removedIndexes.add(indexOf);
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = super.contains(o);
        if (result == true) {
            int indexOf = super.indexOf(o);
            result = !this.removedIndexes.contains(indexOf);
        }
        return result;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        throw new UnsupportedOperationException();
    }
}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/