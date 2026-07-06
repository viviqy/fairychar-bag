# HttpResult Examples

> 返回示例入口: [02-web-rest-aop-and-lock-examples.md](02-web-rest-aop-and-lock-examples.md)。说明和约束见 `../references/02a-http-result.md`。

## Example 1: 成功响应

```java
return HttpResult.ok();
return HttpResult.ok(user);
```

## Example 2: 失败响应

```java
return HttpResult.fail();
return HttpResult.fail(RestErrorCode.DATA_NOT_EXIST);
return HttpResult.fail(RestErrorCode.PARAM_INVALIDATE, errors);
```

## Example 3: 同时设置 HTTP 状态码和业务响应体

```java
return HttpResult.response(HttpStatus.BAD_REQUEST, RestErrorCode.PARAM_ERROR, null);
return HttpResult.response(HttpStatus.BAD_REQUEST, RestErrorCode.PARAM_ERROR, errors, "参数格式错误");
```
