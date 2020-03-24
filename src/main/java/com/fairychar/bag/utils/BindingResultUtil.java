package com.fairychar.bag.utils;


import com.fairychar.bag.domain.exceptions.ParamErrorException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

/**
 * Created with IDEA <br>
 * User: lmq <br>
 * Date: 2019/12/4 <br>
 * time: 17:06 <br>
 *
 * @author lmq <br>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BindingResultUtil {
    public static void checkBindingErrors(BindingResult... bindingResults) throws ParamErrorException {
        for (BindingResult bindingResult : bindingResults) {
            if (bindingResult.hasErrors()) {
                String errors = bindingResult
                        .getFieldErrors().stream()
                        .map(e -> e.getField() + " " + e.getDefaultMessage())
                        .collect(Collectors.joining(","));
                throw new ParamErrorException(errors);
            }
        }
    }

}
