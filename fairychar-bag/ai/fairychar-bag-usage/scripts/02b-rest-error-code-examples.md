# RestErrorCode Examples

> 返回示例入口: [02-web-rest-aop-and-lock-examples.md](02-web-rest-aop-and-lock-examples.md)。说明和约束见 `../references/02b-rest-error-code.md`。

## Example 1: 先复用已有错误码

```java
if (user == null) {
    throw new RestException(RestErrorCode.DATA_NOT_EXIST);
}

if (Boolean.TRUE.equals(user.getFrozen())) {
    throw new RestException(RestErrorCode.USER_FROZEN);
}
```

## Example 2: 错误码语义够用，只覆盖 message

```java
if (!allowedFileTypes.contains(fileType)) {
    throw new RestException(RestErrorCode.FILE_FORMAT_NOT_SUPPORT, "仅支持 jpg、png、webp 文件");
}
```

## Example 3: 错误码语义够用，通过 data 返回上下文

```java
if (!failedIds.isEmpty()) {
    throw new RestException(RestErrorCode.DATA_UPDATE_FAILED, "部分数据更新失败", failedIds);
}
```

## Example 4: 确实需要项目级错误码时实现 IRestErrorCode

```java
@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements IRestErrorCode {
    USER_PHONE_BOUND(30001, "手机号已绑定"),
    USER_EMAIL_BOUND(30002, "邮箱已绑定");

    private final int code;
    private final String message;
}
```

## Example 5: 项目级错误码直接通过 RestException 抛出

```java
throw new RestException(UserErrorCode.USER_PHONE_BOUND);
throw new RestException(UserErrorCode.USER_EMAIL_BOUND, "当前邮箱已被其他账号绑定");
```
