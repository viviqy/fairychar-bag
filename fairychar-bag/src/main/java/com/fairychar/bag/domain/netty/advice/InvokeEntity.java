package com.fairychar.bag.domain.netty.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Method参数包装实体
 * method.invoke(obj,args..)
 * obj=bean method的执行类
 * args=args method的执行参数
 */
@AllArgsConstructor
@Getter
class InvokeEntity {
    private final Object bean;
    private final Object[] args;
}
