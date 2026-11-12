# 参数校验与内置约束

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。Validation 注解和显式分组；@EndWith 不用于后缀校验。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 参数校验和自定义 Validator

### 标准校验异常处理

开启:

```yaml
fairychar:
  bag:
    web:
      advice:
        enable: true
```

Controller:

```java
@PostMapping("/users")
public HttpResult<Void> create(@RequestBody @Valid CreateUserQuery query) {
    return HttpResult.ok();
}
```

校验失败会返回:

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

### 手动处理校验结果

参见 [BindingResult 手动检查](binding-result.md)。

### 内置校验注解

| 注解 | 类型 | 说明 |
| --- | --- | --- |
| `@Phone` | `String` | Hutool 手机号校验 |
| `@IdCard` | `String` | Hutool 身份证校验 |
| `@Url` | `String` | 使用 `Consts.Regex.URL` |
| `@IP` | `String` | 使用 `Consts.Regex.IP` |
| `@In({"A","B"})` | `String` | 值必须在数组内 |
| `@NotIn({"A","B"})` | `String` | 值不能在数组内 |
| `@StartWith(value = {"pre"}, ignoreCase = true, ignoreEmpty = false)` | `Object` | 字符串前缀校验 |
| `@EndWith(value = {"suf"}, ignoreCase = true, ignoreEmpty = false)` | `Object` | 不用于新项目后缀校验；当前行为是前缀判断。改用业务显式后缀判断或经验证的正则约束 |
| `@Language(LanguageType.CHINESE)` | `String` | 按内置正则校验语言字符 |
| `@DateBetween(pattern = "yyyy-MM-dd", min = "2024-01-01", max = "now")` | `String` | 日期范围，不含边界 |
| `@TimeBetween(pattern = "yyyy-MM-dd HH:mm:ss", min = "now", max = "2099-12-31 23:59:59")` | `String` | 时间范围，不含边界 |
| `@FileSize(unit = FileSize.Unit.MB, min = 1, max = 10)` | `MultipartFile` | 文件大小范围 |

示例:

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

## 校验分组与实现类

`DeleteVali`、`IdVali`、`InsertVali`、`InsertOrUpdateVali`、`SearchVali`、`UniqueVali`、`UpdateVali` 是无继承关系的 marker 接口。名字不会自动组合分组；例如 `InsertOrUpdateVali` 不自动包含 `InsertVali` 和 `UpdateVali`。在约束 `groups` 和入口 `@Validated(...)` 中显式选择同一组。

`AbstractPatternValidator` 及 `DateValidator`、`TimeValidator`、`PhoneValidator`、`IdCardValidator`、`IpValidator`、`InValidator`、`NotInValidator`、`StartWithValidator`、`EndWithValidator`、`LanguageValidator`、`UrlValidator`、`FileSizeValidator` 是 Validation 生命周期实现。业务优先使用对应注解；若手动创建 Validator，要先用相应注解初始化，不能假设直接 `new` 后就具备全部配置。`initialize`、`isValid` 等回调完整签名见 [校验 API](../../api/domain-validator-rest.md)。

## 类型与完整签名

- [`com.fairychar.bag.domain.validator.rest.DateBetween`](../../api/domain-validator-rest--datebetween.md)
- [`com.fairychar.bag.domain.validator.rest.DateValidator`](../../api/domain-validator-rest--datevalidator.md)
- [`com.fairychar.bag.domain.validator.rest.EndWith`](../../api/domain-validator-rest--endwith.md)
- [`com.fairychar.bag.domain.validator.rest.EndWithValidator`](../../api/domain-validator-rest--endwithvalidator.md)
- [`com.fairychar.bag.domain.validator.rest.FileSize.Unit`](../../api/domain-validator-rest--filesize-unit.md)
- [`com.fairychar.bag.domain.validator.rest.FileSize`](../../api/domain-validator-rest--filesize.md)
- [`com.fairychar.bag.domain.validator.rest.FileSizeValidator`](../../api/domain-validator-rest--filesizevalidator.md)
- [`com.fairychar.bag.domain.validator.rest.IdCard`](../../api/domain-validator-rest--idcard.md)
- [`com.fairychar.bag.domain.validator.rest.IdCardValidator`](../../api/domain-validator-rest--idcardvalidator.md)
- [`com.fairychar.bag.domain.validator.rest.In`](../../api/domain-validator-rest--in.md)
- [`com.fairychar.bag.domain.validator.rest.InValidator`](../../api/domain-validator-rest--invalidator.md)
- [`com.fairychar.bag.domain.validator.rest.IP`](../../api/domain-validator-rest--ip.md)
- [`com.fairychar.bag.domain.validator.rest.IpValidator`](../../api/domain-validator-rest--ipvalidator.md)
- [`com.fairychar.bag.domain.validator.rest.Language.LanguageType`](../../api/domain-validator-rest--language-languagetype.md)
- [`com.fairychar.bag.domain.validator.rest.Language`](../../api/domain-validator-rest--language.md)
- [`com.fairychar.bag.domain.validator.rest.LanguageValidator`](../../api/domain-validator-rest--languagevalidator.md)
- [`com.fairychar.bag.domain.validator.rest.NotIn`](../../api/domain-validator-rest--notin.md)
- [`com.fairychar.bag.domain.validator.rest.NotInValidator`](../../api/domain-validator-rest--notinvalidator.md)
- [`com.fairychar.bag.domain.validator.rest.Phone`](../../api/domain-validator-rest--phone.md)
- [`com.fairychar.bag.domain.validator.rest.PhoneValidator`](../../api/domain-validator-rest--phonevalidator.md)
- [`com.fairychar.bag.domain.validator.rest.StartWith`](../../api/domain-validator-rest--startwith.md)
- [`com.fairychar.bag.domain.validator.rest.StartWithValidator`](../../api/domain-validator-rest--startwithvalidator.md)
- [`com.fairychar.bag.domain.validator.rest.TimeBetween`](../../api/domain-validator-rest--timebetween.md)
- [`com.fairychar.bag.domain.validator.rest.TimeValidator`](../../api/domain-validator-rest--timevalidator.md)
- [`com.fairychar.bag.domain.validator.rest.Url`](../../api/domain-validator-rest--url.md)
- [`com.fairychar.bag.domain.validator.rest.UrlValidator`](../../api/domain-validator-rest--urlvalidator.md)
- [`com.fairychar.bag.domain.validator.rest.abstracts.AbstractPatternValidator`](../../api/domain-validator-rest-abstracts.md)
- [`com.fairychar.bag.domain.validator.rest.group.DeleteVali`](../../api/domain-validator-rest-group.md)
- [`com.fairychar.bag.domain.validator.rest.group.IdVali`](../../api/domain-validator-rest-group.md)
- [`com.fairychar.bag.domain.validator.rest.group.InsertOrUpdateVali`](../../api/domain-validator-rest-group.md)
- [`com.fairychar.bag.domain.validator.rest.group.InsertVali`](../../api/domain-validator-rest-group.md)
- [`com.fairychar.bag.domain.validator.rest.group.SearchVali`](../../api/domain-validator-rest-group.md)
- [`com.fairychar.bag.domain.validator.rest.group.UniqueVali`](../../api/domain-validator-rest-group.md)
- [`com.fairychar.bag.domain.validator.rest.group.UpdateVali`](../../api/domain-validator-rest-group.md)
