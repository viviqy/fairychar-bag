package com.fairychar.bag.domain.exceptions;

import lombok.Getter;

/**
 * <p>数据已存在异常</p>
 *
 * @author qiyue
 */
@Getter
public class DataAlreadyExistException extends RuntimeException {
    private int code;
    private Object data;

    public DataAlreadyExistException() {
    }

    public DataAlreadyExistException(String message) {
        super(message);
    }

    public DataAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public DataAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataAlreadyExistException(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public DataAlreadyExistException(String message, int code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public DataAlreadyExistException(String message, Throwable cause, int code, Object data) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public DataAlreadyExistException(Throwable cause, int code, Object data) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public DataAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace
            , int code, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.data = data;
    }
}