package com.fairychar.bag.domain.exceptions;

import lombok.Getter;

/**
 * @author chiyo
 * @since 1.0
 */
@Getter
public class AcceptedException extends RuntimeException {
    private int code;
    private Object data;


    public AcceptedException() {
    }

    public AcceptedException(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public AcceptedException(String message, int code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public AcceptedException(String message, Throwable cause, int code, Object data) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public AcceptedException(Throwable cause, int code, Object data) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public AcceptedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace
            , int code, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.data = data;
    }
}
