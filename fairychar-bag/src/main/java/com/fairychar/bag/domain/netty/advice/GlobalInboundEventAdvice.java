package com.fairychar.bag.domain.netty.advice;

import com.fairychar.bag.domain.annotations.EventHandler;
import com.fairychar.bag.domain.annotations.NettyEventAdvice;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.template.CacheOperateTemplate;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Datetime: 2021/7/1 21:55
 *
 * @author chiyo
 * @since 1.0
 */
@Slf4j
public class GlobalInboundEventAdvice extends ChannelInboundHandlerAdapter implements BeanFactoryPostProcessor {


    /**
     * key=mark(ex+handler+method)
     */
    private HashMap<Class, Method> cache1;
    /**
     * key=method fullName;
     */
    private HashMap<String, InvokeEntity> invokeArgsCache = new HashMap<>(32);
    private Map<String, Object> beanMap;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        this.dispatch(ctx, evt);
    }

    private void dispatch(ChannelHandlerContext ctx, Object evt)
            throws InvocationTargetException, IllegalAccessException {
        Method method = this.obtainMethod(evt);
        this.invoke(ctx, evt, method);
    }


    /**
     * 执行异常处理
     *
     * @param ctx
     * @param evt
     * @param method
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private void invoke(ChannelHandlerContext ctx, Object evt, Method method) throws InvocationTargetException, IllegalAccessException {
        if (method != null) {
            InvokeEntity invokeEntity = this.getInvokeEntity(ctx, evt, method);
            method.invoke(invokeEntity.getBean(), invokeEntity.getArgs());
        } else {
            ctx.fireUserEventTriggered(evt);
        }
    }

    /**
     * 获取当前method的缓存InvokeEntity信息
     *
     * @param ctx
     * @param evt
     * @param method
     * @return
     */
    private InvokeEntity getInvokeEntity(ChannelHandlerContext ctx, Object evt, Method method) {
        InvokeEntity invokeEntity = CacheOperateTemplate.get(() -> this.invokeArgsCache.get(method.toGenericString()), () -> {
            Object bean = SpringContextHolder.getInstance().getBean(method.getDeclaringClass());
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] args = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                if (parameterTypes[i].isAssignableFrom(ctx.getClass())) {
                    args[i] = ctx;
                } else if (evt.getClass().isAssignableFrom(parameterTypes[i])) {
                    args[i] = evt;
                }
            }
            return new InvokeEntity(bean, args);
        }, e -> this.invokeArgsCache.put(method.toGenericString(), e), method);
        return invokeEntity;
    }


    private Method obtainMethod(Object c) {
        return this.cache1.get(c) != null ? this.cache1.get(c) :
                (this.cache1.get(Object.class) != null ? this.cache1.get(Object.class) : null);
    }


    /**
     * <p>验证映射到的Method合法性</p>
     * <p>
     * 1.校验异常处理方法是否重复
     * 2.校验是否存在配置了methodName但是却未指定Handler
     *
     * @param methods
     * @throws IllegalAccessException
     */
    private void validate(List<Method> methods) throws IllegalAccessException {
        ArrayList<EventInfo> eventClassList = new ArrayList<>(methods.size());
        for (Method m : methods) {
            EventHandler eventHandler = m.getAnnotation(EventHandler.class);
            eventClassList.add(new EventInfo(eventHandler.value(), m));
        }
        this.ensureNotExistSameMethod(eventClassList);
        this.createCache(eventClassList);
    }

    /**
     * 创建异常处理器映射方法缓存
     *
     * @param eventInfoList
     */
    private void createCache(ArrayList<EventInfo> eventInfoList) {
        this.cache1 = new HashMap<>(eventInfoList.size());
        eventInfoList.stream().collect(Collectors.groupingBy(c -> c)).entrySet().forEach(e -> {
            Method method = e.getValue().get(0).getMethod();
            method.setAccessible(true);
            this.cache1.put(e.getKey().getEventClass(), method);
        });

    }


    /**
     * 验证是否存在相同的错误处理方法
     *
     * @param eventClassList
     * @throws IllegalAccessException
     */
    private void ensureNotExistSameMethod(ArrayList<EventInfo> eventClassList) throws IllegalAccessException {
        Map<Class, List<EventInfo>> methodMap = eventClassList.stream().collect(Collectors.groupingBy(c -> c.getEventClass()));
        for (List<EventInfo> value : methodMap.values()) {
            if (value.size() > 1) {
                throw new IllegalAccessException("find more than one same handler methods, name=" + value.get(0).getEventClass().getName());
            }
        }
    }

    /**
     * 初始化映射方法缓存
     *
     * @param values
     * @throws IllegalAccessException
     */
    private void initCache(Collection<Object> values) throws IllegalAccessException {
        List<Method> methods = values.stream().flatMap(c -> Arrays.stream(c.getClass().getDeclaredMethods()))
                .filter(m -> m.getDeclaredAnnotation(EventHandler.class) != null)
                .collect(Collectors.toList());
        if (methods.isEmpty()) {
            log.warn("there are none exception resolve methods");
        }
        this.validate(methods);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        this.beanMap = beanFactory.getBeansWithAnnotation(NettyEventAdvice.class);
        if (this.beanMap.isEmpty()) {
            throw new NoSuchBeanDefinitionException("cant find any bean annotated with NettyAdvice");
        }
        try {
            this.initCache(this.beanMap.values());
        } catch (Exception e) {
            throw new BeanCreationException(e.getMessage(), e);
        }
        this.beanMap = null;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class EventInfo {
        private Class eventClass;
        private Method method;
    }

}
