# Web REST AOP And Lock Examples Index

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。说明和约束见 `../references/02-web-rest-aop-and-lock.md` 及其细分文档。本文件只做示例路由。

## 细分示例

| 需要的示例 | 读取 scripts |
| --- | --- |
| `HttpResult.ok/fail/response` | [02a-http-result-examples](02a-http-result-examples.md) |
| `RestErrorCode` 复用、`RestException` 抛出、Advice 配置 | [02c-rest-exception-and-advice-examples](02c-rest-exception-and-advice-examples.md) |
| `@RequestLog`、`LoggingHandler`、日志 AOP 配置 | [02d-request-log-aop-examples](02d-request-log-aop-examples.md) |
| `@MethodLock` 本地锁、Redis 锁、ZK 锁配置 | [02e-method-lock-examples](02e-method-lock-examples.md) |

## 读取建议

- 只写正常响应时，只读 `02a-http-result-examples.md`。
- 只写接口业务失败时，读 `02c-rest-exception-and-advice-examples.md`；需要手动构造失败响应时再读 `02a`。
- 只加日志切面时，读 `02d-request-log-aop-examples.md`。
- 只加方法锁时，读 `02e-method-lock-examples.md`。
