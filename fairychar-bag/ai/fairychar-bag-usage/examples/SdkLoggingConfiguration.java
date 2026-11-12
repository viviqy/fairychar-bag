package com.example.sdkdemo.configuration;

import com.fairychar.bag.beans.aop.LoggingHandler;
import com.fairychar.bag.beans.aop.IgnoreContentLoggingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class SdkLoggingConfiguration {

    @Bean
    public LoggingHandler sdkDemoLoggingHandler() {
        return new IgnoreContentLoggingHandler();
    }
}
