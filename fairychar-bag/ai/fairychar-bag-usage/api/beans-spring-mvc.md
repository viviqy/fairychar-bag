# `com.fairychar.bag.beans.spring.mvc`

[返回 API 索引](README.md)

[EraseValue](#beans-spring-mvc-erasevalue) · [FuzzyResult](#beans-spring-mvc-fuzzyresult) · [FuzzyValue](#beans-spring-mvc-fuzzyvalue) · [KeepValue](#beans-spring-mvc-keepvalue) · [PropertyValueAdvice](#beans-spring-mvc-propertyvalueadvice)

<a id="beans-spring-mvc-erasevalue"></a>

## `com.fairychar.bag.beans.spring.mvc.EraseValue`

类型声明：

```java
public abstract @interface com.fairychar.bag.beans.spring.mvc.EraseValue
```

使用说明：[features/field-processing/erase-value.md](../features/field-processing/erase-value.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.Class<?>[] com.fairychar.bag.beans.spring.mvc.EraseValue.value() default {}
```

### public 字段 / 枚举常量

无。

<a id="beans-spring-mvc-fuzzyresult"></a>

## `com.fairychar.bag.beans.spring.mvc.FuzzyResult`

类型声明：

```java
public abstract @interface com.fairychar.bag.beans.spring.mvc.FuzzyResult
```

使用说明：[features/field-processing/fuzzy-value.md](../features/field-processing/fuzzy-value.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.String com.fairychar.bag.beans.spring.mvc.FuzzyResult.field() default ""
```

### public 字段 / 枚举常量

无。

<a id="beans-spring-mvc-fuzzyvalue"></a>

## `com.fairychar.bag.beans.spring.mvc.FuzzyValue`

类型声明：

```java
public abstract @interface com.fairychar.bag.beans.spring.mvc.FuzzyValue
```

使用说明：[features/field-processing/fuzzy-value.md](../features/field-processing/fuzzy-value.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract int com.fairychar.bag.beans.spring.mvc.FuzzyValue.beginAt() default 0
public abstract int com.fairychar.bag.beans.spring.mvc.FuzzyValue.endAt() default 0
public abstract java.lang.Class<? extends com.fairychar.bag.beans.spring.mvc.FuzzyValueProcessor>[] com.fairychar.bag.beans.spring.mvc.FuzzyValue.processor() default {}
public abstract java.lang.String com.fairychar.bag.beans.spring.mvc.FuzzyValue.replaceSymbol() default "*"
```

### public 字段 / 枚举常量

无。

<a id="beans-spring-mvc-keepvalue"></a>

## `com.fairychar.bag.beans.spring.mvc.KeepValue`

类型声明：

```java
public abstract @interface com.fairychar.bag.beans.spring.mvc.KeepValue
```

使用说明：[features/field-processing/keep-value.md](../features/field-processing/keep-value.md)。

接口：`java.lang.annotation.Annotation`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract java.lang.Class<?>[] com.fairychar.bag.beans.spring.mvc.KeepValue.value() default {}
```

### public 字段 / 枚举常量

无。

<a id="beans-spring-mvc-propertyvalueadvice"></a>

## `com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice`

类型声明：

```java
public abstract class com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice<T extends java.lang.annotation.Annotation>
```

使用说明：[features/field-processing/keep-value.md](../features/field-processing/keep-value.md)。

父类：`org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter`。

### public 构造器

```java
public com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice(java.lang.Class<T>)
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice.supports(org.springframework.core.MethodParameter,java.lang.reflect.Type,java.lang.Class<? extends org.springframework.http.converter.HttpMessageConverter<?>>)
public java.lang.Object com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice.afterBodyRead(java.lang.Object,org.springframework.http.HttpInputMessage,org.springframework.core.MethodParameter,java.lang.reflect.Type,java.lang.Class<? extends org.springframework.http.converter.HttpMessageConverter<?>>)
```

### public 字段 / 枚举常量

无。

