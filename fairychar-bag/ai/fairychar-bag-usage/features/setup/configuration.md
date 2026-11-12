# SDK 配置与运行前提

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。查询自动装配、配置默认值和运行时 Bean；具体功能直接读取对应功能页。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 基本信息

- SDK: `fairychar-bag`
- Java 版本: 21
- 自动配置: SDK 通过 Spring Boot 自动装配，调用方无需手动导入内部配置类。
- 配置前缀: `fairychar.bag`
- 代码风格:
  - 工具类通常为 `final` + 私有无参构造。
  - 接口常用 `I*` 命名。
  - DTO/VO/Query/Properties/Util/Template/Configurer/AspectJ/Handler 后缀按现有风格延续。
  - REST 失败优先用 `RestException`、`RestErrorCode`、`HttpResult`。

## 运行时 Bean 与使用前置条件

本文假设业务项目已经引用 SDK JAR，不列 POM 坐标与版本。JAR 存在并不等于外部客户端和处理器已经初始化：

- Redis 锁和 Redis 序列化: 需要 Spring Data Redis、Redisson。
- 方法锁 Redis 模式: 需要 Spring 容器中有 `RedissonClient`。
- 方法锁 ZK 模式: 需要 Spring 容器中有 `CuratorFramework`。
- MyBatis Plus 租户拦截器: 需要 MyBatis Plus extension。
- Netty: 需要 Netty。
- Web/MVC/校验/AOP: 需要 Spring MVC、Hibernate Validator、Spring AOP。

这些是功能运行条件，不是依赖索引。日志 handler、租户拦截器和 Netty 生命周期仍由业务项目按需装配。

## 推荐配置

按需开启功能，未开启的切面或 MVC Advice 不会自动注册。

以下是各功能配置位置的合集，不是应整体复制的最小配置。日志 handler 需另行注册；Netty 参数不会自动启动服务；演示 AES 密钥和 RSA 占位符不可用于生产。首次使用优先采用 [最小闭环](../../examples/minimal-web.md) 中只含所需功能的配置。

```yaml
fairychar:
  bag:
    aop:
      log:
        enable: true
        global-level: info
        global-before: jsonLoggingHandler
        global-after: jsonLoggingHandler
      lock:
        enable: true
        default-lock: local
        global-timeout: 1
        time-unit: seconds
    web:
      advice:
        enable: true
      property-processor:
        enable: true
    secret:
      aes:
        key: "1234567890123456"
      rsa:
        pub-key: "..."
        pri-key: "..."
    server-client:
      server:
        port: 10000
        boss-size: 1
        worker-size: 4
      client:
        host: 127.0.0.1
        port: 10000
        event-loop-size: 2
```

配置说明:

| 配置 | 作用 |
| --- | --- |
| `fairychar.bag.aop.log.enable` | 开启请求日志，仅处理 `*..controller..*.*(..)` 下带 `@RequestLog` 的方法 |
| `fairychar.bag.aop.log.global-level` | 全局日志级别，`@RequestLog(loggingLevel = NONE)` 时使用 |
| `fairychar.bag.aop.log.global-before` | 全局前置 `LoggingHandler` Bean 名 |
| `fairychar.bag.aop.log.global-after` | 全局后置 `LoggingHandler` Bean 名 |
| `fairychar.bag.aop.lock.enable` | 开启 `@MethodLock` 方法锁功能 |
| `fairychar.bag.aop.lock.default-lock` | `@MethodLock(lockType = DEFAULT)` 时使用，不能为 `DEFAULT` |
| `fairychar.bag.aop.lock.global-timeout` | 乐观锁全局等待时间，默认 1 |
| `fairychar.bag.aop.lock.time-unit` | 乐观锁全局等待时间单位，默认 `SECONDS` |
| `fairychar.bag.web.advice.enable` | 开启统一异常返回功能 |
| `fairychar.bag.web.property-processor.enable` | 开启请求字段保留/擦除和响应脱敏功能 |
| `fairychar.bag.secret.aes.key` | 存在时注册 Hutool `AES` Bean |
| `fairychar.bag.secret.rsa.pub-key` + `pri-key` | 两者都存在时注册 Hutool `RSA` Bean |

## 自动配置 Bean

SDK 会按条件自动启用功能及注册 Bean，调用方无需手动注册内部配置类和字段处理 Advice：

- 全局异常处理：通过功能开关启用，业务抛出 `RestException`，无需调用内部处理器。
- 请求/响应字段处理：通过 `@KeepValue`、`@EraseValue`、`@FuzzyResult`、`@FuzzyValue` 使用。
- Controller 请求日志：通过 `@RequestLog` 与日志配置使用，无需手动注册或调用内部切面。
- 方法锁：通过 `@MethodLock` 与锁配置使用，无需手动注册或调用内部切面。
- Hutool `AES`、`RSA`: 由密钥配置触发。

上下文查询与初始化时机见 [Spring 上下文访问](spring-context.md)。

## 配置模型与默认值

完整 getter/setter、构造器及嵌套类型见 [properties API](../../api/properties.md)。直接 `new` 配置对象不会自动创建其嵌套对象；读取前应保证该配置分支已绑定或自行初始化。

| 配置类型 | 对应分支 | 默认值与限制 |
| --- | --- | --- |
| `FairycharBagProperties` | `fairychar.bag` 根对象 | `aop`、`serverClient`、`secret`、`web` 未显式初始化 |
| `AopProperties.Log` | `aop.log` | `enable=false`，`globalLevel=INFO`，handler 名默认 null；启用日志后应显式注册并指定 handler |
| `AopProperties.Lock` | `aop.lock` | `enable=false`，`globalTimeout=1`，`timeUnit=SECONDS`，`defaultLock=LOCAL` |
| `WebProperties.Advice` | `web.advice` | `enable=false` |
| `WebProperties.PropertyProcessor` | `web.property-processor` | `enable=false`；共同控制请求字段处理和响应脱敏 |
| `SecretProperties.AesProperties` | `secret.aes` | `key` 默认 null；不要将文档演示密钥用于生产 |
| `SecretProperties.RsaProperties` | `secret.rsa` | `pubKey`、`priKey` 默认 null；双方配置齐全才触发默认 RSA Bean |
| `NettyServerClientProperties.ClientProperties` | `server-client.client` | host 默认 null，port、eventLoopSize 默认 0；不会自动构造或启动客户端 |
| `NettyServerClientProperties.ServerProperties` | `server-client.server` | port、bossSize、workerSize 默认 0；不会自动构造或启动服务端 |

默认对象可替换性以具体 Bean 条件为准，不要假设所有默认 Bean 都有 `@ConditionalOnMissingBean`。业务自定义 Advice 时应检查是否与默认注册重复。

## 类型与完整签名

- [`com.fairychar.bag.properties.AopProperties.Lock`](../../api/properties--aopproperties-lock.md)
- [`com.fairychar.bag.properties.AopProperties.Log`](../../api/properties--aopproperties-log.md)
- [`com.fairychar.bag.properties.AopProperties`](../../api/properties--aopproperties.md)
- [`com.fairychar.bag.properties.FairycharBagProperties`](../../api/properties--fairycharbagproperties.md)
- [`com.fairychar.bag.properties.NettyServerClientProperties.ClientProperties`](../../api/properties--nettyserverclientproperties-clientproperties.md)
- [`com.fairychar.bag.properties.NettyServerClientProperties.ServerProperties`](../../api/properties--nettyserverclientproperties-serverproperties.md)
- [`com.fairychar.bag.properties.NettyServerClientProperties`](../../api/properties--nettyserverclientproperties.md)
- [`com.fairychar.bag.properties.SecretProperties.AesProperties`](../../api/properties--secretproperties-aesproperties.md)
- [`com.fairychar.bag.properties.SecretProperties.RsaProperties`](../../api/properties--secretproperties-rsaproperties.md)
- [`com.fairychar.bag.properties.SecretProperties`](../../api/properties--secretproperties.md)
- [`com.fairychar.bag.properties.WebProperties.Advice`](../../api/properties--webproperties-advice.md)
- [`com.fairychar.bag.properties.WebProperties.PropertyProcessor`](../../api/properties--webproperties-propertyprocessor.md)
- [`com.fairychar.bag.properties.WebProperties`](../../api/properties--webproperties.md)
