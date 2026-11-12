# `com.fairychar.bag.extension.action.condition.bool`

[返回 API 索引](README.md)

[AbstractActionFlow](#extension-action-condition-bool-abstractactionflow) · [ActionFlow](#extension-action-condition-bool-actionflow) · [FlowBuilder](#extension-action-condition-bool-flowbuilder) · [ParentActionCondition](#extension-action-condition-bool-parentactioncondition) · [RootAction](#extension-action-condition-bool-rootaction)

<a id="extension-action-condition-bool-abstractactionflow"></a>

## `com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow`

类型声明：

```java
public abstract class com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow<C,N>
```

使用说明：[features/extensions/action-flow.md](../features/extensions/action-flow.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.extension.action.condition.bool.ActionFlow<C, N>`。

继承接口导航： [查看声明](extension-action-condition-bool.md#extension-action-condition-bool-actionflow)。

### public 构造器

```java
public com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow()
```

### 当前类型声明的 public 方法

```java
public com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow.getFalseFlow()
public com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow.getTrueFlow()
public void com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow.callNext(C)
public void com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow.setFalseFlow(com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow)
public void com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow.setTrueFlow(com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow)
```

### public 字段 / 枚举常量

无。

<a id="extension-action-condition-bool-actionflow"></a>

## `com.fairychar.bag.extension.action.condition.bool.ActionFlow`

类型声明：

```java
public abstract interface com.fairychar.bag.extension.action.condition.bool.ActionFlow<T,C>
```

使用说明：[features/extensions/action-flow.md](../features/extensions/action-flow.md)。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract C com.fairychar.bag.extension.action.condition.bool.ActionFlow.getNextParam(T)
public abstract boolean com.fairychar.bag.extension.action.condition.bool.ActionFlow.compute(T)
public abstract com.fairychar.bag.extension.action.condition.bool.ActionFlow<T, C> com.fairychar.bag.extension.action.condition.bool.ActionFlow.instanceBean()
public abstract java.util.Set<com.fairychar.bag.extension.action.condition.bool.ParentActionCondition> com.fairychar.bag.extension.action.condition.bool.ActionFlow.getParentClassSet()
public abstract void com.fairychar.bag.extension.action.condition.bool.ActionFlow.callNext(T)
public default java.util.Set<java.lang.String> com.fairychar.bag.extension.action.condition.bool.ActionFlow.group()
```

### public 字段 / 枚举常量

无。

<a id="extension-action-condition-bool-flowbuilder"></a>

## `com.fairychar.bag.extension.action.condition.bool.FlowBuilder`

类型声明：

```java
public class com.fairychar.bag.extension.action.condition.bool.FlowBuilder
```

使用说明：[features/extensions/action-flow.md](../features/extensions/action-flow.md)。

父类：`java.lang.Object`。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow com.fairychar.bag.extension.action.condition.bool.FlowBuilder.buildFlow()
public java.lang.String com.fairychar.bag.extension.action.condition.bool.FlowBuilder.convertAsJsonSchema()
public static com.fairychar.bag.extension.action.condition.bool.FlowBuilder com.fairychar.bag.extension.action.condition.bool.FlowBuilder.fromClasses(java.util.Set<java.lang.Class<com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow>>)
```

### public 字段 / 枚举常量

无。

<a id="extension-action-condition-bool-parentactioncondition"></a>

## `com.fairychar.bag.extension.action.condition.bool.ParentActionCondition`

类型声明：

```java
public class com.fairychar.bag.extension.action.condition.bool.ParentActionCondition
```

使用说明：[features/extensions/action-flow.md](../features/extensions/action-flow.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.extension.action.condition.bool.ParentActionCondition(java.lang.Class<? extends com.fairychar.bag.extension.action.condition.bool.ActionFlow>,boolean)
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.extension.action.condition.bool.ParentActionCondition.equals(java.lang.Object)
public boolean com.fairychar.bag.extension.action.condition.bool.ParentActionCondition.isCondition()
public int com.fairychar.bag.extension.action.condition.bool.ParentActionCondition.hashCode()
public java.lang.Class<? extends com.fairychar.bag.extension.action.condition.bool.ActionFlow> com.fairychar.bag.extension.action.condition.bool.ParentActionCondition.getParentClass()
```

### public 字段 / 枚举常量

无。

<a id="extension-action-condition-bool-rootaction"></a>

## `com.fairychar.bag.extension.action.condition.bool.RootAction`

类型声明：

```java
public class com.fairychar.bag.extension.action.condition.bool.RootAction
```

使用说明：[features/extensions/action-flow.md](../features/extensions/action-flow.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.extension.action.condition.bool.ActionFlow`。

继承接口导航： [查看声明](extension-action-condition-bool.md#extension-action-condition-bool-actionflow)。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.extension.action.condition.bool.RootAction.compute(java.lang.Object)
public com.fairychar.bag.extension.action.condition.bool.ActionFlow com.fairychar.bag.extension.action.condition.bool.RootAction.instanceBean()
public java.lang.Object com.fairychar.bag.extension.action.condition.bool.RootAction.getNextParam(java.lang.Object)
public java.util.Set<com.fairychar.bag.extension.action.condition.bool.ParentActionCondition> com.fairychar.bag.extension.action.condition.bool.RootAction.getParentClassSet()
public static com.fairychar.bag.extension.action.condition.bool.ParentActionCondition com.fairychar.bag.extension.action.condition.bool.RootAction.getCondition()
public void com.fairychar.bag.extension.action.condition.bool.RootAction.callNext(java.lang.Object)
```

### public 字段 / 枚举常量

无。

