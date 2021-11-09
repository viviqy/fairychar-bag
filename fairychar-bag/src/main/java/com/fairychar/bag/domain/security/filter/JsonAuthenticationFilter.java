package com.fairychar.bag.domain.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * <p>Json登录过滤器</p>
 * <p>使用方式</p>
 * <code>
 * <@Bean
 * JsonAuthenticationFilter jsonAuthenticationFilter() throws Exception {
 * JsonAuthenticationFilter filter = new JsonAuthenticationFilter();
 * filter.setAuthenticationManager(authenticationManagerBean());
 * //filter.setAuthenticationSuccessHandler(loginSuccessHandler);
 * return filter;
 * }
 * <p>
 * <@Override
 * public AuthenticationManager authenticationManagerBean() throws Exception {
 * return super.authenticationManagerBean();
 * }
 * </code>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@AllArgsConstructor
@Data
@Slf4j
public class JsonAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper mapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!"POST".equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
                UsernamePasswordAuthenticationToken authRequest = null;
                try (InputStream is = request.getInputStream()) {
                    Map<String, String> authenticationBean = this.mapper.readValue(is, Map.class);
                    authRequest = new UsernamePasswordAuthenticationToken(authenticationBean.get("username"), authenticationBean.get("password"));
                } catch (IOException e) {
                    if (log.isErrorEnabled()) {
                        log.error("{}", e.getCause().toString());
                    }
                    authRequest = new UsernamePasswordAuthenticationToken("", "");
                } finally {
                    this.setDetails(request, authRequest);
                    return this.getAuthenticationManager().authenticate(authRequest);
                }
            } else {
                return super.attemptAuthentication(request, response);
            }
        }
    }
}
