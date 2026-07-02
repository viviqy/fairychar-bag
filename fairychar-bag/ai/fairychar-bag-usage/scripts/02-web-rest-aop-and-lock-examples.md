# Web REST AOP And Lock Examples

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。说明和约束见 `../references/` 中对应文档。

## Example 1: HttpResult

```java
return HttpResult.ok();
return HttpResult.ok(user);
return HttpResult.fail();
return HttpResult.fail(RestErrorCode.DATA_NOT_EXIST);
return HttpResult.fail(RestErrorCode.PARAM_INVALIDATE, errors);
return HttpResult.response(HttpStatus.BAD_REQUEST, RestErrorCode.PARAM_ERROR, null);
```

## Example 2: RestException / FBException

```java
throw new RestException(RestErrorCode.DATA_NOT_EXIST);
throw new RestException(RestErrorCode.PARAM_ERROR, "用户 id 不能为空");
throw new RestException(RestErrorCode.DATA_EXIST, "用户名已存在", username);
```

## Example 3: RestException / FBException

```yaml
fairychar:
  bag:
    web:
      advice:
        enable: true
```

## Example 4: 使用方式

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

## Example 5: 使用方式

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

## Example 6: 使用方式

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

## Example 7: 使用方式

```text
execution(public * *..controller..*.*(..)) && @annotation(requestLog)
```

## Example 8: 方法锁 @MethodLock

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

## Example 9: 方法锁 @MethodLock

```java
@Service
class OrderService {
    @MethodLock(lockType = MethodLock.Type.LOCAL, nameExpression = "'order:' + #orderId")
    public void updateLocal(Long orderId) {
        // 同 JVM 内同 orderId 串行
    }
}
```

## Example 10: 方法锁 @MethodLock

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

## Example 11: 方法锁 @MethodLock

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

