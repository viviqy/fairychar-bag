# Feign 固定降级响应

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## FeignFallbackProxy：返回类型限制

`createDefault(Class<I>, Throwable)` 与 `createDefault(Class<I>, Throwable, HttpResult)` 都返回 JDK 动态代理。传入类型必须为接口。

**代理的业务方法实际统一返回 `ResponseEntity`，HTTP 状态为 `SERVICE_UNAVAILABLE`，body 为失败 `HttpResult`。** 因此不要把它套在返回 `HttpResult`、普通 DTO 或基本类型的方法上，否则调用时可能发生类型转换/拆箱错误。接口应约束为兼容的 `ResponseEntity<HttpResult<...>>` 返回类型。

- 两参数版本读取 `cause.getMessage()`；`cause` 不应为 null。异常原始消息可能被暴露，应在业务侧考虑脱敏。
- 三参数版本可以提供固定失败体；返回对象可能在多次调用间共享，不要修改。
- 创建代理使用 SDK 类加载器，插件隔离类加载器中定义的接口不保证可见。
- 不自动注册 Feign fallback，也不提供重试、熔断或监控。

业务测试必须验证接口声明的返回类型、HTTP 503 与错误体；类型不兼容时实现业务自己的 fallback，不套用该代理。

## 类型与完整签名

- [`com.fairychar.bag.proxy.FeignFallbackProxy`](../../api/proxy.md)
