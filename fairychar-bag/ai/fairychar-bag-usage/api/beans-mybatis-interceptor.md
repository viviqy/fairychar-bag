# `com.fairychar.bag.beans.mybatis.interceptor`

[返回 API 索引](README.md)

[ITenantSkipper](#beans-mybatis-interceptor-itenantskipper) · [ITenantSwitcher](#beans-mybatis-interceptor-itenantswitcher) · [SimpleTenantSkipper](#beans-mybatis-interceptor-simpletenantskipper) · [SkipableTenantLineInnerInterceptor](#beans-mybatis-interceptor-skipabletenantlineinnerinterceptor) · [SwitchableTenantLineInnerInterceptor](#beans-mybatis-interceptor-switchabletenantlineinnerinterceptor) · [TenantSwitcher](#beans-mybatis-interceptor-tenantswitcher)

<a id="beans-mybatis-interceptor-itenantskipper"></a>

## `com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper`

类型声明：

```java
public abstract interface com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper
```

使用说明：[features/data/tenant-isolation.md](../features/data/tenant-isolation.md)。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract boolean com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper.getSkip()
public abstract void com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper.cleanContext()
public abstract void com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper.setSkip(boolean)
```

### public 字段 / 枚举常量

无。

<a id="beans-mybatis-interceptor-itenantswitcher"></a>

## `com.fairychar.bag.beans.mybatis.interceptor.ITenantSwitcher`

类型声明：

```java
public abstract interface com.fairychar.bag.beans.mybatis.interceptor.ITenantSwitcher
```

使用说明：[features/data/tenant-isolation.md](../features/data/tenant-isolation.md)。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public abstract boolean com.fairychar.bag.beans.mybatis.interceptor.ITenantSwitcher.use()
```

### public 字段 / 枚举常量

无。

<a id="beans-mybatis-interceptor-simpletenantskipper"></a>

## `com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper`

类型声明：

```java
public class com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper
```

使用说明：[features/data/tenant-isolation.md](../features/data/tenant-isolation.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper`。

继承接口导航： [查看声明](beans-mybatis-interceptor.md#beans-mybatis-interceptor-itenantskipper)。

### public 构造器

```java
public com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper()
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper.getSkip()
public void com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper.cleanContext()
public void com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper.setSkip(boolean)
```

### public 字段 / 枚举常量

无。

<a id="beans-mybatis-interceptor-skipabletenantlineinnerinterceptor"></a>

## `com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor`

类型声明：

```java
public class com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor
```

使用说明：[features/data/tenant-isolation.md](../features/data/tenant-isolation.md)。

父类：`com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor`。

### public 构造器

```java
public com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor(com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler)
public com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor(com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler,com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper)
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor.equals(java.lang.Object)
public int com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor.hashCode()
public void com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor.beforeQuery(org.apache.ibatis.executor.Executor,org.apache.ibatis.mapping.MappedStatement,java.lang.Object,org.apache.ibatis.session.RowBounds,org.apache.ibatis.session.ResultHandler,org.apache.ibatis.mapping.BoundSql)
```

### public 字段 / 枚举常量

无。

<a id="beans-mybatis-interceptor-switchabletenantlineinnerinterceptor"></a>

## `com.fairychar.bag.beans.mybatis.interceptor.SwitchableTenantLineInnerInterceptor`

类型声明：

```java
public class com.fairychar.bag.beans.mybatis.interceptor.SwitchableTenantLineInnerInterceptor
```

使用说明：[features/data/tenant-isolation.md](../features/data/tenant-isolation.md)。

父类：`com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor`。

### public 构造器

```java
public com.fairychar.bag.beans.mybatis.interceptor.SwitchableTenantLineInnerInterceptor(com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler)
```

### 当前类型声明的 public 方法

```java
public void com.fairychar.bag.beans.mybatis.interceptor.SwitchableTenantLineInnerInterceptor.beforeQuery(org.apache.ibatis.executor.Executor,org.apache.ibatis.mapping.MappedStatement,java.lang.Object,org.apache.ibatis.session.RowBounds,org.apache.ibatis.session.ResultHandler,org.apache.ibatis.mapping.BoundSql)
```

### public 字段 / 枚举常量

无。

<a id="beans-mybatis-interceptor-tenantswitcher"></a>

## `com.fairychar.bag.beans.mybatis.interceptor.TenantSwitcher`

类型声明：

```java
public class com.fairychar.bag.beans.mybatis.interceptor.TenantSwitcher
```

使用说明：[features/data/tenant-isolation.md](../features/data/tenant-isolation.md)。

父类：`java.lang.Object`。

接口：`com.fairychar.bag.beans.mybatis.interceptor.ITenantSwitcher`。

继承接口导航： [查看声明](beans-mybatis-interceptor.md#beans-mybatis-interceptor-itenantswitcher)。

### public 构造器

```java
public com.fairychar.bag.beans.mybatis.interceptor.TenantSwitcher(boolean)
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.beans.mybatis.interceptor.TenantSwitcher.use()
```

### public 字段 / 枚举常量

无。

