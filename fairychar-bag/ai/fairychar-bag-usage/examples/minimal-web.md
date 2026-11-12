# Web 功能组合示例（可选）

[返回功能入口](../fairychar-bag-usage-guide.md)

本页只组合响应、业务异常、字段白名单和脱敏，不替代功能说明。只需单项能力时直接读 [统一响应](../features/web/http-result.md)、[异常处理](../features/web/exception-handling.md)、[字段保留](../features/field-processing/keep-value.md) 或 [脱敏](../features/field-processing/fuzzy-value.md)。

## 运行方式

将 [完整 Controller](SdkQuickStartController.java) 放进业务应用可扫描包；替换包名和路由，不将演示接口暴露到生产。这里只使用已经接入的 JAR，不需要 SDK 源文件。

```yaml
fairychar:
  bag:
    web:
      advice:
        enable: true
      property-processor:
        enable: true
```

## 请求与断言

| 请求 | 预期结果 |
| --- | --- |
| POST `/sdk-demo/users`，JSON `{"name":"Alice","roleCode":"admin"}` | data.name=Alice；roleCode 为 null 或被 JSON 策略省略 |
| GET `/sdk-demo/contact` | data.phone=138****5678 |
| GET `/sdk-demo/failure` | code/msg 对应 RestErrorCode.DATA_NOT_EXIST；HTTP 状态单独断言 |

本示例不含启动类、鉴权和持久化；可编译不等于已验证自动装配和真实请求链。日志与锁的组合分别见 [日志功能](../features/web/request-logging.md) 和 [方法锁](../features/locking/method-lock.md)。
