package com.fairychar.bag.domain.conditional;

import cn.hutool.system.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * {@link ConditionalOnSystemOS}
 *
 * @author chiyo
 */
@Slf4j
class OnSystemOsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnSystemOS.class.getName());
        if (annotationAttributes == null) {
            return false;
        }
        ConditionalOnSystemOS.OS os = (ConditionalOnSystemOS.OS) annotationAttributes.get("os");
        boolean condition = (Boolean) annotationAttributes.get("condition");
        log.info("os=[{}],condition=[{}]", os, condition);
        switch (os) {
            case Windows:
                return SystemUtil.getOsInfo().isWindows() & condition;
            case Linux:
                return SystemUtil.getOsInfo().isLinux() & condition;
            case MacOSX:
                return SystemUtil.getOsInfo().isMac() & condition;
            default:
                return false;
        }
    }
}
