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
- `14000+`: 权限类。
- `18000+`: 通用业务异常。
- `19000+`: 微服务类。
- `20000+`: 系统类。

新增业务错误码时优先实现 `IRestErrorCode` 或扩展现有枚举风格，不要在业务代码中散落裸数字和裸字符串。

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

