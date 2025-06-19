package com.fairychar.security.core.auth.permission;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 基础登录用户权限信息类
 *
 * @author chiyo <br>
 */
@AllArgsConstructor
@Data
public class ApiAuthority implements IApiAuthority {
    private String api;
    private String method;

    @Override
    public String getApi() {
        return this.api;
    }

    @Override
    public String getMethod() {
        return this.method;
    }
}