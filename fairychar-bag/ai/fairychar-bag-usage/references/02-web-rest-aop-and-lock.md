# Web REST AOP And Lock Reference Index

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。本文件只做二级路由；具体说明、约束和 API 语义继续拆到同目录细分文档。代码示例从 `../scripts/02-web-rest-aop-and-lock-examples.md` 进入。

## 读取原则

- 只需要统一响应包装时，读 `02a-http-result.md`。
- 只需要选择或新增错误码时，读 `02b-rest-error-code.md`。
- 只需要抛业务异常或理解统一异常返回时，读 `02c-rest-exception-and-advice.md`。
- 只需要 Controller 请求/响应日志时，读 `02d-request-log-aop.md`。
- 只需要方法级本地锁、Redis 锁、ZK 锁时，读 `02e-method-lock.md`。
- 写接口失败返回时，通常至少需要同时读 `02b-rest-error-code.md` 和 `02c-rest-exception-and-advice.md`。

## 细分路由

| 具体任务 | 先读 references | 需要示例时读 scripts |
| --- | --- | --- |
| Controller 或 Service 返回统一结构 `HttpResult` | [02a-http-result](02a-http-result.md) | [02a-http-result-examples](../scripts/02a-http-result-examples.md) |
| 理解 `HttpResult.response(...)` 设置 HTTP 状态码的行为 | [02a-http-result](02a-http-result.md) | [02a-http-result-examples](../scripts/02a-http-result-examples.md) |
| 选择已有 `RestErrorCode`，避免重复定义错误码 | [02b-rest-error-code](02b-rest-error-code.md) | [02b-rest-error-code-examples](../scripts/02b-rest-error-code-examples.md) |
| 新增业务错误码或实现 `IRestErrorCode`，并通过 `RestException` 使用 | [02b-rest-error-code](02b-rest-error-code.md) | [02b-rest-error-code-examples](../scripts/02b-rest-error-code-examples.md) |
| Controller/Service 抛业务失败异常 | [02c-rest-exception-and-advice](02c-rest-exception-and-advice.md) | [02c-rest-exception-and-advice-examples](../scripts/02c-rest-exception-and-advice-examples.md) |
| 理解 `RestException`、`FBException`、`DefaultExceptionAdvice` 的边界 | [02c-rest-exception-and-advice](02c-rest-exception-and-advice.md) | [02c-rest-exception-and-advice-examples](../scripts/02c-rest-exception-and-advice-examples.md) |
| 处理 `BindException`、`ConstraintViolationException`、`MethodArgumentNotValidException` | [02c-rest-exception-and-advice](02c-rest-exception-and-advice.md) 和 [03-validation-mvc-and-field-processing](03-validation-mvc-and-field-processing.md) | [validation/mvc examples](../scripts/03-validation-mvc-and-field-processing-examples.md) |
| 给 Controller 方法加 `@RequestLog` | [02d-request-log-aop](02d-request-log-aop.md) | [02d-request-log-aop-examples](../scripts/02d-request-log-aop-examples.md) |
| 选择 `SimpleLoggingHanlder`、`SwaggerLoggingHandler`、`JsonLoggingHandler`、`IgnoreContentLoggingHandler` | [02d-request-log-aop](02d-request-log-aop.md) | [02d-request-log-aop-examples](../scripts/02d-request-log-aop-examples.md) |
| 给方法加 `@MethodLock` 本地锁 | [02e-method-lock](02e-method-lock.md) | [02e-method-lock-examples](../scripts/02e-method-lock-examples.md) |
| 给方法加 `@MethodLock` Redis 分布式锁 | [02e-method-lock](02e-method-lock.md) | [02e-method-lock-examples](../scripts/02e-method-lock-examples.md) |
| 给方法加 `@MethodLock` ZooKeeper 分布式锁 | [02e-method-lock](02e-method-lock.md) | [02e-method-lock-examples](../scripts/02e-method-lock-examples.md) |

## 最小规则

- REST 失败优先走 `RestException`、`RestErrorCode`、`HttpResult`。
- 项目接口业务异常默认强制抛 `RestException`，不要随意新增异常基类。
- 写错误码前必须先查 `02b-rest-error-code.md` 的完整枚举表。
- `@RequestLog` 只对包路径含 `controller` 且方法标注注解的接口方法生效。
- `@MethodLock` 的 Redis 和 ZK 模式依赖业务应用提供 `RedissonClient` 或 `CuratorFramework` Bean。
