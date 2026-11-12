# `com.fairychar.bag.function`

[返回 API 索引](README.md)

[Action](#function-action) · [IDataBaseShardingProcessor](#function-idatabaseshardingprocessor) · [IShardingProcessor](#function-ishardingprocessor) · [ITableShardingProcessor](#function-itableshardingprocessor)

<a id="function-action"></a>

## `com.fairychar.bag.function.Action`

类型声明：

```java
public abstract interface com.fairychar.bag.function.Action
```

使用说明：[features/function/action.md](../features/function/action.md)。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract void com.fairychar.bag.function.Action.doAction() throws java.lang.RuntimeException
```

### public 字段 / 枚举常量

无。

<a id="function-idatabaseshardingprocessor"></a>

## `com.fairychar.bag.function.IDataBaseShardingProcessor`

类型声明：

```java
public abstract interface com.fairychar.bag.function.IDataBaseShardingProcessor<R,P>
```

使用说明：[features/extensions/sharding.md](../features/extensions/sharding.md)。

接口：`com.fairychar.bag.function.IShardingProcessor<R, P>`。

继承接口导航： [查看声明](function.md#function-ishardingprocessor)。

### public 构造器

无。

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

无。

<a id="function-ishardingprocessor"></a>

## `com.fairychar.bag.function.IShardingProcessor`

类型声明：

```java
public abstract interface com.fairychar.bag.function.IShardingProcessor<R,P>
```

使用说明：[features/extensions/sharding.md](../features/extensions/sharding.md)。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract R com.fairychar.bag.function.IShardingProcessor.calculate(P)
public default int com.fairychar.bag.function.IShardingProcessor.calculateHash(P)
```

### public 字段 / 枚举常量

无。

<a id="function-itableshardingprocessor"></a>

## `com.fairychar.bag.function.ITableShardingProcessor`

类型声明：

```java
public abstract interface com.fairychar.bag.function.ITableShardingProcessor<R,P>
```

使用说明：[features/extensions/sharding.md](../features/extensions/sharding.md)。

接口：`com.fairychar.bag.function.IShardingProcessor<R, P>`。

继承接口导航： [查看声明](function.md#function-ishardingprocessor)。

### public 构造器

无。

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

无。

