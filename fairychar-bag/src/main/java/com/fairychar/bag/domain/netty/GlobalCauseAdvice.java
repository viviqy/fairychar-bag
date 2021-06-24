package com.fairychar.bag.domain.netty;

import com.fairychar.bag.domain.annotions.CauseHandler;
import com.fairychar.bag.domain.annotions.NettyAdvice;
import com.google.common.base.Strings;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.annotation.PostConstruct;
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

    private HashMap<String, Method> cache;
    private Map<String, Object> beanMap;


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        dispatch(ctx, cause);
    }

    private void dispatch(ChannelHandlerContext ctx, Throwable cause) throws InvocationTargetException, IllegalAccessException {
        StackTraceElement stackTraceElement = cause.getStackTrace()[0];
        String key = new CauseInfo().setEx(cause.getClass()).setHandler(ctx.channel().getClass()).setMethodName(stackTraceElement.getMethodName())
                .setArgs(new Class[]{Void.class})//暂时无法取得参数
                .getMark();
        Method method = this.cache.get(key);
        method.invoke(null,ctx,cause);
    }


    private void validate(List<Method> methods) throws IllegalAccessException {
        List<CauseInfo> causeInfoList = methods.stream().map(m -> {
            CauseHandler causeHandler = m.getAnnotation(CauseHandler.class);
            return new CauseInfo(causeHandler.value(), causeHandler.handler(), causeHandler.methodName(), causeHandler.args(), m);
        }).collect(Collectors.toList());
        Map<String, List<CauseInfo>> methodMap = causeInfoList.stream().collect(Collectors.groupingBy(c -> c.getMark()));
        ensureNotExistSameMethod(methodMap);
        createCache(methodMap);
    }

    private void createCache(Map<String, List<CauseInfo>> methodMap) {
        cache = new HashMap<>(methodMap.size());
        methodMap.entrySet().forEach(e -> {
            cache.put(e.getKey(), e.getValue().get(0).getMethod());
        });
    }

    /**
     * 验证是否存在相同的错误处理方法
     *
     * @param methodMap
     * @throws IllegalAccessException
     */
    private void ensureNotExistSameMethod(Map<String, List<CauseInfo>> methodMap) throws IllegalAccessException {
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

    /**
     * 1.同一个Ex只能有一个处理方法 (ex,handler=null,method=null)
     * 2.同一个Ex不同handler可以有不同的处理方法(ex,handler,method=null)
     * 3.同一个ex同一个handler不同的方法可以有不同的处理方法(ex,handler,method)
     *
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
        private Class[] args;
        private Method method;

        public String getMark() {
            return ex.getName().concat("-")
                    .concat(handler.getName()).concat("-")
                    .concat(Strings.isNullOrEmpty(methodName) ? "unselect" : methodName).concat("-")
                    .concat(Arrays.stream(args).map(a -> a.getName()).collect(Collectors.joining(",")));
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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