# `com.fairychar.bag.template`

[返回 API 索引](README.md)

[ActionSelectorTemplate](#template-actionselectortemplate) · [CacheOperateTemplate](#template-cacheoperatetemplate)

<a id="template-actionselectortemplate"></a>

## `com.fairychar.bag.template.ActionSelectorTemplate`

类型声明：

```java
public class com.fairychar.bag.template.ActionSelectorTemplate
```

使用说明：[features/concurrency/task-selector.md](../features/concurrency/task-selector.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.template.ActionSelectorTemplate()
public com.fairychar.bag.template.ActionSelectorTemplate(java.util.concurrent.ExecutorService,java.util.concurrent.ExecutorService)
```

### 当前类型声明的 public 方法

```java
public void com.fairychar.bag.template.ActionSelectorTemplate.put(com.fairychar.bag.extension.concurrent.ActionSchedule)
public void com.fairychar.bag.template.ActionSelectorTemplate.put(java.lang.String,long,com.fairychar.bag.domain.abstracts.AbstractScheduleAction)
public void com.fairychar.bag.template.ActionSelectorTemplate.put(java.lang.String,long,com.fairychar.bag.function.Action)
public void com.fairychar.bag.template.ActionSelectorTemplate.remove(java.lang.String)
public void com.fairychar.bag.template.ActionSelectorTemplate.remove(java.lang.String,boolean)
public void com.fairychar.bag.template.ActionSelectorTemplate.setTimePause(long)
public void com.fairychar.bag.template.ActionSelectorTemplate.shutdownGracefully()
public void com.fairychar.bag.template.ActionSelectorTemplate.shutdownNow()
public void com.fairychar.bag.template.ActionSelectorTemplate.start()
```

### public 字段 / 枚举常量

无。

<a id="template-cacheoperatetemplate"></a>

## `com.fairychar.bag.template.CacheOperateTemplate`

类型声明：

```java
public final class com.fairychar.bag.template.CacheOperateTemplate
```

使用说明：[features/data/cache-read-through.md](../features/data/cache-read-through.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static <C> C com.fairychar.bag.template.CacheOperateTemplate.get(java.util.function.Supplier<C>,java.util.function.Supplier<C>,java.util.function.Consumer<C>,java.lang.Object)
public static <C> C com.fairychar.bag.template.CacheOperateTemplate.get(java.util.function.Supplier<C>,java.util.function.Supplier<C>,java.util.function.Consumer<C>,org.redisson.api.RLock)
```

### public 字段 / 枚举常量

无。

