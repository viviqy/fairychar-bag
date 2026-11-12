# `com.fairychar.bag.listener`

[返回 API 索引](README.md)

[SpringContextHolder](#listener-springcontextholder)

<a id="listener-springcontextholder"></a>

## `com.fairychar.bag.listener.SpringContextHolder`

类型声明：

```java
public class com.fairychar.bag.listener.SpringContextHolder
```

使用说明：[features/setup/spring-context.md](../features/setup/spring-context.md)。

父类：`java.lang.Object`。

接口：`org.springframework.context.ApplicationListener<org.springframework.context.event.ContextRefreshedEvent>`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public <A extends java.lang.annotation.Annotation> A com.fairychar.bag.listener.SpringContextHolder.findAnnotationOnBean(java.lang.String,java.lang.Class<A>) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public <A extends java.lang.annotation.Annotation> A com.fairychar.bag.listener.SpringContextHolder.findAnnotationOnBean(java.lang.String,java.lang.Class<A>,boolean) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public <A extends java.lang.annotation.Annotation> java.util.Set<A> com.fairychar.bag.listener.SpringContextHolder.findAllAnnotationsOnBean(java.lang.String,java.lang.Class<A>,boolean) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public <T> T com.fairychar.bag.listener.SpringContextHolder.getBean(java.lang.Class<T>) throws org.springframework.beans.BeansException
public <T> T com.fairychar.bag.listener.SpringContextHolder.getBean(java.lang.Class<T>,java.lang.Object...) throws org.springframework.beans.BeansException
public <T> T com.fairychar.bag.listener.SpringContextHolder.getBean(java.lang.String,java.lang.Class<T>) throws org.springframework.beans.BeansException
public <T> java.util.Map<java.lang.String, T> com.fairychar.bag.listener.SpringContextHolder.getBeansOfType(java.lang.Class<T>) throws org.springframework.beans.BeansException
public <T> java.util.Map<java.lang.String, T> com.fairychar.bag.listener.SpringContextHolder.getBeansOfType(java.lang.Class<T>,boolean,boolean) throws org.springframework.beans.BeansException
public <T> org.springframework.beans.factory.ObjectProvider<T> com.fairychar.bag.listener.SpringContextHolder.getBeanProvider(java.lang.Class<T>)
public <T> org.springframework.beans.factory.ObjectProvider<T> com.fairychar.bag.listener.SpringContextHolder.getBeanProvider(java.lang.Class<T>,boolean)
public <T> org.springframework.beans.factory.ObjectProvider<T> com.fairychar.bag.listener.SpringContextHolder.getBeanProvider(org.springframework.core.ParameterizedTypeReference<T>)
public <T> org.springframework.beans.factory.ObjectProvider<T> com.fairychar.bag.listener.SpringContextHolder.getBeanProvider(org.springframework.core.ResolvableType)
public <T> org.springframework.beans.factory.ObjectProvider<T> com.fairychar.bag.listener.SpringContextHolder.getBeanProvider(org.springframework.core.ResolvableType,boolean)
public boolean com.fairychar.bag.listener.SpringContextHolder.containsBean(java.lang.String)
public boolean com.fairychar.bag.listener.SpringContextHolder.containsBeanDefinition(java.lang.String)
public boolean com.fairychar.bag.listener.SpringContextHolder.containsLocalBean(java.lang.String)
public boolean com.fairychar.bag.listener.SpringContextHolder.isPrototype(java.lang.String) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public boolean com.fairychar.bag.listener.SpringContextHolder.isSingleton(java.lang.String) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public boolean com.fairychar.bag.listener.SpringContextHolder.isTypeMatch(java.lang.String,java.lang.Class<?>) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public boolean com.fairychar.bag.listener.SpringContextHolder.isTypeMatch(java.lang.String,org.springframework.core.ResolvableType) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public int com.fairychar.bag.listener.SpringContextHolder.getBeanDefinitionCount()
public java.lang.Class<?> com.fairychar.bag.listener.SpringContextHolder.getType(java.lang.String) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public java.lang.Class<?> com.fairychar.bag.listener.SpringContextHolder.getType(java.lang.String,boolean) throws org.springframework.beans.factory.NoSuchBeanDefinitionException
public java.lang.ClassLoader com.fairychar.bag.listener.SpringContextHolder.getClassLoader()
public java.lang.Object com.fairychar.bag.listener.SpringContextHolder.getBean(java.lang.String) throws org.springframework.beans.BeansException
public java.lang.Object com.fairychar.bag.listener.SpringContextHolder.getBean(java.lang.String,java.lang.Object...) throws org.springframework.beans.BeansException
public java.lang.String com.fairychar.bag.listener.SpringContextHolder.getMessage(java.lang.String,java.lang.Object[],java.lang.String,java.util.Locale)
public java.lang.String com.fairychar.bag.listener.SpringContextHolder.getMessage(java.lang.String,java.lang.Object[],java.util.Locale) throws org.springframework.context.NoSuchMessageException
public java.lang.String com.fairychar.bag.listener.SpringContextHolder.getMessage(org.springframework.context.MessageSourceResolvable,java.util.Locale) throws org.springframework.context.NoSuchMessageException
public java.lang.String[] com.fairychar.bag.listener.SpringContextHolder.getAliases(java.lang.String)
public java.lang.String[] com.fairychar.bag.listener.SpringContextHolder.getBeanDefinitionNames()
public java.lang.String[] com.fairychar.bag.listener.SpringContextHolder.getBeanNamesForAnnotation(java.lang.Class<? extends java.lang.annotation.Annotation>)
public java.lang.String[] com.fairychar.bag.listener.SpringContextHolder.getBeanNamesForType(java.lang.Class<?>)
public java.lang.String[] com.fairychar.bag.listener.SpringContextHolder.getBeanNamesForType(java.lang.Class<?>,boolean,boolean)
public java.lang.String[] com.fairychar.bag.listener.SpringContextHolder.getBeanNamesForType(org.springframework.core.ResolvableType)
public java.lang.String[] com.fairychar.bag.listener.SpringContextHolder.getBeanNamesForType(org.springframework.core.ResolvableType,boolean,boolean)
public java.util.Map<java.lang.String, java.lang.Object> com.fairychar.bag.listener.SpringContextHolder.getBeansWithAnnotation(java.lang.Class<? extends java.lang.annotation.Annotation>) throws org.springframework.beans.BeansException
public org.springframework.beans.factory.BeanFactory com.fairychar.bag.listener.SpringContextHolder.getParentBeanFactory()
public org.springframework.core.env.Environment com.fairychar.bag.listener.SpringContextHolder.getEnvironment()
public org.springframework.core.io.Resource com.fairychar.bag.listener.SpringContextHolder.getResource(java.lang.String)
public org.springframework.core.io.Resource[] com.fairychar.bag.listener.SpringContextHolder.getResources(java.lang.String) throws java.io.IOException
public static com.fairychar.bag.listener.SpringContextHolder com.fairychar.bag.listener.SpringContextHolder.getInstance()
public void com.fairychar.bag.listener.SpringContextHolder.onApplicationEvent(org.springframework.context.event.ContextRefreshedEvent)
public void com.fairychar.bag.listener.SpringContextHolder.publishEvent(java.lang.Object)
public void com.fairychar.bag.listener.SpringContextHolder.publishEvent(org.springframework.context.ApplicationEvent)
```

### public 字段 / 枚举常量

无。

