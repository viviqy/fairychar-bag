package com.fairychar.bag.configurer;

import com.fairychar.bag.aop.LoggingAspectJ;
import com.fairychar.bag.aop.MethodLockAspectJ;
import com.fairychar.bag.converter.mvc.StringToLocalDateConverter;
import com.fairychar.bag.converter.mvc.StringToLocalDateTimeConverter;
import com.fairychar.bag.domain.hystrix.strategy.RequestContextConcurrencyStrategy;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * bag Bean配置启动项
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@EnableConfigurationProperties(value = {FairycharBagProperties.class})
public class BagBeansAutoConfigurer {
    @Autowired
    private FairycharBagProperties bagProperties;


    @ConditionalOnProperty(prefix = "fairychar.bag.aop.log", name = "enable", havingValue = "true")
    @Configuration
    protected static class LogConfiguration {
        @Bean
        @ConditionalOnMissingBean
        LoggingAspectJ loggingAspectJ() {
            return new LoggingAspectJ();
        }
    }

    @ConditionalOnProperty(name = "fairychar.bag.aop.lock.enable", havingValue = "true")
    @Configuration
    protected static class LockConfiguration {
        @Bean
        @ConditionalOnMissingBean
        MethodLockAspectJ methodLockAspectJ() {
            return new MethodLockAspectJ();
        }
    }


    @ConditionalOnProperty(name = "fairychar.bag.convert.mvc.enable", havingValue = "true")
    @Configuration
    protected static class ConvertConfiguration {
        @Bean
        @ConditionalOnMissingBean
        Converter<String, LocalDate> localDateConverter() {
            return new StringToLocalDateConverter();
        }

        @Bean
        @ConditionalOnMissingBean
        Converter<String, LocalDateTime> LocalDateTimeConverter() {
            return new StringToLocalDateTimeConverter();
        }
    }


    @Configuration
    @ConditionalOnProperty(name = "fairychar.bag.hystrix.shareRequestContext", havingValue = "true")
    @Slf4j
    protected static class HystrixRequestContextConfiguration {

        @Autowired(required = false)
        private HystrixConcurrencyStrategy existingConcurrencyStrategy;

        @PostConstruct
        public void init() {
            // Keeps references of existing Hystrix plugins.
            HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance()
                    .getEventNotifier();
            HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance()
                    .getMetricsPublisher();
            HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance()
                    .getPropertiesStrategy();
            HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance()
                    .getCommandExecutionHook();
            HystrixConcurrencyStrategy concurrencyStrategy = this.detectRegisteredConcurrencyStrategy();

            HystrixPlugins.reset();

            // Registers existing plugins excepts the Concurrent Strategy plugin.
            HystrixPlugins.getInstance().registerConcurrencyStrategy(
                    new RequestContextConcurrencyStrategy(concurrencyStrategy));
            HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
            HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
            HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
            HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
        }

        private HystrixConcurrencyStrategy detectRegisteredConcurrencyStrategy() {
            HystrixConcurrencyStrategy registeredStrategy = HystrixPlugins.getInstance()
                    .getConcurrencyStrategy();
            if (this.existingConcurrencyStrategy == null) {
                return registeredStrategy;
            }
            // Hystrix registered a default Strategy.
            if (registeredStrategy instanceof HystrixConcurrencyStrategyDefault) {
                return this.existingConcurrencyStrategy;
            }
            // If registeredStrategy not the default and not some use bean of
            // existingConcurrencyStrategy.
            if (!this.existingConcurrencyStrategy.equals(registeredStrategy)) {
                HystrixRequestContextConfiguration.log.warn(
                        "Multiple HystrixConcurrencyStrategy detected. Bean of HystrixConcurrencyStrategy was used.");
            }
            return this.existingConcurrencyStrategy;
        }

    }
}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/