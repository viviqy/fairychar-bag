# 响应字段脱敏

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。@FuzzyResult 定位对象，@FuzzyValue 按索引替换；使用独立可修改 VO。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 响应脱敏 @FuzzyResult / @FuzzyValue

开启:

```yaml
fairychar:
  bag:
    web:
      property-processor:
        enable: true
```

直接脱敏返回对象:

```java
class UserVO {
    @FuzzyValue(beginAt = 3, endAt = 7)
    private String phone = "13812345678";
}

@FuzzyResult
@GetMapping("/users/{id}")
public UserVO get(@PathVariable Long id) {
    return userService.get(id);
}
```

包装体脱敏:

```java
@FuzzyResult(field = "data")
@GetMapping("/users/{id}")
public HttpResult<UserVO> get(@PathVariable Long id) {
    return HttpResult.ok(userService.get(id));
}
```

默认脱敏规则的 `beginAt/endAt` 行为:

```java
@FuzzyValue(beginAt = 3, endAt = 7)
private String phone = "13812345678";
// 输出: 138****5678
// 默认规则: 保留 [0, beginAt)，替换 [beginAt, endAt)，保留 [endAt, length)
```

`@FuzzyValue` 完整属性为 `beginAt`（默认 0）、`endAt`（默认 0）、`replaceSymbol`（默认 `"*"`）、`processor`（默认空数组）。默认处理替换 `[beginAt,endAt)`，不是自动识别手机号；索引必须适合实际字符串长度。空值、越界和集合中的 null 元素需要业务先处理或单独验证。

新项目使用默认脱敏规则即可，`processor` 保持默认值；本文不提供内部处理器的类和方法说明。脱敏会原地修改字段或集合，不要直接对数据库实体、共享缓存对象和不可修改集合做响应脱敏，优先转换为独立 VO。

脱敏支持:

- 对象内递归查找带 `@FuzzyValue` 的字段。
- 字段类型为 `String`。
- 字段类型为 `List` 且元素是 `String`。
- 字段类型为 `Map` 且 value 是 `String`。
- `@FuzzyResult(field = "data.user")` 支持嵌套字段路径。

## 业务验收

手机号 `13812345678` 变为 `138****5678`；另外覆盖 null、短字符串、空集合和嵌套路径，不对共享实体原地脱敏。

## 完整示例

[演示 Controller](../../examples/SdkQuickStartController.java) 展示注解 import 和请求/响应类型；只选取当前功能的方法，示例路由不暴露到生产环境。

## 类型与完整签名

- [`com.fairychar.bag.beans.spring.mvc.FuzzyResult`](../../api/beans-spring-mvc.md)
- [`com.fairychar.bag.beans.spring.mvc.FuzzyValue`](../../api/beans-spring-mvc.md)
