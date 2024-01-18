package com.fairychar.bag.domain.security;

import java.io.Serializable;

/**
 * Datetime: 2021/12/2 22:45
 *
 * @author chiyo
 * @since 1.0
 */
public interface JsonLoginQuery extends Serializable {

    String obtainUsername();

    String obtainPassword();
}
