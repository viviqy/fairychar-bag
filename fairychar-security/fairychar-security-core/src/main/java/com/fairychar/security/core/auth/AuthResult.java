package com.fairychar.security.core.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class AuthResult<T> implements Serializable {

    private int code;
    private T data;
    private String msg;
}
