package com.fairychar.bag.listener;

import lombok.experimental.Delegate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created with IDEA <br>
 * User: qiyue <br>
 * Date: 2020/04/12 <br>
 * time: 17:29 <br>
 *
 * @author qiyue <br>
 */
public class SpringContextHolder implements ApplicationListener<ContextRefreshedEvent> {

    @Delegate
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
