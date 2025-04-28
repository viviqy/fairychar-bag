package com.fairychar.security.core.auth;

import java.io.Serializable;

/**
 * Datetime: 2021/12/2 22:45
 *
 * @author chiyo
 * @since 1.0
 */
public interface JsonLoginRequest extends Serializable {

    String obtainUsername();

    String obtainPassword();
}
