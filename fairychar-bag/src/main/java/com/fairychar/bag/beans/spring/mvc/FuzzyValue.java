package com.fairychar.bag.beans.spring.mvc;

import java.lang.annotation.*;

/**
 * spring mvc 响应参数property值脱敏
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FuzzyValue {
    /**
     * 开始索引
     *
     * @return int
     */
    int beginAt() default 0;

    /**
     * 结束索引
     *
     * @return int
     */
    int endAt() default 0;

    /**
     * 替换符号
     *
     * @return {@link String}
     */
    String replaceSymbol() default "*";

    /**
     * <p>脱敏加密执行器</p>
     * 当此项值不为空时,会选择对应SpringBean来执行脱敏加密运算
     *
     * @return {@link Class}<{@link ?} {@link extends} {@link FuzzyValueProcessor}>{@link []}
     */
    Class<? extends FuzzyValueProcessor>[] processor() default {};


}
