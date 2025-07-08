package com.fairychar.security.core.auth.handler;

import com.fairychar.bag.pojo.vo.HttpResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.util.List;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class PostableLogoutSuccessHandler implements LogoutSuccessHandler {
    private final ObjectMapper objectMapper;
    private List<ILogoutPostHandler> postHandlers = List.of();

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("user logout success: {}", authentication);
        if (!postHandlers.isEmpty()) {
            for (ILogoutPostHandler postHandler : postHandlers) {
                postHandler.post(request, response, authentication);
            }
        }
        response.setStatus(200);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(this.objectMapper.writeValueAsString(HttpResult.ok()));
    }
}
