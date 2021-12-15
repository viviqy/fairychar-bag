package com.fairychar.bag.domain.security.filter;

import com.fairychar.bag.domain.security.JsonLoginQuery;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

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
@Slf4j
public class JsonAuthenticationFilter<T extends JsonLoginQuery> extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper mapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!"POST".equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            if (request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_UTF8_VALUE) || request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
                try (InputStream is = request.getInputStream()) {
                    T authenticationBean = this.mapper.readValue(is, new TypeReference<T>() {
                    });
                    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(authenticationBean.obtainUsername(), authenticationBean.obtainPassword());
                    this.setDetails(request, authRequest);
                    return this.getAuthenticationManager().authenticate(authRequest);
                } catch (Exception e) {
                    log.error("{}", e.getCause().toString());
                    throw new BadCredentialsException("login parameter cant resolved");
                }
            } else {
                throw new AuthenticationServiceException("Authentication contentType not supported: " + request.getContentType());
            }
        }
    }
}
