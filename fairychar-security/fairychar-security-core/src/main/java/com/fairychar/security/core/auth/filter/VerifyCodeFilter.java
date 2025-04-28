package com.fairychar.security.core.auth.filter;

import com.fairychar.security.core.verify.ICodeVerifier;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * 验证码校验过滤器<br>
 * 需要实现{@link ICodeVerifier}的bean
 *
 * @author chiyo
 */
@RequiredArgsConstructor
public class VerifyCodeFilter extends OncePerRequestFilter {
    private final List<String> validateUrls;
    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final ICodeVerifier codeVerifier;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean matched = false;
        for (String url : this.validateUrls) {
            if (this.antPathMatcher.match(url, request.getRequestURI())) {
                matched = true;
                break;
            }
        }
        if (matched) {
            try {
                this.codeVerifier.verifyCode(request, response);
                filterChain.doFilter(request, response);
            } catch (AuthenticationException e) {
                this.authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
