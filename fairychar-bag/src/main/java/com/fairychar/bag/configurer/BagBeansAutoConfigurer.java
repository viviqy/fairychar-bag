package com.fairychar.bag.configurer;

import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.AES;
import com.fairychar.bag.aop.LoggingAspectJ;
import com.fairychar.bag.aop.MethodLockAspectJ;
import com.fairychar.bag.beans.spring.converter.StringToLocalDateConverter;
import com.fairychar.bag.beans.spring.converter.StringToLocalDateTimeConverter;
import com.fairychar.bag.beans.spring.mvc.EraseValueAdvice;
import com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice;
import com.fairychar.bag.beans.spring.mvc.KeepValueAdvice;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.fairychar.bag.web.DefaultExceptionAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * bag Bean配置启动项
 *
 * @author chiyo
 * @since 0.0.1-SNAPSHOT
 */
@Configuration
@EnableConfigurationProperties(FairycharBagProperties.class)
public class BagBeansAutoConfigurer {


//    @Configuration
//    protected static class SwaggerExtendsConfiguration {
//        @Bean
//        OperationBuilderPlugin requestIgnoreParameterPlugin() {
//            return new RequestIgnoreParameterPlugin();
//        }
//    }

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
        Converter<String, LocalDateTime> localDateTimeConverter() {
            return new StringToLocalDateTimeConverter();
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