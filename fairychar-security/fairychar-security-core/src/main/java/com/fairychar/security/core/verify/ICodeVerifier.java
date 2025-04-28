package com.fairychar.security.core.verify;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;

/**
 * 验证码验证器
 *
 * @author chiyo <br>
 */
public interface ICodeVerifier {

    /**
     * 生成验证码
     *
     * @param request  请求
     * @param response 响应
     */
    void generateCode(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 校验验证码
     *
     * @param request  请求
     * @param response 响应
     */
    void verifyCode(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException;
}
