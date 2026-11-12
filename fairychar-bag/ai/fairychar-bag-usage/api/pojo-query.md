# `com.fairychar.bag.pojo.query`

[返回 API 索引](README.md)

[DateBetweenQuery](#pojo-query-datebetweenquery) · [SimpleTypeQuery](#pojo-query-simpletypequery) · [TimeBetweenQuery](#pojo-query-timebetweenquery)

<a id="pojo-query-datebetweenquery"></a>

## `com.fairychar.bag.pojo.query.DateBetweenQuery`

类型声明：

```java
public class com.fairychar.bag.pojo.query.DateBetweenQuery
```

使用说明：[features/web/request-models.md](../features/web/request-models.md)。

父类：`java.lang.Object`。

接口：`java.io.Serializable`。

### public 构造器

```java
public com.fairychar.bag.pojo.query.DateBetweenQuery()
public com.fairychar.bag.pojo.query.DateBetweenQuery(java.time.LocalDate,java.time.LocalDate)
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.pojo.query.DateBetweenQuery.equals(java.lang.Object)
public com.fairychar.bag.pojo.query.DateBetweenQuery com.fairychar.bag.pojo.query.DateBetweenQuery.setFrom(java.time.LocalDate)
public com.fairychar.bag.pojo.query.DateBetweenQuery com.fairychar.bag.pojo.query.DateBetweenQuery.setTo(java.time.LocalDate)
public int com.fairychar.bag.pojo.query.DateBetweenQuery.hashCode()
public java.lang.String com.fairychar.bag.pojo.query.DateBetweenQuery.toString()
public java.time.LocalDate com.fairychar.bag.pojo.query.DateBetweenQuery.getFrom()
public java.time.LocalDate com.fairychar.bag.pojo.query.DateBetweenQuery.getTo()
```

### public 字段 / 枚举常量

无。

<a id="pojo-query-simpletypequery"></a>

## `com.fairychar.bag.pojo.query.SimpleTypeQuery`

类型声明：

```java
public class com.fairychar.bag.pojo.query.SimpleTypeQuery<T>
```

使用说明：[features/web/request-models.md](../features/web/request-models.md)。

父类：`java.lang.Object`。

接口：`java.io.Serializable`。

### public 构造器

```java
public com.fairychar.bag.pojo.query.SimpleTypeQuery()
public com.fairychar.bag.pojo.query.SimpleTypeQuery(T)
```

### 当前类型声明的 public 方法

```java
public T com.fairychar.bag.pojo.query.SimpleTypeQuery.getValue()
public boolean com.fairychar.bag.pojo.query.SimpleTypeQuery.equals(java.lang.Object)
public com.fairychar.bag.pojo.query.SimpleTypeQuery<T> com.fairychar.bag.pojo.query.SimpleTypeQuery.setValue(T)
public int com.fairychar.bag.pojo.query.SimpleTypeQuery.hashCode()
public java.lang.String com.fairychar.bag.pojo.query.SimpleTypeQuery.toString()
```

### public 字段 / 枚举常量

无。

<a id="pojo-query-timebetweenquery"></a>

## `com.fairychar.bag.pojo.query.TimeBetweenQuery`

类型声明：

```java
public class com.fairychar.bag.pojo.query.TimeBetweenQuery
```

使用说明：[features/web/request-models.md](../features/web/request-models.md)。

父类：`java.lang.Object`。

接口：`java.io.Serializable`。

### public 构造器

```java
public com.fairychar.bag.pojo.query.TimeBetweenQuery()
public com.fairychar.bag.pojo.query.TimeBetweenQuery(java.time.LocalDateTime,java.time.LocalDateTime)
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.pojo.query.TimeBetweenQuery.equals(java.lang.Object)
public com.fairychar.bag.pojo.query.TimeBetweenQuery com.fairychar.bag.pojo.query.TimeBetweenQuery.setFrom(java.time.LocalDateTime)
public com.fairychar.bag.pojo.query.TimeBetweenQuery com.fairychar.bag.pojo.query.TimeBetweenQuery.setTo(java.time.LocalDateTime)
public int com.fairychar.bag.pojo.query.TimeBetweenQuery.hashCode()
public java.lang.String com.fairychar.bag.pojo.query.TimeBetweenQuery.toString()
public java.time.LocalDateTime com.fairychar.bag.pojo.query.TimeBetweenQuery.getFrom()
public java.time.LocalDateTime com.fairychar.bag.pojo.query.TimeBetweenQuery.getTo()
```

### public 字段 / 枚举常量

无。

