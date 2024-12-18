package com.fairychar.bag.domain.exceptions;

import lombok.Getter;

/**
 * 业务异常类
 *
 * @author chiyo
 * @since 0.0.1
 */
@Getter
public class FBException extends RuntimeException {
    private int code;
    private Object data;

    public FBException() {
    }

    public FBException(String message) {
        super(message);
    }

    public FBException(int code, String message) {
        super(message);
    }

    public FBException(String message, Throwable cause) {
        super(message, cause);
    }

    public FBException(Throwable cause) {
        super(cause);
    }

    public FBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FBException(String message, int code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public FBException(String message, Throwable cause, int code, Object data) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public FBException(Throwable cause, int code, Object data) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public FBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.data = data;
    }
}
