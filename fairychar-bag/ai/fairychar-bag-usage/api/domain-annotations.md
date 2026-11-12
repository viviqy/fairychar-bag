# `com.fairychar.bag.domain.annotations`

[返回 API 索引](README.md)

[CauseHandler](#domain-annotations-causehandler) · [EventHandler](#domain-annotations-eventhandler) · [Type](#domain-annotations-methodlock-type) · [MethodLock](#domain-annotations-methodlock) · [NettyCauseAdvice](#domain-annotations-nettycauseadvice) · [NettyEventAdvice](#domain-annotations-nettyeventadvice) · [Level](#domain-annotations-requestlog-level) · [RequestLog](#domain-annotations-requestlog)

<a id="domain-annotations-causehandler"></a>

## `com.fairychar.bag.domain.annotations.CauseHandler`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.annotations.CauseHandler
```

使用说明：[features/netty/handler-annotations.md](../features/netty/handler-annotations.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.Class<? extends io.netty.channel.ChannelHandler> com.fairychar.bag.domain.annotations.CauseHandler.handler() default io.netty.channel.ChannelHandler.class
public abstract java.lang.Class<? extends java.lang.Throwable> com.fairychar.bag.domain.annotations.CauseHandler.value()
public abstract java.lang.String com.fairychar.bag.domain.annotations.CauseHandler.methodName() default ""
```

### public 字段 / 枚举常量

无。

<a id="domain-annotations-eventhandler"></a>

## `com.fairychar.bag.domain.annotations.EventHandler`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.annotations.EventHandler
```

使用说明：[features/netty/handler-annotations.md](../features/netty/handler-annotations.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.Class com.fairychar.bag.domain.annotations.EventHandler.value() default java.lang.Void.class
```

### public 字段 / 枚举常量

无。

<a id="domain-annotations-methodlock-type"></a>

## `com.fairychar.bag.domain.annotations.MethodLock.Type`

类型声明：

```java
public static final enum com.fairychar.bag.domain.annotations.MethodLock$Type
```

使用说明：[features/locking/method-lock.md](../features/locking/method-lock.md)。

父类：`java.lang.Enum<com.fairychar.bag.domain.annotations.MethodLock$Type>`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static com.fairychar.bag.domain.annotations.MethodLock$Type com.fairychar.bag.domain.annotations.MethodLock$Type.valueOf(java.lang.String)
public static com.fairychar.bag.domain.annotations.MethodLock$Type[] com.fairychar.bag.domain.annotations.MethodLock$Type.values()
```

### public 字段 / 枚举常量

```java
public static final com.fairychar.bag.domain.annotations.MethodLock$Type com.fairychar.bag.domain.annotations.MethodLock$Type.DEFAULT [enum constant]
public static final com.fairychar.bag.domain.annotations.MethodLock$Type com.fairychar.bag.domain.annotations.MethodLock$Type.LOCAL [enum constant]
public static final com.fairychar.bag.domain.annotations.MethodLock$Type com.fairychar.bag.domain.annotations.MethodLock$Type.REDIS [enum constant]
public static final com.fairychar.bag.domain.annotations.MethodLock$Type com.fairychar.bag.domain.annotations.MethodLock$Type.ZK [enum constant]
```

<a id="domain-annotations-methodlock"></a>

## `com.fairychar.bag.domain.annotations.MethodLock`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.annotations.MethodLock
```

使用说明：[features/locking/method-lock.md](../features/locking/method-lock.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract boolean com.fairychar.bag.domain.annotations.MethodLock.enable() default true
public abstract boolean com.fairychar.bag.domain.annotations.MethodLock.optimistic() default false
public abstract com.fairychar.bag.domain.annotations.MethodLock$Type com.fairychar.bag.domain.annotations.MethodLock.lockType() default com.fairychar.bag.domain.annotations.MethodLock.Type.DEFAULT
public abstract int com.fairychar.bag.domain.annotations.MethodLock.timeout() default -1
public abstract java.lang.String com.fairychar.bag.domain.annotations.MethodLock.distributedPrefix() default "fairychar:lock:"
public abstract java.lang.String com.fairychar.bag.domain.annotations.MethodLock.nameExpression() default ""
public abstract java.util.concurrent.TimeUnit com.fairychar.bag.domain.annotations.MethodLock.timeUnit() default java.util.concurrent.TimeUnit.NANOSECONDS
```

### public 字段 / 枚举常量

无。

<a id="domain-annotations-nettycauseadvice"></a>

## `com.fairychar.bag.domain.annotations.NettyCauseAdvice`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.annotations.NettyCauseAdvice
```

使用说明：[features/netty/handler-annotations.md](../features/netty/handler-annotations.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

无。

<a id="domain-annotations-nettyeventadvice"></a>

## `com.fairychar.bag.domain.annotations.NettyEventAdvice`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.annotations.NettyEventAdvice
```

使用说明：[features/netty/handler-annotations.md](../features/netty/handler-annotations.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

无。

<a id="domain-annotations-requestlog-level"></a>

## `com.fairychar.bag.domain.annotations.RequestLog.Level`

类型声明：

```java
public static final enum com.fairychar.bag.domain.annotations.RequestLog$Level
```

使用说明：[features/web/request-logging.md](../features/web/request-logging.md)。

父类：`java.lang.Enum<com.fairychar.bag.domain.annotations.RequestLog$Level>`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static com.fairychar.bag.domain.annotations.RequestLog$Level com.fairychar.bag.domain.annotations.RequestLog$Level.valueOf(java.lang.String)
public static com.fairychar.bag.domain.annotations.RequestLog$Level[] com.fairychar.bag.domain.annotations.RequestLog$Level.values()
```

### public 字段 / 枚举常量

```java
public static final com.fairychar.bag.domain.annotations.RequestLog$Level com.fairychar.bag.domain.annotations.RequestLog$Level.DEBUG [enum constant]
public static final com.fairychar.bag.domain.annotations.RequestLog$Level com.fairychar.bag.domain.annotations.RequestLog$Level.ERROR [enum constant]
public static final com.fairychar.bag.domain.annotations.RequestLog$Level com.fairychar.bag.domain.annotations.RequestLog$Level.INFO [enum constant]
public static final com.fairychar.bag.domain.annotations.RequestLog$Level com.fairychar.bag.domain.annotations.RequestLog$Level.NONE [enum constant]
public static final com.fairychar.bag.domain.annotations.RequestLog$Level com.fairychar.bag.domain.annotations.RequestLog$Level.TRACE [enum constant]
public static final com.fairychar.bag.domain.annotations.RequestLog$Level com.fairychar.bag.domain.annotations.RequestLog$Level.WARN [enum constant]
```

<a id="domain-annotations-requestlog"></a>

## `com.fairychar.bag.domain.annotations.RequestLog`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.annotations.RequestLog
```

使用说明：[features/web/request-logging.md](../features/web/request-logging.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract boolean com.fairychar.bag.domain.annotations.RequestLog.enable() default true
public abstract com.fairychar.bag.domain.annotations.RequestLog$Level com.fairychar.bag.domain.annotations.RequestLog.loggingLevel() default com.fairychar.bag.domain.annotations.RequestLog.Level.NONE
public abstract java.lang.String com.fairychar.bag.domain.annotations.RequestLog.afterHandler() default ""
public abstract java.lang.String com.fairychar.bag.domain.annotations.RequestLog.beforeHandler() default ""
```

### public 字段 / 枚举常量

无。

