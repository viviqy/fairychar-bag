# fairychar-bag SDK 功能入口

面向只有 SDK JAR 的业务项目 AI。假定 JAR 已接入；不处理 POM、SDK 构建发布或内部实现修改。

## 如何使用

1. 按当前需求直接读取下表对应功能页，不要求先读其他入口或通读全部文档。
2. 功能页包含前提、调用方式、行为边界和示例，是该能力的行为说明；仅在核对 import、重载或注解默认值时读取 [API 签名索引](api/README.md)。
3. 只开启当前功能需要的配置，沿用业务项目已有的异常处理、Bean、事务和资源治理方式。完整示例在 examples，片段内业务类型需自行替换。
4. 实际 JAR 与文档不匹配时停止采用冲突用法。未闭合的语义不按名字猜测，不要求获得源码，也不以“待测试”代替基本使用契约。

## 采用状态

- **可直接采用**：仅限文档明确的操作和输入，不表示所有边界或业务集成都已实测。
- **条件接入**：满足功能页列出的配置、线程、安全和外部环境要求后采用。
- **不默认采用**：存在已知风险或契约缺口，优先采用页内给出的业务替代；未明确要求时不生成接入代码。
- **仅签名可查 / 局部语义可查**：不从 public 或方法名推导生产保证；只按明确说明的范围使用。

## 按需求定位

### 接入与配置

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `Lock` / `Log` / `AopProperties` 等 | [SDK 配置与运行前提](features/setup/configuration.md) |
| `ConditionalOnDateTime` / `ConditionalOnPingHost` / `ConditionalOnRandomNumber` 等 | [条件装配注解](features/setup/conditional-beans.md) |
| `GsonBean` / `JsonBean` / `PathMatcherBean` 等 | [全局共享对象 Singletons](features/setup/shared-objects.md) |
| `SpringContextHolder` | [Spring 上下文访问](features/setup/spring-context.md) |
| 查询 API 签名、索引范围与版本兼容边界 | [API 查询与兼容边界](features/setup/api-compatibility.md) |

### Web 与接口

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `HttpResult` | [统一响应 HttpResult](features/web/http-result.md) |
| `IRestErrorCode` / `RestErrorCode` | [业务错误码](features/web/error-code.md) |
| `AcceptedException` / `DataAlreadyExistException` / `FBException` 等 | [业务异常与统一异常响应](features/web/exception-handling.md) |
| `IgnoreContentLoggingHandler` / `JsonLoggingHandler` / `LoggingHandler` 等 | [请求日志](features/web/request-logging.md) |
| `KeyValuePair` / `ByteBodyQuery` / `ByteListQuery` 等 | [通用 Query 与键值载体](features/web/request-models.md) |
| `FeignFallbackProxy` | [Feign 固定降级响应](features/web/feign-fallback.md) |
| `CloneServletInputStream` / `ClonedServletRequest` / `EmptyServletRequest` | [请求体缓存与请求包装](features/web/request-wrapper.md) |

### 参数校验

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `DateBetween` / `DateValidator` / `EndWith` 等 | [参数校验与内置约束](features/validation/constraints.md) |
| `ParamErrorException` / `BindingResultUtil` | [手动检查 BindingResult](features/validation/binding-result.md) |

### 字段处理

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `EraseValue` | [请求字段擦除 @EraseValue](features/field-processing/erase-value.md) |
| `KeepValue` / `PropertyValueAdvice` | [请求字段保留 @KeepValue](features/field-processing/keep-value.md) |
| `FuzzyResult` / `FuzzyValue` | [响应字段脱敏](features/field-processing/fuzzy-value.md) |

### 锁

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `MethodLock` | [注解方法锁](features/locking/method-lock.md) |
| `FailToGetLockException` / `RedisLockUtil` | [Redis 手动锁](features/locking/redis-lock.md) |

### 缓存与数据

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `CacheOperateTemplate` | [缓存双检查读取](features/data/cache-read-through.md) |
| `AesTypeHandler` / `RsaTypeHandler` | [MyBatis 字段加解密](features/data/mybatis-crypto.md) |
| `ITenantSkipper` / `ITenantSwitcher` / `SimpleTenantSkipper` 等 | [MyBatis 租户查询开关](features/data/tenant-isolation.md) |
| `PrefixStringSerializer` | [Redis key 前缀序列化](features/data/redis-prefix.md) |
| `GzipStringSerializer` | [Redis Gzip 字符串序列化](features/data/redis-gzip.md) |

### 工具与常量

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `Consts` | [常量 Consts](features/utilities/constants.md) |
| `StringUtil` | [字符串与 Gzip](features/utilities/string.md) |
| `DateConvertUtil` | [日期时间工具](features/utilities/date-time.md) |
| `CollectionUtil` | [列表均分](features/utilities/collection-split.md) |
| `MapObjectNode` / `MappingAO` / `MappingObjectAO` 等 | [树构造与对象映射](features/utilities/tree-mapping.md) |
| `RequestUtil` | [请求上下文工具](features/utilities/request-context.md) |
| `SimpleEvaluationContext` / `SimpleExpressionRootObject` / `SpelUtil` | [SpEL 表达式求值](features/utilities/spel.md) |
| `ReflectUtil` / `FieldContainer` | [反射与字段操作](features/utilities/reflection.md) |
| `FileUtil` | [文件拼接、截取与测试文件](features/utilities/file-operations.md) |
| `BiPredicateList` | [按等价规则替换列表元素](features/utilities/predicate-list.md) |

### 通用函数式接口

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `Action`：保存、传递或调用无参数、无返回值操作 | [Action 通用函数式接口](features/function/action.md) |

### 并发与任务

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `TransactionUtil` | [异步事务协调](features/concurrency/async-transactions.md) |
| `ConcurrentUtil` | [Future 顺序等待](features/concurrency/future-wait.md) |
| `CircularTaskUtil` | [循环轮询](features/concurrency/polling.md) |
| `TaskTestUtil` | [任务测试辅助](features/concurrency/task-test.md) |
| `AssignableFactory` | [加权许可调度](features/concurrency/weighted-permits.md) |
| `RepeatTaskExecutor` | [重复任务编排](features/concurrency/repeat-tasks.md) |
| `RoundTaskExecutor` | [分轮任务编排](features/concurrency/round-tasks.md) |
| `ActionSelectorTemplate` | [定时任务选择器](features/concurrency/task-selector.md) |
| `AbstractScheduleAction` / `ActionSchedule` | [动作调度器](features/concurrency/action-schedule.md) |
| `AbstractBalkingReference` / `IBalkingReference` | [Balking 状态引用](features/concurrency/balking-reference.md) |

### Netty

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `SimpleNettyServer` / `RunState` | [Netty 服务端封装](features/netty/server.md) |
| `SimpleNettyClient` | [Netty 客户端封装](features/netty/client.md) |
| `DelimitersHeadTailFrameDecoder` / `HeadTailFrame` | [头尾帧解码](features/netty/frame-decoder.md) |
| `CauseHandler` / `EventHandler` / `NettyCauseAdvice` 等 | [Netty 处理标记与回调](features/netty/handler-annotations.md) |

### 业务扩展

| 当前需求 / 类型 | 功能说明 |
| --- | --- |
| `AbstractActionFlow` / `ActionFlow` / `FlowBuilder` 等 | [条件动作流](features/extensions/action-flow.md) |
| `BaseCalculator` / `Operator` / `IDataBaseShardingProcessor` 等 | [分片计算扩展](features/extensions/sharding.md) |

## 验证与交付

功能页的验收用于业务项目测试。编译、离线断言、HTTP/AOP、外部服务、多实例与并发验证分别记录；未执行的层次明确写“未验证”。线程池、客户端和连接由业务明确资源责任，任务停止不等于资源已释放。

仅需演示 Web 功能组合时可选用 [最小 Web 示例](examples/minimal-web.md)，它不是必读入口。
