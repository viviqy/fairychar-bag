# 手动检查 BindingResult

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。checkBindingErrors 有错误时抛 ParamErrorException，不是 RestException。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 输入、输出与失败

| 入口 | 输入与效果 | 失败、责任与边界 |
| --- | --- | --- |
| `BindingResultUtil.checkBindingErrors(BindingResult...)` 与 List 重载 | 容器和元素非 null；无错误时正常返回 void；错误拼为 `[field] message`，同一结果以逗号连接，每个有错误的结果末尾加 CRLF | 有错误抛 `ParamErrorException`，不是 RestException；仅有对象级错误也会抛出但文本可能只有 CRLF。不自动把该异常转换为预期业务错误码，业务应使用已有校验链或显式转换 |

## BindingResultUtil

位置: `com.fairychar.bag.utils.BindingResultUtil`

用于手动检查 `BindingResult`，有错误时抛 `ParamErrorException`。

```java
@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @Valid CreateUserQuery query, BindingResult bindingResult) {
    BindingResultUtil.checkBindingErrors(bindingResult);
    return HttpResult.ok();
}
```

## 类型与完整签名

- [`com.fairychar.bag.domain.exceptions.ParamErrorException`](../../api/domain-exceptions--paramerrorexception.md)
- [`com.fairychar.bag.utils.BindingResultUtil`](../../api/utils--bindingresultutil.md)
