# 请求字段保留 @KeepValue

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。JSON 绑定后按标注字段和 group 筛选请求体；不是权限校验。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## @KeepValue

作用于 `@RequestBody` 参数和字段。进入 Controller 前，只保留 group 匹配的标注字段，未标注或 group 不匹配的字段均清空。

两种处理器都只处理请求体当前类声明的非静态、非 final 字段，不递归处理嵌套对象或父类字段。清空时引用类型置为 `null`，基本类型重置为 Java 默认值（如 `0`、`false`、`'\0'`）。

```java
class UserPatchQuery {
    @KeepValue
    private String name;
    private String roleCode;
}

@PostMapping("/users/patch")
public HttpResult<Void> patch(@RequestBody @KeepValue UserPatchQuery query) {
    // query.name 保留原值
    // query.roleCode == null
    return HttpResult.ok();
}
```

## group 语义

`@EraseValue` 和 `@KeepValue` 都支持 `Class<?>[] value()`：

- 参数和字段都未指定 group（空数组）时匹配。
- 两者都指定 group 时，至少有一个相同的 Class 才匹配；重复 group 不影响结果。
- 只有一方未指定 group 时不匹配；空数组不是通配符。

```java
interface AdminGroup {}

class UserQuery {
    @KeepValue(AdminGroup.class)
    private String secret;
}

@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @KeepValue(AdminGroup.class) UserQuery query) {
    return HttpResult.ok();
}
```

## 启用与调用前提

```yaml
fairychar:
  bag:
    web:
      property-processor:
        enable: true
```

参数同时标注 `@RequestBody` 与当前处理注解。只处理当前类声明的非 static、非 final 字段，不处理父类字段，也不递归嵌套对象。清空引用为 null，基本类型为 Java 默认值。被清空字段不要添加同场景必填约束。复杂请求优先独立 Query，不用字段处理代替授权。

## 业务验收

白名单字段保留、未标注字段清空、默认组、显式匹配组、不匹配组、开关关闭；清空 null 字段可受 JSON 输出策略影响。

## 完整示例

[演示 Controller](../../examples/SdkQuickStartController.java) 展示注解 import 和请求/响应类型；只选取当前功能的方法，示例路由不暴露到生产环境。

## 类型与完整签名

- [`com.fairychar.bag.beans.spring.mvc.KeepValue`](../../api/beans-spring-mvc.md)
- [`com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice`](../../api/beans-spring-mvc.md)
