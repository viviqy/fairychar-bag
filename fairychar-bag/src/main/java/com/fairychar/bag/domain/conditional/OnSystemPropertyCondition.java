package com.fairychar.bag.domain.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author chiyo
 */
@Slf4j
class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = (String) annotationAttributes.get("name");
        String value = (String) annotationAttributes.get("value");
        log.info(String.format("name=[%s],value=[%s]", name, value));
        return System.getProperty(name).equals(value);
    }
}
