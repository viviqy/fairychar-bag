package com.fairychar.bag.domain.security;

import com.fairychar.bag.domain.security.codec.OAuth2JsonTokenSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.io.Serializable;

/**
 * @author chiyo
 * @since 1.0
 */
@Data
@ToString(callSuper = true)
@JsonInclude
@JsonSerialize(using = OAuth2JsonTokenSerializer.class)
public class OAuth2JsonToken extends DefaultOAuth2AccessToken implements Serializable {
    private static final long serialVersionUID = -5415580786548179550L;
    @JsonInclude
    private int code;
    @JsonInclude
    private String msg;

    public OAuth2JsonToken() {
        super((String) null);
    }

    public OAuth2JsonToken(String value) {
        super(value);
    }

    public OAuth2JsonToken(int code, OAuth2AccessToken accessToken, String msg) {
        super(accessToken);
        this.code = code;
        this.msg = msg;
    }

}
