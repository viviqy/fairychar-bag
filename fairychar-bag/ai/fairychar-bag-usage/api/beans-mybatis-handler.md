# `com.fairychar.bag.beans.mybatis.handler`

[返回 API 索引](README.md)

[AesTypeHandler](#beans-mybatis-handler-aestypehandler) · [RsaTypeHandler](#beans-mybatis-handler-rsatypehandler)

<a id="beans-mybatis-handler-aestypehandler"></a>

## `com.fairychar.bag.beans.mybatis.handler.AesTypeHandler`

类型声明：

```java
public class com.fairychar.bag.beans.mybatis.handler.AesTypeHandler
```

使用说明：[features/data/mybatis-crypto.md](../features/data/mybatis-crypto.md)。

父类：`org.apache.ibatis.type.BaseTypeHandler<java.lang.String>`。

### public 构造器

```java
public com.fairychar.bag.beans.mybatis.handler.AesTypeHandler()
```

### 当前类型声明的 public 方法

```java
public java.lang.String com.fairychar.bag.beans.mybatis.handler.AesTypeHandler.getNullableResult(java.sql.CallableStatement,int) throws java.sql.SQLException
public java.lang.String com.fairychar.bag.beans.mybatis.handler.AesTypeHandler.getNullableResult(java.sql.ResultSet,int) throws java.sql.SQLException
public java.lang.String com.fairychar.bag.beans.mybatis.handler.AesTypeHandler.getNullableResult(java.sql.ResultSet,java.lang.String) throws java.sql.SQLException
public static java.lang.String com.fairychar.bag.beans.mybatis.handler.AesTypeHandler.decrypt(java.lang.String)
public static java.lang.String com.fairychar.bag.beans.mybatis.handler.AesTypeHandler.encryptBase64(java.lang.String)
public static java.lang.String com.fairychar.bag.beans.mybatis.handler.AesTypeHandler.encryptHex(java.lang.String)
public static void com.fairychar.bag.beans.mybatis.handler.AesTypeHandler.setAes(cn.hutool.crypto.symmetric.AES)
public void com.fairychar.bag.beans.mybatis.handler.AesTypeHandler.setNonNullParameter(java.sql.PreparedStatement,int,java.lang.String,org.apache.ibatis.type.JdbcType) throws java.sql.SQLException
```

### public 字段 / 枚举常量

无。

<a id="beans-mybatis-handler-rsatypehandler"></a>

## `com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler`

类型声明：

```java
public class com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler
```

使用说明：[features/data/mybatis-crypto.md](../features/data/mybatis-crypto.md)。

父类：`org.apache.ibatis.type.BaseTypeHandler<java.lang.String>`。

### public 构造器

```java
public com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler()
```

### 当前类型声明的 public 方法

```java
public java.lang.String com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler.getNullableResult(java.sql.CallableStatement,int) throws java.sql.SQLException
public java.lang.String com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler.getNullableResult(java.sql.ResultSet,int) throws java.sql.SQLException
public java.lang.String com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler.getNullableResult(java.sql.ResultSet,java.lang.String) throws java.sql.SQLException
public static java.lang.String com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler.decrypt(java.lang.String)
public static java.lang.String com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler.encryptBase64(java.lang.String)
public static void com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler.setRsa(cn.hutool.crypto.asymmetric.RSA)
public void com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler.setNonNullParameter(java.sql.PreparedStatement,int,java.lang.String,org.apache.ibatis.type.JdbcType) throws java.sql.SQLException
```

### public 字段 / 枚举常量

无。

