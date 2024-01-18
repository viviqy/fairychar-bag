package com.fairychar.bag.domain.security.enhancer;

import com.fairychar.bag.domain.security.OAuth2JsonToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * accessToken Json加强器
 *
 * @author chiyo
 * @since 1.0
 */
public class StandardReusltEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        return new OAuth2JsonToken(200, accessToken, "success");
    }
}
