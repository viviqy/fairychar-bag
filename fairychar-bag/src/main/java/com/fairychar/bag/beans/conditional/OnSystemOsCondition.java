package com.fairychar.bag.beans.conditional;

import com.fairychar.bag.domain.conditional.ConditionalOnSystemOS;
import com.sun.media.jfxmediaimpl.HostUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author chiyo
 */
@Slf4j
public class OnSystemOsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnSystemOS.class.getName());
        ConditionalOnSystemOS.OS os = (ConditionalOnSystemOS.OS) annotationAttributes.get("os");
        boolean condition = (Boolean) annotationAttributes.get("condition");
        switch (os){

            case Windows:
                break;
            case Linux:
                break;
            case MacOSX:
                break;
            case IOS:
                break;
        }
    }
}
