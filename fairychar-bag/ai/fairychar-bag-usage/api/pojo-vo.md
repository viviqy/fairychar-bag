# `com.fairychar.bag.pojo.vo`

[返回 API 索引](README.md)

[HttpResult](#pojo-vo-httpresult)

<a id="pojo-vo-httpresult"></a>

## `com.fairychar.bag.pojo.vo.HttpResult`

类型声明：

```java
public class com.fairychar.bag.pojo.vo.HttpResult<T>
```

使用说明：[features/web/http-result.md](../features/web/http-result.md)。

父类：`java.lang.Object`。

接口：`java.io.Serializable`。

### public 构造器

```java
public com.fairychar.bag.pojo.vo.HttpResult()
public com.fairychar.bag.pojo.vo.HttpResult(int,T,java.lang.String)
```

### 当前类型声明的 public 方法

```java
public T com.fairychar.bag.pojo.vo.HttpResult.getData()
public boolean com.fairychar.bag.pojo.vo.HttpResult.equals(java.lang.Object)
public com.fairychar.bag.pojo.vo.HttpResult<T> com.fairychar.bag.pojo.vo.HttpResult.setCode(int)
public com.fairychar.bag.pojo.vo.HttpResult<T> com.fairychar.bag.pojo.vo.HttpResult.setData(T)
public com.fairychar.bag.pojo.vo.HttpResult<T> com.fairychar.bag.pojo.vo.HttpResult.setMsg(java.lang.String)
public int com.fairychar.bag.pojo.vo.HttpResult.getCode()
public int com.fairychar.bag.pojo.vo.HttpResult.hashCode()
public java.lang.String com.fairychar.bag.pojo.vo.HttpResult.getMsg()
public java.lang.String com.fairychar.bag.pojo.vo.HttpResult.toString()
public static <T> com.fairychar.bag.pojo.vo.HttpResult<T> com.fairychar.bag.pojo.vo.HttpResult.fail()
public static <T> com.fairychar.bag.pojo.vo.HttpResult<T> com.fairychar.bag.pojo.vo.HttpResult.fail(T)
public static <T> com.fairychar.bag.pojo.vo.HttpResult<T> com.fairychar.bag.pojo.vo.HttpResult.fail(com.fairychar.bag.domain.exceptions.RestErrorCode)
public static <T> com.fairychar.bag.pojo.vo.HttpResult<T> com.fairychar.bag.pojo.vo.HttpResult.fail(com.fairychar.bag.domain.exceptions.RestErrorCode,T)
public static <T> com.fairychar.bag.pojo.vo.HttpResult<T> com.fairychar.bag.pojo.vo.HttpResult.ok(T)
public static com.fairychar.bag.pojo.vo.HttpResult com.fairychar.bag.pojo.vo.HttpResult.ok()
public static com.fairychar.bag.pojo.vo.HttpResult com.fairychar.bag.pojo.vo.HttpResult.response(org.springframework.http.HttpStatus,com.fairychar.bag.domain.exceptions.RestErrorCode,java.lang.Object)
public static com.fairychar.bag.pojo.vo.HttpResult com.fairychar.bag.pojo.vo.HttpResult.response(org.springframework.http.HttpStatus,com.fairychar.bag.domain.exceptions.RestErrorCode,java.lang.Object,java.lang.String)
```

### public 字段 / 枚举常量

无。

