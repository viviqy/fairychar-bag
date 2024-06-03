package com.fairychar.bag.domain.exceptions;

/**
 * HTTP前端参数校验失败异常类
 *
 * @author chiyo
 */
public class ParamErrorException extends RuntimeException {
    public ParamErrorException() {
        super();
    }

    public ParamErrorException(String message) {
        super(message);
    }
}
