package com.fairychar.bag.domain.security.handler;

import com.fairychar.bag.domain.security.JsonLoginToken;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基于Json返回参数的简单登录成功返回器
 *
 * @author chiyo <br>
 * @since 1.0
 */
@AllArgsConstructor
@Slf4j
public class JsonLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final ObjectMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("user login success: {}", authentication);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(this.mapper.writeValueAsString(HttpResult.ok(new JsonLoginToken(request.getSession().getId(), authentication))));
    }
}
