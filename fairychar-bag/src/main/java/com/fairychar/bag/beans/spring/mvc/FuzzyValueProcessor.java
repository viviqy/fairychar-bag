package com.fairychar.bag.beans.spring.mvc;

/**
 * spring mvc Response body脱敏加密执行器{@link FuzzyValue}
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
public interface FuzzyValueProcessor {

    /**
     * 模糊值
     *
     * @param text 源text值
     * @return {@link String} 脱敏加密后的text值
     */
    String fuzzyValue(String text);
}
