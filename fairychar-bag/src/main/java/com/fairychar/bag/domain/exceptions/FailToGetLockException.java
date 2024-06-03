package com.fairychar.bag.domain.exceptions;

import lombok.Getter;

/**
 * 在乐观锁情况下未获取到锁的异常标志
 *
 * @author chiyo
 * @since 1.0
 */
@Getter
public class FailToGetLockException extends RuntimeException {
    private int code;
    private Object data;


    public FailToGetLockException() {
    }

    public FailToGetLockException(String message) {
        super(message);
    }

    public FailToGetLockException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailToGetLockException(Throwable cause) {
        super(cause);
    }

    public FailToGetLockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FailToGetLockException(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public FailToGetLockException(String message, int code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public FailToGetLockException(String message, Throwable cause, int code, Object data) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public FailToGetLockException(Throwable cause, int code, Object data) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public FailToGetLockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.data = data;
    }
}
