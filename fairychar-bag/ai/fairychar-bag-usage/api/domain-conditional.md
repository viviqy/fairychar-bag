# `com.fairychar.bag.domain.conditional`

[返回 API 索引](README.md)

[ConditionalOnDateTime](#domain-conditional-conditionalondatetime) · [ConditionalOnPingHost](#domain-conditional-conditionalonpinghost) · [ConditionalOnRandomNumber](#domain-conditional-conditionalonrandomnumber) · [OS](#domain-conditional-conditionalonsystemos-os) · [ConditionalOnSystemOS](#domain-conditional-conditionalonsystemos) · [ConditionalOnSystemProperty](#domain-conditional-conditionalonsystemproperty)

<a id="domain-conditional-conditionalondatetime"></a>

## `com.fairychar.bag.domain.conditional.ConditionalOnDateTime`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.conditional.ConditionalOnDateTime
```

使用说明：[features/setup/conditional-beans.md](../features/setup/conditional-beans.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.String com.fairychar.bag.domain.conditional.ConditionalOnDateTime.lower()
public abstract java.lang.String com.fairychar.bag.domain.conditional.ConditionalOnDateTime.pattern() default "yyyy-MM-dd HH:mm:ss"
public abstract java.lang.String com.fairychar.bag.domain.conditional.ConditionalOnDateTime.upper()
```

### public 字段 / 枚举常量

无。

<a id="domain-conditional-conditionalonpinghost"></a>

## `com.fairychar.bag.domain.conditional.ConditionalOnPingHost`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.conditional.ConditionalOnPingHost
```

使用说明：[features/setup/conditional-beans.md](../features/setup/conditional-beans.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract boolean com.fairychar.bag.domain.conditional.ConditionalOnPingHost.result()
public abstract int com.fairychar.bag.domain.conditional.ConditionalOnPingHost.timeout() default 1000
public abstract java.lang.String com.fairychar.bag.domain.conditional.ConditionalOnPingHost.host()
```

### public 字段 / 枚举常量

无。

<a id="domain-conditional-conditionalonrandomnumber"></a>

## `com.fairychar.bag.domain.conditional.ConditionalOnRandomNumber`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.conditional.ConditionalOnRandomNumber
```

使用说明：[features/setup/conditional-beans.md](../features/setup/conditional-beans.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract int com.fairychar.bag.domain.conditional.ConditionalOnRandomNumber.end()
public abstract int com.fairychar.bag.domain.conditional.ConditionalOnRandomNumber.number() default 0
```

### public 字段 / 枚举常量

无。

<a id="domain-conditional-conditionalonsystemos-os"></a>

## `com.fairychar.bag.domain.conditional.ConditionalOnSystemOS.OS`

类型声明：

```java
public static final enum com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS
```

使用说明：[features/setup/conditional-beans.md](../features/setup/conditional-beans.md)。

父类：`java.lang.Enum<com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS>`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS.valueOf(java.lang.String)
public static com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS[] com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS.values()
```

### public 字段 / 枚举常量

```java
public static final com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS.Linux [enum constant]
public static final com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS.MacOSX [enum constant]
public static final com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS.Windows [enum constant]
```

<a id="domain-conditional-conditionalonsystemos"></a>

## `com.fairychar.bag.domain.conditional.ConditionalOnSystemOS`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.conditional.ConditionalOnSystemOS
```

使用说明：[features/setup/conditional-beans.md](../features/setup/conditional-beans.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract boolean com.fairychar.bag.domain.conditional.ConditionalOnSystemOS.condition()
public abstract com.fairychar.bag.domain.conditional.ConditionalOnSystemOS$OS com.fairychar.bag.domain.conditional.ConditionalOnSystemOS.os()
```

### public 字段 / 枚举常量

无。

<a id="domain-conditional-conditionalonsystemproperty"></a>

## `com.fairychar.bag.domain.conditional.ConditionalOnSystemProperty`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.conditional.ConditionalOnSystemProperty
```

使用说明：[features/setup/conditional-beans.md](../features/setup/conditional-beans.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.String com.fairychar.bag.domain.conditional.ConditionalOnSystemProperty.name() default ""
public abstract java.lang.String com.fairychar.bag.domain.conditional.ConditionalOnSystemProperty.value() default ""
```

### public 字段 / 枚举常量

无。

