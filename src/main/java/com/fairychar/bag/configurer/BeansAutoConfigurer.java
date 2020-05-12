package com.fairychar.bag.configurer;

import com.fairychar.bag.aop.BindingCheckAspectJ;
import com.fairychar.bag.aop.LoggingAspectJ;
import com.fairychar.bag.converter.mvc.StringToLocalDateConverter;
import com.fairychar.bag.converter.mvc.StringToLocalDateTimeConverter;
import com.fairychar.bag.properties.FairycharBagProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created with IDEA <br>
 * Date: 2020/5/12 <br>
 * time: 12:22 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(value = {FairycharBagProperties.class})
public class BeansAutoConfigurer {
    @Autowired
    private FairycharBagProperties bagProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "fairychar.bag.aop.binding", name = "enable", havingValue = "true")
    BindingCheckAspectJ bindingCheckAspectJ() {
        return new BindingCheckAspectJ();
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