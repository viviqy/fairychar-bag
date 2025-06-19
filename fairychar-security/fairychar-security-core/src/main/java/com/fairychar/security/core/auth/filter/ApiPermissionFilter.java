package com.fairychar.security.core.auth.filter;

import com.fairychar.security.core.auth.permission.IApiAuthority;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>接口权限拦截器</pre>
 *
 * @author chiyo <br>
 * @since 1.3.3
 */
@Slf4j
@RequiredArgsConstructor
public class ApiPermissionFilter extends OncePerRequestFilter {

    /**
     * 需要忽略的路径,采用antMatch方式
     */
    private final Set<String> ignorePaths;
    private final AccessDeniedHandler accessDeniedHandler;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        for (String ignorePath : this.ignorePaths) {
            if (this.antPathMatcher.match(ignorePath, request.getRequestURI())) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        List<IApiAuthority> apiAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(m -> ((IApiAuthority) m)).collect(Collectors.toList());
        for (IApiAuthority apiAuthority : apiAuthorities) {
            if (this.antPathMatcher.match(apiAuthority.getApi(), request.getRequestURI())
                    && (request.getMethod().equalsIgnoreCase(apiAuthority.getMethod())
                    || apiAuthority.getMethod().equalsIgnoreCase("*"))
            ) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        this.accessDeniedHandler.handle(request, response
                , new AccessDeniedException("no accessible to access this url=" + request.getRequestURI()));
    }
}
