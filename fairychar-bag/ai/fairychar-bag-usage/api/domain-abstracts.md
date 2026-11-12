# `com.fairychar.bag.domain.abstracts`

[返回 API 索引](README.md)

[AbstractBalkingReference](#domain-abstracts-abstractbalkingreference) · [AbstractScheduleAction](#domain-abstracts-abstractscheduleaction)

<a id="domain-abstracts-abstractbalkingreference"></a>

## `com.fairychar.bag.domain.abstracts.AbstractBalkingReference`

类型声明：

```java
public abstract class com.fairychar.bag.domain.abstracts.AbstractBalkingReference<T>
```

使用说明：[features/concurrency/balking-reference.md](../features/concurrency/balking-reference.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.domain.concurrent.IBalkingReference<T>`。

继承接口导航： [查看声明](domain-concurrent.md#domain-concurrent-ibalkingreference)。

### public 构造器

```java
public com.fairychar.bag.domain.abstracts.AbstractBalkingReference(T)
```

### 当前类型声明的 public 方法

```java
public abstract boolean com.fairychar.bag.domain.abstracts.AbstractBalkingReference.doSave()
public synchronized boolean com.fairychar.bag.domain.abstracts.AbstractBalkingReference.change(T)
public synchronized boolean com.fairychar.bag.domain.abstracts.AbstractBalkingReference.save()
```

### public 字段 / 枚举常量

无。

<a id="domain-abstracts-abstractscheduleaction"></a>

## `com.fairychar.bag.domain.abstracts.AbstractScheduleAction`

类型声明：

```java
public abstract class com.fairychar.bag.domain.abstracts.AbstractScheduleAction
```

使用说明：[features/concurrency/action-schedule.md](../features/concurrency/action-schedule.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.function.Action`。

继承接口导航： [查看声明](function.md#function-action)。

### public 构造器

```java
public com.fairychar.bag.domain.abstracts.AbstractScheduleAction()
```

### 当前类型声明的 public 方法

```java
public abstract void com.fairychar.bag.domain.abstracts.AbstractScheduleAction.doAction() throws java.lang.RuntimeException
public synchronized void com.fairychar.bag.domain.abstracts.AbstractScheduleAction.interrupt(java.lang.Thread)
public synchronized void com.fairychar.bag.domain.abstracts.AbstractScheduleAction.interruptAll()
public void com.fairychar.bag.domain.abstracts.AbstractScheduleAction.doAction0() throws java.util.concurrent.TimeoutException,java.lang.InterruptedException
```

### public 字段 / 枚举常量

无。

