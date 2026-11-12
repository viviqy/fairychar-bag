# 请求日志

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。通过 @RequestLog、LoggingHandler Bean 和配置记录请求日志。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## AOP 日志

用途: 为 Controller 方法增加请求前、请求后日志处理。它通过 `@RequestLog` 标注方法，再由日志处理器决定打印内容。

SDK 自动提供切面实现；调用方只需配置开关、使用注解，按需选择或实现 `LoggingHandler`，无需手动创建、注册或调用内部切面。

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
- 常规 Controller 方法只写 `@RequestLog` 即可，不需要重复配置文件中的 Bean 名和日志级别。注解参数均可省略，也可只指定需要覆盖的一项。
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

- `SimpleLoggingHanlder` 的实际类名拼写是 `Hanlder`，不是 `Handler`；import 时不要自动纠正。
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

## 示例：开启日志切面

```yaml
fairychar:
  bag:
    aop:
      log:
        enable: true
        global-level: INFO
        global-before: jsonLoggingHandler
        global-after: jsonLoggingHandler
```

## 示例：注册日志处理器

当前 SDK 的 `ObjectMapper` 类型为 `tools.jackson.databind.ObjectMapper`；处理器类型位于 `com.fairychar.bag.beans.aop`，Spring 注解位于 `org.springframework.context.annotation`。下面是需要放入业务配置类的示意代码，不包含完整业务应用。

```java
@Configuration
class LoggingConfiguration {
    @Bean
    LoggingHandler jsonLoggingHandler(ObjectMapper objectMapper) {
        return new JsonLoggingHandler(objectMapper, false);
    }

    @Bean
    LoggingHandler ignoreContentLoggingHandler() {
        return new IgnoreContentLoggingHandler();
    }
}
```

## 示例：Controller 方法使用全局配置（推荐默认写法）

使用前面的 YAML 和同名 Bean 注册后，下面的裸注解会使用 `global-before=jsonLoggingHandler`、`global-after=jsonLoggingHandler` 和 `global-level=INFO`。`userService`、`CreateUserQuery`、`UserVO` 是业务已有对象和类型，片段省略 Service 注入。

```java
@RestController
@RequestMapping("/users")
class UserController {
    @RequestLog
    @PostMapping
    public HttpResult<UserVO> create(@RequestBody @Valid CreateUserQuery query) {
        return HttpResult.ok(userService.create(query));
    }
}
```

## 示例：仅覆盖当前方法需要改变的参数

```java
@RequestLog(afterHandler = "ignoreContentLoggingHandler")
```

此时前置处理器仍取 `global-before`，日志级别仍取 `global-level`，只有后置处理器改为指定 Bean。也可以同时显式设置三项：

```java
@RequestLog(
        beforeHandler = "jsonLoggingHandler",
        afterHandler = "jsonLoggingHandler",
        loggingLevel = RequestLog.Level.INFO
)
```

| 参数 | 解析优先级与省略效果 |
| --- | --- |
| `beforeHandler` | 非空白注解值优先，否则使用 `global-before`；前后两项独立解析 |
| `afterHandler` | 非空白注解值优先，否则使用 `global-after` |
| `loggingLevel` | 非 `NONE` 注解值优先；默认 `NONE` 使用 `global-level`，不是关闭日志 |
| `enable` | 默认 true；`@RequestLog(enable=false)` 跳过当前方法前后日志处理 |

handler 的注解值为空串或纯空白均表示回退全局，不表示禁用该阶段。如果对应全局 handler 也未配置或为空白，该阶段不调用处理器；配置了名称但没有相应 `LoggingHandler` Bean 不是有效接入，不会自动选另一个 Bean 补位。仅注册 Bean 不会自动将其设为全局 handler，仍需配置 Bean 名。

内置日志处理器按上述级别规则输出；自定义 `LoggingHandler` 的具体输出策略由业务实现负责。后置处理发生在方法正常返回后，抛异常时不保证调用 after handler，不能把它作为必达审计或 finally 清理机制。

## 示例：当前切面匹配范围

```text
execution(public * *..controller..*.*(..)) && @annotation(requestLog)
```

## 业务验收

包名包含 controller、方法有注解、handler Bean 名匹配；验证裸 `@RequestLog` 使用全局处理器及级别、单项覆盖不改变其他项、`enable=false` 跳过前后处理、异常返回不依赖 after handler；日志不泄露密码、令牌或敏感请求体。

## 完整可编译示例

[日志 Bean 配置](../../examples/SdkLoggingConfiguration.java) 与 [演示 Controller](../../examples/SdkFeatureController.java)。Controller 同时演示方法锁时，还需 [锁 Service](../../examples/SdkLockService.java) 并开启锁配置；仅使用日志无需启用锁。

这组完整 Java 模板注册的 Bean 名为 `sdkDemoLoggingHandler`，不同于上面的 JSON 片段示例。Controller 使用裸 `@RequestLog`，配套配置如下；不要只复制 Java 文件而漏掉全局 Bean 名。

```yaml
fairychar:
  bag:
    aop:
      log:
        enable: true
        global-level: INFO
        global-before: sdkDemoLoggingHandler
        global-after: sdkDemoLoggingHandler
      lock:
        enable: true
        default-lock: LOCAL
```

## 类型与完整签名

- [`com.fairychar.bag.beans.aop.IgnoreContentLoggingHandler`](../../api/beans-aop.md)
- [`com.fairychar.bag.beans.aop.JsonLoggingHandler`](../../api/beans-aop.md)
- [`com.fairychar.bag.beans.aop.LoggingHandler`](../../api/beans-aop.md)
- [`com.fairychar.bag.beans.aop.SimpleLoggingHanlder`](../../api/beans-aop.md)
- [`com.fairychar.bag.beans.aop.SwaggerLoggingHandler`](../../api/beans-aop.md)
- [`com.fairychar.bag.domain.annotations.RequestLog.Level`](../../api/domain-annotations.md)
- [`com.fairychar.bag.domain.annotations.RequestLog`](../../api/domain-annotations.md)
