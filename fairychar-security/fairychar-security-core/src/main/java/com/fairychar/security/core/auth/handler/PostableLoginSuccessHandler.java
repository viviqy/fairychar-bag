package com.fairychar.security.core.auth.handler;

import com.fairychar.security.core.auth.AuthResult;
import com.fairychar.security.core.auth.JsonLoginToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.util.List;

/**
 * 基于Json返回参数的简单登录成功返回器
 *
 * @author chiyo
 * @since 1.0
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class PostableLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final ObjectMapper mapper;
    private List<ISuccessPostHandler> postHandlers = List.of();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        log.info("user login success: {}", authentication);
        if (!postHandlers.isEmpty()) {
            for (ISuccessPostHandler postHandler : postHandlers) {
                postHandler.post(request, response, authentication);
            }
        }
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        AuthResult<JsonLoginToken> result = new AuthResult<>(200, new JsonLoginToken(request.getSession().getId(), null), "success");
        response.getWriter().write(this.mapper.writeValueAsString(result));
    }
}
