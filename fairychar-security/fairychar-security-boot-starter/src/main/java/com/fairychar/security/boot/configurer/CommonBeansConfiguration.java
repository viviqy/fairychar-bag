package com.fairychar.security.boot.configurer;

import com.fairychar.security.core.auth.entrypoint.MappedExceptionAuthenticationEntryPoint;
import com.fairychar.security.core.auth.handler.*;
import com.fairychar.security.core.properties.FairycharSecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.List;
import java.util.Map;

/**
 * 安全认证基础Bean配置
 *
 * @author chiyo <br>
 */
@Configuration
@EnableConfigurationProperties(FairycharSecurityProperties.class)
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class CommonBeansConfiguration {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired(required = false)
    private List<ISuccessPostHandler> successPostHandler;
    @Autowired(required = false)
    private List<IFailurePostHandler> failurePostHandlers;
    @Autowired(required = false)
    private List<ILogoutPostHandler> logoutPostHandlers;

    @Bean
    @ConditionalOnMissingBean(value = {AuthenticationSuccessHandler.class})
    AuthenticationSuccessHandler postableLoginSuccessHandler() {
        if (successPostHandler != null) {
            return new PostableLoginSuccessHandler(this.objectMapper, this.successPostHandler);
        } else {
            return new PostableLoginSuccessHandler(this.objectMapper);
        }
    }

    @Bean
    @ConditionalOnMissingBean(value = {AuthenticationFailureHandler.class})
    AuthenticationFailureHandler postableLoginFailedHandler() {
        if (failurePostHandlers != null) {
            return new PostableLoginFailureHandler(this.objectMapper, this.failurePostHandlers);
        } else {
            return new PostableLoginFailureHandler(this.objectMapper);
        }
    }

    @Bean
    @ConditionalOnMissingBean
    AccessDeniedHandler postableAccessDeniedHandler() {
        return new JsonAccessDeniedHandler(this.objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean
    AuthenticationEntryPoint mappedExceptionAuthenticationEntryPoint() {
        return new MappedExceptionAuthenticationEntryPoint(this.objectMapper, Map.of());
    }

    @Bean
    @ConditionalOnMissingBean
    LogoutSuccessHandler postableLogoutSuccessHandler() {
        if (logoutPostHandlers != null) {
            return new PostableLogoutSuccessHandler(this.objectMapper, this.logoutPostHandlers);
        } else {
            return new PostableLogoutSuccessHandler(this.objectMapper);
        }
    }

}