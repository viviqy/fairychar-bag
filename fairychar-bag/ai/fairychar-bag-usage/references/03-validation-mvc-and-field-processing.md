# Validation MVC And Field Processing Reference

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。本文件只保留说明、约束和 API 语义；代码示例放在 `../scripts/`。

## 参数校验和自定义 Validator

### 标准校验异常处理

开启:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `标准校验异常处理`。


Controller:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `标准校验异常处理`。


校验失败会返回:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `标准校验异常处理`。


### BindingResultUtil

位置: `com.fairychar.bag.utils.BindingResultUtil`

用于手动检查 `BindingResult`，有错误时抛 `ParamErrorException`。


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `BindingResultUtil`。


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
| `@EndWith(value = {"suf"}, ignoreCase = true, ignoreEmpty = false)` | `Object` | 源码当前实际使用 `startsWith` 判断，使用前注意 |
| `@Language(LanguageType.CHINESE)` | `String` | 按内置正则校验语言字符 |
| `@DateBetween(pattern = "yyyy-MM-dd", min = "2024-01-01", max = "now")` | `String` | 日期范围，不含边界 |
| `@TimeBetween(pattern = "yyyy-MM-dd HH:mm:ss", min = "now", max = "2099-12-31 23:59:59")` | `String` | 时间范围，不含边界 |
| `@FileSize(unit = FileSize.Unit.MB, min = 1, max = 10)` | `MultipartFile` | 文件大小范围 |

示例:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `内置校验注解`。


## 请求体字段擦除和保留

开启:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `请求体字段擦除和保留`。


### @EraseValue

作用于 `@RequestBody` 参数和字段。进入 Controller 前，把匹配字段置为 `null`。


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `@EraseValue`。


### @KeepValue

作用于 `@RequestBody` 参数和字段。进入 Controller 前，只保留匹配字段，其它字段置为 `null`。


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `@KeepValue`。


### group 语义

`@EraseValue` 和 `@KeepValue` 都支持 `Class<?>[] value()`。参数注解和字段注解的 group 有交集时才认为匹配。


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `group 语义`。


## 响应脱敏 @FuzzyResult / @FuzzyValue

开启:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `响应脱敏 @FuzzyResult / @FuzzyValue`。


直接脱敏返回对象:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `响应脱敏 @FuzzyResult / @FuzzyValue`。


包装体脱敏:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `响应脱敏 @FuzzyResult / @FuzzyValue`。


默认 `FuzzyValueAdvice` 的 `beginAt/endAt` 行为:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `响应脱敏 @FuzzyResult / @FuzzyValue`。


自定义处理器:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `响应脱敏 @FuzzyResult / @FuzzyValue`。


`FuzzyMiddleTextProcessor` 的 `endAt` 表示“从右保留几位”，与默认处理逻辑不同。

脱敏支持:

- 对象内递归查找带 `@FuzzyValue` 的字段。
- 字段类型为 `String`。
- 字段类型为 `List` 且元素是 `String`。
- 字段类型为 `Map` 且 value 是 `String`。
- `@FuzzyResult(field = "data.user")` 支持嵌套字段路径。

## MVC 日期转换

开启:


> 代码示例已移到 `../scripts/03-validation-mvc-and-field-processing-examples.md`，对应标题: `MVC 日期转换`。


注册:

- `StringToLocalDateConverter`
- `StringToLocalDateTimeConverter`

底层使用 `DateConvertUtil.parseDate` 和 `DateConvertUtil.parseTime`。

