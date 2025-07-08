package com.fairychar.security.core.auth.permission;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ApiAuthority provider
 *
 * @author chiyo <br>
 * @since 1.3.3
 */
public interface ApiAuthorityProvider {
    List<IApiAuthority> getApiAuthorities(HttpServletRequest request);
}
