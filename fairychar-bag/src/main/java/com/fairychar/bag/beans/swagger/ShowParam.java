package com.fairychar.bag.beans.swagger;

import java.lang.annotation.*;

/**
 * <p>swagger文档请求参数部分暂时注解</p>
 * 在不想每个接口都定义一个请求参数的情况下,通常会使用一个大的请求参数实体来做
 * 通用的请求体,但是这个通用请求体在swagger文档上,对于有些接口显示的参数太多
 * 无用的,容易引起阅读困难.这个注解可以让接口指定显示当前接口需要展示的字段,隐藏
 * 其他无用字段.
 * <pre>
 *     {@code
 *     class Sample{
 *         @ShowParam
 *         private String name;
 *         private String gender;
 *     }
 *
 *     @GetMapping("/getOne")
 *     public Sample getOne(@ShowParam @RequestBody Sample sample){
 *         return sample;
 *     }
 *     }
 * </pre>
 * swagger文档上这个接口请求参数只会暂时name字段
 *
 * @author chiyo
 * @since 1.0.2
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Deprecated(since = "openapi3")
//后期想办法适配
public @interface ShowParam {
    /**
     * 代表group,当作用于请求接口上代表只显示指定Class的字段名称
     * 当作用于model上代表字段可以被设置的group指定显示
     *
     * @return {@link Class}<{@link ?}>{@link []}
     */
    Class[] value() default {};
}
