package com.fairychar.bag.domain.concurrent;


public interface IBalkingReference<T> {

    boolean save() throws Exception;

    boolean change(T t) throws Exception;
}
