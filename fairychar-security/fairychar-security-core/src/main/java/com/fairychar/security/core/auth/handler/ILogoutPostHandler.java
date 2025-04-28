package com.fairychar.security.core.auth.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
public interface ILogoutPostHandler {
    void post(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
}
