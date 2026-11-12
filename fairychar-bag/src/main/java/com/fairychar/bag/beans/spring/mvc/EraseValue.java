package com.fairychar.bag.beans.spring.mvc;

import java.lang.annotation.*;

/**
 * <p>spring mvc 请求参数的property值抹除注解</p>
 * 请求参数内被标记的字段,在没进controller接口前将会把值抹除
 * 只处理请求体当前类声明的非静态、非final字段；引用类型置为null，基本类型重置为Java默认值，不递归处理嵌套对象或父类字段。
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
 * @author chiyo
 * @since 1.0.2
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface EraseValue {

    /**
     * 字段和参数都不指定group时匹配；显式group按Class交集匹配，仅一方为空时不匹配。
     * 只有匹配的标注字段会被抹除，未标注字段保持原值。
     *
     * @return {@link Class}<{@link ?}>{@link []}
     */
    Class<?>[] value() default {};


}
