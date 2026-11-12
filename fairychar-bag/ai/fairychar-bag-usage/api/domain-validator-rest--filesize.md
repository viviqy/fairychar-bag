# `com.fairychar.bag.domain.validator.rest.FileSize`

[返回包目录](domain-validator-rest.md)

<a id="domain-validator-rest-filesize"></a>

## `com.fairychar.bag.domain.validator.rest.FileSize`

类型声明：

```java
public abstract @interface com.fairychar.bag.domain.validator.rest.FileSize
```

使用说明：[features/validation/constraints.md](../features/validation/constraints.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract com.fairychar.bag.domain.validator.rest.FileSize$Unit com.fairychar.bag.domain.validator.rest.FileSize.unit() default com.fairychar.bag.domain.validator.rest.FileSize.Unit.KB
public abstract java.lang.Class<? extends jakarta.validation.Payload>[] com.fairychar.bag.domain.validator.rest.FileSize.payload() default {}
public abstract java.lang.Class<?>[] com.fairychar.bag.domain.validator.rest.FileSize.groups() default {}
public abstract java.lang.String com.fairychar.bag.domain.validator.rest.FileSize.message() default "file size not in range"
public abstract long com.fairychar.bag.domain.validator.rest.FileSize.max()
public abstract long com.fairychar.bag.domain.validator.rest.FileSize.min() default 0
```

### public 字段 / 枚举常量

无。

