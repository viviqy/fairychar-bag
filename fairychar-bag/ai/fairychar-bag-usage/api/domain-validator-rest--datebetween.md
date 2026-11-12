# `com.fairychar.bag.domain.validator.rest.DateBetween`

[返回包目录](domain-validator-rest.md)

<a id="domain-validator-rest-datebetween"></a>

## `com.fairychar.bag.domain.validator.rest.DateBetween`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.validator.rest.DateBetween
```

使用说明：[features/validation/constraints.md](../features/validation/constraints.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.Class<? extends jakarta.validation.Payload>[] com.fairychar.bag.domain.validator.rest.DateBetween.payload() default {}
public abstract java.lang.Class<?>[] com.fairychar.bag.domain.validator.rest.DateBetween.groups() default {}
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.DateBetween.max() default "2099-12-31"
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.DateBetween.message() default "date not in range"
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.DateBetween.min() default "1976-01-01"
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.DateBetween.pattern() default "yyyy-MM-dd"
```

### public 字段 / 枚举常量

无。

