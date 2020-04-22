package com.fairychar.bag.listener;

import lombok.experimental.Delegate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created with IDEA <br>
 * User: qiyue <br>
 * Date: 2020/04/12 <br>
 * time: 17:29 <br>
 * <p>spring bean工具类,包含ApplicationContext的所有方法</p>
 *
 * @author qiyue <br>
 */
public class SpringContextHolder implements ApplicationListener<ContextRefreshedEvent> {

    @Delegate(types = {EnvironmentCapable.class, ListableBeanFactory.class, HierarchicalBeanFactory.class, MessageSource.class, ApplicationEventPublisher.class, ResourcePatternResolver.class})
    private ApplicationContext context;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        SpringContextHolder instance = getInstance();
        instance.context = ((ApplicationContext) contextRefreshedEvent.getSource());
    }


    private SpringContextHolder() {

    }


    private enum Singleton {
        INSTANCE;

        Singleton() {
            instance = new SpringContextHolder();
        }

        private final SpringContextHolder instance;

        public SpringContextHolder getInstance() {
            return INSTANCE.instance;
        }
    }

    public static SpringContextHolder getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
