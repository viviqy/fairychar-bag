# `com.fairychar.bag.utils.ReflectUtil`

[返回包目录](utils.md)

<a id="utils-reflectutil"></a>

## `com.fairychar.bag.utils.ReflectUtil`

类型声明：

```java
public final class com.fairychar.bag.utils.ReflectUtil
```

使用说明：[features/utilities/reflection.md](../features/utilities/reflection.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static <T,I> java.util.List<T> com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild(java.util.List<T>,java.lang.String,java.lang.String,I)
public static <T,I> java.util.List<T> com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent(java.lang.String,I,java.util.function.Function<java.util.List<I>, java.util.List<T>>)
public static <T,I> java.util.List<T> com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent(java.lang.String,java.util.List<I>,java.util.function.Function<java.util.List<I>, java.util.List<T>>)
public static <T,I> java.util.List<T> com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent(java.util.List<T>,java.lang.String,java.lang.String,I)
public static <T,I> void com.fairychar.bag.utils.ReflectUtil.recursiveSearch(java.util.List<T>,java.util.List<T>,java.lang.String,java.lang.String,I)
public static <T,P> java.util.List<T> com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild(java.lang.String,P,java.util.function.Function<java.util.List<P>, java.util.List<T>>)
public static <T,P> java.util.List<T> com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild(java.lang.String,java.util.List<P>,java.util.function.Function<java.util.List<P>, java.util.List<T>>)
public static <T> T com.fairychar.bag.utils.ReflectUtil.copyProperties(java.lang.Object,java.lang.Class<T>,boolean)
public static <T> T com.fairychar.bag.utils.ReflectUtil.mapToEntity(java.util.Map<java.lang.String, java.lang.Object>,java.lang.Class<T>)
public static <T> T com.fairychar.bag.utils.ReflectUtil.mapToEntity(java.util.Map<java.lang.String, java.lang.Object>,java.lang.Class<T>,boolean,boolean)
public static java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<com.fairychar.bag.utils.base.FieldContainer>> com.fairychar.bag.utils.ReflectUtil.recursiveSearchFieldValueByAnnotations(java.lang.Object,java.util.Collection<java.lang.Class<? extends java.lang.annotation.Annotation>>)
public static java.util.Map<java.lang.Class<? extends java.lang.annotation.Annotation>, java.util.List<java.lang.reflect.Field>> com.fairychar.bag.utils.ReflectUtil.recursiveSearchFieldByAnnotations(java.lang.Class,java.util.Collection<java.lang.Class<? extends java.lang.annotation.Annotation>>)
public static java.util.Map<java.lang.String, java.lang.Object> com.fairychar.bag.utils.ReflectUtil.entityToMap(java.lang.Object)
public static java.util.Map<java.lang.String, java.lang.Object> com.fairychar.bag.utils.ReflectUtil.entityToMap(java.lang.Object,boolean)
public static java.util.Set<java.lang.reflect.Field> com.fairychar.bag.utils.ReflectUtil.getClassFields(java.lang.Class<?>,boolean,boolean,boolean)
public static sun.misc.Unsafe com.fairychar.bag.utils.ReflectUtil.getUnsafe()
public static void com.fairychar.bag.utils.ReflectUtil.compareAndSwapInteger(java.lang.Integer,java.lang.Integer)
public static void com.fairychar.bag.utils.ReflectUtil.compareAndSwapLong(java.lang.Long,java.lang.Long)
public static void com.fairychar.bag.utils.ReflectUtil.copyProperties(java.lang.Object,java.lang.Object,boolean)
public static void com.fairychar.bag.utils.ReflectUtil.eraseValue(java.lang.Object,java.lang.Class<?>...)
public static void com.fairychar.bag.utils.ReflectUtil.eraseValue(java.lang.Object,java.lang.String)
public static void com.fairychar.bag.utils.ReflectUtil.keepValue(java.lang.Object,java.lang.String)
public static void com.fairychar.bag.utils.ReflectUtil.setInt(java.lang.Integer,java.lang.Integer)
public static void com.fairychar.bag.utils.ReflectUtil.setLong(java.lang.Long,java.lang.Long)
```

### public 字段 / 枚举常量

无。

