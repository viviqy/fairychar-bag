# 包结构与类型命名规范

新增类时先按职责选包，再按后缀命名。不要先想类名再随手放包。

## 总体边界

- `fairychar-bag/src` 是可复用 starter/library 代码，不新增应用层 `controller/service/mapper/entity`。
- 应用业务模块可以使用 `controller`、`service`、`service.interfaces`、`mapper`、`entity` 等结构，但只能在目标模块已有或明确需要应用层结构时使用。
- 不创建泛化包：`common`、`core`、`manager`、`support`、`handler`。只有现有树中已经存在同职责窄包时才沿用。

## 顶层包职责

| 包 | 职责 |
| --- | --- |
| `aop` | AOP 切面入口，只放 `*AspectJ` 等切面类。 |
| `beans` | 可替换 Spring Bean、框架适配器、技术集成 Bean，必须继续放入技术子包。 |
| `configurer` | 自动配置类，例如 `BagBeansAutoConfigurer`。 |
| `domain` | 库级公共契约：注解、异常、枚举、校验、条件注解、Netty 领域对象、常量、单例。 |
| `extension` | 有状态或对象行为的运行时扩展，例如请求包装、并发执行器、计算器、集合扩展。 |
| `function` | 小型函数式接口、回调接口、处理器接口。 |
| `listener` | Spring 生命周期、上下文监听或持有器。 |
| `pojo` | 纯数据载体：`ao`、`dto`、`query`、`vo`。 |
| `configuration` | 自动配置辅助对象；配置属性类统一放在 `configuration.properties`。 |
| `proxy` | 动态代理、fallback 代理等。 |
| `mapper` | 应用模块 MyBatis-Plus Mapper 接口；只声明方法，不写 SQL。 |
| `template` | 模板方法类，封装重复控制流并通过回调扩展。 |
| `utils` | 无状态静态工具类；内部辅助对象放 `utils.base`，测试工具放 `utils.test`。 |

## 详细放置规则

| 新增类型 | 放置位置 | 示例 |
| --- | --- | --- |
| 注解驱动或横切逻辑切面入口 | `aop` | `LoggingAspectJ`、`MethodLockAspectJ` |
| AOP handler/helper | `beans.aop` | `LoggingHandler`、`JsonLoggingHandler`、`LoggingHelper` |
| MyBatis type handler | `beans.mybatis.handler` | `AesTypeHandler`、`RsaTypeHandler` |
| MyBatis interceptor、租户切换、租户跳过契约 | `beans.mybatis.interceptor` | `ITenantSkipper`、`SwitchableTenantLineInnerInterceptor` |
| Netty client/server/decoder Bean | `beans.netty.client`、`beans.netty.server`、`beans.netty.decoder` | `SimpleNettyClient`、`SimpleNettyServer` |
| Redis serializer 或 Redis 集成 Bean | `beans.redis` | `GzipStringSerializer`、`PrefixStringSerializer` |
| Spring MVC/global advice | `beans.spring.advice` | `DefaultExceptionAdvice`、`InvalidateLog` |
| Spring converter | `beans.spring.converter` | `StringToLocalDateConverter` |
| MVC 响应/请求 body advice、脱敏注解、属性处理器 | `beans.spring.mvc` | `FuzzyValueAdvice`、`EraseValue`、`FuzzyValueProcessor` |
| Swagger/OpenAPI 插件或注解 | `beans.swagger` | `RequestIgnoreParameterPlugin`、`ShowParam` |
| AOP/Netty 等基础设施消费的注解 | `domain.annotations` | `RequestLog`、`MethodLock`、`CauseHandler` |
| 抽象基类 | `domain.abstracts` | `AbstractBalkingReference`、`AbstractScheduleAction` |
| 并发契约 | `domain.concurrent` | `IBalkingReference` |
| Spring 条件注解及 Condition 实现 | `domain.conditional` | `ConditionalOnSystemOS`、`OnSystemOsCondition` |
| 错误码、REST/业务异常、异常标记 | `domain.exceptions` | `IRestErrorCode`、`RestException`、`RestErrorCode` |
| 库级枚举 | `domain.enums` | `RunState` |
| Netty advice dispatcher 或帧对象 | `domain.netty.advice`、`domain.netty.frame` | `GlobalInboundCauseAdvice`、`HeadTailFrame` |
| Spring marker、表达式上下文对象 | `domain.spring`、`domain.spring.expression` | `BeanAwareMarker`、`SimpleEvaluationContext` |
| Jakarta Validation 注解或校验器 | `domain.validator.rest` | `Phone`、`PhoneValidator` |
| Validation group marker interface | `domain.validator.rest.group` | `InsertVali`、`UpdateVali` |
| Action-flow builder、条件树 | `extension.action.condition.bool` | `ActionFlow`、`FlowBuilder`、`RootAction` |
| 计算器或操作符扩展 | `extension.calculator` | `BaseCalculator`、`Operator` |
| 集合对象扩展 | `extension.collection` | `BiPredicateList` |
| 并发执行器、调度对象 | `extension.concurrent` | `RepeatTaskExecutor`、`RoundTaskExecutor` |
| Servlet request wrapper、mock、stream、header holder | `extension.request` | `ClonedServletRequest`、`HeaderValueHolder` |
| 函数式回调、分片处理器接口 | `function` | `Action`、`IShardingProcessor` |
| Spring context holder/listener | `listener` | `SpringContextHolder` |
| 输入或中间聚合对象 | `pojo.ao` | `MappingAO`、`TreeNode` |
| 传输对象、键值载体 | `pojo.dto` | `KeyValuePair` |
| 请求/query/body 载体 | `pojo.query`、`pojo.query.body` | `DateBetweenQuery`、`StringBodyQuery` |
| 响应包装或校验结果对象 | `pojo.vo` | `HttpResult`、`InvalidateFieldVO` |
| 功能配置分组 | `configuration.properties` | `FairycharBagProperties`、`AopProperties` |
| 应用模块 MyBatis-Plus Mapper 接口 | `mapper` | `SysDictMapper` |
| 应用模块 Mapper XML | `src/resources/mapper` | `SysDictMapper.xml` |
| 动态代理、fallback factory | `proxy` | `FeignFallbackProxy` |
| 可复用控制流模板 | `template` | `CacheOperateTemplate`、`ActionSelectorTemplate` |
| 静态工具 | `utils` | `RequestUtil`、`SpelUtil`、`FileUtil` |
| 工具内部辅助对象 | `utils.base` | `FieldContainer` |
| 测试专用工具 | `utils.test` | `TaskTestUtil` |
| 应用模块 REST Controller | `controller` | `PermissionPolicyController` |
| 应用模块 Service 接口 | `service.interfaces` | `IPermissionPolicyService` |
| 应用模块 Service 实现 | `service` | `PermissionPolicyService` |

## 决策规则

- 需要 Spring 生命周期、可被用户替换、属于技术集成：优先 `beans.<technology>` 或 `configurer`。
- 公共注解、枚举、异常、校验契约、marker：优先 `domain.<kind>`。
- 有对象状态或运行时行为的包装/扩展：优先 `extension.<feature>`，不要放 `utils`。
- 全静态、无 Spring 生命周期：放 `utils`。
- 只有一个类的新包要谨慎；先检查现有包是否已表达同一职责。
- 应用模块已有 `controller/service/service.interfaces/mapper` 时，按样例布局：Service 接口在 `service.interfaces`，Service 实现在 `service`，控制器在 `controller`，Mapper 接口在 `mapper`，SQL XML 在 `src/resources/mapper`。

## 命名模式

- 接口常用 `I*`：`IBalkingReference`、`ITenantSkipper`、`IShardingProcessor`。
- 应用 Service 接口：`I<Name>Service`；实现：`<Name>Service`。
- 请求对象：`*Query`。
- 响应对象：`*VO` 或 `HttpResult`。
- 自动配置：`*AutoConfigurer` 或 `*Configuration`。
- AOP：`*AspectJ`、`*Handler`、`*Helper`。
- 工具类：`*Util`。
- 模板类：`*Template`。
- 配置属性：`*Properties`。
