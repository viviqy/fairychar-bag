package com.fairychar.security.core.auth.permission;

import org.springframework.security.core.GrantedAuthority;

/**
 * 基础权限
 *
 * @author chiyo <br>
 */
public interface IApiAuthority extends GrantedAuthority {


    /**
     * 获取api路径
     *
     * @return
     */
    String getApi();

    /**
     * 获取请求方式,支持*代表所有
     *
     * @return {@link String }
     */
    String getMethod();
    

    @Override
    default String getAuthority() {
        //不使用此方式拦截
        return "";
    }
}