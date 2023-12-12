package com.fairychar.bag.configurer;

import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.AES;
import com.fairychar.bag.aop.LoggingAspectJ;
import com.fairychar.bag.aop.MethodLockAspectJ;
import com.fairychar.bag.beans.spring.mvc.EraseValueAdvice;
import com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice;
import com.fairychar.bag.beans.spring.mvc.KeepValueAdvice;
import com.fairychar.bag.beans.swagger.RequestIgnoreParameterPlugin;
import com.fairychar.bag.converter.mvc.StringToLocalDateConverter;
import com.fairychar.bag.converter.mvc.StringToLocalDateTimeConverter;
import com.fairychar.bag.domain.hystrix.callable.base.CallableContext;
import com.fairychar.bag.domain.hystrix.strategy.SharedContextConcurrencyStrategy;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.fairychar.bag.web.DefaultExceptionAdvice;
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
import springfox.documentation.spi.service.OperationBuilderPlugin;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * bag Bean配置启动项
 *
 * @author chiyo <br>
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@EnableConfigurationProperties(FairycharBagProperties.class)
public class BagBeansAutoConfigurer {


    @Configuration
    protected static class SwaggerExtendsConfiguration {
        @Bean
        OperationBuilderPlugin requestIgnoreParameterPlugin() {
            return new RequestIgnoreParameterPlugin();
        }
    }

    @Configuration
    protected static class WebConfiguration {
        @ConditionalOnProperty(prefix = "fairychar.bag.web.advice", name = "enable", havingValue = "true")
        @Bean
        DefaultExceptionAdvice defaultExceptionAdvice() {
            return new DefaultExceptionAdvice();
        }

        @ConditionalOnProperty(prefix = "fairychar.bag.web.property-processor", name = "enable", havingValue = "true")
        protected static class PropertyValueConfiguration {
            @Bean
            KeepValueAdvice keepValueAdvice() {
                return new KeepValueAdvice();
            }

            @Bean
            EraseValueAdvice eraseValueAdvice() {
                return new EraseValueAdvice();
            }

            @Bean
            FuzzyValueAdvice fuzzyValueAdvice() {
                return new FuzzyValueAdvice();
            }
        }

    }


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
    @ConditionalOnProperty(name = "fairychar.bag.hystrix.shared-context", havingValue = "true")
    @Slf4j
    protected static class HystrixSharedContextConfiguration {

        @Autowired(required = false)
        private HystrixConcurrencyStrategy existingConcurrencyStrategy;
        @Autowired
        private List<CallableContext<?>> callableContexts;

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
                    new SharedContextConcurrencyStrategy(concurrencyStrategy, this.callableContexts));
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
                HystrixSharedContextConfiguration.log.warn(
                        "Multiple HystrixConcurrencyStrategy detected. Bean of HystrixConcurrencyStrategy was used.");
            }
            return this.existingConcurrencyStrategy;
        }
    }

    @Configuration
    @EnableConfigurationProperties(FairycharBagProperties.class)
    protected static class SecretConfiguration {
        @Autowired
        private FairycharBagProperties bagProperties;

        @Bean
        @ConditionalOnMissingBean
        @ConditionalOnProperty(name = "fairychar.bag.secret.aes.key")
        AES aes() {
            return new AES(bagProperties.getSecret().getAes().getKey().getBytes(StandardCharsets.UTF_8));
        }


        @Bean
        @ConditionalOnMissingBean
        @ConditionalOnProperty(name = {"fairychar.bag.secret.rsa.pri-key", "fairychar.bag.secret.rsa.pub-key"})
        RSA rsa() {
            return new RSA(bagProperties.getSecret().getRsa().getPriKey(), bagProperties.getSecret().getRsa().getPubKey());
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