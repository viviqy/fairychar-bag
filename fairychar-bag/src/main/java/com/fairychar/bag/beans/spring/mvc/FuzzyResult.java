package com.fairychar.bag.beans.spring.mvc;

import java.lang.annotation.*;

/**
 * spring mvc 响应参数接口标记注解,被标记的接口将会脱敏响应参数
 * <pre>
 *     {@code
 *     class Sample{
 *         @FuzzyValue(beginAt=1,endAt=2)
 *         private String name="1234";
 *     }
 *
 *     @FuzzyResult
 *     @GetMapping("/getOne")
 *     public Sample getOne(){
 *         return new Sample();
 *         //response= {name: "1**4"}
 *     }
 *
 *     }
 * </pre>
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FuzzyResult {
    /**
     * 由于接口大多会包装一层进行返回,如<br>
     * <pre>
     * {@code
     * public HttpResult<User> getUser();
     * }
     * </pre>
     * 这种情况下,实际业务返回对象为User.class,但是HttpResult一般无法在data字段上添加注解<br>
     * 提供field属性,取包装体字段为模糊对象进行模糊处理<br>
     * 属性字段名称,如果有值则会取对应字段值为Object,可以通过.分割<br>
     * 如果值为空则取当前返回对象为Object
     * <pre>{@code
     * @FuzzyResult(field = "data.user")
     * }
     * </pre>
     *
     * @return {@link String}
     */
    String field() default "";


}
