package com.fairychar.security.core.auth;

import java.io.Serializable;

/**
 *
 * @author chiyo
 * @since 1.3.3
 */
public interface IJsonLoginRequest extends Serializable {

    String getUsername();

    String getPassword();
}
