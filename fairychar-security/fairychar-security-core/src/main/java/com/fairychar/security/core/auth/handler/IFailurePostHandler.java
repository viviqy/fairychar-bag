package com.fairychar.security.core.auth.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
public interface IFailurePostHandler {
    void post(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception);
}
