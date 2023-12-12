package com.fairychar.bag.beans.spring.mvc;

import java.lang.annotation.*;

/**
 * <p>spring mvc 请求参数property保持值</p>
 * 请求参数内<font color="red"><b>没有被标记</b>的字段</font> ,在没进controller接口前将会把值抹除<br>
 * <pre>
 *   {@code
 *   class Request{
 *       @KeepValue
 *       private String name;
 *       private String gender;
 *   }
 *
 *   @PostMapping("/add")
 *   public String add(@RequestBody @KeepValue Request request){
 *       //request gender字段的值将会为null
 *       return request.toString();
 *   }
 *
 *   }
 * </pre>
 * 与其对应的反作用注解{@link EraseValue}
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface KeepValue {

    /**
     * 代表group,当作用于请求接口上代表只抹除指定Class的字段值<br>
     * 当作用于model上代表字段可以被设置的group指定保留
     *
     * @return {@link Class}<{@link ?}>{@link []}
     */
    Class<?>[] value() default {};


}
