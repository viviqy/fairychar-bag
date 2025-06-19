package com.fairychar.security.core.pojo.request;

import com.fairychar.security.core.auth.IJsonLoginRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础登录参数体
 *
 * @author chiyo <br>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleJsonLoginRequest implements IJsonLoginRequest {
    private String username;
    private String password;


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
