package com.fairychar.bag.utils;


import com.fairychar.bag.domain.exceptions.ParamErrorException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * hibernate validator校验结果渲染工具类
 *
 * @author chiyo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BindingResultUtil {
    private static final String LINER = "\r\n";

    public static void checkBindingErrors(BindingResult... bindingResults) throws ParamErrorException {
        StringBuffer errors = new StringBuffer();
        for (BindingResult bindingResult : bindingResults) {
            if (bindingResult.hasErrors()) {
                errors.append(bindingResult
                        .getFieldErrors().stream()
                        .map(e -> "[" + e.getField() + "]" + " " + e.getDefaultMessage())
                        .collect(Collectors.joining(",")));
                errors.append(LINER);
            }
        }
        if (errors.length() > 0) {
            throw new ParamErrorException(errors.toString());
        }
    }

    public static void checkBindingErrors(List<BindingResult> bindingResults) throws ParamErrorException {
        checkBindingErrors(bindingResults.toArray(new BindingResult[]{}));
    }

}
