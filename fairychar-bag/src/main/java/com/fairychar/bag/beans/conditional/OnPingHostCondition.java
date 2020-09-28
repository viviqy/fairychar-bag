package com.fairychar.bag.beans.conditional;

import com.fairychar.bag.domain.conditional.ConditionalOnPingHost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.metadata.InvalidConfigurationMetadataException;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.tools.Diagnostic;
import java.net.InetAddress;
import java.util.Map;

/**
 * @author chiyo
 */
@Slf4j
public class OnPingHostCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnPingHost.class.getName());
        String host = (String) annotationAttributes.get("host");
        boolean result = (Boolean) annotationAttributes.get("result");
        int timeout = (Integer) annotationAttributes.get("timeout");
        log.info(String.format("name= %s , result= %s", host, result));
        try {
            InetAddress address = InetAddress.getByName(host);
            boolean reachable = address.isReachable(timeout);
            return reachable;
        } catch (Exception e) {
            throw new InvalidConfigurationMetadataException(e.getMessage(), Diagnostic.Kind.ERROR);
        }
    }
}
