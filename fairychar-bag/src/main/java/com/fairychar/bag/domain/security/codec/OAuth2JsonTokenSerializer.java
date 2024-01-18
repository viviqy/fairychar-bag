package com.fairychar.bag.domain.security.codec;

import com.fairychar.bag.domain.security.OAuth2JsonToken;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * OAuth2 Json序列化器
 *
 * @author chiyo
 * @since
 */
public class OAuth2JsonTokenSerializer extends StdSerializer<OAuth2JsonToken> {

    private static final long serialVersionUID = -885403412406468300L;

    public OAuth2JsonTokenSerializer() {
        super(OAuth2JsonToken.class);
    }

    @Override
    public void serialize(OAuth2JsonToken oAuth2AccessToken, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) oAuth2AccessToken;
        jgen.writeStartObject();
        jgen.writeObjectField("code", oAuth2AccessToken.getCode());

        jgen.writeObjectFieldStart("data");
        jgen.writeStringField(OAuth2AccessToken.ACCESS_TOKEN, token.getValue());
        jgen.writeStringField(OAuth2AccessToken.TOKEN_TYPE, token.getTokenType());
        OAuth2RefreshToken refreshToken = token.getRefreshToken();
        if (refreshToken != null) {
            jgen.writeStringField(OAuth2AccessToken.REFRESH_TOKEN, refreshToken.getValue());
        }
        Date expiration = token.getExpiration();
        if (expiration != null) {
            long now = System.currentTimeMillis();
            jgen.writeNumberField(OAuth2AccessToken.EXPIRES_IN, (expiration.getTime() - now) / 1000);
        }
        Set<String> scope = token.getScope();
        if (scope != null && !scope.isEmpty()) {
            StringBuffer scopes = new StringBuffer();
            for (String s : scope) {
                Assert.hasLength(s, "Scopes cannot be null or empty. Got " + scope + "");
                scopes.append(s);
                scopes.append(" ");
            }
            jgen.writeStringField(OAuth2AccessToken.SCOPE, scopes.substring(0, scopes.length() - 1));
        }
        Map<String, Object> additionalInformation = token.getAdditionalInformation();
        for (String key : additionalInformation.keySet()) {
            jgen.writeObjectField(key, additionalInformation.get(key));
        }
        jgen.writeEndObject();

        jgen.writeObjectField("msg", oAuth2AccessToken.getMsg());
        jgen.writeEndObject();
    }
}
