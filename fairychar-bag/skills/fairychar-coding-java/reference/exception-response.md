# REST 响应、异常与错误码规范

适用于 REST API 返回、业务异常、参数校验失败、错误码扩展。

## 总体规则

- 正常响应使用 `HttpResult.ok(...)`。
- API/业务失败使用 `RestException` 或领域业务异常。
- 错误码统一通过 `IRestErrorCode` 抽象，不在业务代码中散落裸数字和裸消息。
- 参数校验由统一 advice 转成 `HttpResult.fail(RestErrorCode.PARAM_INVALIDATE, ...)`。
- 系统异常记录 error 日志并返回统一失败响应。
- 预期内业务异常不要按系统异常打印完整错误日志。

## IRestErrorCode 定义规范

- 错误码定义必须实现 `IRestErrorCode`。
- 必须稳定暴露：
  - `int getCode()`
  - `String getMessage()`
- 推荐使用 enum 定义错误码，每个枚举项包含 code 和 message。
- code 使用明确数值段分组；不要随意复用已有 code。
- message 使用简洁中文，描述用户或调用方可理解的失败原因。
- Service、Controller、Advice 只消费 `IRestErrorCode`，不要绕过接口读取实现细节。
- 领域模块需要自定义错误码时，新建领域 enum 实现 `IRestErrorCode`，不要把所有业务错误塞进公共 `RestErrorCode`。

## 禁止写法

- `throw new RuntimeException("策略不存在")`
- `return HttpResult.fail(10001, "策略不存在")`
- 在 Service 中定义局部常量 `int ERROR_CODE = ...`
- 同一错误语义在多个类中重复写 code/message
- 错误码 enum 不实现 `IRestErrorCode`

## 推荐写法

```java
public enum PermissionErrorCode implements IRestErrorCode {
    POLICY_NOT_FOUND(20001, "策略不存在"),
    POLICY_CODE_EXISTS(20002, "策略编码已存在");

    private final int code;
    private final String message;

    PermissionErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
```

## 异常使用

- 公共库 REST 失败优先使用 `RestException(RestErrorCode.*)`。
- 应用领域可以定义 `PermissionBusinessException(PermissionErrorCode.*)` 这类领域异常，但构造参数仍应接受 `IRestErrorCode`。
- 需要附加消息时，保留错误码语义，只补充上下文，例如 `PermissionBusinessException(PermissionErrorCode.PARAM_ERROR, "策略必填字段不能为空")`。
- 底层工具类非 REST 语义失败可以使用项目已有基础异常，例如 `FBException`。

## 响应与日志

- Controller 不手写失败响应分支，除非已有统一模式要求。
- Advice 处理系统异常时使用参数化日志：`log.error("system error,msg={}", e.getMessage(), e)`。
- 业务异常、参数异常属于可预期失败，不要当作系统错误重复打印。

## 样例

- `code/src/main/java/com/fairychar/bag/domain/exceptions/IRestErrorCode.java`
- `code/src/main/java/com/fairychar/bag/domain/exceptions/RestErrorCode.java`
- `code/src/main/java/com/fairychar/bag/domain/exceptions/RestException.java`
- `code/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java`
