package com.fairychar.bag.domain.netty.advice;

import com.fairychar.bag.domain.annotions.CauseHandler;
import com.fairychar.bag.domain.annotions.NettyCauseAdvice;
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
 * channel inBound 全局异常处理器,添加到inbound pipeline的最后节点
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Slf4j
public class GlobalInboundCauseAdvice extends ChannelInboundHandlerAdapter implements BeanFactoryPostProcessor {

    private final static String ALL = "0all";
    /**
     * key=mark(ex+handler+method)
     */
    private HashMap<String, Method> cache1;
    private HashMap<String, Method> cache2;
    private HashMap<Class<? extends Throwable>, Method> cache3;
    /**
     * key=method fullName;
     */
    private HashMap<String, InvokeEntity> invokeArgsCache = new HashMap<>(32);
    private Map<String, Object> beanMap;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        this.dispatch(ctx, cause);
    }

    /**
     * 异常处理分发,如果未找到异常处理器将会将此异常向下传递
     *
     * @param ctx
     * @param cause
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    private void dispatch(ChannelHandlerContext ctx, Throwable cause) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        StackTraceElement stackTraceElement = this.findByChannelHandler(cause);
        CauseInfo causeInfo = this.getCauseInfo(cause, stackTraceElement);
        Method method = this.obtainMethod(causeInfo);
        this.invoke(ctx, cause, method);
    }

    /**
     * 包装获取CauseInfo信息
     *
     * @param cause
     * @param stackTraceElement
     * @return
     * @throws ClassNotFoundException
     */
    private CauseInfo getCauseInfo(Throwable cause, StackTraceElement stackTraceElement) throws ClassNotFoundException {
        return new CauseInfo().setEx(cause.getClass())
                .setHandler(Class.forName(stackTraceElement.getClassName()))
                .setMethodName(stackTraceElement.getMethodName());
    }

    /**
     * 执行异常处理
     *
     * @param ctx
     * @param cause
     * @param method
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private void invoke(ChannelHandlerContext ctx, Throwable cause, Method method) throws InvocationTargetException, IllegalAccessException {
        if (method != null) {
            InvokeEntity invokeEntity = this.getInvokeEntity(ctx, cause, method);
            method.invoke(invokeEntity.getBean(), invokeEntity.getArgs());
        } else {
            ctx.fireExceptionCaught(cause);
        }
    }

    /**
     * 获取当前method的缓存InvokeEntity信息
     *
     * @param ctx
     * @param cause
     * @param method
     * @return
     */
    private InvokeEntity getInvokeEntity(ChannelHandlerContext ctx, Throwable cause, Method method) {
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
        return invokeEntity;
    }

    /**
     * 根据causeInfo信息,分别从cache1,cache2,cache3里获取对应的Method<br>
     * cache1推断方式 = exception+handler+method <br>
     * cache2推断方式 = exception+handler <br>
     * cache3推断方式 = exception <br>
     * <p>
     * 获取优先级顺序为 cache1->cache2->cache3
     *
     * @param c causeInfo
     * @return 查到的Method或者null
     */
    private Method obtainMethod(CauseInfo c) {
        String key = c.getMark();
        return this.cache1.get(key) != null ? this.cache1.get(key) :
                (this.cache2.get(this.obtainCache2Key(c)) != null ? this.cache2.get(this.obtainCache2Key(c)) :
                        (this.cache3.get(c.getEx()) != null ? this.cache3.get(c.getEx()) :
                                (this.cache3.get(Exception.class) != null ? this.cache3.get(Exception.class) : null)));

    }


    /**
     * <p>验证映射到的Method合法性</p>
     * <p>
     * 1.校验异常处理方法是否重复 <br>
     * 2.校验是否存在配置了methodName但是却未指定Handler <br>
     *
     * @param methods
     * @throws IllegalAccessException
     */
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
        this.ensureNotExistSameMethod(causeInfoList);
        this.createCache(causeInfoList);
    }

    /**
     * 创建异常处理器映射方法缓存
     *
     * @param causeInfoList
     */
    private void createCache(List<CauseInfo> causeInfoList) {
        this.cache1 = new HashMap<>(causeInfoList.size());
        causeInfoList.stream().collect(Collectors.groupingBy(c -> c.getMark())).entrySet().forEach(e -> {
            Method method = e.getValue().get(0).getMethod();
            method.setAccessible(true);
            this.cache1.put(e.getKey(), method);
        });

        this.cache2 = new HashMap<>(causeInfoList.size());
        causeInfoList.stream().filter(c -> ALL.equals(c.getMethodName()) && c.getHandler() != ChannelHandler.class)
                .forEach(e -> {
                    String key = this.obtainCache2Key(e);
                    this.cache2.put(key, e.getMethod());
                });

        this.cache3 = new HashMap<>(causeInfoList.size());
        causeInfoList.stream().filter(c -> ALL.equals(c.getMethodName()) && c.getHandler() == ChannelHandler.class)
                .forEach(e -> this.cache3.put(e.getEx(), e.getMethod()));
    }


    /**
     * 获取cache2缓存的Key
     *
     * @param causeInfo
     * @return
     */
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

    /**
     * 初始化映射方法缓存
     *
     * @param values
     * @throws IllegalAccessException
     */
    private void initCache(Collection<Object> values) throws IllegalAccessException {
        List<Method> methods = values.stream().flatMap(c -> Arrays.stream(c.getClass().getDeclaredMethods()))
                .filter(m -> m.getDeclaredAnnotation(CauseHandler.class) != null)
                .collect(Collectors.toList());
        if (methods.isEmpty()) {
            log.warn("there are none exception resolve methods");
        }
        this.validate(methods);
    }

    /**
     * 通过类名判断当前类是否是{@link ChannelHandler}的实现类
     *
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    private boolean isChannelHandler(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        return ChannelHandler.class.isAssignableFrom(clazz);
    }


    /**
     * 根据cause获取ChannelHandler实现类抛出异常的stack信息(获取Handler类名和异常抛出方法名)
     *
     * @param cause
     * @return
     * @throws ClassNotFoundException
     */
    private StackTraceElement findByChannelHandler(Throwable cause) throws ClassNotFoundException {
        for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
            if (this.isChannelHandler(stackTraceElement.getClassName())) {
                return stackTraceElement;
            }
        }
        //never happened
        return null;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        this.beanMap = beanFactory.getBeansWithAnnotation(NettyCauseAdvice.class);
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
            return this.ex.getName().concat("-")
                    .concat(this.handler.getName()).concat("-")
                    .concat(Strings.isNullOrEmpty(this.methodName) ? GlobalInboundCauseAdvice.ALL : this.methodName);
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