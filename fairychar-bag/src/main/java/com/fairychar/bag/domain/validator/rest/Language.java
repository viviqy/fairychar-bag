package com.fairychar.bag.domain.validator.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 语言校验
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LanguageValidator.class)
public @interface Language {
    LanguageType value();

    String message() default "not support this language";

    Class<?>[] groups() default {};


    /**
     * 语言类型
     *
     * @author chiyo
     */
    @AllArgsConstructor
    @Getter
    enum LanguageType {

        /**
         * 中文
         */
        CHINESE("^[\\u4e00-\\u9fa5]+$"),
        /**
         * 中文与英文
         */
        CHINES_WITH_ENGLISH("^[\\u4e00-\\u9fa5]+$+[a-zA-Z]+"),
        /**
         * 带数字中文
         */
        CHINESE_WITH_NUMBER("^[\\u4e00-\\u9fa5]+$+[0-9]+"),
        /**
         * 中文与英文和数字
         */
        CHINESE_WITH_ENGLISH_AND_NUMBER("^[\\u4e00-\\u9fa5]+$+[a-zA-Z0-9]+");

        private String regex;
    }
}
