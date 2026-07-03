# RequestLog AOP Examples

> 返回示例入口: [02-web-rest-aop-and-lock-examples.md](02-web-rest-aop-and-lock-examples.md)。说明和约束见 `../references/02d-request-log-aop.md`。

## Example 1: 开启日志切面

```yaml
fairychar:
  bag:
    aop:
      log:
        enable: true
        global-level: INFO
        global-before: jsonLoggingHandler
        global-after: jsonLoggingHandler
```

## Example 2: 注册日志处理器

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

## Example 3: Controller 方法使用 @RequestLog

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

## Example 4: 当前切面匹配范围

```text
execution(public * *..controller..*.*(..)) && @annotation(requestLog)
```
