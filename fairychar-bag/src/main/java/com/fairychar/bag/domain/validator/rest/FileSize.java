package com.fairychar.bag.domain.validator.rest;

import com.fairychar.bag.domain.Consts;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文件大小校验
 *
 * @author chiyo
 * @since 1.3.2
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileSizeValidator.class)
public @interface FileSize {

    String message() default "file size not in range";

    /**
     * 单位
     *
     * @return {@link String }
     */
    Unit unit() default Unit.KB;

    /**
     * 最小大小
     *
     * @return {@link String }
     */
    long min() default 0L;

    /**
     * 最大大小
     *
     * @return {@link String }
     */
    long max();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Getter
    @AllArgsConstructor
    enum Unit {
        B(1),
        KB(Consts.KB_PER_B),
        MB(Consts.MB_PER_B),
        GB(Consts.GB_PER_B),
        TB(Consts.TB_PER_B),
        PB(Consts.PB_PER_B),
        ;
        private long size;
    }
}
