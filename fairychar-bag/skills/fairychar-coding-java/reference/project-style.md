# Fairychar Bag Src Style Reference

Use this only for Java work under `fairychar-bag/src`.

## Scope

- Evidence source: `fairychar-bag/src/main/java`, `fairychar-bag/src/main/resources`, `fairychar-bag/src/test`.
- Standalone evidence source: this skill's copied examples under `code/src/main/java`.
- Do not infer style from sibling modules, root docs, or archetype templates.
- Java baseline: 17.
- Common stack in this module: Spring Boot 3, Spring MVC, AOP, MyBatis-Plus integration helpers, Redis, Netty, Lombok, Hutool, Guava, Jackson, Logback, Jakarta Validation.

## Formatting And Checkstyle

- No tab characters.
- Max file length target: 2000 lines.
- Max line target: 140 columns. Existing code has a few long lines; avoid adding more.
- Braces are required around blocks.
- Normal Java naming rules apply; `ID`, `URL`, and `XML` are allowed abbreviations.
- Javadocs are present but not strict; prefer short Chinese comments or concise technical comments where they clarify public APIs.

## Package And Type Naming

Main packages:

| Package | Purpose |
| --- | --- |
| `aop` | Aspect entry points. |
| `beans` | AOP handlers, MyBatis helpers, Redis serializers, Netty wrappers, Spring MVC advice/converters. |
| `configurer` | `BagBeansAutoConfigurer` and feature auto-config. |
| `domain` | annotations, exceptions, enums, validators, conditional annotations, Netty domain types. |
| `extension` | request/concurrent/calculator/action extensions. |
| `function` | small functional interfaces such as `Action`. |
| `pojo` | `ao`, `dto`, `query`, `vo` objects. |
| `properties` | `@ConfigurationProperties` trees. |
| `template` | reusable template-method helpers. |
| `utils` | static utility classes. |

Naming patterns:

- Interfaces often start with `I`: `IBalkingReference`, `ITenantSkipper`, `ITenantSwitcher`, `IShardingProcessor`.
- Request/simple input objects use `*Query`.
- Response wrappers use `*VO` or `HttpResult`.
- Auto-config: `*AutoConfigurer` or `*Configuration`.
- AOP types: `*AspectJ`, `*Handler`, `*Helper`.
- Static utilities: `*Util`.
- Template helpers: `*Template`.

## Class Naming

- Use UpperCamelCase for classes, interfaces, annotations, and enums.
- Interfaces that represent extension points or processors commonly start with `I`: `IBalkingReference`, `ITenantSkipper`, `IShardingProcessor`.
- Abstract base classes start with `Abstract`: `AbstractBalkingReference`, `AbstractScheduleAction`, `AbstractPatternValidator`.
- AOP entry classes end with `AspectJ`: `LoggingAspectJ`, `MethodLockAspectJ`.
- Spring MVC advice classes end with `Advice`: `DefaultExceptionAdvice`, `FuzzyValueAdvice`.
- Handler implementations end with `Handler`: `LoggingHandler`, `JsonLoggingHandler`, `SwaggerLoggingHandler`.
- Utility classes end with `Util` and are usually `final`: `StringUtil`, `DateConvertUtil`, `RequestUtil`.
- Template-method helpers end with `Template`: `CacheOperateTemplate`, `ActionSelectorTemplate`.
- Configuration property classes end with `Properties`: `FairycharBagProperties`, `AopProperties`, `SecretProperties`.
- Annotation/validator pairs use the annotation name plus `Validator`: `Phone` and `PhoneValidator`, `DateBetween` and `DateValidator`.
- Simple request/response data objects keep suffixes such as `*Query`, `*VO`, `*AO`, `*Node`.

## Method Naming

- Use lowerCamelCase for methods.
- Boolean-returning checks may use `is*`, `has*`, or domain verbs matching framework APIs, for example `isValid`.
- Conversion methods use `sourceToTarget` naming: `dateToLocaldateTime`, `localdateToDate`, `entityToMap`, `mapToEntity`.
- Parsing and resolving methods use verb-first names: `parseTime`, `parseDate`, `resolveNameExpression`, `createEvaluationContext`.
- Factory/cache helpers use explicit action names: `createOrGetLocalLock`, `getAndPutCacheIfNeeded`.
- AOP lifecycle methods use timing prefixes: `beforeLogging`, `afterLogging`, `handleBefore`, `handleAfter`.
- Collection/tree utilities describe the operation and shape: `splitList`, `listToTree`, `mapToNode`, `recursiveSearchChild`, `recursiveSearchParent`.
- Keep Spring/framework override names unchanged: `afterPropertiesSet`, `convert`, `isValid`, `pkVal`.
- Avoid vague names like `doIt`, `process`, or `handle` unless paired with a specific domain noun.

## Constants And Singleton Containers

Use this for shared domain-level constants and reusable singleton objects under `com.fairychar.bag.domain`.

- Central constants live in `Consts`, a `final` class with `@NoArgsConstructor(access = AccessLevel.PRIVATE)`.
- Constant names use `public static final` plus UPPER_SNAKE_CASE: `EMPTY_STR`, `KB_PER_B`, `SIMPLE_DATETIME_FORMAT`, `MYSQL_MAX_DATETIME`.
- Keep common sentinel strings and date/time formats in `Consts` instead of duplicating literals in aspects, validators, converters, or utilities.
- Group related constants with nested `public static final class` types when the group is stable and small: `Consts.OAuth2`, `Consts.Regex`.
- Nested constant group names use UpperCamelCase by domain, while their fields remain UPPER_SNAKE_CASE.
- Prebuilt formatter/date constants can live beside their source pattern constants: `SIMPLE_DATETIME_FORMAT` and `SIMPLE_DATE_TIME_FORMATTER`.
- Common reusable object holders live in `Singletons`; add a nested `*Bean` class such as `RestTemplateBean`, `RandomBean`, `PathMatcherBean`, `GsonBean`, or `JsonBean`.
- Singleton holder classes use `@NoArgsConstructor(access = AccessLevel.PRIVATE)`, a private enum named `Singleton` with `INSTANCE`, and a public static `getInstance()` method.
- Store singleton objects in `private final transient` fields inside the enum; initialize simple objects inline or configure complex objects in the enum constructor.
- Put object setup next to creation, for example the `ObjectMapper` settings in `JsonBean.Singleton`.
- Prefer `Singletons.*Bean.getInstance()` for shared infrastructure objects already represented there; use Spring beans when the object needs external configuration, lifecycle hooks, or conditional replacement.

Copied examples:

- `code/src/main/java/com/fairychar/bag/domain/Consts.java`
- `code/src/main/java/com/fairychar/bag/domain/Singletons.java`

## Lombok And POJO Style

Typical data objects:

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

Use `@Getter/@Setter` for configuration roots when nearby properties classes do so. Use `@Data` for simple query/response objects.

## Configuration Properties Style

Use this for code under `com.fairychar.bag.properties`.

- Root configuration class is `FairycharBagProperties`, annotated with `@ConfigurationProperties(prefix = "fairychar.bag")`.
- Feature property classes end with `Properties`: `AopProperties`, `ConvertProperties`, `NettyServerClientProperties`, `SecretProperties`, `WebProperties`.
- Nested config groups are public static inner classes with clear feature names: `AopProperties.Log`, `AopProperties.Lock`, `ConvertProperties.Mvc`, `WebProperties.Advice`.
- Mark nested property fields with `@NestedConfigurationProperty` when the existing nearby class does so, especially on root or multi-level property objects.
- Lombok style is local: `FairycharBagProperties`, `AopProperties`, and `ConvertProperties` use `@Getter/@Setter`; several leaf classes use `@Data`. Match the surrounding file instead of forcing one Lombok annotation everywhere.
- Boolean feature switches are named `enable`, not `enabled`, to match config keys like `fairychar.bag.aop.log.enable`.
- Provide defaults only where the code relies on global fallback behavior, for example `RequestLog.Level.INFO`, `globalTimeout = 1`, `TimeUnit.SECONDS`, `MethodLock.Type.LOCAL`.
- Leave optional external values unset by default, for example AES/RSA keys, Netty host/port, handler bean names.
- Property field names use lowerCamelCase and map directly to kebab-case YAML keys: `serverClient` -> `server-client`, `globalBefore` -> `global-before`, `propertyProcessor` -> `property-processor`.
- Add short comments for non-obvious semantics, especially feature switches, timeout units, lock types, and advice/property processor behavior.
- New properties must be wired through `BagBeansAutoConfigurer` with `@EnableConfigurationProperties(FairycharBagProperties.class)` and conditional annotations when they control optional beans.

Copied examples:

- `code/src/main/java/com/fairychar/bag/properties/FairycharBagProperties.java`
- `code/src/main/java/com/fairychar/bag/properties/AopProperties.java`
- `code/src/main/java/com/fairychar/bag/properties/ConvertProperties.java`
- `code/src/main/java/com/fairychar/bag/properties/NettyServerClientProperties.java`
- `code/src/main/java/com/fairychar/bag/properties/SecretProperties.java`
- `code/src/main/java/com/fairychar/bag/properties/WebProperties.java`
- `code/src/main/java/com/fairychar/bag/configurer/BagBeansAutoConfigurer.java`

## Exceptions And Responses

- API/business failures use `RestException(RestErrorCode.*)`.
- Lower-level utility failures may use `FBException`.
- Parameter validation is handled by advice and returns `HttpResult.fail(RestErrorCode.PARAM_INVALIDATE, ...)`.
- Generic system failures log `error("system error,msg={}", e.getMessage(), e)` and return `HttpResult.fail()`.
- Expected validation/business failures should not be logged as system errors.

Copied examples:

- `code/src/main/java/com/fairychar/bag/domain/exceptions/IRestErrorCode.java`
- `code/src/main/java/com/fairychar/bag/domain/exceptions/RestErrorCode.java`
- `code/src/main/java/com/fairychar/bag/domain/exceptions/RestException.java`
- `code/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java`

## Logging

- Use `@Slf4j`.
- Prefer parameterized logs: `log.info("message key={}", value)`.
- Debug-level structured logs are acceptable for validation details.
- Do not introduce `System.out.println` in production code; tests currently use it, but new production code should not.

## Utility And Template Style

Static utility classes usually look like:

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {
    public static String defaultText(String source, String text) {
        return Strings.isNullOrEmpty(source) ? text : source;
    }
}
```

Template helpers use `Supplier`, `Consumer`, and project functional interfaces to isolate repeated control flow.

## Auto-Configuration Style

`BagBeansAutoConfigurer` groups optional features with nested `protected static` configuration classes.

- Feature switches use `@ConditionalOnProperty`.
- Defaults that users may replace use `@ConditionalOnMissingBean`.
- Properties are enabled with `@EnableConfigurationProperties(FairycharBagProperties.class)`.
- New auto-config classes must be listed in `fairychar-bag/src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`.

## AOP And Handlers

- Aspect entry classes end with `AspectJ`.
- Annotations in `domain.annotations` describe behavior, while `aop` implements it.
- Handler extension points are interfaces or simple beans, for example `LoggingHandler`.
- Method bodies usually validate early, return early on disabled features, then delegate to private helpers.

## Validators And Converters

- Validation annotations live under `domain.validator.rest`.
- Validator implementations are paired by name, for example `Phone` and `PhoneValidator`.
- Spring converters live under `beans.spring.converter`.
- Prefer project exceptions or `Assert` checks over silent failures for invalid configuration.

## Tests

The Maven/Surefire config skips tests by default. Existing tests are light and often exploratory. Still add focused tests for new behavior, especially validators, utility methods, converters, AOP helpers, serializers, and error handling.
