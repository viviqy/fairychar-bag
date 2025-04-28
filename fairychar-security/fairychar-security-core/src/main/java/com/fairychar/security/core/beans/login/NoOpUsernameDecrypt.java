package com.fairychar.security.core.beans.login;

/**
 * noOp
 *
 * @author chiyo <br>
 * @since 1.3.3
 */
public class NoOpUsernameDecrypt implements IUsernameDecrypt {
    @Override
    public String decrypt(String username) {
        return username;
    }
}
