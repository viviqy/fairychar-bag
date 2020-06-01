package com.fairychar.bag.utils;


import com.fairychar.bag.domain.exceptions.ParamErrorException;
import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA <br>
 * User: chiyo <br>
 * Date: 2019/12/4 <br>
 * time: 17:06 <br>
 *
 * @author chiyo <br>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BindingResultUtil {
    private final static String LINER = "\r\n";

    public static void checkBindingErrors(BindingResult... bindingResults) throws ParamErrorException {
        String errors = "";
        for (BindingResult bindingResult : bindingResults) {
            if (bindingResult.hasErrors()) {
                errors += bindingResult
                        .getFieldErrors().stream()
                        .map(e -> "[" + e.getField() + "]" + " " + e.getDefaultMessage())
                        .collect(Collectors.joining(","));
                errors.concat(LINER);
            }
        }
        if (!Strings.isNullOrEmpty(errors)) {
            throw new ParamErrorException(errors);
        }
    }

    public static void checkBindingErrors(List<BindingResult> bindingResults) throws ParamErrorException {
        checkBindingErrors(bindingResults.toArray(new BindingResult[]{}));
    }

}
