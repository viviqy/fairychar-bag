package com.fairychar.security.core.properties;

import lombok.Data;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
@Data
public class UrlProperties {
    private String login = "/login";
    private String logout = "/logout";
    private String[] allowed;
    private String[] authenticated;
    private boolean disableLoginCors = true;
    private boolean disableLoginCsrf = true;
}
