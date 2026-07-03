# RestException And DefaultExceptionAdvice Reference

> 返回二级入口: [02-web-rest-aop-and-lock.md](02-web-rest-aop-and-lock.md)。代码示例放在 `../scripts/02c-rest-exception-and-advice-examples.md`。

## RestException

位置: `com.fairychar.bag.domain.exceptions.RestException`

用途: MVC 统一返回体系的基础业务异常类。项目接口中的业务异常必须优先抛 `RestException`，它基本能覆盖所有需要返回给前端的失败场景。

强制使用规则:

- Controller 或被 Controller 调用的 Service 中，凡是需要返回业务失败给前端的异常，默认抛 `RestException`。
- 抛异常前先从 [02b-rest-error-code](02b-rest-error-code.md) 中选择最贴近语义的错误码。
- 不要在接口业务中随意抛 `RuntimeException`、`IllegalArgumentException`、`FBException` 或自定义异常作为前端业务失败。
- 除非 `RestException` 的 `errorCode + msg + data` 三段结构确实无法表达业务需要，才允许新建新的项目异常基类。
- 新建异常基类时必须同时设计统一 Advice 处理逻辑、返回结构、错误码策略和使用边界，不要只新增一个异常类。

字段:

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| `errorCode` | `IRestErrorCode` | 业务错误码。`DefaultExceptionAdvice` 使用它的 `code` 作为响应 `code` |
| `data` | `Object` | 可选错误上下文数据。`DefaultExceptionAdvice` 原样写入响应 `data` |
| `message` | `String` | 继承自 `RuntimeException`。`DefaultExceptionAdvice` 使用 `e.getMessage()` 作为响应 `msg` |

构造方法语义:

| 构造方法 | 响应 code | 响应 msg | 响应 data | 使用场景 |
| --- | --- | --- | --- | --- |
| `RestException(IRestErrorCode errorCode)` | `errorCode.getCode()` | `errorCode.getMessage()` | `null` | 最常用。错误码 message 已能表达失败原因 |
| `RestException(IRestErrorCode errorCode, Object data)` | `errorCode.getCode()` | `errorCode.getMessage()` | `data` | 需要把失败上下文返回给前端，如冲突字段、失败 id 列表 |
| `RestException(IRestErrorCode errorCode, String msg)` | `errorCode.getCode()` | `msg` | `null` | 需要用更具体的业务文案覆盖默认 message |
| `RestException(IRestErrorCode errorCode, String msg, Object data)` | `errorCode.getCode()` | `msg` | `data` | 同时需要自定义文案和错误上下文 |

推荐抛法:

| 场景 | 推荐错误码 | 推荐构造方式 |
| --- | --- | --- |
| 参数组合不合法 | `PARAM_ERROR` | `RestException(RestErrorCode.PARAM_ERROR, "具体参数错误原因")` |
| id 查询不到数据 | `DATA_NOT_EXIST` | `RestException(RestErrorCode.DATA_NOT_EXIST)` |
| 创建时唯一键冲突 | `DATA_EXIST` | `RestException(RestErrorCode.DATA_EXIST, data)` |
| 重复提交或重复保存 | `DUPLICATE_SAVE` | `RestException(RestErrorCode.DUPLICATE_SAVE)` |
| 获取锁失败 | `LOCK_FAILED` | `RestException(RestErrorCode.LOCK_FAILED)` |
| 调第三方失败 | `THIRD_REQUEST_FAILED` | `RestException(RestErrorCode.THIRD_REQUEST_FAILED, msg)` |
| 无更具体语义的业务失败 | `OPERATION_FAILED` | `RestException(RestErrorCode.OPERATION_FAILED, msg)` |

## DefaultExceptionAdvice

位置: `com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice`

用途: MVC 全局异常处理器。开启后把校验异常、`FBException`、`RestException` 和兜底异常统一转换成 `HttpResult`。

开启方式:

| 配置项 | 说明 |
| --- | --- |
| `fairychar.bag.web.advice.enable=true` | 开启默认全局异常处理 |

`RestException` 的实际返回逻辑:

| 来源 | HttpResult 字段 |
| --- | --- |
| `e.getErrorCode().getCode()` | `code` |
| `e.getData()` | `data` |
| `e.getMessage()` | `msg` |

Advice 处理的异常:

| 异常类型 | 响应语义 |
| --- | --- |
| `BindException` | 参数绑定或表单校验失败 |
| `ConstraintViolationException` | 方法参数约束校验失败 |
| `MethodArgumentNotValidException` | 请求体对象校验失败 |
| `FBException` | 通用基础异常，兼容底层工具或旧代码 |
| `RestException` | MVC 业务异常首选路径 |
| 其他 `Exception` | 兜底异常，当前源码记录 error 日志后返回 `HttpResult.fail()`，响应码是 `OPERATION_FAILED` |

## FBException

位置: `com.fairychar.bag.domain.exceptions.FBException`

用途: 通用基础异常。它会被 `DefaultExceptionAdvice` 捕获，但不是 MVC 业务异常首选。

使用边界:

| 场景 | 是否推荐 |
| --- | --- |
| 工具类、底层通用逻辑、兼容旧代码 | 可以使用 `FBException` |
| Controller 或接口 Service 需要返回业务失败给前端 | 不推荐，改用 `RestException` |
| 需要统一错误码、message、data 返回结构 | 使用 `RestException` |
| 需要新项目异常基类 | 只有 `RestException` 无法满足时才设计 |

注意:

- `DefaultExceptionAdvice` 捕获 `FBException` 后会读取 `e.getCode()`、`e.getData()` 和 `e.getMessage()`。
- `FBException(String message)`、`FBException(int code, String message)` 等部分构造方法不会写入 `code/data` 字段；其中 `FBException(int code, String message)` 虽有 `code` 参数，但当前源码没有赋值给字段。
- 如果必须通过 `FBException` 返回业务码，使用会设置 `code/data` 的构造方法，例如 `FBException(String message, int code, Object data)`。
- 新接口业务失败不要为了设置 `FBException.code` 而绕开 `RestException`。

## 新建异常类的门槛

只有同时满足以下条件，才考虑为项目新增异常基类:

- `RestException` 的 `errorCode + msg + data` 不能表达业务失败。
- 需要不同于 `HttpResult` 的响应结构，且这是项目协议要求。
- 已设计独立的 Advice 捕获逻辑。
- 已定义错误码策略和复用规则。
- 已明确哪些层可以抛新异常、哪些层仍使用 `RestException`。

默认结论: 大多数项目接口不需要新增异常基类。
