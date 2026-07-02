# Integrations Netty Concurrency And Agent Rules Reference

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。本文件只保留说明、约束和 API 语义；代码示例放在 `../scripts/`。

## MyBatis 工具

### AES/RSA TypeHandler

位置:

- `com.fairychar.bag.beans.mybatis.handler.AesTypeHandler`
- `com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler`

配置 AES/RSA Bean:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `AES/RSA TypeHandler`。


实体字段:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `AES/RSA TypeHandler`。


静态工具:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `AES/RSA TypeHandler`。


注意:

- `AesTypeHandler` 和 `RsaTypeHandler` 内部依赖静态 `aes/rsa` 字段，使用前必须确保已注入或手动 `setAes/setRsa`。
- `AesTypeHandler` 入库使用 `encryptHex`，出库 `decryptStr`。
- `RsaTypeHandler` 入库用公钥，出库用私钥。

### 租户拦截器

#### SwitchableTenantLineInnerInterceptor

Mapper 参数中传入 `ITenantSwitcher`，动态决定该次查询是否使用租户插件。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `SwitchableTenantLineInnerInterceptor`。


如果参数中没有 `ITenantSwitcher`，默认使用租户。

#### SkipableTenantLineInnerInterceptor

通过 `ITenantSkipper` 的线程上下文跳过租户处理。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `SkipableTenantLineInnerInterceptor`。


注意: `SimpleTenantSkipper` 的默认 ThreadLocal 初始值是 `true`，结合 `SkipableTenantLineInnerInterceptor` 时要按当前实现仔细验证“默认是否跳过”的业务预期。

## Redis Serializer

### PrefixStringSerializer

位置: `com.fairychar.bag.beans.redis.PrefixStringSerializer`

用途: 在 Redis key 序列化时自动加前缀。源码当前反序列化只调用父类 `deserialize`，不会去掉前缀。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `PrefixStringSerializer`。


### GzipStringSerializer

位置: `com.fairychar.bag.beans.redis.GzipStringSerializer`

用途: value 字符串序列化时 Gzip 压缩，反序列化时解压。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `GzipStringSerializer`。


## Netty 简化封装

### SimpleNettyServer


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `SimpleNettyServer`。


构造方法:

- `SimpleNettyServer(int workerSize, int port)`
- `SimpleNettyServer(int workerSize, int port, ChannelInitializer<SocketChannel> childHandlers)`
- `SimpleNettyServer(int workerSize, int port, ChannelInitializer<ServerSocketChannel> handlers, ChannelInitializer<SocketChannel> childHandlers)`

行为:

- boss 线程数固定为 1。
- `start()` 设置 `RunState.STARTING -> STARTED`。
- `stop()` 带 `@PreDestroy`，关闭 channel、boss、worker。

### SimpleNettyClient


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `SimpleNettyClient`。


构造方法:

- `SimpleNettyClient(int workerSize, int port, String host)`
- `SimpleNettyClient(int workerSize, int port, String host, ChannelInitializer<SocketChannel> childHandlers)`

### DelimitersHeadTailFrameDecoder

固定头尾协议解码:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `DelimitersHeadTailFrameDecoder`。


输出对象: `HeadTailFrame`

- `head`: 协议头。
- `content`: 协议体 `ByteBuf`，使用后需要 `release()`。
- `tail`: 协议尾。

注意:

- 如果头不匹配会 `in.clear()` 并抛 `DecoderException("head error")`。
- `maxCapacity` 是内部缓存 ByteBuf 容量。

## 并发和任务编排

### Action

位置: `com.fairychar.bag.function.Action`


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `Action`。


大量工具都用它承载无返回值任务。

### AssignableFactory

位置: `com.fairychar.bag.extension.concurrent.AssignableFactory`

用于按“资源权重”分配并发许可。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `AssignableFactory`。


语义:

- 内部使用 `Semaphore`。
- `workers` 表示本任务占用多少许可。
- `recruitWorkers(int workers)` 无外部线程池版本已废弃。

### RepeatTaskExecutor

位置: `com.fairychar.bag.extension.concurrent.RepeatTaskExecutor`

多个任务组成一个批次，同一批次所有任务都执行完后进入下一批次。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `RepeatTaskExecutor`。


注意:

- 每个 action 在自己的线程中无限循环。
- 每轮结束后在 `CyclicBarrier` 等待。
- `stop()` 会 `cyclicBarrier.reset()`，触发任务退出。

### RoundTaskExecutor

位置: `com.fairychar.bag.extension.concurrent.RoundTaskExecutor`

将多个任务链按下标分轮同步执行。第 0 轮所有链的第 0 个任务完成后，才进入第 1 轮。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `RoundTaskExecutor`。


`boxedTaskList` 会把短链补空 action，使所有链长度一致。

### ActionSelectorTemplate

位置: `com.fairychar.bag.template.ActionSelectorTemplate`

轻量定时任务选择器。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `ActionSelectorTemplate`。


行为:

- `boss` 单线程轮询任务。
- `worker` 默认大小为 CPU 核心数。
- `period` 单位是毫秒。
- 同一个任务如果上次还在执行，本轮会跳过，不会并发重入。
- `remove(taskName, true)` 会中断该任务当前执行线程。
- `shutdownGracefully()` 和 `shutdownNow()` 用于停止。

注意: `shutdownGracefully()` 当前源码里的状态检查条件较反直觉，实际使用前建议补测试。

### AbstractBalkingReference

位置: `com.fairychar.bag.domain.abstracts.AbstractBalkingReference`

用于“状态有变更才保存”的 balking 模式。


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `AbstractBalkingReference`。


## 条件动作流 ActionFlow

位置: `com.fairychar.bag.extension.action.condition.bool`

适用于构建 bool 条件树，每个节点计算 `true/false` 后进入对应子节点。

定义 root 节点:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `条件动作流 ActionFlow`。


定义子节点:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `条件动作流 ActionFlow`。


构建并执行:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `条件动作流 ActionFlow`。


约束:

- 必须且只能有一个 root，即 `getParentClassSet()` 包含 `RootAction.getCondition()` 的节点。
- 同一父节点的 true 分支最多一个子节点，false 分支最多一个子节点。
- `convertAsJsonSchema()` 必须在 `buildFlow()` 后调用。

## 条件装配注解

位置: `com.fairychar.bag.domain.conditional`

| 注解 | 作用 |
| --- | --- |
| `@ConditionalOnSystemProperty` | 按 JVM system property 判断 |
| `@ConditionalOnSystemOS` | 按操作系统判断 |
| `@ConditionalOnRandomNumber` | 按随机数范围判断 |
| `@ConditionalOnPingHost` | 按 host ping 可达性判断 |
| `@ConditionalOnDateTime` | 按时间判断 |

这些注解用于 Spring Bean 条件装配。写新自动配置时，优先使用 Spring Boot 自带 `@ConditionalOnProperty`；只有确实需要这些特殊条件时再使用。

## 常量和单例

### Consts

位置: `com.fairychar.bag.domain.Consts`

使用规则:

- 写代码前先查本节，优先复用已有常量，不要重复定义日期格式、OAuth2 grant type、IP/URL 正则或容量单位。
- 表中的 value 按当前源码语义描述；对象类型常量给出类型和值来源。
- `TB_PER_B` 和 `PB_PER_B` 当前源码使用 int 字面量连乘后再赋值给 `long`，实际 Java 计算过程会先按 int 运算并溢出。需要精确 TB/PB 字节数时，不要直接复用这两个常量，先修源码为 `1024L * ...` 并补测试。

#### 基础常量和容量单位

| 常量 | 类型 | value / 语义 | 复用场景 |
| --- | --- | --- | --- |
| `EMPTY_STR` | `String` | `""` | 空字符串占位、默认值 |
| `KB_PER_B` | `long` | `1024` | KB 与 byte 换算 |
| `MB_PER_B` | `long` | `1024 * 1024`，实际值 `1048576` | MB 与 byte 换算 |
| `GB_PER_B` | `long` | `1024 * 1024 * 1024`，实际值 `1073741824` | GB 与 byte 换算 |
| `TB_PER_B` | `long` | 源码表达式 `1024 * 1024 * 1024 * 1024`，当前存在 int 溢出风险 | 仅在确认源码修复前谨慎使用 |
| `PB_PER_B` | `long` | 源码表达式 `1024 * 1024 * 1024 * 1024 * 1024`，当前存在 int 溢出风险 | 仅在确认源码修复前谨慎使用 |
| `NONE` | `String` | `"none"` | 无值、无参数、默认路径片段占位 |

#### 日期时间常量

| 常量 | 类型 | value / 语义 | 复用场景 |
| --- | --- | --- | --- |
| `SIMPLE_DATETIME_FORMAT` | `String` | `"yyyy-MM-dd HH:mm:ss"` | 标准日期时间格式字符串 |
| `SIMPLE_DATE_TIME_FORMATTER` | `DateTimeFormatter` | `DateTimeFormatter.ofPattern(SIMPLE_DATETIME_FORMAT)` | 格式化或解析标准日期时间 |
| `SIMPLE_DATE_FORMAT` | `String` | `"yyyy-MM-dd"` | 标准日期格式字符串 |
| `SIMPLE_DATE_FORMATTER` | `DateTimeFormatter` | `DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT)` | 格式化或解析标准日期 |
| `MYSQL_MAX_DATETIME` | `LocalDateTime` | `9999-12-31 23:59:59` | MySQL `DATETIME` 最大哨兵值 |
| `MYSQL_MAX_TIMESTAMP` | `LocalDateTime` | `2038-01-19 03:14:07` | MySQL `TIMESTAMP` 最大哨兵值 |

#### OAuth2 grant type 常量

位置: `Consts.OAuth2`

| 常量 | 类型 | value | 复用场景 |
| --- | --- | --- | --- |
| `AUTHORIZATION_CODE` | `String` | `"authorization_code"` | OAuth2 授权码模式 |
| `PASSWORD` | `String` | `"password"` | OAuth2 密码模式 |
| `CLIENT_CREDENTIALS` | `String` | `"client_credentials"` | OAuth2 客户端凭证模式 |
| `IMPLICIT` | `String` | `"implicit"` | OAuth2 隐式模式 |
| `REFRESH_TOKEN` | `String` | `"refresh_token"` | OAuth2 刷新令牌模式 |

#### Regex 常量

位置: `Consts.Regex`

| 常量 | 类型 | value / 语义 | 复用场景 |
| --- | --- | --- | --- |
| `IP` | `String` | IPv4 基础格式正则: 四段 1-3 位数字，未限制每段小于等于 255 | `@IP` 校验器、简单 IP 格式判断 |
| `URL` | `String` | `http`/`https` URL 基础格式正则，要求域名中有点和 2 位以上顶级域 | `@Url` 校验器、简单 URL 格式判断 |

### Singletons

位置: `com.fairychar.bag.domain.Singletons`

用途: 给非 Spring 管理的工具代码提供少量全局复用对象。优先使用 Spring Bean；只有工具类、静态方法或无法注入 Bean 的场景才使用 `Singletons`。

使用规则:

- 业务 Service、Controller、Repository 中优先注入 Spring Bean，不要因为方便而绕过依赖注入。
- `RestTemplateBean` 返回的是裸 `RestTemplate`，没有超时、拦截器、连接池、错误处理配置；生产 HTTP 调用优先使用业务自定义 Bean。
- `RandomBean` 返回 `java.util.Random`，不是密码学安全随机数；生成 token、密钥、验证码种子时不要使用它。
- `JsonBean` 的 `ObjectMapper` 是项目工具默认 JSON 配置，适合工具类序列化；接口响应仍优先交给 Spring MVC 的 Jackson 配置。

| 内部类 | 入口方法 | 返回类型 | 源码配置 / 行为 | 适用场景 |
| --- | --- | --- | --- | --- |
| `RestTemplateBean` | `Singletons.RestTemplateBean.getInstance()` | `RestTemplate` | 直接 `new RestTemplate()`，无额外配置 | 工具类里临时发起简单 HTTP 请求；更复杂请求应改为注入业务配置后的 `RestTemplate` |
| `RandomBean` | `Singletons.RandomBean.getInstance()` | `Random` | `new Random(System.currentTimeMillis())` | 非安全随机数，如简单抽样、测试随机数据 |
| `PathMatcherBean` | `Singletons.PathMatcherBean.getInstance()` | `AntPathMatcher` | 直接 `new AntPathMatcher()` | 静态工具中做 Ant 风格路径匹配 |
| `GsonBean` | `Singletons.GsonBean.getInstance()` | `Gson` | 直接 `new Gson()` | 简单 JSON 转换；需要统一日期、null、JavaTime 策略时优先用 `JsonBean` 或业务 ObjectMapper |
| `JsonBean` | `Singletons.JsonBean.getInstance()` | `ObjectMapper` | `JsonInclude.Include.ALWAYS`；关闭日期 timestamp；关闭空 Bean 失败；日期格式 `yyyy-MM-dd HH:mm:ss`; 忽略未知属性；注册 `JavaTimeModule` | 工具类 JSON 序列化/反序列化，尤其需要支持 Java Time 类型时 |

## POJO 和通用 Query

用途: 为简单 DTO、简单 JSON 请求体和通用时间范围查询提供可复用类型，减少重复创建只有一个字段的 `*Query`。

使用规则:

- 这些类适合“字段语义非常通用”的接口，例如只提交一个 id、一个字符串、一个 id 列表、一个日期范围。
- 复杂业务请求不要滥用这些类；如果字段需要业务命名、校验分组、Swagger 描述或后续扩展，应创建明确命名的业务 `*Query`。
- `SimpleTypeQuery<T>` 注释里写明 “feign 下不可用泛型”；Feign 请求体不要使用这个泛型包装类。
- `*BodyQuery` 的单值字段名固定为 `body`。
- `*ListQuery` 的集合字段名固定为 `list`。
- `DateBetweenQuery` 和 `TimeBetweenQuery` 只表达 from/to，不内置范围合法性校验。

### DTO

| 类 | 包 | 字段 | 用途 |
| --- | --- | --- | --- |
| `KeyValuePair` | `com.fairychar.bag.pojo.dto` | `name: K`, `value: V` | 返回或接收简单键值对列表；例如下拉选项、枚举展示、统计项映射 |

### 通用 Query

| 类 | 包 | 字段 | 用途 |
| --- | --- | --- | --- |
| `SimpleTypeQuery` | `com.fairychar.bag.pojo.query` | `value: T`，带 `@NotNull` | 接收一个泛型值的简单 JSON 请求体；Feign 下不要使用 |
| `DateBetweenQuery` | `com.fairychar.bag.pojo.query` | `from: LocalDate`, `to: LocalDate`，`@JsonFormat(pattern = Consts.SIMPLE_DATE_FORMAT)` | 日期范围查询，例如按天筛选报表、列表 |
| `TimeBetweenQuery` | `com.fairychar.bag.pojo.query` | `from: LocalDateTime`, `to: LocalDateTime`，`@JsonFormat(pattern = Consts.SIMPLE_DATETIME_FORMAT)` | 日期时间范围查询，例如按时间戳筛选记录 |

### 单值 JSON 请求体

| 类 | 包 | 字段 | Swagger schema | 用途 |
| --- | --- | --- | --- | --- |
| `StringBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: String` | `StringBody`, `String类型Json请求体` | 请求体只需要一个字符串值 |
| `LongBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: Long` | `LongBody`, `Long类型Json请求体` | 请求体只需要一个 Long 值，例如 id |
| `IntegerBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: Integer` | `IntegerBody`, `Integer类型Json请求体` | 请求体只需要一个 Integer 值 |
| `ShortBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: Short` | `ShortBody`, `Short类型Json请求体` | 请求体只需要一个 Short 值 |
| `ByteBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: Byte` | `ByteBody`, `Byte类型Json请求体` | 请求体只需要一个 Byte 值 |

### 集合 JSON 请求体

| 类 | 包 | 字段 | Swagger schema | 用途 |
| --- | --- | --- | --- | --- |
| `StringListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<String>` | `StringList`, `String类型Json请求集合` | 请求体只需要一个字符串列表 |
| `LongListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<Long>` | `LongList`, `Long类型Json请求集合` | 请求体只需要一个 Long 列表，例如批量 id |
| `IntegerListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<Integer>` | `IntegerList`, `Integer类型Json请求集合` | 请求体只需要一个 Integer 列表 |
| `ShortListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<Short>` | `ShortList`, `Short类型Json请求集合` | 请求体只需要一个 Short 列表 |
| `ByteListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<Byte>` | `ByteList`, `Byte类型Json请求集合体` | 请求体只需要一个 Byte 列表 |

## FeignFallbackProxy

位置: `com.fairychar.bag.proxy.FeignFallbackProxy`

用于 Feign fallback 代理场景。使用前先看源码和调用方需求，确保返回值和异常处理符合业务预期。

## 给 agent 的开发准则

1. 修改 `fairychar-bag/src` 下 Java 代码时，优先延续现有风格，不要把字段注入、`I*` 接口、`*Util` 静态方法强行改成另一套风格。
2. 新增自动配置 Bean 必须考虑条件开关和 `@ConditionalOnMissingBean`。
3. 新增 REST 错误优先走 `IRestErrorCode`、`RestException`、`HttpResult`。
4. 新增工具方法要明确 null、异常、线程安全语义，并补 focused test。
5. 对已有实现里看起来反直觉的行为，不要在 README 或代码里“按理想行为”描述，必须按源码和测试描述；如需修复，单独提交行为变更和测试。
6. `pom.xml` 的 Surefire 当前 `skipTests=true`，需要验证测试时显式执行目标测试或调整命令参数。
7. 涉及 Redis、ZK、MyBatis Plus、Netty 的代码，注意这些依赖多为 provided，测试中要 mock 或显式提供运行时依赖。

## 常用验证命令

在仓库根目录执行:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `常用验证命令`。


如果需要跑测试，由于模块配置默认跳过测试，使用:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `常用验证命令`。


如需做风格检查，可运行项目内技能脚本:


> 代码示例已移到 `../scripts/05-integrations-netty-concurrency-and-agent-rules-examples.md`，对应标题: `常用验证命令`。

