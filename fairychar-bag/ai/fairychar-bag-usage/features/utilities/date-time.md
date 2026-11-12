# 日期时间工具

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：可直接采用（文档内操作）**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## DateConvertUtil

位置: `com.fairychar.bag.utils.DateConvertUtil`

```java
LocalDate date = DateConvertUtil.parseDate("20260702");
LocalDateTime time = DateConvertUtil.parseTime("2026-07-02 12:30:00");
Date legacy = DateConvertUtil.localdateToDate(LocalDate.now());
```

支持日期格式:

- `yyyy-MM-dd`
- `yyyyMMdd`
- `yyyyMd`
- `yyyy/M/d`
- `yyyy/MM/dd`

支持时间格式:

- `yyyy-MM-dd HH:mm:ss`
- `yyyyMMdd HH:mm:ss`
- `yyyyMd HH:mm:ss`
- `yyyy/M/d HH:mm:ss`
- `yyyy/M/d HH/mm/ss`
- `yyyy/MM/dd HH/mm/ss`
- `yyyy/MM/ddHH/mm/ss`
- `yyyyMMdd HHmmss`
- `yyyyMMddHHmmss`

注意: 解析失败返回 `null`，不会抛解析异常；入参空白会触发 Hutool `Assert.notBlank`。

候选格式同时受输入长度筛选，不能据单个 M/d 推断任意位数；SMART 解析会调整部分无效日历日期，不作为严格输入校验。具体输入、返回与失败行为如下。

日期对象互转方法：

| 方法 | 返回与时区语义 |
| --- | --- |
| `dateToLocaldateTime(Date)` | 返回系统默认时区下的 `LocalDateTime` |
| `dateToLocaldate(Date)` | 返回系统默认时区下的 `LocalDate` |
| `localdateToDate(LocalDate)` | 返回系统默认时区中该日期开始时间对应的 `Date` |

以上方法不接受 null，也没有显式 ZoneId 参数；跨时区业务应自己选择时区，不要假设固定 UTC。方法名大小写按实际 API 保留，不存在 `localdateTimeToDate(...)`。完整签名见 [utils API](../../api/utils.md)。

## 输入、效果与失败契约

**前置与输入**：`parseDate` / `parseTime` 接收非空白字符串，不 trim。优先输入 `2026-01-02`、`2026-01-02 03:04:05` 等明确格式；专题中其他格式还受输入长度等于格式字符串长度的筛选，不能据格式中的单个 M/d 推断支持任意一位或两位月日。

**效果与返回**：日期返回 `LocalDate`，时间返回 `LocalDateTime`；非空白文本不能解析时返回 null。使用格式器的 SMART 解析，不承担严格日历合法性校验；例如 `2026-02-30` 可被调整为 `2026-02-28`。多个候选格式没有优先级契约，歧义文本不要使用。

**失败**：null、空字符串、纯空白抛 `IllegalArgumentException`；不匹配返回 null 不是异常。三个 Date 互转方法的 null 输入抛 `NullPointerException`。

**副作用与资源**：不修改输入；Date 互转使用系统默认时区。`localdateToDate` 为该时区当天起始时刻；不等于固定 UTC，DST 由时区规则决定。需要严格格式、偏移或 UTC 时采用业务显式格式器和 ZoneId。

**输入 → 输出**：`parseDate("not-a-date") → null`；`parseDate(" 2026-01-02 ") → null`；`parseTime("2026-01-02 03:04:05") → 2026-01-02T03:04:05`。真实业务测试必须区分空白异常和非匹配 null。

## 类型与完整签名

- [`com.fairychar.bag.utils.DateConvertUtil`](../../api/utils--dateconvertutil.md)
