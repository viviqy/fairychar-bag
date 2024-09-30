package com.fairychar.bag.domain.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.metadata.InvalidConfigurationMetadataException;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.tools.Diagnostic;
import java.net.InetAddress;
import java.util.Map;

/**
 * {@link ConditionalOnPingHost}
 *
 * @author chiyo
 */
@Slf4j
class OnPingHostCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnPingHost.class.getName());
        if (annotationAttributes == null) {
            return false;
        }
        String host = (String) annotationAttributes.get("host");
        boolean result = (Boolean) annotationAttributes.get("result");
        int timeout = (Integer) annotationAttributes.get("timeout");
        log.info("host=[{}],result=[{}],timeout=[{}]", host, result, timeout);
        try {
            InetAddress address = InetAddress.getByName(host);
            boolean reachable = address.isReachable(timeout);
            return reachable == result;
        } catch (Exception e) {
            throw new InvalidConfigurationMetadataException(e.getMessage(), Diagnostic.Kind.ERROR);
        }
    }
}
