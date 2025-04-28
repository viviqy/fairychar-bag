package com.fairychar.security.core.verify;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author chiyo <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class SimpleImageCode {
    private String sessionId;
    private String value;
    private LocalDateTime expireTime;
}
