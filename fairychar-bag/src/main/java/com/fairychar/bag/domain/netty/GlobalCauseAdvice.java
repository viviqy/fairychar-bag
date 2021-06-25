package com.fairychar.bag.domain.netty;

import com.fairychar.bag.domain.annotions.CauseHandler;
import com.fairychar.bag.domain.annotions.NettyAdvice;
import com.fairychar.bag.listener.SpringContextHolder;
import com.fairychar.bag.template.CacheOperateTemplate;
import com.fairychar.bag.utils.StringUtil;
import com.google.common.base.Strings;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
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
 * Datetime: 2021/6/24 17:46 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Slf4j
public class GlobalCauseAdvice extends ChannelInboundHandlerAdapter implements BeanFactoryPostProcessor {

    /**
     * key=mark(ex+handler+method+args)
     */
    private HashMap<String, Method> cache1;
    private HashMap<String, Method> cache2;
    private HashMap<Class<? extends Throwable>, Method> cache3;
    /**
     * key=method fullName;
     */
    private HashMap<String, InvokeEntity> invokeArgsCache = new HashMap<>(32);
    private Map<String, Object> beanMap;
    private final static String ALL = "0all";

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        dispatch(ctx, cause);
    }

    private void dispatch(ChannelHandlerContext ctx, Throwable cause) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        StackTraceElement stackTraceElement = this.findByChannelHandler(cause);
        CauseInfo causeInfo = getCauseInfo(cause, stackTraceElement);
        Method method = obtainMethod(causeInfo);
        invoke(ctx, cause, method);
    }

    private CauseInfo getCauseInfo(Throwable cause, StackTraceElement stackTraceElement) throws ClassNotFoundException {
        return new CauseInfo().setEx(cause.getClass())
                .setHandler(Class.forName(stackTraceElement.getClassName()))
                .setMethodName(stackTraceElement.getMethodName());
    }

    private void invoke(ChannelHandlerContext ctx, Throwable cause, Method method) throws InvocationTargetException, IllegalAccessException {
        if (method != null) {
            InvokeEntity invokeEntity = CacheOperateTemplate.get(() -> this.invokeArgsCache.get(method.toGenericString()), () -> {
                Object bean = SpringContextHolder.getInstance().getBean(method.getDeclaringClass());
                Class<?>[] parameterTypes = method.getParameterTypes();
                Object[] args = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes[i].isAssignableFrom(ctx.getClass())) {
                        args[i] = ctx;
                    } else if (cause.getClass().isAssignableFrom(parameterTypes[i])) {
                        args[i] = cause;
                    }
                }
                return new InvokeEntity(bean, args);
            }, e -> this.invokeArgsCache.put(method.toGenericString(), e), method);
            method.invoke(invokeEntity.getBean(), invokeEntity.getArgs());
        } else {
            fireExceptionCaught(ctx, cause);
        }
    }

    private Method obtainMethod(CauseInfo c) {
        String key = c.getMark();
        return this.cache1.get(key) != null ? this.cache1.get(key) :
                (this.cache2.get(obtainCache2Key(c)) != null ? this.cache2.get(obtainCache2Key(c)) :
                        (this.cache3.get(c.getEx()) != null ? this.cache3.get(c.getEx()) : null));

    }

    private void fireExceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.fireExceptionCaught(cause);
    }


    private void validate(List<Method> methods) throws IllegalAccessException {
        ArrayList<CauseInfo> causeInfoList = new ArrayList<>();
        for (Method m : methods) {
            CauseHandler causeHandler = m.getAnnotation(CauseHandler.class);
            if (!Strings.isNullOrEmpty(causeHandler.methodName()) && causeHandler.handler() == ChannelHandler.class) {
                throw new IllegalAccessException("methodName should conditional with handler,current=" + causeHandler.methodName());
            }
            CauseInfo causeInfo = new CauseInfo(causeHandler.value(), causeHandler.handler()
                    , StringUtil.defaultText(causeHandler.methodName(), ALL)
                    , m);
            causeInfoList.add(causeInfo);
        }
        ensureNotExistSameMethod(causeInfoList);
        createCache(causeInfoList);
    }

    private void createCache(List<CauseInfo> causeInfoList) {
        cache1 = new HashMap<>(causeInfoList.size());
        causeInfoList.stream().collect(Collectors.groupingBy(c -> c.getMark())).entrySet().forEach(e -> {
            Method method = e.getValue().get(0).getMethod();
            method.setAccessible(true);
            cache1.put(e.getKey(), method);
        });

        cache2 = new HashMap<>(causeInfoList.size());
        causeInfoList.stream().filter(c -> ALL.equals(c.getMethodName()) && c.getHandler() != ChannelHandler.class)
                .forEach(e -> {
                    String key = obtainCache2Key(e);
                    this.cache2.put(key, e.getMethod());
                });

        cache3 = new HashMap<>(causeInfoList.size());
        causeInfoList.stream().filter(c -> ALL.equals(c.getMethodName()) && c.getHandler() == ChannelHandler.class)
                .forEach(e -> this.cache3.put(e.getEx(), e.getMethod()));
    }


    private String obtainCache2Key(CauseInfo causeInfo) {
        return causeInfo.ex.getName().concat("-").concat(causeInfo.handler.getName());
    }

    /**
     * 验证是否存在相同的错误处理方法
     *
     * @throws IllegalAccessException
     */
    private void ensureNotExistSameMethod(List<CauseInfo> causeInfoList) throws IllegalAccessException {
        Map<String, List<CauseInfo>> methodMap = causeInfoList.stream().collect(Collectors.groupingBy(c -> c.getMark()));
        for (List<CauseInfo> value : methodMap.values()) {
            if (value.size() > 1) {
                throw new IllegalAccessException("find more than one same handler methods, name=" + value.get(0).getMark());
            }
        }
    }

    private void initCache(Collection<Object> values) throws IllegalAccessException {
        List<Method> methods = values.stream().flatMap(c -> Arrays.stream(c.getClass().getDeclaredMethods()))
                .filter(m -> m.getDeclaredAnnotation(CauseHandler.class) != null)
                .collect(Collectors.toList());
        if (methods.isEmpty()) {
            log.warn("there are none exception resolve methods");
        }
        validate(methods);
    }

    private boolean isChannelHandler(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        return ChannelHandler.class.isAssignableFrom(clazz);
    }


    private StackTraceElement findByChannelHandler(Throwable cause) throws ClassNotFoundException {
        for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
            if (this.isChannelHandler(stackTraceElement.getClassName())) {
                return stackTraceElement;
            }
        }
        //never happened
        return null;
    }

    @AllArgsConstructor
    @Getter
    static class InvokeEntity {
        private final Object bean;
        private final Object[] args;
    }

    /**
     * 1.同一个Ex只能有一个处理方法 (ex,handler=null,method=null)
     * 2.同一个Ex不同handler可以有不同的处理方法(ex,handler,method=null)
     * 3.同一个ex同一个handler不同的方法可以有不同的处理方法(ex,handler,method)
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Accessors(chain = true)
    static class CauseInfo {
        private Class ex;
        private Class handler;
        private String methodName;
        private Method method;

        public String getMark() {
            return ex.getName().concat("-")
                    .concat(handler.getName()).concat("-")
                    .concat(Strings.isNullOrEmpty(methodName) ? ALL : methodName);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanMap = beanFactory.getBeansWithAnnotation(NettyAdvice.class);
        if (beanMap.isEmpty()) {
            throw new NoSuchBeanDefinitionException("cant find any bean annotated with NettyAdvice");
        }
        try {
            initCache(beanMap.values());
        } catch (Exception e) {
            throw new BeanCreationException(e.getMessage(), e);
        }
        beanMap = null;
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