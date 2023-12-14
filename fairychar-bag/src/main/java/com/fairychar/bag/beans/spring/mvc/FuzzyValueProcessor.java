package com.fairychar.bag.beans.spring.mvc;

/**
 * spring mvc Response body脱敏加密执行器<br>
 * 可通过指定{@link FuzzyValue#processor()}以达到在脱敏时选择自定义的解析器
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
public interface FuzzyValueProcessor {

    /**
     * 模糊值
     *
     * @param text        源text值
     * @param fuzzyResult 模糊结果注解
     * @return {@link String}
     */
    String fuzzyValue(String text, FuzzyValue fuzzyResult);
}
