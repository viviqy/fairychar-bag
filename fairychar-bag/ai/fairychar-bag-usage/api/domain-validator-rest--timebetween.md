# `com.fairychar.bag.domain.validator.rest.TimeBetween`

[返回包目录](domain-validator-rest.md)

<a id="domain-validator-rest-timebetween"></a>

## `com.fairychar.bag.domain.validator.rest.TimeBetween`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.validator.rest.TimeBetween
```

使用说明：[features/validation/constraints.md](../features/validation/constraints.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.Class<? extends jakarta.validation.Payload>[] com.fairychar.bag.domain.validator.rest.TimeBetween.payload() default {}
public abstract java.lang.Class<?>[] com.fairychar.bag.domain.validator.rest.TimeBetween.groups() default {}
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.TimeBetween.max() default "2099-12-31 23:59:59"
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.TimeBetween.message() default "time not in range"
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.TimeBetween.min() default "1976-01-01 00:00:01"
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.TimeBetween.pattern() default "yyyy-MM-dd HH:mm:ss"
```

### public 字段 / 枚举常量

无。

