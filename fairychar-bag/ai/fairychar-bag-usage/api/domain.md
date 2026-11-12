# `com.fairychar.bag.domain`

[返回 API 索引](README.md)

[OAuth2](#domain-consts-oauth2) · [Regex](#domain-consts-regex) · [Consts](#domain-consts) · [GsonBean](#domain-singletons-gsonbean) · [JsonBean](#domain-singletons-jsonbean) · [PathMatcherBean](#domain-singletons-pathmatcherbean) · [RandomBean](#domain-singletons-randombean) · [RestTemplateBean](#domain-singletons-resttemplatebean) · [Singletons](#domain-singletons)

<a id="domain-consts-oauth2"></a>

## `com.fairychar.bag.domain.Consts.OAuth2`

类型声明：

```java
public static final class com.fairychar.bag.domain.Consts$OAuth2
```

使用说明：[features/utilities/constants.md](../features/utilities/constants.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.domain.Consts$OAuth2()
```

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

```java
public static final java.lang.String com.fairychar.bag.domain.Consts$OAuth2.AUTHORIZATION_CODE
public static final java.lang.String com.fairychar.bag.domain.Consts$OAuth2.CLIENT_CREDENTIALS
public static final java.lang.String com.fairychar.bag.domain.Consts$OAuth2.IMPLICIT
public static final java.lang.String com.fairychar.bag.domain.Consts$OAuth2.PASSWORD
public static final java.lang.String com.fairychar.bag.domain.Consts$OAuth2.REFRESH_TOKEN
```

<a id="domain-consts-regex"></a>

## `com.fairychar.bag.domain.Consts.Regex`

类型声明：

```java
public static final class com.fairychar.bag.domain.Consts$Regex
```

使用说明：[features/utilities/constants.md](../features/utilities/constants.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.domain.Consts$Regex()
```

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

```java
public static final java.lang.String com.fairychar.bag.domain.Consts$Regex.IP
public static final java.lang.String com.fairychar.bag.domain.Consts$Regex.URL
```

<a id="domain-consts"></a>

## `com.fairychar.bag.domain.Consts`

类型声明：

```java
public final class com.fairychar.bag.domain.Consts
```

使用说明：[features/utilities/constants.md](../features/utilities/constants.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

```java
public static final java.lang.String com.fairychar.bag.domain.Consts.EMPTY_STR
public static final java.lang.String com.fairychar.bag.domain.Consts.NONE
public static final java.lang.String com.fairychar.bag.domain.Consts.SIMPLE_DATETIME_FORMAT
public static final java.lang.String com.fairychar.bag.domain.Consts.SIMPLE_DATE_FORMAT
public static final java.time.LocalDateTime com.fairychar.bag.domain.Consts.MYSQL_MAX_DATETIME
public static final java.time.LocalDateTime com.fairychar.bag.domain.Consts.MYSQL_MAX_TIMESTAMP
public static final java.time.format.DateTimeFormatter com.fairychar.bag.domain.Consts.SIMPLE_DATE_FORMATTER
public static final java.time.format.DateTimeFormatter com.fairychar.bag.domain.Consts.SIMPLE_DATE_TIME_FORMATTER
public static final long com.fairychar.bag.domain.Consts.GB_PER_B
public static final long com.fairychar.bag.domain.Consts.KB_PER_B
public static final long com.fairychar.bag.domain.Consts.MB_PER_B
public static final long com.fairychar.bag.domain.Consts.PB_PER_B
public static final long com.fairychar.bag.domain.Consts.TB_PER_B
```

<a id="domain-singletons-gsonbean"></a>

## `com.fairychar.bag.domain.Singletons.GsonBean`

类型声明：

```java
public static class com.fairychar.bag.domain.Singletons$GsonBean
```

使用说明：[features/setup/shared-objects.md](../features/setup/shared-objects.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static com.google.gson.Gson com.fairychar.bag.domain.Singletons$GsonBean.getInstance()
```

### public 字段 / 枚举常量

无。

<a id="domain-singletons-jsonbean"></a>

## `com.fairychar.bag.domain.Singletons.JsonBean`

类型声明：

```java
public static class com.fairychar.bag.domain.Singletons$JsonBean
```

使用说明：[features/setup/shared-objects.md](../features/setup/shared-objects.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static tools.jackson.databind.ObjectMapper com.fairychar.bag.domain.Singletons$JsonBean.getInstance()
```

### public 字段 / 枚举常量

无。

<a id="domain-singletons-pathmatcherbean"></a>

## `com.fairychar.bag.domain.Singletons.PathMatcherBean`

类型声明：

```java
public static class com.fairychar.bag.domain.Singletons$PathMatcherBean
```

使用说明：[features/setup/shared-objects.md](../features/setup/shared-objects.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static org.springframework.util.AntPathMatcher com.fairychar.bag.domain.Singletons$PathMatcherBean.getInstance()
```

### public 字段 / 枚举常量

无。

<a id="domain-singletons-randombean"></a>

## `com.fairychar.bag.domain.Singletons.RandomBean`

类型声明：

```java
public static class com.fairychar.bag.domain.Singletons$RandomBean
```

使用说明：[features/setup/shared-objects.md](../features/setup/shared-objects.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static java.util.Random com.fairychar.bag.domain.Singletons$RandomBean.getInstance()
```

### public 字段 / 枚举常量

无。

<a id="domain-singletons-resttemplatebean"></a>

## `com.fairychar.bag.domain.Singletons.RestTemplateBean`

类型声明：

```java
public static class com.fairychar.bag.domain.Singletons$RestTemplateBean
```

使用说明：[features/setup/shared-objects.md](../features/setup/shared-objects.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static org.springframework.web.client.RestTemplate com.fairychar.bag.domain.Singletons$RestTemplateBean.getInstance()
```

### public 字段 / 枚举常量

无。

<a id="domain-singletons"></a>

## `com.fairychar.bag.domain.Singletons`

类型声明：

```java
public class com.fairychar.bag.domain.Singletons
```

使用说明：[features/setup/shared-objects.md](../features/setup/shared-objects.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.domain.Singletons()
```

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

无。

