package com.fairychar.bag.domain.exceptions;

import java.sql.SQLException;

/**
 * <p>数据已存在异常</p>
 *
 * @author qiyue
 */
public class DataAlreadyExistException extends SQLException {
    public DataAlreadyExistException() {
        super("数据已存在");
    }

    public DataAlreadyExistException(String reason) {
        super(reason);
    }

    public DataAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
