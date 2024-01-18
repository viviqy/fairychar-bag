package com.fairychar.bag.listener;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * <p>spring bean工具类,包含ApplicationContext的所有方法</p>
 *
 * @author qiyue
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpringContextHolder implements ApplicationListener<ContextRefreshedEvent> {

    @Delegate(types = {EnvironmentCapable.class, ListableBeanFactory.class, HierarchicalBeanFactory.class, MessageSource.class, ApplicationEventPublisher.class, ResourcePatternResolver.class})
    private ApplicationContext context;

    public static SpringContextHolder getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        SpringContextHolder instance = getInstance();
        instance.context = ((ApplicationContext) contextRefreshedEvent.getSource());
    }

    private enum Singleton {
        INSTANCE;

        private final SpringContextHolder instance;

        Singleton() {
            this.instance = new SpringContextHolder();
        }

        public SpringContextHolder getInstance() {
            return INSTANCE.instance;
        }
    }
}
