# fairychar-bag 使用说明

`fairychar-bag` 是 Fairychar 项目的通用开发工具包，提供 Spring Boot 自动配置、Web 返回体、统一异常、AOP 日志、方法锁、参数校验、请求/响应字段处理、MyBatis 加解密和租户拦截器、Redis/缓存工具、Netty 简化封装、并发任务工具、反射映射工具等能力。

本文档按当前源码重写，目标读者是需要在本项目内继续写代码的 agent。写代码前优先参考本文档和源码，不要只依赖旧示例。

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
    convert:
      mvc:
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

## 统一响应和异常

### HttpResult

位置: `com.fairychar.bag.pojo.vo.HttpResult`

字段:

- `code`: 业务码。
- `data`: 返回数据，字段本身带 `@FuzzyValue`，可配合 `@FuzzyResult(field = "data")` 对包装数据脱敏。
- `msg`: 消息。

常用方法:

```java
return HttpResult.ok();
return HttpResult.ok(user);
return HttpResult.fail();
return HttpResult.fail(RestErrorCode.DATA_NOT_EXIST);
return HttpResult.fail(RestErrorCode.PARAM_INVALIDATE, errors);
return HttpResult.response(HttpStatus.BAD_REQUEST, RestErrorCode.PARAM_ERROR, null);
```

`response(...)` 会通过 `RequestUtil.getCurrentResponse()` 设置 HTTP 状态码，必须在 Web 请求线程中使用。

### RestErrorCode

位置: `com.fairychar.bag.domain.exceptions.RestErrorCode`

错误码按区间分组:

- `10000-11000`: 参数、文件类。
- `12000+`: 数据操作类。
- `14000+`: 权限类。
- `18000+`: 通用业务异常。
- `19000+`: 微服务类。
- `20000+`: 系统类。

新增业务错误码时优先实现 `IRestErrorCode` 或扩展现有枚举风格，不要在业务代码中散落裸数字和裸字符串。

### RestException / FBException

推荐:

```java
throw new RestException(RestErrorCode.DATA_NOT_EXIST);
throw new RestException(RestErrorCode.PARAM_ERROR, "用户 id 不能为空");
throw new RestException(RestErrorCode.DATA_EXIST, "用户名已存在", username);
```

`DefaultExceptionAdvice` 会处理:

- `BindException`
- `ConstraintViolationException`
- `MethodArgumentNotValidException`
- `FBException`
- `RestException`
- 其他 `Exception`

开启方式:

```yaml
fairychar:
  bag:
    web:
      advice:
        enable: true
```

## AOP 日志

### 使用方式

开启切面:

```yaml
fairychar:
  bag:
    aop:
      log:
        enable: true
        global-level: info
        global-before: jsonLoggingHandler
        global-after: jsonLoggingHandler
```

注册日志处理器:

```java
@Configuration
class LoggingConfiguration {
    @Bean
    LoggingHandler jsonLoggingHandler(ObjectMapper objectMapper) {
        return new JsonLoggingHandler(objectMapper, false);
    }

    @Bean
    LoggingHandler ignoreContentLoggingHandler() {
        return new IgnoreContentLoggingHandler();
    }
}
```

Controller 使用:

```java
@RestController
@RequestMapping("/users")
class UserController {
    @RequestLog(
            beforeHandler = "jsonLoggingHandler",
            afterHandler = "jsonLoggingHandler",
            loggingLevel = RequestLog.Level.INFO
    )
    @PostMapping
    public HttpResult<UserVO> create(@RequestBody @Valid CreateUserQuery query) {
        return HttpResult.ok(userService.create(query));
    }
}
```

切面只匹配:

```text
execution(public * *..controller..*.*(..)) && @annotation(requestLog)
```

因此方法必须在包路径含 `controller` 的类中，且方法上必须标 `@RequestLog`。

### @RequestLog

| 属性 | 默认值 | 说明 |
| --- | --- | --- |
| `enable` | `true` | 单方法开关 |
| `loggingLevel` | `NONE` | `NONE` 表示使用全局 `global-level` |
| `beforeHandler` | `""` | 前置处理器 Bean 名，空则用 `global-before` |
| `afterHandler` | `""` | 后置处理器 Bean 名，空则用 `global-after` |

### 内置 LoggingHandler

| 类 | 行为 |
| --- | --- |
| `SimpleLoggingHanlder` | 打印 IP、URI、请求参数、响应结果 |
| `SwaggerLoggingHandler` | 依赖 `@Tag` 和 `@Operation(operationId)`，打印接口名称 |
| `JsonLoggingHandler` | 以 JSON 打印 request/response，自动处理 `MultipartFile`、`HttpServletRequest`、`HttpServletResponse` |
| `IgnoreContentLoggingHandler` | 只打印 IP 和 URI，不打印 body/response |

注意:

- `SwaggerLoggingHandler` 未对缺少 `@Tag`、`@Operation` 做空值保护，使用前要保证注解存在。
- `JsonLoggingHandler` 使用请求头 `TRACE_ID`；没有该请求头时会生成 UUID 并写入 request attribute。

## 方法锁 @MethodLock

开启:

```yaml
fairychar:
  bag:
    aop:
      lock:
        enable: true
        default-lock: local
        global-timeout: 2
        time-unit: seconds
```

本地锁:

```java
@Service
class OrderService {
    @MethodLock(lockType = MethodLock.Type.LOCAL, nameExpression = "'order:' + #orderId")
    public void updateLocal(Long orderId) {
        // 同 JVM 内同 orderId 串行
    }
}
```

Redis 分布式锁:

```java
@MethodLock(
        lockType = MethodLock.Type.REDIS,
        optimistic = true,
        timeout = 3,
        timeUnit = TimeUnit.SECONDS,
        distributedPrefix = "fairychar:order:",
        nameExpression = "'stock:' + #skuId"
)
public void deductStock(Long skuId) {
    // 未在 3 秒内拿到锁时抛 FailToGetLockException
}
```

ZooKeeper 分布式锁:

```java
@MethodLock(
        lockType = MethodLock.Type.ZK,
        optimistic = false,
        distributedPrefix = "/fairychar/order/",
        nameExpression = "'pay:' + #orderId"
)
public void pay(Long orderId) {
    // 悲观阻塞直到拿到锁
}
```

属性说明:

| 属性 | 默认值 | 说明 |
| --- | --- | --- |
| `lockType` | `DEFAULT` | `DEFAULT` 使用全局 `default-lock`，可选 `LOCAL`、`REDIS`、`ZK` |
| `enable` | `true` | false 时直接执行原方法 |
| `timeout` | `-1` | 乐观锁等待时间，`-1` 使用全局 |
| `optimistic` | `false` | true 使用 `tryLock/acquire(timeout)`，false 阻塞获取锁 |
| `timeUnit` | `NANOSECONDS` | 作为“使用全局单位”的哨兵值 |
| `nameExpression` | `""` | SpEL 表达式，空时使用方法全路径作为锁名 |
| `distributedPrefix` | `fairychar:lock:` | Redis key 前缀或 ZK path 前缀 |

实现约束:

- Redis 模式从 `SpringContextHolder` 取 `RedissonClient`。
- ZK 模式从 `SpringContextHolder` 取 `CuratorFramework`。
- 本地锁使用 `ConcurrentHashMap<String, ReentrantLock>` 保存锁实例。
- `nameExpression` 没有 `#` 时会按普通 SpEL 字面表达式求值，常量字符串要写成 `"'collector'"`，否则可能被当成属性名解析。

## 参数校验和自定义 Validator

### 标准校验异常处理

开启:

```yaml
fairychar:
  bag:
    web:
      advice:
        enable: true
```

Controller:

```java
@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @Valid CreateUserQuery query) {
    return HttpResult.ok();
}
```

校验失败会返回:

```json
{
  "code": 10000,
  "data": [
    {
      "field": "phone",
      "msg": "not phone number",
      "defaultMessage": null
    }
  ],
  "msg": "参数校验失败"
}
```

### BindingResultUtil

位置: `com.fairychar.bag.utils.BindingResultUtil`

用于手动检查 `BindingResult`，有错误时抛 `ParamErrorException`。

```java
@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @Valid CreateUserQuery query, BindingResult bindingResult) {
    BindingResultUtil.checkBindingErrors(bindingResult);
    return HttpResult.ok();
}
```

### 内置校验注解

| 注解 | 类型 | 说明 |
| --- | --- | --- |
| `@Phone` | `String` | Hutool 手机号校验 |
| `@IdCard` | `String` | Hutool 身份证校验 |
| `@Url` | `String` | 使用 `Consts.Regex.URL` |
| `@IP` | `String` | 使用 `Consts.Regex.IP` |
| `@In({"A","B"})` | `String` | 值必须在数组内 |
| `@NotIn({"A","B"})` | `String` | 值不能在数组内 |
| `@StartWith(value = {"pre"}, ignoreCase = true, ignoreEmpty = false)` | `Object` | 字符串前缀校验 |
| `@EndWith(value = {"suf"}, ignoreCase = true, ignoreEmpty = false)` | `Object` | 源码当前实际使用 `startsWith` 判断，使用前注意 |
| `@Language(LanguageType.CHINESE)` | `String` | 按内置正则校验语言字符 |
| `@DateBetween(pattern = "yyyy-MM-dd", min = "2024-01-01", max = "now")` | `String` | 日期范围，不含边界 |
| `@TimeBetween(pattern = "yyyy-MM-dd HH:mm:ss", min = "now", max = "2099-12-31 23:59:59")` | `String` | 时间范围，不含边界 |
| `@FileSize(unit = FileSize.Unit.MB, min = 1, max = 10)` | `MultipartFile` | 文件大小范围 |

示例:

```java
@Data
class CreateUserQuery {
    @Phone
    private String phone;

    @In({"MALE", "FEMALE"})
    private String gender;

    @DateBetween(min = "1900-01-01", max = "now")
    private String birthday;

    @FileSize(unit = FileSize.Unit.MB, max = 5)
    private MultipartFile avatar;
}
```

## 请求体字段擦除和保留

开启:

```yaml
fairychar:
  bag:
    web:
      property-processor:
        enable: true
```

### @EraseValue

作用于 `@RequestBody` 参数和字段。进入 Controller 前，把匹配字段置为 `null`。

```java
class UserQuery {
    @EraseValue
    private String roleCode;
    private String name;
}

@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @EraseValue UserQuery query) {
    // query.roleCode == null
    // query.name 保留原值
    return HttpResult.ok();
}
```

### @KeepValue

作用于 `@RequestBody` 参数和字段。进入 Controller 前，只保留匹配字段，其它字段置为 `null`。

```java
class UserPatchQuery {
    @KeepValue
    private String name;
    private String roleCode;
}

@PostMapping("/users/patch")
public HttpResult<Void> patch(@RequestBody @KeepValue UserPatchQuery query) {
    // query.name 保留原值
    // query.roleCode == null
    return HttpResult.ok();
}
```

### group 语义

`@EraseValue` 和 `@KeepValue` 都支持 `Class<?>[] value()`。参数注解和字段注解的 group 有交集时才认为匹配。

```java
interface AdminGroup {}

class UserQuery {
    @EraseValue(AdminGroup.class)
    private String secret;
}

@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @EraseValue(AdminGroup.class) UserQuery query) {
    // secret 被擦除
    return HttpResult.ok();
}
```

## 响应脱敏 @FuzzyResult / @FuzzyValue

开启:

```yaml
fairychar:
  bag:
    web:
      property-processor:
        enable: true
```

直接脱敏返回对象:

```java
class UserVO {
    @FuzzyValue(beginAt = 3, endAt = 7)
    private String phone = "13812345678";
}

@FuzzyResult
@GetMapping("/users/{id}")
public UserVO get(@PathVariable Long id) {
    return userService.get(id);
}
```

包装体脱敏:

```java
@FuzzyResult(field = "data")
@GetMapping("/users/{id}")
public HttpResult<UserVO> get(@PathVariable Long id) {
    return HttpResult.ok(userService.get(id));
}
```

默认 `FuzzyValueAdvice` 的 `beginAt/endAt` 行为:

```java
@FuzzyValue(beginAt = 3, endAt = 7)
private String phone = "13812345678";
// 输出: 138****5678
// 源码逻辑: 保留 [0, beginAt)，替换 [beginAt, endAt)，保留 [endAt, length)
```

自定义处理器:

```java
@Bean
FuzzyValueProcessor middleFuzzy() {
    return new FuzzyMiddleTextProcessor();
}

class UserVO {
    @FuzzyValue(beginAt = 1, endAt = 1, processor = FuzzyMiddleTextProcessor.class)
    private String name = "张三丰";
}
```

`FuzzyMiddleTextProcessor` 的 `endAt` 表示“从右保留几位”，与默认处理逻辑不同。

脱敏支持:

- 对象内递归查找带 `@FuzzyValue` 的字段。
- 字段类型为 `String`。
- 字段类型为 `List` 且元素是 `String`。
- 字段类型为 `Map` 且 value 是 `String`。
- `@FuzzyResult(field = "data.user")` 支持嵌套字段路径。

## MVC 日期转换

开启:

```yaml
fairychar:
  bag:
    convert:
      mvc:
        enable: true
```

注册:

- `StringToLocalDateConverter`
- `StringToLocalDateTimeConverter`

底层使用 `DateConvertUtil.parseDate` 和 `DateConvertUtil.parseTime`。

## 工具类详解

### StringUtil

位置: `com.fairychar.bag.utils.StringUtil`

```java
byte[] bytes = StringUtil.compressByGzip("hello");
String text = StringUtil.decompressByGzip(bytes);
String value = StringUtil.defaultText(input, "default");
```

方法:

- `compressByGzip(String data)`: UTF-8 Gzip 压缩，失败抛 `FBException`。
- `decompressByGzip(byte[] compressedData)`: UTF-8 Gzip 解压，按行读取并拼接，换行会被去掉。
- `defaultText(String source, String text)`: `source` 为 null 或空字符串时返回 `text`。
- `fillBegin` / `fillEnd`: 已废弃，优先用 Guava `Strings.padStart/padEnd`。

### DateConvertUtil

位置: `com.fairychar.bag.utils.DateConvertUtil`

```java
LocalDate date = DateConvertUtil.parseDate("20260702");
LocalDateTime time = DateConvertUtil.parseTime("2026-07-02 12:30:00");
Date legacy = DateConvertUtil.localdateToDate(LocalDate.now());
```

支持日期格式:

- `yyyy-MM-dd`
- `yyyyMMdd`
- `yyyyMd`
- `yyyy/M/d`
- `yyyy/MM/dd`

支持时间格式:

- `yyyy-MM-dd HH:mm:ss`
- `yyyyMMdd HH:mm:ss`
- `yyyyMd HH:mm:ss`
- `yyyy/M/d HH:mm:ss`
- `yyyy/M/d HH/mm/ss`
- `yyyy/MM/dd HH/mm/ss`
- `yyyy/MM/ddHH/mm/ss`
- `yyyyMMdd HHmmss`
- `yyyyMMddHHmmss`

注意: 解析失败返回 `null`，不会抛解析异常；入参空白会触发 Hutool `Assert.notBlank`。

### RequestUtil

位置: `com.fairychar.bag.utils.RequestUtil`

```java
HttpServletRequest request = RequestUtil.getCurrentRequest();
HttpServletResponse response = RequestUtil.getCurrentResponse();
String ip = RequestUtil.getIpAddress(request);
Map<String, String> headers = RequestUtil.getHeader(request);

RequestUtil.putAttribute("userId", 1L);
Long userId = RequestUtil.getAttribute("userId", Long.class);
```

方法:

- `getHeader(HttpServletRequest)`: 返回所有 header 的 `LinkedHashMap`。
- `getCurrentRequest()`: 从 `RequestContextHolder` 获取当前请求，失败抛 `FBException`。
- `getCurrentResponse()`: 从 `RequestContextHolder` 获取当前响应，失败抛 `FBException`。
- `putAttribute(String, T)`: 写当前 request attribute。
- `getAttribute(String, Class<T>)`: 读当前 request attribute，源码未做类型校验，靠调用方保证类型。
- `getIpAddress(HttpServletRequest)`: 依次读取 `X-Forwarded-For`、`Proxy-Client-IP`、`WL-Proxy-Client-IP`、`HTTP_CLIENT_IP`、`X-Real-IP`，最后用 `getRemoteAddr()`。
- `obtainUri(MethodSignature)`: 从 Controller 类和方法的 Mapping 注解拼接 URI。

注意:

- `obtainUri` 假设 mapping 的 `value()[0]` 存在，空 mapping 可能异常。
- `getCurrentRequest/Response` 只能在请求线程使用。

### SpelUtil

位置: `com.fairychar.bag.utils.SpelUtil`

用于 AOP 场景从方法参数解析 SpEL。

```java
Method method = OrderService.class.getMethod("update", Long.class);
String key = SpelUtil.eval("'order:' + #orderId", method, new Object[]{1L}, String.class);
```

方法:

- `eval(String expression, JoinPoint joinPoint, Class<T> returnType)`
- `eval(String expression, Method method, Object[] args, Class<T> returnType)`
- `createEvaluationContext(Method method, Object[] args)`
- `parseExpression(String expression)`: 内部有 `ConcurrentHashMap` 表达式缓存。

### ReflectUtil

位置: `com.fairychar.bag.utils.ReflectUtil`

适用于简单 Bean 映射、递归查找字段、树形父子递归查找、字段擦除/保留。它直接使用反射字段，不依赖 getter/setter。

#### Map 和 Bean 转换

```java
Map<String, Object> map = Map.of("id", 1L, "name", "Tom");
User user = ReflectUtil.mapToEntity(map, User.class);

Map<String, Object> userMap = ReflectUtil.entityToMap(user, false);

UserVO vo = ReflectUtil.copyProperties(user, UserVO.class, false);
ReflectUtil.copyProperties(user, existingVO, false);
```

参数语义:

- `mapToEntity(map, clazz, mustMatchAll, matchNull)`
  - `mustMatchAll=true`: map key 在目标类找不到同名字段时抛异常。
  - `matchNull=true`: null 值也写入目标字段。
- `entityToMap(source, matchNull)`
  - `matchNull=false`: 跳过 null 值。
- `copyProperties(source, target, matchNull)`
  - 只复制同名字段。
  - `matchNull=false`: null 值不复制。

#### 字段保留和擦除

```java
ReflectUtil.eraseValue(user, "password,salt");
ReflectUtil.eraseValue(user, String.class);
ReflectUtil.keepValue(user, "id,name");
```

注意:

- `eraseValue(o, "*")` 会擦除当前类所有声明字段。
- `keepValue` 当前实现对多字段匹配有重复循环，复杂场景要先看源码或补测试。
- final 字段可能抛异常。

#### 递归搜索父子

内存列表:

```java
List<Menu> children = ReflectUtil.recursiveSearchChild(allMenus, "id", "parentId", 0L);
List<Menu> parents = ReflectUtil.recursiveSearchParent(allMenus, "parentId", "id", childId);
```

函数式查询，适合数据库批量查询:

```java
List<Menu> allChildren = ReflectUtil.recursiveSearchChild("id", 0L, parentIds -> {
    return menuMapper.selectByParentIds(parentIds);
});

List<Menu> allParents = ReflectUtil.recursiveSearchParent("parentId", List.of(10L, 11L), ids -> {
    return menuMapper.selectByIds(ids);
});
```

#### 注解字段搜索

```java
Map<Class<? extends Annotation>, List<FieldContainer>> result =
        ReflectUtil.recursiveSearchFieldValueByAnnotations(
                user,
                List.of(FuzzyValue.class)
        );
```

支持递归对象、`Collection`、`Map`，并通过 `identityHashCode` 防止循环引用重复解析。

#### Unsafe 方法

`setLong`、`setInt`、`compareAndSwapLong`、`compareAndSwapInteger` 会修改包装类型内部值，属于危险能力。普通业务代码不要使用，除非明确需要做底层实验且有测试覆盖。

### MappingObjectUtil

位置: `com.fairychar.bag.utils.MappingObjectUtil`

#### 列表转 TreeNode

```java
List<TreeNode<Menu>> tree = MappingObjectUtil.listToTree(
        menus,
        "parentId",
        "id",
        0L
);
```

返回 `TreeNode<T>`:

- `current`: 当前对象。
- `child`: 子节点列表。

#### 列表转原对象树

```java
List<Menu> tree = MappingObjectUtil.listToTree(
        menus,
        "parentId",
        "id",
        "children",
        0L
);
```

要求对象有同名字段:

- `parentId`
- `id`
- `children`

且 `children` 类型能接收 `List<T>`。

#### Map 转展示对象

```java
List<MappingAO<String, Long>> items = MappingObjectUtil.mapping(countMap);
List<MappingObjectAO<String, User>> groups = MappingObjectUtil.mappingList(groupMap);
List<MapObjectNode<User>> nodes = MappingObjectUtil.mapToNode(nestedGroupMap);
```

用途:

- `mapping`: `Map<K,V>` -> `List<MappingAO<K,V>>`
- `mappingList`: `Map<K,List<V>>` -> 带 count 的列表。
- `mapToNode`: 支持嵌套 `Map` 或末级 `List` 的树节点包装。

### RedisLockUtil

位置: `com.fairychar.bag.utils.RedisLockUtil`

悲观锁:

```java
RLock lock = redissonClient.getLock("user:" + userId);
RedisLockUtil.lock(lock, () -> {
    // 业务逻辑
});
```

带双检查:

```java
RedisLockUtil.lock(
        lock,
        () -> checkCacheBeforeLock(),
        () -> checkCacheAfterLock(),
        () -> loadDbAndPutCache(),
        30,
        TimeUnit.SECONDS
);
```

乐观锁:

```java
RedisLockUtil.tryLock(lock, () -> updateStock(), 3, TimeUnit.SECONDS);
```

语义:

- `lock(...)`: 调用 Redisson `lock()` 或 `lock(time, unit)`，获取不到时阻塞。
- `tryLock(...)`: 获取失败抛 `FailToGetLockException`。
- `beforeSearch`: 加锁前执行。
- `searchAgain`: 加锁后再次检查，典型用于缓存击穿双检查。
- `action`: 真正业务动作。
- finally 中会判断 `isHeldByCurrentThread()` 后解锁。

### CacheOperateTemplate

位置: `com.fairychar.bag.template.CacheOperateTemplate`

本地锁缓存读取:

```java
User user = CacheOperateTemplate.get(
        () -> localCache.get(id),
        () -> userMapper.selectById(id),
        value -> localCache.put(id, value),
        ("user:" + id).intern()
);
```

Redis 分布式锁缓存读取:

```java
User user = CacheOperateTemplate.get(
        () -> redisTemplate.opsForValue().get("user:" + id),
        () -> userMapper.selectById(id),
        value -> redisTemplate.opsForValue().set("user:" + id, value),
        redissonClient.getLock("lock:user:" + id)
);
```

语义:

1. 先读缓存。
2. 缓存为空则加锁。
3. 锁内再次读缓存。
4. 仍为空则读 DB。
5. DB 非空时写缓存并返回。
6. DB 为空时返回 null，不写缓存。

### TransactionUtil

位置: `com.fairychar.bag.utils.TransactionUtil`

用于多个异步事务协同提交/回滚。所有任务执行完后在 `CyclicBarrier` 等待，如果任一任务失败则 `isAllSuccess=false`，各事务在 finally 中标记回滚。

```java
ExecutorService executor = Executors.newFixedThreadPool(2);
AtomicBoolean allSuccess = new AtomicBoolean(true);
CyclicBarrier barrier = new CyclicBarrier(2);

Future<?> f1 = TransactionUtil.doWithTransactionAsync(
        () -> orderMapper.insert(order),
        allSuccess,
        barrier,
        executor,
        transactionTemplate,
        30
);

Future<?> f2 = TransactionUtil.doWithTransactionAsync(
        () -> stockMapper.deduct(stockId),
        allSuccess,
        barrier,
        executor,
        transactionTemplate,
        30
);

ConcurrentUtil.getFutures(List.of(f1, f2));
```

注意:

- `CyclicBarrier` 的 parties 必须等于参与事务任务数。
- 如果一个任务抛异常，会设置 `isAllSuccess=false`。
- 如果等待超时或 barrier 异常，也会回滚。

### ConcurrentUtil

位置: `com.fairychar.bag.utils.ConcurrentUtil`

```java
ConcurrentUtil.getFutures(futures);
```

逐个 `Future.get()`:

- `InterruptedException`: 恢复中断标记并抛 `FBException`。
- `ExecutionException`: 抛 `FBException`。

### CollectionUtil

位置: `com.fairychar.bag.utils.CollectionUtil`

```java
List<List<Long>> parts = CollectionUtil.splitList(ids, 4);
```

将列表尽量平均分成指定份数:

- 原列表长度小于等于份数时，每个元素单独一份，不足部分补空列表。
- 原列表长度大于份数时，余数分配给前几份。

### CircularTaskUtil

位置: `com.fairychar.bag.utils.CircularTaskUtil`

```java
boolean ok = CircularTaskUtil.run(
        () -> remoteService.isReady(),
        true,
        100,
        5_000
);
```

参数:

- `task`: 每轮执行的 `Supplier<Boolean>`。
- `condition`: 期望结果。
- `maxRound`: 最大轮数，0 表示无限。
- `maxMillis`: 最大耗时毫秒，0 表示无限。

注意: 无法中断正在执行的 supplier，只在下一轮循环前检查超时。

### FileUtil

位置: `com.fairychar.bag.utils.FileUtil`

拼接文件:

```java
FileUtil.concatFile("out.bin", new File("head.bin"), new File("part1.bin"), new File("part2.bin"));
```

按百分比分割文件:

```java
FileUtil.cutFile("source.bin", "middle.bin", 0.2D, 0.8D);
```

创建测试假文件:

```java
FileUtil.createFakeFile("tmp.bin", 1024 * 1024);
FileUtil.createFakeFileByNio("tmp-nio.bin", (byte) 0, 1024 * 1024, 4096);
```

注意:

- `cutFile` 的 `start` 范围 `[0, 1)`，`end` 范围 `(0, 1]`。
- `createFakeFileByNio` 如果目标文件已存在，会抛运行时异常。

### TaskTestUtil

位置: `com.fairychar.bag.utils.test.TaskTestUtil`

用于测试或压测辅助，不建议生产业务依赖。

```java
ExecutorService executor = TaskTestUtil.createThreadPool("demo", 8);
long cost = TaskTestUtil.batchRunSync(() -> service.call(), 100, executor);
TaskTestUtil.concurrentRunAsync(List.of(action1, action2));
```

常用方法:

- `createThreadPool(poolName, size)`
- `createThreadPoolByCpuCore(poolName)`
- `createThreadPoolByCpuCore(poolName, multi)`
- `concurrentRunAsync(actions)`
- `batchRunSync(actions, executor)`
- `batchRunAsync(actions, executor)`
- `getWasteMillis(action, round)`

## MyBatis 工具

### AES/RSA TypeHandler

位置:

- `com.fairychar.bag.beans.mybatis.handler.AesTypeHandler`
- `com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler`

配置 AES/RSA Bean:

```yaml
fairychar:
  bag:
    secret:
      aes:
        key: "1234567890123456"
      rsa:
        pub-key: "..."
        pri-key: "..."
```

实体字段:

```java
@TableField(typeHandler = AesTypeHandler.class)
private String phone;

@TableField(typeHandler = RsaTypeHandler.class)
private String idCard;
```

静态工具:

```java
String cipher = AesTypeHandler.encryptHex("hello");
String plain = AesTypeHandler.decrypt(cipher);

String rsaCipher = RsaTypeHandler.encryptBase64("hello");
String rsaPlain = RsaTypeHandler.decrypt(rsaCipher);
```

注意:

- `AesTypeHandler` 和 `RsaTypeHandler` 内部依赖静态 `aes/rsa` 字段，使用前必须确保已注入或手动 `setAes/setRsa`。
- `AesTypeHandler` 入库使用 `encryptHex`，出库 `decryptStr`。
- `RsaTypeHandler` 入库用公钥，出库用私钥。

### 租户拦截器

#### SwitchableTenantLineInnerInterceptor

Mapper 参数中传入 `ITenantSwitcher`，动态决定该次查询是否使用租户插件。

```java
List<User> listUsers(@Param("query") UserQuery query, ITenantSwitcher tenantSwitcher);

userMapper.listUsers(query, new TenantSwitcher(false)); // 不使用租户
userMapper.listUsers(query, new TenantSwitcher(true));  // 使用租户
```

如果参数中没有 `ITenantSwitcher`，默认使用租户。

#### SkipableTenantLineInnerInterceptor

通过 `ITenantSkipper` 的线程上下文跳过租户处理。

```java
SimpleTenantSkipper skipper = new SimpleTenantSkipper();

try {
    skipper.setSkip(true);
    return userMapper.listAll();
} finally {
    skipper.cleanContext();
}
```

注意: `SimpleTenantSkipper` 的默认 ThreadLocal 初始值是 `true`，结合 `SkipableTenantLineInnerInterceptor` 时要按当前实现仔细验证“默认是否跳过”的业务预期。

## Redis Serializer

### PrefixStringSerializer

位置: `com.fairychar.bag.beans.redis.PrefixStringSerializer`

用途: 在 Redis key 序列化时自动加前缀。源码当前反序列化只调用父类 `deserialize`，不会去掉前缀。

```java
RedisTemplate<String, Object> template = new RedisTemplate<>();
template.setKeySerializer(new PrefixStringSerializer("my-service:"));
```

### GzipStringSerializer

位置: `com.fairychar.bag.beans.redis.GzipStringSerializer`

用途: value 字符串序列化时 Gzip 压缩，反序列化时解压。

```java
template.setValueSerializer(new GzipStringSerializer());
```

## Netty 简化封装

### SimpleNettyServer

```java
SimpleNettyServer server = new SimpleNettyServer(
        4,
        10000,
        new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline()
                        .addLast(new DelimitersHeadTailFrameDecoder(
                                new byte[]{0x02},
                                new byte[]{0x03},
                                1024
                        ))
                        .addLast(new MyInboundHandler());
            }
        }
);

server.setMaxShutdownWaitSeconds(10);
server.start();
```

构造方法:

- `SimpleNettyServer(int workerSize, int port)`
- `SimpleNettyServer(int workerSize, int port, ChannelInitializer<SocketChannel> childHandlers)`
- `SimpleNettyServer(int workerSize, int port, ChannelInitializer<ServerSocketChannel> handlers, ChannelInitializer<SocketChannel> childHandlers)`

行为:

- boss 线程数固定为 1。
- `start()` 设置 `RunState.STARTING -> STARTED`。
- `stop()` 带 `@PreDestroy`，关闭 channel、boss、worker。

### SimpleNettyClient

```java
SimpleNettyClient client = new SimpleNettyClient(
        2,
        10000,
        "127.0.0.1",
        new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new MyInboundHandler());
            }
        }
);

client.start();
Channel channel = client.getChannel();
```

构造方法:

- `SimpleNettyClient(int workerSize, int port, String host)`
- `SimpleNettyClient(int workerSize, int port, String host, ChannelInitializer<SocketChannel> childHandlers)`

### DelimitersHeadTailFrameDecoder

固定头尾协议解码:

```java
new DelimitersHeadTailFrameDecoder(
        new byte[]{0x68},
        new byte[]{0x16},
        2048
);
```

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

```java
@FunctionalInterface
public interface Action {
    void doAction() throws RuntimeException;
}
```

大量工具都用它承载无返回值任务。

### AssignableFactory

位置: `com.fairychar.bag.extension.concurrent.AssignableFactory`

用于按“资源权重”分配并发许可。

```java
ExecutorService executor = Executors.newFixedThreadPool(8);
AssignableFactory factory = AssignableFactory.recruitWorkers(3, executor);

factory.doWork(() -> callA(), 2);
factory.doWork(() -> callB(), 1);

Future<String> future = factory.doWorkFuture(() -> loadData(), 1);
```

语义:

- 内部使用 `Semaphore`。
- `workers` 表示本任务占用多少许可。
- `recruitWorkers(int workers)` 无外部线程池版本已废弃。

### RepeatTaskExecutor

位置: `com.fairychar.bag.extension.concurrent.RepeatTaskExecutor`

多个任务组成一个批次，同一批次所有任务都执行完后进入下一批次。

```java
RepeatTaskExecutor executor = RepeatTaskExecutor.createCycle(
        List.of(
                () -> syncA(),
                () -> syncB()
        ),
        "sync"
);

executor.start(
        e -> log.warn("interrupted", e),
        e -> log.warn("timeout", e),
        e -> log.warn("broken", e),
        10_000
);
```

注意:

- 每个 action 在自己的线程中无限循环。
- 每轮结束后在 `CyclicBarrier` 等待。
- `stop()` 会 `cyclicBarrier.reset()`，触发任务退出。

### RoundTaskExecutor

位置: `com.fairychar.bag.extension.concurrent.RoundTaskExecutor`

将多个任务链按下标分轮同步执行。第 0 轮所有链的第 0 个任务完成后，才进入第 1 轮。

```java
List<List<Action>> chains = new ArrayList<>();
chains.add(new ArrayList<>(List.of(() -> stepA1(), () -> stepA2())));
chains.add(new ArrayList<>(List.of(() -> stepB1(), () -> stepB2())));

RoundTaskExecutor executor = RoundTaskExecutor.boxedTaskList(chains);
executor.start();
```

`boxedTaskList` 会把短链补空 action，使所有链长度一致。

### ActionSelectorTemplate

位置: `com.fairychar.bag.template.ActionSelectorTemplate`

轻量定时任务选择器。

```java
ActionSelectorTemplate template = new ActionSelectorTemplate();
template.setTimePause(100);

template.put("refresh-cache", 5_000, () -> refreshCache());
template.put("sync-user", 10_000, new AbstractScheduleAction() {
    @Override
    public void doAction() {
        syncUser();
    }
});

template.start();
```

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

```java
class ConfigRef extends AbstractBalkingReference<Config> {
    ConfigRef(Config config) {
        super(config);
    }

    @Override
    public boolean doSave() {
        repository.save(t);
        return true;
    }
}

ConfigRef ref = new ConfigRef(config);
ref.save();       // 首次保存
ref.change(newConfig);
ref.save();       // 有变更才保存
```

## 条件动作流 ActionFlow

位置: `com.fairychar.bag.extension.action.condition.bool`

适用于构建 bool 条件树，每个节点计算 `true/false` 后进入对应子节点。

定义 root 节点:

```java
public class StringFlow extends AbstractActionFlow<String, Integer> {
    @Override
    public ActionFlow<String, Integer> instanceBean() {
        return new StringFlow();
    }

    @Override
    public boolean compute(String context) {
        return context.isEmpty();
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return Sets.newHashSet(RootAction.getCondition());
    }

    @Override
    public Integer getNextParam(String context) {
        return Integer.valueOf(context);
    }
}
```

定义子节点:

```java
public class IntegerCompareFlow extends AbstractActionFlow<Integer, Integer> {
    @Override
    public ActionFlow<Integer, Integer> instanceBean() {
        return new IntegerCompareFlow();
    }

    @Override
    public boolean compute(Integer context) {
        return context > 1;
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return Sets.newHashSet(new ParentActionCondition(StringFlow.class, true));
    }

    @Override
    public Integer getNextParam(Integer context) {
        return context + 1;
    }
}
```

构建并执行:

```java
Set<Class<AbstractActionFlow>> classes = new HashSet<>();
classes.add((Class) StringFlow.class);
classes.add((Class) IntegerCompareFlow.class);

FlowBuilder builder = FlowBuilder.fromClasses(classes);
AbstractActionFlow root = builder.buildFlow();
root.callNext("123");
```

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

```powershell
mvn -pl fairychar-bag -am -DskipTests compile
```

如果需要跑测试，由于模块配置默认跳过测试，使用:

```powershell
mvn -pl fairychar-bag -am -DskipTests=false test
```

如需做风格检查，可运行项目内技能脚本:

```powershell
powershell -ExecutionPolicy Bypass -File fairychar-bag\skills\fairychar-coding-java\script\check-fairychar-style.ps1 -Root fairychar-bag\src\main\java
```
