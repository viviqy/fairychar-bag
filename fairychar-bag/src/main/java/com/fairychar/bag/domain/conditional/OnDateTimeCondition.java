package com.fairychar.bag.domain.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author chiyo
 */
@Slf4j
class OnDateTimeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnDateTime.class.getName());
        String lowerStr = (String) annotationAttributes.get("lower");
        String upperStr = (String) annotationAttributes.get("upper");
        String pattern = (String) annotationAttributes.get("pattern");
        LocalDateTime lower = LocalDateTime.parse(lowerStr, DateTimeFormatter.ofPattern(pattern));
        LocalDateTime upper = LocalDateTime.parse(upperStr, DateTimeFormatter.ofPattern(pattern));
        LocalDateTime checkPoint = LocalDateTime.now();
        if (checkPoint.isAfter(lower) && checkPoint.isBefore(upper)) {
            return true;
        }
        return false;
    }
}
