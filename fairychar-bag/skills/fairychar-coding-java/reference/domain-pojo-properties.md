# 常量、单例、POJO 与配置属性规范

适用于 `domain`、`pojo`、`configuration.properties` 中的数据、配置和公共对象。

## 常量容器

- 公共常量集中放 `domain.Consts`。
- `Consts` 是 `final` 类，并使用 `@NoArgsConstructor(access = AccessLevel.PRIVATE)`。
- 常量使用 `public static final` 与 UPPER_SNAKE_CASE：`EMPTY_STR`、`KB_PER_B`、`SIMPLE_DATETIME_FORMAT`。
- 通用哨兵字符串、日期格式、正则等不要在 aspect、validator、converter、utility 中重复写。
- 稳定小分组可使用嵌套 `public static final class`：`Consts.OAuth2`、`Consts.Regex`。
- 嵌套分组类名使用 UpperCamelCase，字段仍使用 UPPER_SNAKE_CASE。

## 单例容器

- 公共可复用对象放 `domain.Singletons`。
- 新增对象时添加嵌套 `*Bean` 类，例如 `RestTemplateBean`、`RandomBean`、`PathMatcherBean`、`GsonBean`、`JsonBean`。
- 单例 holder 使用：
  - `@NoArgsConstructor(access = AccessLevel.PRIVATE)`
  - 私有 enum `Singleton`
  - enum 中 `INSTANCE`
  - public static `getInstance()`
- 单例对象放在 enum 的 `private final transient` 字段中。
- 简单对象可内联初始化；复杂对象在 enum 构造器中配置。
- 需要外部配置、生命周期、条件替换的对象不要放 `Singletons`，应使用 Spring Bean。

## POJO 与 Lombok

典型数据对象：

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
public class InvalidateFieldVO implements Serializable {
    @Schema(description = "校验字段")
    private String field;
    @Schema(description = "校验失败原因")
    private String message;
}
```

- 简单 query/response 对象通常使用 `@Data`。
- 配置根对象如果附近代码使用 `@Getter/@Setter`，继续保持局部风格。
- POJO 字段优先写 `@Schema(description = "...")`。
- `pojo` 只放数据载体，不放业务逻辑、Spring Bean 或工具方法。

## Lombok 使用规范

Lombok 只用于减少样板代码，不能改变类型职责或隐藏不清晰的初始化逻辑。

| 场景 | 推荐注解 | 样例 |
| --- | --- | --- |
| 纯数据载体、响应包装、简单 Query/VO | `@Data`；需要链式赋值时加 `@Accessors(chain = true)`；需要框架/手动构造时加 `@NoArgsConstructor`、`@AllArgsConstructor` | `HttpResult` |
| 配置属性类 | `@Getter` + `@Setter` | `FairycharBagProperties`、`AopProperties` |
| 枚举错误码或只读字段枚举 | `@AllArgsConstructor` + `@Getter`，字段保持 `private final` | `RestErrorCode` |
| 异常类或只需要暴露读取的领域对象 | `@Getter` | `RestException` |
| 常量类、单例 holder、纯静态工具类 | `@NoArgsConstructor(access = AccessLevel.PRIVATE)`，类本身通常为 `final` | `Consts`、`Singletons.*Bean` |

具体约束：

- `@Data` 只用于纯数据对象；不要用在 Service、Controller、Mapper、Configurer、Aspect、Template、Util、Exception 上。
- 配置属性类不要用 `@Data`，保持 `@Getter/@Setter`，避免给配置对象生成不必要的 `equals/hashCode/toString`。
- 错误码 enum 可用 `@AllArgsConstructor/@Getter` 生成构造器和 getter，但如果接口方法需要稳定语义，继续显式实现 `getCode()`、`getMessage()`。
- 异常类只用 `@Getter` 暴露附加字段，不使用 `@Setter`，避免异常对象被外部修改。
- 常量类和静态工具类必须阻止实例化，优先用 `@NoArgsConstructor(access = AccessLevel.PRIVATE)`，不要手写空 public 构造器。
- 当前样例未使用 `@Builder`、`@Value`、`@Slf4j`、`@SneakyThrows`、`@RequiredArgsConstructor`；新增时不要默认引入，除非目标模块已有同类用法且理由明确。

## 配置属性

- 根配置类为 `FairycharBagProperties`。
- 根配置使用 `@ConfigurationProperties(prefix = "fairychar.bag")`。
- 所有配置属性类统一放在 `configuration.properties` 包下，不放在 `configuration` 直属包或旧 `properties` 顶层包。
- 功能配置类以 `Properties` 结尾；参考样例只保留 `FairycharBagProperties` 和 `AopProperties`。
- 根配置通过字段挂载功能配置对象，并在字段上使用 `@NestedConfigurationProperty`，例如 `private AopProperties aop;`。
- 功能配置内部的紧密子组使用 public static inner class，例如 `AopProperties.Log`、`AopProperties.Lock`。
- 需要表达多级配置时优先使用 `@NestedConfigurationProperty` 挂载下一层配置对象，而不是把所有字段压平到根配置；根配置挂功能配置，功能配置再挂内部子组时都按这个方式标注。
- Lombok 风格跟随附近文件：根或大配置类常用 `@Getter/@Setter`，叶子类可用 `@Data`。
- 布尔功能开关命名为 `enable`，对应配置键如 `fairychar.bag.aop.log.enable`。
- 只有代码依赖全局 fallback 时才提供默认值，例如 `RequestLog.Level.INFO`、`globalTimeout = 1`、`TimeUnit.SECONDS`。
- 外部敏感值或环境值默认留空，例如 AES/RSA key、Netty host/port、handler bean name。
- 字段使用 lowerCamelCase，并自然映射 kebab-case YAML：`serverClient` -> `server-client`。
- 新配置控制可选 Bean 时，必须在自动配置中接入条件判断。

## 样例

- `code/src/main/java/com/fairychar/bag/domain/Consts.java`
- `code/src/main/java/com/fairychar/bag/domain/Singletons.java`
- `code/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java`
- `code/src/main/java/com/fairychar/bag/configuration/properties/FairycharBagProperties.java`
- `code/src/main/java/com/fairychar/bag/configuration/properties/AopProperties.java`
