package com.fairychar.bag.domain.exceptions;

/**
 * Datetime: 2021/12/23 00:11
 *
 * @author chiyo
 * @since 1.0
 */
public class AcceptedException extends RuntimeException {
    public AcceptedException() {
    }

    public AcceptedException(String message) {
        super(message);
    }

    public AcceptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AcceptedException(Throwable cause) {
        super(cause);
    }

    public AcceptedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
