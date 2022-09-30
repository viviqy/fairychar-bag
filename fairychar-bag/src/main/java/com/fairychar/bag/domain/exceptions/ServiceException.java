package com.fairychar.bag.domain.exceptions;

import lombok.Getter;

/**
 * 业务异常类
 * Datetime: 2022/10/1 00:34 <br>
 *
 * @author chiyo <br>
 * @since 0.0.1
 */
@Getter
public class ServiceException extends RuntimeException {
    private int code;
    private Object data;

    public ServiceException(String message) {
        super(message);
        this.code = 0;
    }

    public ServiceException(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ServiceException(String message, int code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public ServiceException(String message, Throwable cause, int code, Object data) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public ServiceException(Throwable cause, int code, Object data) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.data = data;
    }
}