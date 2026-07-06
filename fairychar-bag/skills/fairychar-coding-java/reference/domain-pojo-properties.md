# 常量、单例、POJO 与配置属性规范

适用于 `domain`、`pojo`、`properties` 中的数据、配置和公共对象。

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

## 配置属性

- 根配置类为 `FairycharBagProperties`。
- 根配置使用 `@ConfigurationProperties(prefix = "fairychar.bag")`。
- 功能配置类以 `Properties` 结尾：`AopProperties`、`ConvertProperties`、`NettyServerClientProperties`、`SecretProperties`、`WebProperties`。
- 嵌套配置组使用 public static inner class：`AopProperties.Log`、`AopProperties.Lock`、`ConvertProperties.Mvc`。
- 需要表达多级配置时，按附近代码使用 `@NestedConfigurationProperty`。
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
- `code/src/main/java/com/fairychar/bag/properties/FairycharBagProperties.java`
- `code/src/main/java/com/fairychar/bag/properties/AopProperties.java`
- `code/src/main/java/com/fairychar/bag/properties/WebProperties.java`
