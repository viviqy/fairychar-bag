package com.fairychar.security.core.auth.handler;

import com.fairychar.security.core.auth.AuthResult;
import com.fairychar.security.core.auth.JsonLoginToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

/**
 * 基于Json返回参数的简单登录成功返回器
 *
 * @author chiyo
 * @since 1.0
 */
@AllArgsConstructor
@Slf4j
public class JsonLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final ObjectMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        log.info("user login success: {}", authentication);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        AuthResult<JsonLoginToken> result = new AuthResult<>(200, new JsonLoginToken(request.getSession().getId(), authentication), "success");
        response.getWriter().write(this.mapper.writeValueAsString(result));
    }
}
