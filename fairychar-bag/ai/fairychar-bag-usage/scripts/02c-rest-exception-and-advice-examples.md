# RestException And DefaultExceptionAdvice Examples

> 返回示例入口: [02-web-rest-aop-and-lock-examples.md](02-web-rest-aop-and-lock-examples.md)。说明和约束见 `../references/02c-rest-exception-and-advice.md`。

## Example 1: 抛出业务异常

```java
throw new RestException(RestErrorCode.DATA_NOT_EXIST);
throw new RestException(RestErrorCode.PARAM_ERROR, "用户 id 不能为空");
throw new RestException(RestErrorCode.DATA_EXIST, "用户名已存在", username);
```

## Example 2: Service 中强制使用 RestException

```java
public UserVO detail(Long userId) {
    if (userId == null) {
        throw new RestException(RestErrorCode.PARAM_ERROR, "用户 id 不能为空");
    }
    User user = userMapper.selectById(userId);
    if (user == null) {
        throw new RestException(RestErrorCode.DATA_NOT_EXIST);
    }
    return userConverter.toVO(user);
}
```

## Example 3: 开启 DefaultExceptionAdvice

```yaml
fairychar:
  bag:
    web:
      advice:
        enable: true
```
