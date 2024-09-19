package com.fairychar.bag.domain.exceptions;

import lombok.Getter;

/**
 * HTTP前端参数校验失败异常类
 *
 * @author chiyo
 */
@Getter
public class ParamErrorException extends RuntimeException {
    private int code;
    private Object data;

    public ParamErrorException() {
    }

    public ParamErrorException(String message) {
        super(message);
    }

    public ParamErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamErrorException(Throwable cause) {
        super(cause);
    }

    public ParamErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ParamErrorException(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ParamErrorException(String message, int code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public ParamErrorException(String message, Throwable cause, int code, Object data) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public ParamErrorException(Throwable cause, int code, Object data) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public ParamErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace
            , int code, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.data = data;
    }
}
