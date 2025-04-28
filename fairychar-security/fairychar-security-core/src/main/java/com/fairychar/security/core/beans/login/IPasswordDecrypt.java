package com.fairychar.security.core.beans.login;

/**
 * 登录密码解密器
 *
 * @author chiyo <br>
 * @since 1.3.3
 */
public interface IPasswordDecrypt {
    String decrypt(String password);
}
