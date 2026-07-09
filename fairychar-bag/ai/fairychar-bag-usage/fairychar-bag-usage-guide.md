# fairychar-bag 渐进式使用指南

`fairychar-bag` 是 Fairychar 项目的通用开发工具包。此入口文档只保留 agent 写代码时的加载路线和最小规则；详细说明按主题拆到 `references/`，可复制的代码示例和验证脚本放到 `scripts/`。

## 使用方式

1. 先读本文件，确定任务类型。
2. 只加载下表中与任务相关的 reference 文档。
3. 需要代码示例时，再加载对应的 scripts 文档。
4. 修改源码前优先确认当前源码实现，不要只依赖文档。

## 快速路由

### 接入和配置

| 具体任务 | 先读 references | 需要示例时读 scripts |
| --- | --- | --- |
| 判断模块信息、Java 版本、自动配置入口、配置前缀 | [overview-and-configuration](references/01-overview-and-configuration.md) | 不需要示例 |
| 判断 Redis、ZK、MyBatis Plus、Netty、Web/AOP 运行时依赖 | [overview-and-configuration](references/01-overview-and-configuration.md) | 不需要示例 |
| 编写 `fairychar.bag.*` YAML 配置 | [overview-and-configuration](references/01-overview-and-configuration.md) | [overview examples](scripts/01-overview-and-configuration-examples.md) |
| 新增或调整自动配置 Bean | [overview-and-configuration](references/01-overview-and-configuration.md) | [overview examples](scripts/01-overview-and-configuration-examples.md) |

### Web、响应、异常、AOP

| 具体任务 | 先读 references | 需要示例时读 scripts |
| --- | --- | --- |
| 判断 Web/REST/AOP/Lock 应该读哪个细分文档 | [web-rest-aop-and-lock index](references/02-web-rest-aop-and-lock.md) | 不需要示例 |
| 返回统一响应 `HttpResult`、理解 `response(...)` | [http-result](references/02a-http-result.md) | [http-result examples](scripts/02a-http-result-examples.md) |
| 选择已有 `RestErrorCode`，避免重复错误码 | [rest-error-code](references/02b-rest-error-code.md) | [rest-error-code examples](scripts/02b-rest-error-code-examples.md) |
| 新增错误码枚举或实现 `IRestErrorCode`，并通过 `RestException` 使用 | [rest-error-code](references/02b-rest-error-code.md) | [rest-error-code examples](scripts/02b-rest-error-code-examples.md) |
| 抛出 MVC 业务异常 `RestException` | [rest-exception-and-advice](references/02c-rest-exception-and-advice.md) | [rest-exception examples](scripts/02c-rest-exception-and-advice-examples.md) |
| 理解 `FBException`、`DefaultExceptionAdvice`、统一异常返回 | [rest-exception-and-advice](references/02c-rest-exception-and-advice.md) | [rest-exception examples](scripts/02c-rest-exception-and-advice-examples.md) |
| 给 Controller 方法加 `@RequestLog` | [request-log-aop](references/02d-request-log-aop.md) | [request-log examples](scripts/02d-request-log-aop-examples.md) |
| 选择或实现 `LoggingHandler`、`SimpleLoggingHanlder`、`SwaggerLoggingHandler`、`JsonLoggingHandler`、`IgnoreContentLoggingHandler` | [request-log-aop](references/02d-request-log-aop.md) | [request-log examples](scripts/02d-request-log-aop-examples.md) |
| 给方法加本地锁、Redis 锁或 ZK 锁 `@MethodLock` | [method-lock](references/02e-method-lock.md) | [method-lock examples](scripts/02e-method-lock-examples.md) |

### 校验、请求体处理、响应脱敏

| 具体任务 | 先读 references | 需要示例时读 scripts |
| --- | --- | --- |
| 处理 `@Valid`、`BindException`、`ConstraintViolationException`、`MethodArgumentNotValidException` | [validation-mvc-and-field-processing](references/03-validation-mvc-and-field-processing.md) | [validation/mvc examples](scripts/03-validation-mvc-and-field-processing-examples.md) |
| 手动检查 `BindingResultUtil` | [validation-mvc-and-field-processing](references/03-validation-mvc-and-field-processing.md) | [validation/mvc examples](scripts/03-validation-mvc-and-field-processing-examples.md) |
| 使用校验注解 `@Phone`、`@IdCard`、`@Url`、`@IP`、`@In`、`@NotIn` | [validation-mvc-and-field-processing](references/03-validation-mvc-and-field-processing.md) | [validation/mvc examples](scripts/03-validation-mvc-and-field-processing-examples.md) |
| 使用校验注解 `@StartWith`、`@EndWith`、`@Language`、`@DateBetween`、`@TimeBetween`、`@FileSize` | [validation-mvc-and-field-processing](references/03-validation-mvc-and-field-processing.md) | [validation/mvc examples](scripts/03-validation-mvc-and-field-processing-examples.md) |
| 请求体字段擦除 `@EraseValue` | [validation-mvc-and-field-processing](references/03-validation-mvc-and-field-processing.md) | [validation/mvc examples](scripts/03-validation-mvc-and-field-processing-examples.md) |
| 请求体字段保留 `@KeepValue` | [validation-mvc-and-field-processing](references/03-validation-mvc-and-field-processing.md) | [validation/mvc examples](scripts/03-validation-mvc-and-field-processing-examples.md) |
| 响应脱敏 `@FuzzyResult`、`@FuzzyValue`、`FuzzyValueProcessor`、`FuzzyMiddleTextProcessor` | [validation-mvc-and-field-processing](references/03-validation-mvc-and-field-processing.md) | [validation/mvc examples](scripts/03-validation-mvc-and-field-processing-examples.md) |
| MVC `String -> LocalDate`、`String -> LocalDateTime` 转换 | [validation-mvc-and-field-processing](references/03-validation-mvc-and-field-processing.md) | [validation/mvc examples](scripts/03-validation-mvc-and-field-processing-examples.md) |

### 工具类和模板类

| 具体类或功能 | 先读 references | 需要示例时读 scripts |
| --- | --- | --- |
| `StringUtil`: Gzip 压缩/解压、默认字符串 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `DateConvertUtil`: 日期/时间字符串解析、`Date` 与 `LocalDate` 转换 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `RequestUtil`: 当前 request/response、header、IP、URI、request attribute | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `SpelUtil`: AOP 方法参数 SpEL 解析 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `ReflectUtil`: Map/Bean 转换、属性复制、字段擦除/保留、父子递归搜索、注解字段搜索、Unsafe 方法 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `MappingObjectUtil`: 列表转树、Map 转节点、Map 转展示对象 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `RedisLockUtil`: Redisson 悲观锁、乐观锁、双检查锁模板 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `CacheOperateTemplate`: 本地锁/Redis 锁缓存击穿保护 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `TransactionUtil`: 多异步事务协同提交/回滚 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `ConcurrentUtil`: 统一等待 `Future` 并包装异常 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `CollectionUtil`: List 平均分片 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `CircularTaskUtil`: 循环执行直到条件满足 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `FileUtil`: 文件拼接、按百分比分割、创建测试假文件 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |
| `TaskTestUtil`: 测试/压测线程池和批量运行工具 | [utils-and-templates](references/04-utils-and-templates.md) | [utils examples](scripts/04-utils-and-templates-examples.md) |

### MyBatis、Redis、Netty、并发、ActionFlow

| 具体类或功能 | 先读 references | 需要示例时读 scripts |
| --- | --- | --- |
| `AesTypeHandler`、`RsaTypeHandler`: MyBatis 字段加解密 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `SwitchableTenantLineInnerInterceptor`、`ITenantSwitcher`、`TenantSwitcher`: Mapper 参数控制租户插件 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `SkipableTenantLineInnerInterceptor`、`ITenantSkipper`、`SimpleTenantSkipper`: ThreadLocal 控制租户插件 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `PrefixStringSerializer`、`GzipStringSerializer`: Redis key 前缀和 value Gzip 序列化 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `SimpleNettyServer`、`SimpleNettyClient`: Netty 服务端/客户端封装 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `DelimitersHeadTailFrameDecoder`、`HeadTailFrame`: 固定头尾协议解码 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `Action`: 无返回值任务函数式接口 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `AssignableFactory`: 按资源权重分配并发许可 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `RepeatTaskExecutor`: 多任务批次循环执行 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `RoundTaskExecutor`: 多任务链按下标分轮同步执行 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `ActionSelectorTemplate`、`AbstractScheduleAction`: 轻量周期任务选择器 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `AbstractBalkingReference`、`IBalkingReference`: 状态变更才保存的 balking 模式 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `ActionFlow`、`AbstractActionFlow`、`FlowBuilder`、`ParentActionCondition`、`RootAction`: bool 条件动作流 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [integration examples](scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md) |
| `@ConditionalOnSystemProperty`、`@ConditionalOnSystemOS`、`@ConditionalOnRandomNumber`、`@ConditionalOnPingHost`、`@ConditionalOnDateTime` | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | 不需要示例 |
| `Consts`、`Singletons` | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | 不需要示例 |
| `KeyValuePair`、`SimpleTypeQuery`、`DateBetweenQuery`、`TimeBetweenQuery`、`*BodyQuery`、`*ListQuery` | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | 不需要示例 |
| `FeignFallbackProxy` | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | 不需要示例 |
| agent 开发准则、编译验证命令 | [integrations-netty-concurrency-and-agent-rules](references/05-integrations-netty-concurrency-and-agent-rules.md) | [verify-fairychar-bag-compile.ps1](scripts/verify-fairychar-bag-compile.ps1) |

## 最小必读规则

- Maven 模块是 `fairychar-bag`，Java 版本是 21。
- 自动配置入口在 `src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`。
- 配置根前缀是 `fairychar.bag`。
- 很多依赖是 `provided`；使用 Redis、ZK、MyBatis Plus、Netty 能力时，业务应用或测试必须提供运行时依赖和 Bean。
- 新增自动配置 Bean 时必须考虑 `@ConditionalOnProperty` 和 `@ConditionalOnMissingBean`。
- REST 失败优先走 `RestException`、`RestErrorCode`、`HttpResult`。
- 文档中标注的反直觉行为来自当前源码；需要改变行为时必须单独改源码并补测试。

## 目录约定

```text
fairychar-bag/ai/fairychar-bag-usage/
  fairychar-bag-usage-guide.md          # 渐进式入口
  references/                           # 说明、约束、API 语义
  scripts/                              # 代码示例、可执行验证脚本
```

## 常用验证

```powershell
powershell -ExecutionPolicy Bypass -File fairychar-bag\ai\fairychar-bag-usage\scripts\verify-fairychar-bag-compile.ps1
```
