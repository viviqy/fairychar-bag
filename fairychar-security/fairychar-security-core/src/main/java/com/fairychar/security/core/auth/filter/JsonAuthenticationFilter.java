package com.fairychar.security.core.auth.filter;

import com.fairychar.security.core.auth.IJsonLoginRequest;
import com.fairychar.security.core.beans.login.IPasswordDecrypt;
import com.fairychar.security.core.beans.login.IUsernameDecrypt;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.InputStream;

/**
 * <p>Json登录过滤器</p>
 * <p>使用方式</p>
 * <pre>
 *     {@code
 *   @Bean
 *   JsonAuthenticationFilter jsonAuthenticationFilter() throws Exception {
 *      JsonAuthenticationFilter filter = new JsonAuthenticationFilter();
 *      filter.setAuthenticationManager(authenticationManagerBean());
 *      //filter.setAuthenticationSuccessHandler(loginSuccessHandler);
 *      return filter;
 *   }
 *
 *   @Override
 *   public AuthenticationManager authenticationManagerBean() throws Exception {
 *      return super.authenticationManagerBean();
 *   }}
 * </pre>
 * <code>
 * <
 * </code>
 *
 * @author chiyo
 * @since 1.0
 */
@AllArgsConstructor
@Slf4j
public class JsonAuthenticationFilter<T extends IJsonLoginRequest> extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper mapper;
    private final IUsernameDecrypt usernameDecryptor;
    private final IPasswordDecrypt passwordDecryptor;
    private final Class<T> requestClazz;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!"POST".equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            if (request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    || request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
                try (InputStream is = request.getInputStream()) {
                    T authenticationBean = this.mapper.readValue(is, requestClazz);
                    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                            this.getDecryptUsername(authenticationBean.getUsername())
                            , this.getDecryptPassword(authenticationBean.getPassword()));
                    this.setDetails(request, authRequest);
                    return this.getAuthenticationManager().authenticate(authRequest);
                } catch (AuthenticationException e) {
                    throw e;
                } catch (Exception e) {
                    log.error("{}", e);
                    throw new BadCredentialsException("login parameter cant resolved");
                }
            } else {
                throw new AuthenticationServiceException("Authentication contentType not supported: " + request.getContentType());
            }
        }
    }

    private String getDecryptPassword(String password) {
        if (this.passwordDecryptor != null) {
            return this.passwordDecryptor.decrypt(password);
        }
        return password;
    }

    private String getDecryptUsername(String username) {
        if (this.usernameDecryptor != null) {
            return this.usernameDecryptor.decrypt(username);
        }
        return username;
    }
}
