package com.fairychar.security.core.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 *
 * @author chiyo
 * @since 1.3.3
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class JsonLoginToken implements Serializable {
    private String token;
    private Authentication authentication;
}
