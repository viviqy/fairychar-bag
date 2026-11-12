# `com.fairychar.bag.extension.concurrent`

[返回 API 索引](README.md)

[ActionSchedule](#extension-concurrent-actionschedule) · [AssignableFactory](#extension-concurrent-assignablefactory) · [RepeatTaskExecutor](#extension-concurrent-repeattaskexecutor) · [RoundTaskExecutor](#extension-concurrent-roundtaskexecutor)

<a id="extension-concurrent-actionschedule"></a>

## `com.fairychar.bag.extension.concurrent.ActionSchedule`

类型声明：

```java
public final class com.fairychar.bag.extension.concurrent.ActionSchedule
```

使用说明：[features/concurrency/action-schedule.md](../features/concurrency/action-schedule.md)。

父类：`java.lang.Object`。

接口：`java.lang.Comparable<com.fairychar.bag.extension.concurrent.ActionSchedule>`。

### public 构造器

```java
public com.fairychar.bag.extension.concurrent.ActionSchedule(java.lang.String,long,com.fairychar.bag.domain.abstracts.AbstractScheduleAction)
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.extension.concurrent.ActionSchedule.equals(java.lang.Object)
public boolean com.fairychar.bag.extension.concurrent.ActionSchedule.isWorking()
public com.fairychar.bag.domain.abstracts.AbstractScheduleAction com.fairychar.bag.extension.concurrent.ActionSchedule.getAction()
public int com.fairychar.bag.extension.concurrent.ActionSchedule.compareTo(com.fairychar.bag.extension.concurrent.ActionSchedule)
public int com.fairychar.bag.extension.concurrent.ActionSchedule.hashCode()
public java.lang.String com.fairychar.bag.extension.concurrent.ActionSchedule.getTaskName()
public java.lang.String com.fairychar.bag.extension.concurrent.ActionSchedule.toString()
public java.util.concurrent.atomic.AtomicBoolean com.fairychar.bag.extension.concurrent.ActionSchedule.getWorking()
public java.util.concurrent.atomic.AtomicBoolean com.fairychar.bag.extension.concurrent.ActionSchedule.getWorkingAtomic()
public java.util.concurrent.atomic.AtomicLong com.fairychar.bag.extension.concurrent.ActionSchedule.getLastExecuteTimeAtomic()
public long com.fairychar.bag.extension.concurrent.ActionSchedule.getLastExecuteTime()
public long com.fairychar.bag.extension.concurrent.ActionSchedule.getPeriod()
public void com.fairychar.bag.extension.concurrent.ActionSchedule.setAction(com.fairychar.bag.domain.abstracts.AbstractScheduleAction)
public void com.fairychar.bag.extension.concurrent.ActionSchedule.setPeriod(long)
public void com.fairychar.bag.extension.concurrent.ActionSchedule.setTaskName(java.lang.String)
```

### public 字段 / 枚举常量

无。

<a id="extension-concurrent-assignablefactory"></a>

## `com.fairychar.bag.extension.concurrent.AssignableFactory`

类型声明：

```java
public final class com.fairychar.bag.extension.concurrent.AssignableFactory
```

使用说明：[features/concurrency/weighted-permits.md](../features/concurrency/weighted-permits.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
@Deprecated public static com.fairychar.bag.extension.concurrent.AssignableFactory com.fairychar.bag.extension.concurrent.AssignableFactory.recruitWorkers(int)
public <T> T com.fairychar.bag.extension.concurrent.AssignableFactory.doWork(java.util.function.Supplier<T>,int) throws java.util.concurrent.ExecutionException,java.lang.InterruptedException
public <T> java.util.concurrent.Future<T> com.fairychar.bag.extension.concurrent.AssignableFactory.doWorkFuture(java.util.function.Supplier<T>,int) throws java.util.concurrent.ExecutionException,java.lang.InterruptedException
public int com.fairychar.bag.extension.concurrent.AssignableFactory.getAvailableWorkers()
public static com.fairychar.bag.extension.concurrent.AssignableFactory com.fairychar.bag.extension.concurrent.AssignableFactory.recruitWorkers(int,java.util.concurrent.ExecutorService)
public void com.fairychar.bag.extension.concurrent.AssignableFactory.doWork(com.fairychar.bag.function.Action)
public void com.fairychar.bag.extension.concurrent.AssignableFactory.doWork(com.fairychar.bag.function.Action,int)
public void com.fairychar.bag.extension.concurrent.AssignableFactory.doWork(com.fairychar.bag.function.Action,int,java.util.function.Consumer<java.lang.Exception>)
```

### public 字段 / 枚举常量

无。

<a id="extension-concurrent-repeattaskexecutor"></a>

## `com.fairychar.bag.extension.concurrent.RepeatTaskExecutor`

类型声明：

```java
public final class com.fairychar.bag.extension.concurrent.RepeatTaskExecutor
```

使用说明：[features/concurrency/repeat-tasks.md](../features/concurrency/repeat-tasks.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public long com.fairychar.bag.extension.concurrent.RepeatTaskExecutor.getExecutedTimes()
public static com.fairychar.bag.extension.concurrent.RepeatTaskExecutor com.fairychar.bag.extension.concurrent.RepeatTaskExecutor.createCycle(java.util.List<com.fairychar.bag.function.Action>,java.lang.String)
public void com.fairychar.bag.extension.concurrent.RepeatTaskExecutor.start()
public void com.fairychar.bag.extension.concurrent.RepeatTaskExecutor.start(java.util.function.Consumer<java.lang.InterruptedException>,java.util.function.Consumer<java.util.concurrent.TimeoutException>,java.util.function.Consumer<java.util.concurrent.BrokenBarrierException>,long)
public void com.fairychar.bag.extension.concurrent.RepeatTaskExecutor.stop()
```

### public 字段 / 枚举常量

无。

<a id="extension-concurrent-roundtaskexecutor"></a>

## `com.fairychar.bag.extension.concurrent.RoundTaskExecutor`

类型声明：

```java
public final class com.fairychar.bag.extension.concurrent.RoundTaskExecutor
```

使用说明：[features/concurrency/round-tasks.md](../features/concurrency/round-tasks.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public java.util.concurrent.atomic.AtomicInteger com.fairychar.bag.extension.concurrent.RoundTaskExecutor.getExecuteRound()
public java.util.concurrent.atomic.AtomicInteger com.fairychar.bag.extension.concurrent.RoundTaskExecutor.getExecutedRound()
public java.util.concurrent.atomic.AtomicInteger com.fairychar.bag.extension.concurrent.RoundTaskExecutor.getExecutedTaskCount()
public static com.fairychar.bag.extension.concurrent.RoundTaskExecutor com.fairychar.bag.extension.concurrent.RoundTaskExecutor.boxedTaskList(java.util.List<java.util.List<com.fairychar.bag.function.Action>>)
public static com.fairychar.bag.extension.concurrent.RoundTaskExecutor com.fairychar.bag.extension.concurrent.RoundTaskExecutor.boxedTaskList(java.util.List<java.util.List<com.fairychar.bag.function.Action>>,int)
public void com.fairychar.bag.extension.concurrent.RoundTaskExecutor.awaitTaskDone()
public void com.fairychar.bag.extension.concurrent.RoundTaskExecutor.start()
public void com.fairychar.bag.extension.concurrent.RoundTaskExecutor.start(java.util.function.Consumer<java.lang.InterruptedException>,java.util.function.Consumer<java.util.concurrent.TimeoutException>)
public void com.fairychar.bag.extension.concurrent.RoundTaskExecutor.stop()
```

### public 字段 / 枚举常量

无。

