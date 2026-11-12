# `com.fairychar.bag.utils.test`

[返回 API 索引](README.md)

[TaskTestUtil](#utils-test-tasktestutil)

<a id="utils-test-tasktestutil"></a>

## `com.fairychar.bag.utils.test.TaskTestUtil`

类型声明：

```java
public final class com.fairychar.bag.utils.test.TaskTestUtil
```

使用说明：[features/concurrency/task-test.md](../features/concurrency/task-test.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public static java.util.concurrent.ExecutorService com.fairychar.bag.utils.test.TaskTestUtil.createThreadPool(java.lang.String,int)
public static java.util.concurrent.ExecutorService com.fairychar.bag.utils.test.TaskTestUtil.createThreadPoolByCpuCore(java.lang.String)
public static java.util.concurrent.ExecutorService com.fairychar.bag.utils.test.TaskTestUtil.createThreadPoolByCpuCore(java.lang.String,int)
public static long com.fairychar.bag.utils.test.TaskTestUtil.batchRunSync(com.fairychar.bag.function.Action,int,java.util.concurrent.ExecutorService)
public static long com.fairychar.bag.utils.test.TaskTestUtil.batchRunSync(java.util.List<com.fairychar.bag.function.Action>,java.util.concurrent.ExecutorService)
public static long com.fairychar.bag.utils.test.TaskTestUtil.getWasteMillis(com.fairychar.bag.function.Action,int)
public static void com.fairychar.bag.utils.test.TaskTestUtil.batchRunAsync(com.fairychar.bag.function.Action,int,java.util.concurrent.ExecutorService)
public static void com.fairychar.bag.utils.test.TaskTestUtil.batchRunAsync(java.util.List<com.fairychar.bag.function.Action>,java.util.concurrent.ExecutorService)
public static void com.fairychar.bag.utils.test.TaskTestUtil.concurrentRunAsync(java.util.List<com.fairychar.bag.function.Action>)
public static void com.fairychar.bag.utils.test.TaskTestUtil.concurrentRunAsync(java.util.List<com.fairychar.bag.function.Action>,java.util.concurrent.ExecutorService)
```

### public 字段 / 枚举常量

无。

