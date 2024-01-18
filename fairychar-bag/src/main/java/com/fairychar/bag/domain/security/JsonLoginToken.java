package com.fairychar.bag.domain.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;

/**
 * Datetime: 2021/10/25 16:31
 *
 * @author chiyo
 * @since 1.0
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class JsonLoginToken {
    private String token;
    private Authentication authentication;
}
