package com.fairychar.security.core.auth.strategy;

import com.fairychar.security.core.auth.AuthResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.session.FindByIndexNameSessionRepository;

import java.io.IOException;

/**
 * 过期的token访问策略处理器
 *
 * @author chiyo <br>
 * @since 1.3.3
 */
@Slf4j
@RequiredArgsConstructor
public class JsonSessionExpiredStrategy implements SessionInformationExpiredStrategy {
    private final FindByIndexNameSessionRepository sessionRepository;
    private int httpStatus = 401;
    private final ObjectMapper objectMapper;

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        log.info("token={},principal={} has been expired", event.getSessionInformation().getSessionId(), event.getSessionInformation().getPrincipal());
        this.sessionRepository.deleteById(event.getSessionInformation().getSessionId());
        HttpServletResponse response = event.getResponse();
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(this.httpStatus);
        response.getWriter().write(this.objectMapper.writeValueAsString(new AuthResult<>(401, null, "token expired")));
    }
}
