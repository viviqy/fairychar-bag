package com.fairychar.security.core.auth.handler;

import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

/**
 * 统一权限拦截处理器,用于处理账号的越权操作
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class JsonAccessDeniedHandler implements AccessDeniedHandler {
    private final ObjectMapper objectMapper;
    private int httpStatus = 403;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        log.error("authentication access denied,cause={}", accessDeniedException);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(this.httpStatus);
        response.getWriter().write(this.objectMapper.writeValueAsString(HttpResult.fail(RestErrorCode.ACCESS_DEFINED)));
    }
}