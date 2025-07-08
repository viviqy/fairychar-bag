package com.fairychar.security.core.auth.handler;

import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;
import java.util.List;

/**
 * 基于Json返回参数的简单登录失败处理器
 *
 * @author chiyo
 * @since 1.0
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class PostableLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private final ObjectMapper mapper;
    private List<IFailurePostHandler> postHandlers = List.of();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        log.warn("user login success: {}", exception);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        if (!postHandlers.isEmpty()) {
            for (IFailurePostHandler postHandler : postHandlers) {
                postHandler.post(request, response, exception);
            }
        }
        response.getWriter().write(this.mapper.writeValueAsString(HttpResult.fail(RestErrorCode.AUTHENTICATION_FAILED)));
    }
}
