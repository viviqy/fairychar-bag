package com.fairychar.bag.beans.spring.mvc;

import java.lang.annotation.*;

/**
 * <p>spring mvc 请求参数property保持值</p>
 * 请求参数内<font color="red"><b>没有被标记</b>的字段</font> ,在没进controller接口前将会把值抹除
 * 只保留group匹配的标注字段，其余当前类声明的非静态、非final字段均抹除。
 * 引用类型置为null，基本类型重置为Java默认值，不递归处理嵌套对象或父类字段。
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
 * @author chiyo
 * @since 1.0.2
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface KeepValue {

    /**
     * 字段和参数都不指定group时匹配；显式group按Class交集匹配，仅一方为空时不匹配。
     * 只有匹配的标注字段会被保留，未标注字段和group不匹配的字段均抹除。
     *
     * @return {@link Class}<{@link ?}>{@link []}
     */
    Class<?>[] value() default {};


}
