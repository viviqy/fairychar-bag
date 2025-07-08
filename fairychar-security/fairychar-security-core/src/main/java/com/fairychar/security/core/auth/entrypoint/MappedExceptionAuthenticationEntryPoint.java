package com.fairychar.security.core.auth.entrypoint;

import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.pojo.vo.HttpResult;
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
    private final Map<AuthenticationException, HttpResult> authenticationExceptionMap;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        log.error("authentication failed at entryPoint,cause={}", authException.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(this.httpStatus);
        HttpResult object = authenticationExceptionMap.get(authException);
        if (object == null) {
            response.getWriter().write(this.objectMapper.writeValueAsString(HttpResult.fail(RestErrorCode.AUTHENTICATION_FAILED)));
        } else {
            response.getWriter().write(this.objectMapper.writeValueAsString(object));
        }
    }
}
