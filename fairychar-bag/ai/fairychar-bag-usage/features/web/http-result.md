# 统一响应 HttpResult

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：可直接采用**。构造 MVC 响应体；业务码不等于 HTTP 状态码。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## HttpResult

位置: `com.fairychar.bag.pojo.vo.HttpResult`

用途: MVC 接口统一响应包装。接口正常返回、业务失败返回、异常 Advice 返回都应优先复用这个结构，避免每个项目重复定义 `Result`、`Response`、`ApiResult`。

字段:

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| `code` | `int` | 业务码。成功、失败、异常都通过该字段表达业务状态 |
| `data` | `Object` | 返回数据。字段本身带 `@FuzzyValue`，可配合 `@FuzzyResult(field = "data")` 对包装数据脱敏 |
| `msg` | `String` | 响应消息。成功文案、错误原因、异常 message 都通过该字段表达 |

## 常用方法

| 方法 | 行为 | 使用场景 |
| --- | --- | --- |
| `ok()` | 返回缓存的成功响应，无 data，`code=200`，`msg=success` | 删除、启停、确认类接口只需要表达成功 |
| `ok(T data)` | 返回成功响应并携带 data，`code=200`，`msg=success` | 查询详情、列表、聚合结果 |
| `fail()` | 返回缓存的通用失败响应，错误码为 `OPERATION_FAILED` | 非异常流程中构造通用失败；接口业务失败仍优先抛 `RestException` |
| `fail(T data)` | 返回 `OPERATION_FAILED` 并携带 data | 通用失败但需要返回上下文 |
| `fail(RestErrorCode errorCode)` | 按错误码返回失败响应，无 data | 手动构造失败响应 |
| `fail(RestErrorCode errorCode, T data)` | 按错误码返回失败响应并携带 data | 手动构造失败响应且需要上下文 |
| `response(HttpStatus status, RestErrorCode errorCode, Object data)` | 先设置 HTTP 状态码，再返回统一响应体 | Advice 或需要同时表达 HTTP 状态和业务码的场景 |
| `response(HttpStatus status, RestErrorCode errorCode, Object data, String msg)` | 先设置 HTTP 状态码，再用自定义 msg 返回统一响应体 | 需要覆盖默认错误消息的 HTTP 状态响应 |

## 使用约束

- Controller 返回值需要统一结构时优先返回 `HttpResult`。
- 业务失败需要走异常链时优先抛 `RestException`，开启统一异常返回功能后转成 `HttpResult`。
- 不要在新接口中重复定义项目级 `Result` 类型，除非业务已有不可替代的协议约束。
- `data` 字段已经适配响应脱敏，返回包装对象时可继续配合 `@FuzzyResult(field = "data")`。
- `response(...)` 会通过 `RequestUtil.getCurrentResponse()` 设置 HTTP 状态码，必须在 Web 请求线程中使用；非 Web 线程没有当前 response 时不适合调用。
- `ok()` 与无参 `fail()` 返回可修改的共享缓存实例。不要对它们调用链式 setter 或修改内容，否则会污染其他请求；需要修改时使用 `ok(data)` 或独立构造的 `HttpResult`。
- `fail` / `response` 的错误码重载接收 `RestErrorCode`，不是任意 `IRestErrorCode`；自定义领域错误优先通过 `RestException` 和 Advice 转换。
- 普通 `ok` / `fail` 只构造业务响应体，不自动设置 HTTP 状态。完整构造器和生成的 getter/setter 见 [HttpResult API](../../api/pojo-vo.md)。

## 和其他类的关系

| 相关类 | 关系 |
| --- | --- |
| `RestException` | 接口抛出的业务异常最终由 Advice 转为 `HttpResult` |
| `RestErrorCode` | `RestException` 携带错误码，Advice 写入 `HttpResult.code` |
| 统一异常返回功能 | 开启后将异常转换成 `HttpResult`，不手动调用内部处理器 |
| `RequestUtil` | `HttpResult.response(...)` 依赖它获取当前 `HttpServletResponse` |
| `@FuzzyResult` / `@FuzzyValue` | 可对 `HttpResult.data` 做字段脱敏 |

## 示例：成功响应

```java
return HttpResult.ok();
return HttpResult.ok(user);
```

## 示例：失败响应

```java
return HttpResult.fail();
return HttpResult.fail(RestErrorCode.DATA_NOT_EXIST);
return HttpResult.fail(RestErrorCode.PARAM_INVALIDATE, errors);
```

## 示例：同时设置 HTTP 状态码和业务响应体

```java
return HttpResult.response(HttpStatus.BAD_REQUEST, RestErrorCode.PARAM_ERROR, null);
return HttpResult.response(HttpStatus.BAD_REQUEST, RestErrorCode.PARAM_ERROR, errors, "参数格式错误");
```

## 业务验收

分别断言成功和失败响应的 code、msg、data；测试普通返回不自动修改 HTTP 状态。不要修改无参工厂返回的共享实例。

## 类型与完整签名

- [`com.fairychar.bag.pojo.vo.HttpResult`](../../api/pojo-vo.md)
