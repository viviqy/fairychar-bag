package com.fairychar.bag.domain.exceptions;

import lombok.Getter;

/**
 * Rest异常类
 *
 * @author chiyo
 * @since 0.0.1
 */
@Getter
public class RestException extends RuntimeException {
    private RestErrorCode errorCode;
    private Object data;

    public RestException(RestErrorCode errorCode, Object data) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.data = data;
    }


    public RestException(RestErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public RestException(RestErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public RestException(RestErrorCode errorCode, String msg, Object data) {
        super(msg);
        this.errorCode = errorCode;
        this.data = data;
    }


}
