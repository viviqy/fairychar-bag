# `com.fairychar.bag.domain.exceptions.RestErrorCode`

[返回包目录](domain-exceptions.md)

<a id="domain-exceptions-resterrorcode"></a>

## `com.fairychar.bag.domain.exceptions.RestErrorCode`

类型声明：

```java
public final enum com.fairychar.bag.domain.exceptions.RestErrorCode
```

使用说明：[features/web/error-code.md](../features/web/error-code.md)。

父类：`java.lang.Enum<com.fairychar.bag.domain.exceptions.RestErrorCode>`。

接口：`com.fairychar.bag.domain.exceptions.IRestErrorCode`。

继承接口导航： [查看声明](domain-exceptions.md#domain-exceptions-iresterrorcode)。

### public 构造器

无。

### 当前类型声明的 public 方法

```java
public int com.fairychar.bag.domain.exceptions.RestErrorCode.getCode()
public java.lang.String com.fairychar.bag.domain.exceptions.RestErrorCode.getMessage()
public static com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.valueOf(java.lang.String)
public static com.fairychar.bag.domain.exceptions.RestErrorCode[] com.fairychar.bag.domain.exceptions.RestErrorCode.values()
```

### public 字段 / 枚举常量

```java
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.ACCESS_DEFINED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.AUDIT_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.AUTHENTICATION_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.CONTENT_TYPE_NOT_SUPPORT [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_CONVERT_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_DELETE_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_EXIST [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_HAS_RELATION [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_HIDDEN [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_LOAD_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_LOCKED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_NOT_EXIST [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_SYNC_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_TRANSFER_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DATA_UPDATE_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.DUPLICATE_SAVE [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.FALLBACK [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.FILE_EMPTY [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.FILE_FORMAT_NOT_SUPPORT [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.FILE_NAME_ILLEGAL [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.FILE_TOO_LARGE [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.FILE_TOO_SMALL [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.FILE_UPLOAD_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.GENERATE_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.LOCK_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.OPERATION_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.PARAM_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.PARAM_INVALIDATE [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.PASSWORD_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.PERMISSION_FROZEN [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.RATE_LIMIT_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.ROLE_FROZEN [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.SIGN_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.SYNC_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.SYSTEM_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.THIRD_CALLBACK_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.THIRD_REQUEST_FAILED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.TOKEN_EXPIRED [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.TOKEN_INVALID [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.TOKEN_NOT_EXIST [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.UNKNOWN_ERROR [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.USER_FROZEN [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.USER_NOT_FOUND [enum constant]
public static final com.fairychar.bag.domain.exceptions.RestErrorCode com.fairychar.bag.domain.exceptions.RestErrorCode.USER_NO_PERMISSION [enum constant]
```

