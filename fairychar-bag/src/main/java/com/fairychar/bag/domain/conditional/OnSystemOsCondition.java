package com.fairychar.bag.domain.conditional;

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
class OnSystemOsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnSystemOS.class.getName());
        ConditionalOnSystemOS.OS os = (ConditionalOnSystemOS.OS) annotationAttributes.get("os");
        boolean condition = (Boolean) annotationAttributes.get("condition");
        log.info("os=[{}],condition=[{}]", os, condition);
        switch (os) {
            case Windows:
                return HostUtils.isWindows() & condition;
            case Linux:
                return HostUtils.isLinux() & condition;
            case MacOSX:
                return HostUtils.isMacOSX() & condition;
            case IOS:
                return HostUtils.isIOS() & condition;
            default:
                return false;
        }
    }
}
