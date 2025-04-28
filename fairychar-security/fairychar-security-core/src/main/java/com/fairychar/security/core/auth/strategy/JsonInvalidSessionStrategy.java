package com.fairychar.security.core.auth.strategy;

import com.fairychar.security.core.auth.AuthResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.web.session.InvalidSessionStrategy;

import java.io.IOException;

/**
 * 非法token访问策略处理器
 *
 * @author chiyo <br>
 * @since 1.0
 */
@AllArgsConstructor
@RequiredArgsConstructor
public class JsonInvalidSessionStrategy implements InvalidSessionStrategy {
    private final ObjectMapper objectMapper;
    private int httpStatus = 401;

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(this.httpStatus);
        response.getWriter().write(this.objectMapper.writeValueAsString(new AuthResult<>(401, null, "token invalid")));
    }
}
