# `com.fairychar.bag.utils.TransactionUtil`

[返回包目录](utils.md)

<a id="utils-transactionutil"></a>

## `com.fairychar.bag.utils.TransactionUtil`

类型声明：

```java
public class com.fairychar.bag.utils.TransactionUtil
```

使用说明：[features/concurrency/async-transactions.md](../features/concurrency/async-transactions.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.utils.TransactionUtil()
```

### 当前类型声明的 public 方法

```java
public static java.util.concurrent.Future<?> com.fairychar.bag.utils.TransactionUtil.doWithTransactionAsync(com.fairychar.bag.function.Action,java.util.concurrent.atomic.AtomicBoolean,java.util.concurrent.CyclicBarrier,java.util.concurrent.ExecutorService,org.springframework.transaction.support.TransactionTemplate)
public static java.util.concurrent.Future<?> com.fairychar.bag.utils.TransactionUtil.doWithTransactionAsync(com.fairychar.bag.function.Action,java.util.concurrent.atomic.AtomicBoolean,java.util.concurrent.CyclicBarrier,java.util.concurrent.ExecutorService,org.springframework.transaction.support.TransactionTemplate,int)
```

### public 字段 / 枚举常量

无。

