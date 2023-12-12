package com.fairychar.bag.beans.spring.mvc;

import java.lang.annotation.*;

/**
 * <p>spring mvc 请求参数的property值抹除注解</p>
 * 请求参数内被标记的字段,在没进controller接口前将会把值抹除<br>
 * <pre>
 *   {@code
 *   class Request{
 *       @EraseValue
 *       private String name;
 *       private String gender;
 *   }
 *
 *   @PostMapping("/add")
 *   public String add(@RequestBody @EraseValue Request request){
 *       //request name字段的值将会为null
 *       return request.toString();
 *   }
 *
 *   }
 * </pre>
 * 与其对应的反作用注解{@link KeepValue}
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface EraseValue {

    /**
     * 代表group,当作用于请求接口上代表只抹除指定Class的字段值<br>
     * 当作用于model上代表字段可以被设置的group指定抹除
     *
     * @return {@link Class}<{@link ?}>{@link []}
     */
    Class<?>[] value() default {};


}
