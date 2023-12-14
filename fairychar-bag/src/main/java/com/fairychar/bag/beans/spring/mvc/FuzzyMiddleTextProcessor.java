package com.fairychar.bag.beans.spring.mvc;

import com.google.common.base.Strings;

/**
 * <p>模糊加密字符串</p>
 * beginAt=从左往右数几位,
 * endAt=从右往左数几位,
 * 模糊加密这之间的字符
 * <pre>
 *     {@code
 *     @Configuration
 *     class BeansConfiguration{
 *          @Bean
 *          FuzzyValueProcessor middleFuzzy(){
 *              return new FuzzyMiddleTextProcessor();
 *          }
 *     }
 *
 *     class Sample{
 *         @FuzzyValue(beginAt=1,endAt=1,processor={FuzzyMiddleTextProcessor.class})
 *         private String text="1234";
 *     }
 *
 *     }
 * </pre>
 * 模糊加密后结果为text="1**4";
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
public class FuzzyMiddleTextProcessor implements FuzzyValueProcessor {
    @Override
    public String fuzzyValue(String text, FuzzyValue fuzzyValue) {
        if (Strings.isNullOrEmpty(text)) {
            return text;
        }
        String middle = Strings.repeat(fuzzyValue.replaceSymbol(), (text.length() - fuzzyValue.endAt()) - fuzzyValue.beginAt());
        String replaceText = text.substring(0, fuzzyValue.beginAt())
                .concat(middle)
                .concat(text.substring(text.length() - fuzzyValue.endAt(), text.length()));
        return replaceText;
    }
}
