package com.fairychar.bag.domain.exceptions;

/**
 * 接口响应错误码
 *
 * @author chiyo <br>
 * @since 1.3.2
 */
public interface IRestErrorCode {

    int getCode();

    String getMessage();
}
