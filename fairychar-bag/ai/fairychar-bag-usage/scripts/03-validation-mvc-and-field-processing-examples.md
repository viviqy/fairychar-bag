# Validation MVC And Field Processing Examples

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。说明和约束见 `../references/` 中对应文档。

## Example 1: 标准校验异常处理

```yaml
fairychar:
  bag:
    web:
      advice:
        enable: true
```

## Example 2: 标准校验异常处理

```java
@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @Valid CreateUserQuery query) {
    return HttpResult.ok();
}
```

## Example 3: 标准校验异常处理

```json
{
  "code": 10000,
  "data": [
    {
      "field": "phone",
      "msg": "not phone number",
      "defaultMessage": null
    }
  ],
  "msg": "参数校验失败"
}
```

## Example 4: BindingResultUtil

```java
@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @Valid CreateUserQuery query, BindingResult bindingResult) {
    BindingResultUtil.checkBindingErrors(bindingResult);
    return HttpResult.ok();
}
```

## Example 5: 内置校验注解

```java
@Data
class CreateUserQuery {
    @Phone
    private String phone;

    @In({"MALE", "FEMALE"})
    private String gender;

    @DateBetween(min = "1900-01-01", max = "now")
    private String birthday;

    @FileSize(unit = FileSize.Unit.MB, max = 5)
    private MultipartFile avatar;
}
```

## Example 6: 请求体字段擦除和保留

```yaml
fairychar:
  bag:
    web:
      property-processor:
        enable: true
```

## Example 7: @EraseValue

```java
class UserQuery {
    @EraseValue
    private String roleCode;
    private String name;
}

@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @EraseValue UserQuery query) {
    // query.roleCode == null
    // query.name 保留原值
    return HttpResult.ok();
}
```

## Example 8: @KeepValue

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

## Example 9: group 语义

```java
interface AdminGroup {}

class UserQuery {
    @EraseValue(AdminGroup.class)
    private String secret;
}

@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @EraseValue(AdminGroup.class) UserQuery query) {
    // secret 被擦除
    return HttpResult.ok();
}
```

## Example 10: 响应脱敏 @FuzzyResult / @FuzzyValue

```yaml
fairychar:
  bag:
    web:
      property-processor:
        enable: true
```

## Example 11: 响应脱敏 @FuzzyResult / @FuzzyValue

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

## Example 12: 响应脱敏 @FuzzyResult / @FuzzyValue

```java
@FuzzyResult(field = "data")
@GetMapping("/users/{id}")
public HttpResult<UserVO> get(@PathVariable Long id) {
    return HttpResult.ok(userService.get(id));
}
```

## Example 13: 响应脱敏 @FuzzyResult / @FuzzyValue

```java
@FuzzyValue(beginAt = 3, endAt = 7)
private String phone = "13812345678";
// 输出: 138****5678
// 源码逻辑: 保留 [0, beginAt)，替换 [beginAt, endAt)，保留 [endAt, length)
```

## Example 14: 响应脱敏 @FuzzyResult / @FuzzyValue

```java
@Bean
FuzzyValueProcessor middleFuzzy() {
    return new FuzzyMiddleTextProcessor();
}

class UserVO {
    @FuzzyValue(beginAt = 1, endAt = 1, processor = FuzzyMiddleTextProcessor.class)
    private String name = "张三丰";
}
```

## Example 15: MVC 日期转换

```yaml
fairychar:
  bag:
    convert:
      mvc:
        enable: true
```

