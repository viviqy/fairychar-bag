package com.fairychar.security.core.beans.login;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import lombok.AllArgsConstructor;

/**
 * @author chiyo <br>
 * @since 1.3.3
 */
@AllArgsConstructor
public class RsaPasswordDecrypt implements IPasswordDecrypt {
    private final RSA rsa;

    @Override
    public String decrypt(String password) {
        String decryptStr = this.rsa.decryptStr(password, KeyType.PrivateKey);
        return decryptStr;
    }
}
