# 可复用库代码规范

适用于 `fairychar-bag/src` 下的 starter/library 能力：AOP、Bean、工具、模板、校验器、转换器、Netty/Redis/Spring 集成等。

## 类与方法命名

- 类、接口、注解、枚举使用 UpperCamelCase。
- 接口代表扩展点或处理器时常用 `I*`：`IBalkingReference`、`ITenantSkipper`、`IShardingProcessor`。
- 抽象基类以 `Abstract` 开头：`AbstractBalkingReference`、`AbstractScheduleAction`。
- AOP 入口类以 `AspectJ` 结尾：`LoggingAspectJ`、`MethodLockAspectJ`。
- Spring MVC advice 以 `Advice` 结尾：`DefaultExceptionAdvice`、`FuzzyValueAdvice`。
- handler 实现以 `Handler` 结尾：`LoggingHandler`、`JsonLoggingHandler`。
- 工具类以 `Util` 结尾，并通常声明为 `final`。
- 模板方法类以 `Template` 结尾。
- 注解与校验器成对命名：`Phone` 与 `PhoneValidator`。

## 方法命名

- 方法使用 lowerCamelCase。
- 布尔检查使用 `is*`、`has*` 或框架约定名，例如 `isValid`。
- 转换方法使用 sourceToTarget 语义：`dateToLocaldateTime`、`mapToEntity`。
- 解析/构建方法使用动词开头：`parseTime`、`resolveNameExpression`、`createEvaluationContext`。
- 工厂/缓存方法写清动作：`createOrGetLocalLock`、`getAndPutCacheIfNeeded`。
- AOP 生命周期方法使用时机前缀：`beforeLogging`、`afterLogging`、`handleBefore`、`handleAfter`。
- 集合/树工具说明操作和结构：`splitList`、`listToTree`、`recursiveSearchChild`。
- Spring/framework override 保留框架命名：`afterPropertiesSet`、`convert`、`isValid`。
- 避免 `doIt`、`process`、`handle` 这类无领域名词的泛化方法名。

## AOP 与 Handler

- 切面入口放 `aop`，命名为 `*AspectJ`。
- 行为注解放 `domain.annotations`，切面实现放 `aop`。
- 处理器、helper、可替换协作者放 `beans.aop`。
- 方法体通常先校验、再按配置开关提前返回、最后委托私有方法或 handler。

## Utility 与 Template

静态工具类通常：

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {
    public static String defaultText(String source, String text) {
        return Strings.isNullOrEmpty(source) ? text : source;
    }
}
```

- 工具类不持有 Spring 生命周期。
- 工具内部辅助对象放 `utils.base`。
- 模板类使用 `Supplier`、`Consumer`、项目函数式接口隔离重复控制流。

## Validator 与 Converter

- Validation 注解放 `domain.validator.rest`。
- Validator 实现与注解成对命名。
- Validation group marker 放 `domain.validator.rest.group`。
- Spring converter 放 `beans.spring.converter`。
- 无效配置优先抛项目异常或使用 `Assert` 明确失败，不要静默忽略。

## Logging

- 使用 `@Slf4j`。
- 使用参数化日志：`log.info("message key={}", value)`。
- 校验细节可使用 debug 级别结构化日志。
- 生产代码禁止新增 `System.out.println`。

## 样例

- `code/src/main/java/com/fairychar/bag/aop/...`
- `code/src/main/java/com/fairychar/bag/beans/...`
- `code/src/main/java/com/fairychar/bag/utils/...`
- `code/src/main/java/com/fairychar/bag/template/...`
