package com.fairychar.bag.pojo.vo;

import com.fairychar.bag.beans.spring.mvc.FuzzyValue;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.utils.RequestUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

/**
 * restful响应体
 *
 * @author chiyo
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Builder
public class HttpResult<T> {
    private static final HttpResult CACHED_OK = new HttpResult(200, null, "success");
    private static final HttpResult CACHED_FAIL = new HttpResult<>(RestErrorCode.OPERATION_FAILED.getCode(), null, RestErrorCode.OPERATION_FAILED.getMessage());

    private int code;
    /**
     * 返回数据
     * <p>{@link FuzzyValue}添加模糊化参数支持</p>
     */
    @FuzzyValue
    private T data;
    private String msg;


    public static HttpResult response(HttpStatus code, RestErrorCode errorCode, Object data) {
        HttpServletResponse response = RequestUtil.getCurrentResponse();
        response.setStatus(code.value());
        return new HttpResult(errorCode.getCode(), data, errorCode.getMessage());
    }

    public static HttpResult response(HttpStatus code, RestErrorCode errorCode, Object data, String msg) {
        HttpServletResponse response = RequestUtil.getCurrentResponse();
        response.setStatus(code.value());
        return new HttpResult(errorCode.getCode(), data, msg);
    }


    public static HttpResult ok() {
        return CACHED_OK;
    }


    public static <T> HttpResult<T> ok(T data) {
        return new HttpResult(200, data, "success");
    }

    public static <T> HttpResult<T> fail(T data) {
        return fail(RestErrorCode.OPERATION_FAILED, data);
    }

    public static <T> HttpResult<T> fail(RestErrorCode errorCode) {
        return fail(errorCode, null);
    }

    public static <T> HttpResult<T> fail(RestErrorCode errorCode, T data) {
        return new HttpResult<>(errorCode.getCode(), data, errorCode.getMessage());
    }

    public static <T> HttpResult<T> fail() {
        return CACHED_FAIL;
    }


}
