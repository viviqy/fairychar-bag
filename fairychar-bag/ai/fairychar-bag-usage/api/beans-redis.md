# `com.fairychar.bag.beans.redis`

[返回 API 索引](README.md)

[GzipStringSerializer](#beans-redis-gzipstringserializer) · [PrefixStringSerializer](#beans-redis-prefixstringserializer)

<a id="beans-redis-gzipstringserializer"></a>

## `com.fairychar.bag.beans.redis.GzipStringSerializer`

类型声明：

```java
public class com.fairychar.bag.beans.redis.GzipStringSerializer
```

使用说明：[features/data/redis-gzip.md](../features/data/redis-gzip.md)。

父类：`org.springframework.data.redis.serializer.StringRedisSerializer`。

### public 构造器

```java
public com.fairychar.bag.beans.redis.GzipStringSerializer()
```

### 当前类型声明的 public 方法

```java
public byte[] com.fairychar.bag.beans.redis.GzipStringSerializer.serialize(java.lang.String)
public java.lang.String com.fairychar.bag.beans.redis.GzipStringSerializer.deserialize(byte[])
```

### public 字段 / 枚举常量

无。

<a id="beans-redis-prefixstringserializer"></a>

## `com.fairychar.bag.beans.redis.PrefixStringSerializer`

类型声明：

```java
public class com.fairychar.bag.beans.redis.PrefixStringSerializer
```

使用说明：[features/data/redis-prefix.md](../features/data/redis-prefix.md)。

父类：`org.springframework.data.redis.serializer.StringRedisSerializer`。

### public 构造器

```java
public com.fairychar.bag.beans.redis.PrefixStringSerializer(java.lang.String)
public com.fairychar.bag.beans.redis.PrefixStringSerializer(java.nio.charset.Charset,java.lang.String)
```

### 当前类型声明的 public 方法

```java
public byte[] com.fairychar.bag.beans.redis.PrefixStringSerializer.serialize(java.lang.String)
public java.lang.String com.fairychar.bag.beans.redis.PrefixStringSerializer.deserialize(byte[])
```

### public 字段 / 枚举常量

无。

