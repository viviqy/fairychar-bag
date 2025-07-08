package com.fairychar.security.core.auth.permission;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
public class SecurityContextApiAuthorityProvider implements ApiAuthorityProvider {
    @Override
    public List<IApiAuthority> getApiAuthorities(HttpServletRequest request) {
        List<IApiAuthority> apiAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(m -> ((IApiAuthority) m)).collect(Collectors.toList());
        return apiAuthorities;
    }
}
