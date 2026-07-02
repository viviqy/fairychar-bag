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

常用:

- `EMPTY_STR`
- `NONE`
- `SIMPLE_DATETIME_FORMAT`
- `SIMPLE_DATE_TIME_FORMATTER`
- `SIMPLE_DATE_FORMAT`
- `SIMPLE_DATE_FORMATTER`
- `MYSQL_MAX_DATETIME`
- `MYSQL_MAX_TIMESTAMP`
- `Consts.Regex.IP`
- `Consts.Regex.URL`
- `Consts.OAuth2.*`

### Singletons

位置: `com.fairychar.bag.domain.Singletons`

提供:

- `Singletons.RestTemplateBean.getInstance()`
- `Singletons.RandomBean.getInstance()`
- `Singletons.PathMatcherBean.getInstance()`
- `Singletons.GsonBean.getInstance()`
- `Singletons.JsonBean.getInstance()`

优先使用 Spring Bean；只有工具类或非 Spring 场景需要全局单例时再使用。

## POJO 和通用 Query

常用类型:

- `KeyValuePair`
- `SimpleTypeQuery`
- `DateBetweenQuery`
- `TimeBetweenQuery`
- `StringBodyQuery`
- `StringListQuery`
- `LongBodyQuery`
- `LongListQuery`
- `IntegerBodyQuery`
- `IntegerListQuery`
- `ShortBodyQuery`
- `ShortListQuery`
- `ByteBodyQuery`
- `ByteListQuery`

这些类适合简单请求体，不要为非常复杂的业务请求滥用它们，复杂场景应创建明确命名的 `*Query`。

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

