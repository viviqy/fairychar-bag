# Web REST AOP And Lock Reference

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。本文件只保留说明、约束和 API 语义；代码示例放在 `../scripts/`。

## 统一响应和异常

### HttpResult

位置: `com.fairychar.bag.pojo.vo.HttpResult`

字段:

- `code`: 业务码。
- `data`: 返回数据，字段本身带 `@FuzzyValue`，可配合 `@FuzzyResult(field = "data")` 对包装数据脱敏。
- `msg`: 消息。

常用方法:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `HttpResult`。


`response(...)` 会通过 `RequestUtil.getCurrentResponse()` 设置 HTTP 状态码，必须在 Web 请求线程中使用。

### RestErrorCode

位置: `com.fairychar.bag.domain.exceptions.RestErrorCode`

错误码按区间分组:

- `10000-11000`: 参数、文件类。
- `12000+`: 数据操作类。
- `13000-14000`: 当前源码预留，未定义枚举。
- `14000+`: 权限类。
- `18000+`: 通用业务异常。
- `19000+`: 微服务类。
- `20000+`: 系统类。

使用规则:

- 写业务代码前先查下表，优先复用已有 `RestErrorCode`。
- 只有语义确实不存在时才新增枚举。
- 新增业务错误码时优先实现 `IRestErrorCode` 或扩展现有枚举风格，不要在业务代码中散落裸数字和裸字符串。
- 表中的 `code` 是 Java 源码中数字下划线去掉后的实际 int 值。
- `FILE_TOO_LARGE` 当前源码为 `1_00013`，实际 int 值是 `100013`，这不是文档笔误。

#### 参数和文件类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `PARAM_INVALIDATE` | `10000` | 参数校验失败 | Hibernate Validator、`@Valid`、字段约束校验失败 |
| `CONTENT_TYPE_NOT_SUPPORT` | `10001` | 请求类型不支持 | `Content-Type` 不符合接口要求 |
| `PARAM_ERROR` | `10002` | 参数错误 | 参数存在但业务格式、组合关系或语义错误 |
| `FILE_FORMAT_NOT_SUPPORT` | `10012` | 文件类型不支持 | 上传文件扩展名、MIME 或内容类型不支持 |
| `FILE_TOO_LARGE` | `100013` | 文件超大 | 上传文件超过允许大小；注意源码实际值为 `100013` |
| `FILE_TOO_SMALL` | `10014` | 文件太小 | 上传文件低于允许大小 |
| `FILE_EMPTY` | `10015` | 文件为空 | 上传文件为空或无内容 |
| `FILE_NAME_ILLEGAL` | `10016` | 文件名不合法 | 文件名包含非法字符、路径穿越或不符合命名规则 |
| `FILE_UPLOAD_FAILED` | `10017` | 文件上传失败 | 文件传输、落盘、对象存储写入失败 |

#### 数据操作类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `DATA_EXIST` | `12000` | 数据已存在 | 创建前唯一性检查发现已有数据 |
| `DATA_NOT_EXIST` | `12001` | 数据不存在 | 按 id、编码或条件查询不到数据 |
| `DUPLICATE_SAVE` | `12002` | 重复保存 | 幂等、重复提交、重复创建 |
| `DATA_DELETE_FAILED` | `12003` | 数据删除失败 | 删除数据库记录、缓存或资源失败 |
| `DATA_UPDATE_FAILED` | `12004` | 数据更新失败 | 更新数据库记录、状态流转或持久化失败 |
| `DATA_LOCKED` | `12005` | 数据被锁定 | 数据处于锁定状态，不能修改或删除 |
| `DATA_HIDDEN` | `12006` | 数据不可见 | 数据存在但当前上下文不可见 |
| `DATA_SYNC_ERROR` | `12007` | 数据同步错误 | 内外部系统或缓存同步异常 |
| `DATA_TRANSFER_ERROR` | `12008` | 数据传输错误 | 数据搬运、导入导出、跨服务传输失败 |
| `DATA_CONVERT_ERROR` | `12009` | 数据转换错误 | DTO/Entity/VO、类型或格式转换失败 |
| `DATA_LOAD_ERROR` | `12010` | 数据加载错误 | 数据初始化、批量加载或远端加载失败 |
| `DATA_HAS_RELATION` | `12011` | 数据被其他数据关联 | 删除或变更前发现存在关联数据 |

#### 权限和认证类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `AUTHENTICATION_FAILED` | `14000` | 认证失败 | 登录认证、身份校验失败 |
| `ACCESS_DEFINED` | `14003` | 权限不足 | 已认证但无接口、菜单或资源权限；源码枚举名为 `ACCESS_DEFINED` |
| `USER_NOT_FOUND` | `14004` | 用户不存在 | 登录、授权、用户查询时找不到用户 |
| `PASSWORD_ERROR` | `14005` | 密码错误 | 密码登录失败 |
| `TOKEN_NOT_EXIST` | `14006` | token不存在 | 请求缺少 token |
| `TOKEN_INVALID` | `14007` | token不合法 | token 格式、签名或结构不合法 |
| `TOKEN_EXPIRED` | `14008` | token过期 | token 已过期 |
| `USER_FROZEN` | `14009` | 用户被冻结 | 用户状态冻结，禁止登录或操作 |
| `USER_NO_PERMISSION` | `14010` | 用户没有权限 | 用户缺少业务权限 |
| `ROLE_FROZEN` | `14011` | 角色被冻结 | 角色状态冻结 |
| `PERMISSION_FROZEN` | `14012` | 权限被冻结 | 权限项状态冻结 |

#### 通用业务异常类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `OPERATION_FAILED` | `18000` | 操作失败 | 无更具体语义的通用操作失败 |
| `SIGN_ERROR` | `18001` | 签名错误 | 请求签名、回调签名、验签失败 |
| `THIRD_REQUEST_FAILED` | `18002` | 第三方请求失败 | 调第三方接口失败 |
| `THIRD_CALLBACK_FAILED` | `18003` | 第三方回调失败 | 处理第三方回调失败 |
| `AUDIT_FAILED` | `18004` | 审核失败 | 审批、审核、校验流程未通过 |
| `GENERATE_FAILED` | `18005` | 生成失败 | 生成编号、文件、验证码、报表或其他产物失败 |
| `RATE_LIMIT_ERROR` | `18006` | 频率达到上限 | 限流、频控、重试次数达到上限 |
| `LOCK_FAILED` | `18007` | 锁失败 | 获取业务锁、分布式锁或状态锁失败 |
| `SYNC_FAILED` | `18008` | 同步失败 | 同步动作失败但不需要使用更具体的数据同步错误 |

#### 微服务类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `FALLBACK` | `19001` | fallback | Feign fallback、远端服务降级 |

#### 系统类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `UNKNOWN_ERROR` | `20000` | 未知异常 | 无法分类的未知异常 |
| `SYSTEM_ERROR` | `20001` | 系统错误 | 系统内部错误、配置错误、组件不可用 |

### RestException / FBException

推荐:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `RestException / FBException`。


`DefaultExceptionAdvice` 会处理:

- `BindException`
- `ConstraintViolationException`
- `MethodArgumentNotValidException`
- `FBException`
- `RestException`
- 其他 `Exception`

开启方式:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `RestException / FBException`。


## AOP 日志

### 使用方式

开启切面:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `使用方式`。


注册日志处理器:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `使用方式`。


Controller 使用:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `使用方式`。


切面只匹配:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `使用方式`。


因此方法必须在包路径含 `controller` 的类中，且方法上必须标 `@RequestLog`。

### @RequestLog

| 属性 | 默认值 | 说明 |
| --- | --- | --- |
| `enable` | `true` | 单方法开关 |
| `loggingLevel` | `NONE` | `NONE` 表示使用全局 `global-level` |
| `beforeHandler` | `""` | 前置处理器 Bean 名，空则用 `global-before` |
| `afterHandler` | `""` | 后置处理器 Bean 名，空则用 `global-after` |

### 内置 LoggingHandler

| 类 | 行为 |
| --- | --- |
| `SimpleLoggingHanlder` | 打印 IP、URI、请求参数、响应结果 |
| `SwaggerLoggingHandler` | 依赖 `@Tag` 和 `@Operation(operationId)`，打印接口名称 |
| `JsonLoggingHandler` | 以 JSON 打印 request/response，自动处理 `MultipartFile`、`HttpServletRequest`、`HttpServletResponse` |
| `IgnoreContentLoggingHandler` | 只打印 IP 和 URI，不打印 body/response |

注意:

- `SwaggerLoggingHandler` 未对缺少 `@Tag`、`@Operation` 做空值保护，使用前要保证注解存在。
- `JsonLoggingHandler` 使用请求头 `TRACE_ID`；没有该请求头时会生成 UUID 并写入 request attribute。

## 方法锁 @MethodLock

开启:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `方法锁 @MethodLock`。


本地锁:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `方法锁 @MethodLock`。


Redis 分布式锁:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `方法锁 @MethodLock`。


ZooKeeper 分布式锁:


> 代码示例已移到 `../scripts/02-web-rest-aop-and-lock-examples.md`，对应标题: `方法锁 @MethodLock`。


属性说明:

| 属性 | 默认值 | 说明 |
| --- | --- | --- |
| `lockType` | `DEFAULT` | `DEFAULT` 使用全局 `default-lock`，可选 `LOCAL`、`REDIS`、`ZK` |
| `enable` | `true` | false 时直接执行原方法 |
| `timeout` | `-1` | 乐观锁等待时间，`-1` 使用全局 |
| `optimistic` | `false` | true 使用 `tryLock/acquire(timeout)`，false 阻塞获取锁 |
| `timeUnit` | `NANOSECONDS` | 作为“使用全局单位”的哨兵值 |
| `nameExpression` | `""` | SpEL 表达式，空时使用方法全路径作为锁名 |
| `distributedPrefix` | `fairychar:lock:` | Redis key 前缀或 ZK path 前缀 |

实现约束:

- Redis 模式从 `SpringContextHolder` 取 `RedissonClient`。
- ZK 模式从 `SpringContextHolder` 取 `CuratorFramework`。
- 本地锁使用 `ConcurrentHashMap<String, ReentrantLock>` 保存锁实例。
- `nameExpression` 没有 `#` 时会按普通 SpEL 字面表达式求值，常量字符串要写成 `"'collector'"`，否则可能被当成属性名解析。

