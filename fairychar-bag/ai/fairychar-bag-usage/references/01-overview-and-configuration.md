# Overview And Configuration Reference

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。本文件只保留说明、约束和 API 语义；代码示例放在 `../scripts/`。

## 基本信息

- Maven 模块: `fairychar-bag`
- Java 版本: 17
- 自动配置入口:
  - `com.fairychar.bag.configurer.BagBeansAutoConfigurer`
  - `com.fairychar.bag.listener.SpringContextHolder`
- Spring Boot 自动配置文件: `src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`
- 配置前缀: `fairychar.bag`
- 代码风格:
  - 工具类通常为 `final` + 私有无参构造。
  - 接口常用 `I*` 命名。
  - DTO/VO/Query/Properties/Util/Template/Configurer/AspectJ/Handler 后缀按现有风格延续。
  - REST 失败优先用 `RestException`、`RestErrorCode`、`HttpResult`。

## 依赖注意事项

`fairychar-bag` 的很多依赖是 `provided`，使用对应能力时业务应用需要自己提供运行时 Bean 或依赖:

- Redis 锁和 Redis 序列化: 需要 Spring Data Redis、Redisson。
- 方法锁 Redis 模式: 需要 Spring 容器中有 `RedissonClient`。
- 方法锁 ZK 模式: 需要 Spring 容器中有 `CuratorFramework`。
- MyBatis Plus 租户拦截器: 需要 MyBatis Plus extension。
- Netty: 需要 Netty。
- Web/MVC/校验/AOP: 需要 Spring MVC、Hibernate Validator、Spring AOP。

## 推荐配置

按需开启功能，未开启的切面或 MVC Advice 不会自动注册。


> 代码示例已移到 `../scripts/01-overview-and-configuration-examples.md`，对应标题: `推荐配置`。


配置说明:

| 配置 | 作用 |
| --- | --- |
| `fairychar.bag.aop.log.enable` | 注册 `LoggingAspectJ`，仅拦截 `*..controller..*.*(..)` 下带 `@RequestLog` 的方法 |
| `fairychar.bag.aop.log.global-level` | 全局日志级别，`@RequestLog(loggingLevel = NONE)` 时使用 |
| `fairychar.bag.aop.log.global-before` | 全局前置 `LoggingHandler` Bean 名 |
| `fairychar.bag.aop.log.global-after` | 全局后置 `LoggingHandler` Bean 名 |
| `fairychar.bag.aop.lock.enable` | 注册 `MethodLockAspectJ` |
| `fairychar.bag.aop.lock.default-lock` | `@MethodLock(lockType = DEFAULT)` 时使用，不能为 `DEFAULT` |
| `fairychar.bag.aop.lock.global-timeout` | 乐观锁全局等待时间，默认 1 |
| `fairychar.bag.aop.lock.time-unit` | 乐观锁全局等待时间单位，默认 `SECONDS` |
| `fairychar.bag.web.advice.enable` | 注册 `DefaultExceptionAdvice` |
| `fairychar.bag.web.property-processor.enable` | 注册 `KeepValueAdvice`、`EraseValueAdvice`、`FuzzyValueAdvice` |
| `fairychar.bag.convert.mvc.enable` | 注册 `String -> LocalDate`、`String -> LocalDateTime` 转换器 |
| `fairychar.bag.secret.aes.key` | 存在时注册 Hutool `AES` Bean |
| `fairychar.bag.secret.rsa.pub-key` + `pri-key` | 两者都存在时注册 Hutool `RSA` Bean |

## 自动配置 Bean

`BagBeansAutoConfigurer` 会按条件注册:

- `DefaultExceptionAdvice`: 全局异常处理。
- `KeepValueAdvice`、`EraseValueAdvice`、`FuzzyValueAdvice`: 请求/响应字段处理。
- `LoggingAspectJ`: Controller 日志切面。
- `MethodLockAspectJ`: 方法锁切面。
- `StringToLocalDateConverter`、`StringToLocalDateTimeConverter`: MVC 字符串日期转换。
- Hutool `AES`、`RSA`: 由密钥配置触发。

`SpringContextHolder` 也在自动配置列表中，很多工具通过它按类型获取 Spring Bean，例如 `RedissonClient`、`CuratorFramework`、`FuzzyValueProcessor`。

