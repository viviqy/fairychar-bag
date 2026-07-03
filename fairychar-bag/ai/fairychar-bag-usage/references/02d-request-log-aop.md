# RequestLog AOP Reference

> 返回二级入口: [02-web-rest-aop-and-lock.md](02-web-rest-aop-and-lock.md)。代码示例放在 `../scripts/02d-request-log-aop-examples.md`。

## AOP 日志

用途: 为 Controller 方法增加请求前、请求后日志处理。它通过 `@RequestLog` 标注方法，再由日志处理器决定打印内容。

开启方式:

| 配置项 | 说明 |
| --- | --- |
| `fairychar.bag.aop.log.enable=true` | 开启请求日志切面 |
| `fairychar.bag.aop.log.global-level` | 全局日志等级，方法注解未指定时使用 |
| `fairychar.bag.aop.log.global-before` | 全局前置处理器 Bean 名 |
| `fairychar.bag.aop.log.global-after` | 全局后置处理器 Bean 名 |

生效条件:

- 方法所在包路径必须包含 `controller`。
- 方法上必须标注 `@RequestLog`。
- `@RequestLog(enable = false)` 会关闭单方法日志。
- 全局 before/after 处理器和注解 before/after 处理器通过 Bean 名解析。

## @RequestLog

位置: `com.fairychar.bag.domain.annotations.RequestLog`

属性:

| 属性 | 默认值 | 说明 |
| --- | --- | --- |
| `enable` | `true` | 单方法开关 |
| `loggingLevel` | `NONE` | `NONE` 表示使用全局 `global-level` |
| `beforeHandler` | `""` | 前置处理器 Bean 名，空则用 `global-before` |
| `afterHandler` | `""` | 后置处理器 Bean 名，空则用 `global-after` |

使用建议:

- 同一个项目内尽量统一使用全局 before/after，只在个别接口覆盖 handler。
- 标注在 Controller 方法上，不要标在 Service 方法上期待它生效。
- 使用 `SwaggerLoggingHandler` 时确保接口有 Swagger 注解，否则可能出现空值问题。

## LoggingHandler

位置: `com.fairychar.bag.beans.aop.LoggingHandler`

用途: 请求日志处理器接口。切面在方法执行前后调用 handler，具体打印哪些信息由实现类决定。

内置实现:

| 类 | 行为 | 适用场景 |
| --- | --- | --- |
| `SimpleLoggingHanlder` | 打印 IP、URI、请求参数、响应结果 | 普通接口日志，依赖少 |
| `SwaggerLoggingHandler` | 依赖 `@Tag` 和 `@Operation(operationId)`，打印接口名称 | 项目已完整维护 Swagger/OpenAPI 注解 |
| `JsonLoggingHandler` | 以 JSON 打印 request/response，自动处理 `MultipartFile`、`HttpServletRequest`、`HttpServletResponse` | 需要结构化日志或排查请求体/响应体 |
| `IgnoreContentLoggingHandler` | 只打印 IP 和 URI，不打印 body/response | 敏感接口、大请求体、文件上传接口 |

注意:

- `SimpleLoggingHanlder` 的类名源码拼写是 `Hanlder`，不是 `Handler`。
- `SwaggerLoggingHandler` 未对缺少 `@Tag`、`@Operation` 做空值保护，使用前要保证注解存在。
- `JsonLoggingHandler` 使用请求头 `TRACE_ID`；没有该请求头时会生成 UUID 并写入 request attribute。
- 文件上传、流式响应或包含敏感字段的接口，优先选 `IgnoreContentLoggingHandler` 或自定义 handler。

## 自定义处理器

自定义处理器适合以下场景:

| 场景 | 建议 |
| --- | --- |
| 需要接入公司统一日志格式 | 实现 `LoggingHandler` 并配置为全局 handler |
| 需要隐藏 token、密码、证件号 | 自定义 handler 做字段过滤 |
| 需要把日志写入审计系统 | 自定义 after handler，异步投递审计事件 |
| 单个接口日志体太大 | 在该方法 `@RequestLog` 上指定轻量 handler |
