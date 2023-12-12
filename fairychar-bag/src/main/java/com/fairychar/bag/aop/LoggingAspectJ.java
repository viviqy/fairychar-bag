package com.fairychar.bag.aop;

import cn.hutool.core.lang.Assert;
import com.fairychar.bag.beans.aop.LoggingHandler;
import com.fairychar.bag.domain.annotations.RequestLog;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.properties.FairycharBagProperties;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;

import java.util.Optional;

/**
 * 该类是一个切面，用于在控制器方法执行前后记录日志。
 * 它通过使用@RequestLog注解来确定是否启用日志记录。
 * 如果启用了日志记录，则根据配置的处理程序名称执行相应的处理方法。
 * 如果未配置处理程序名称，则使用全局配置的处理程序名称执行处理方法。
 * 处理程序需要实现LoggingHandler接口。
 */
@Aspect
@Slf4j
@EnableConfigurationProperties(value = {FairycharBagProperties.class})
@Order(0)
public class LoggingAspectJ implements InitializingBean {

    @Autowired
    private FairycharBagProperties properties;

    /**
     * 在控制器方法执行前记录日志。
     * 根据@RequestLog注解的配置决定是否启用日志记录。
     * 如果启用了日志记录，则根据配置的处理程序名称执行相应的处理方法。
     * 如果未配置处理程序名称，则使用全局配置的处理程序名称执行处理方法。
     */
    @Before("execution(public * *..controller..*.*(..))  && @annotation(requestLog)")
    public void beforeLogging(JoinPoint joinPoint, RequestLog requestLog) {
        if (!requestLog.enable()) {
            return;
        }
        Optional<String> handler = Optional.ofNullable(requestLog.beforeHandler()).filter(s -> !s.isEmpty());
        if (handler.isPresent()) {
            handle(handler.get(), joinPoint);
        } else {
            Optional.ofNullable(properties.getAop().getLog().getGlobalBefore()).filter(s -> !Strings.isNullOrEmpty(s))
                    .ifPresent(h -> handle(h, joinPoint));
        }
    }

    /**
     * 在控制器方法执行后记录日志。
     * 根据@RequestLog注解的配置决定是否启用日志记录。
     * 如果启用了日志记录，则根据配置的处理程序名称执行相应的处理方法。
     * 如果未配置处理程序名称，则使用全局配置的处理程序名称执行处理方法。
     */
    @After("execution(public * *..controller..*.*(..))  && @annotation(requestLog)")
    public void afterLogging(JoinPoint joinPoint, RequestLog requestLog) {
        if (!requestLog.enable()) {
            return;
        }
        Optional<String> handler = Optional.ofNullable(requestLog.afterHandler()).filter(s -> !s.isEmpty());
        if (handler.isPresent()) {
            handle(handler.get(), joinPoint);
        } else {
            Optional.ofNullable(properties.getAop().getLog().getGlobalAfter()).filter(s -> !Strings.isNullOrEmpty(s))
                    .ifPresent(h -> handle(h, joinPoint));
        }
    }

    /**
     * 在属性设置完毕后进行一些初始化操作。
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(properties.getAop().getLog().getGlobalLevel(), "global log level cant be null");
    }

    /**
     * 根据处理程序名称执行相应的处理方法。
     */
    private void handle(String handlerName, JoinPoint joinPoint) {
        try {
            LoggingHandler bean = SpringContextHolder.getInstance().getBean(handlerName, LoggingHandler.class);
            bean.accept(joinPoint);
        } catch (NoSuchBeanDefinitionException e) {
            log.error("cant find loggingHandler bean by name {}", handlerName);
        }
    }
}
