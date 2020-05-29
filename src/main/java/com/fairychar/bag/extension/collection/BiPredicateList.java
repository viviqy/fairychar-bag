package com.fairychar.bag.extension.collection;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;

/**
 * Created with IDEA <br>
 * User: qiyue <br>
 * Date: 2020/03/05 <br>
 * time: 18:12 <br>
 *
 * @author qiyue <br>
 */
public class BiPredicateList<T> extends ArrayList<T> {
    private BiPredicate<T, T> biPredicate;

    @Override
    public boolean add(T t) {
        if (super.isEmpty()) {
            super.add(t);
        }
        AtomicInteger matchIndex = new AtomicInteger(-1);
        this.forEach(e -> {
            if (this.biPredicate.test(t, e)) {
                matchIndex.set(this.indexOf(e));
                return;
            }
        });
        if (matchIndex.get() != -1) {
            super.set(matchIndex.get(), t);
        } else {
            super.add(t);
        }
        return true;
    }

    public BiPredicateList(Collection<? extends T> c, BiPredicate<T, T> biPredicate) {
        super(c);
        this.biPredicate = biPredicate;
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
        throw new NotImplementedException();
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