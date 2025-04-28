package com.fairychar.security.core.auth.entrypoint;

import com.fairychar.security.core.auth.AuthResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.util.Map;

/**
 * 认证流程异常出口点
 *
 * @author chiyo <br>
 * @since 1.3.3
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class MappedExceptionAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;
    private int httpStatus = 401;
    private final Map<AuthenticationException, AuthResult> authenticationExceptionMap;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        log.error("authentication failed at entryPoint,cause={}", authException.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(this.httpStatus);
        AuthResult object = authenticationExceptionMap.get(authException);
        if (object == null) {
            response.getWriter().write(this.objectMapper.writeValueAsString(new AuthResult(401, null, "认证失败")));
        } else {
            response.getWriter().write(this.objectMapper.writeValueAsString(object));
        }
    }
}
