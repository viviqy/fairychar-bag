# `com.fairychar.bag.beans.aop`

[返回 API 索引](README.md)

[IgnoreContentLoggingHandler](#beans-aop-ignorecontentlogginghandler) · [JsonLoggingHandler](#beans-aop-jsonlogginghandler) · [LoggingHandler](#beans-aop-logginghandler) · [SimpleLoggingHanlder](#beans-aop-simplelogginghanlder) · [SwaggerLoggingHandler](#beans-aop-swaggerlogginghandler)

<a id="beans-aop-ignorecontentlogginghandler"></a>

## `com.fairychar.bag.beans.aop.IgnoreContentLoggingHandler`

类型声明：

```java
public class com.fairychar.bag.beans.aop.IgnoreContentLoggingHandler
```

使用说明：[features/web/request-logging.md](../features/web/request-logging.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.beans.aop.LoggingHandler`。

继承接口导航： [查看声明](beans-aop.md#beans-aop-logginghandler)。

### public 构造器

```java
public com.fairychar.bag.beans.aop.IgnoreContentLoggingHandler()
```

### 当前类型声明的 public 方法

```java
public void com.fairychar.bag.beans.aop.IgnoreContentLoggingHandler.after(org.aspectj.lang.JoinPoint,java.lang.Object)
public void com.fairychar.bag.beans.aop.IgnoreContentLoggingHandler.before(org.aspectj.lang.JoinPoint)
```

### public 字段 / 枚举常量

无。

<a id="beans-aop-jsonlogginghandler"></a>

## `com.fairychar.bag.beans.aop.JsonLoggingHandler`

类型声明：

```java
public class com.fairychar.bag.beans.aop.JsonLoggingHandler
```

使用说明：[features/web/request-logging.md](../features/web/request-logging.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.beans.aop.LoggingHandler`。

继承接口导航： [查看声明](beans-aop.md#beans-aop-logginghandler)。

### public 构造器

```java
public com.fairychar.bag.beans.aop.JsonLoggingHandler()
public com.fairychar.bag.beans.aop.JsonLoggingHandler(tools.jackson.databind.ObjectMapper,boolean)
```

### 当前类型声明的 public 方法

```java
public void com.fairychar.bag.beans.aop.JsonLoggingHandler.after(org.aspectj.lang.JoinPoint,java.lang.Object)
public void com.fairychar.bag.beans.aop.JsonLoggingHandler.before(org.aspectj.lang.JoinPoint)
```

### public 字段 / 枚举常量

无。

<a id="beans-aop-logginghandler"></a>

## `com.fairychar.bag.beans.aop.LoggingHandler`

类型声明：

```java
public abstract interface com.fairychar.bag.beans.aop.LoggingHandler
```

使用说明：[features/web/request-logging.md](../features/web/request-logging.md)。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract void com.fairychar.bag.beans.aop.LoggingHandler.after(org.aspectj.lang.JoinPoint,java.lang.Object)
public abstract void com.fairychar.bag.beans.aop.LoggingHandler.before(org.aspectj.lang.JoinPoint)
```

### public 字段 / 枚举常量

无。

<a id="beans-aop-simplelogginghanlder"></a>

## `com.fairychar.bag.beans.aop.SimpleLoggingHanlder`

类型声明：

```java
public class com.fairychar.bag.beans.aop.SimpleLoggingHanlder
```

使用说明：[features/web/request-logging.md](../features/web/request-logging.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.beans.aop.LoggingHandler`。

继承接口导航： [查看声明](beans-aop.md#beans-aop-logginghandler)。

### public 构造器

```java
public com.fairychar.bag.beans.aop.SimpleLoggingHanlder()
```

### 当前类型声明的 public 方法

```java
public void com.fairychar.bag.beans.aop.SimpleLoggingHanlder.after(org.aspectj.lang.JoinPoint,java.lang.Object)
public void com.fairychar.bag.beans.aop.SimpleLoggingHanlder.before(org.aspectj.lang.JoinPoint)
```

### public 字段 / 枚举常量

无。

<a id="beans-aop-swaggerlogginghandler"></a>

## `com.fairychar.bag.beans.aop.SwaggerLoggingHandler`

类型声明：

```java
public class com.fairychar.bag.beans.aop.SwaggerLoggingHandler
```

使用说明：[features/web/request-logging.md](../features/web/request-logging.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.beans.aop.LoggingHandler`。

继承接口导航： [查看声明](beans-aop.md#beans-aop-logginghandler)。

### public 构造器

```java
public com.fairychar.bag.beans.aop.SwaggerLoggingHandler()
```

### 当前类型声明的 public 方法

```java
public void com.fairychar.bag.beans.aop.SwaggerLoggingHandler.after(org.aspectj.lang.JoinPoint,java.lang.Object)
public void com.fairychar.bag.beans.aop.SwaggerLoggingHandler.before(org.aspectj.lang.JoinPoint)
```

### public 字段 / 枚举常量

无。

