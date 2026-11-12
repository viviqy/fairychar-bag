# 通用 Query 与键值载体

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## POJO 和通用 Query

用途: 为简单 DTO、简单 JSON 请求体和通用时间范围查询提供可复用类型，减少重复创建只有一个字段的 `*Query`。

使用规则:

- 这些类适合“字段语义非常通用”的接口，例如只提交一个 id、一个字符串、一个 id 列表、一个日期范围。
- 复杂业务请求不要滥用这些类；如果字段需要业务命名、校验分组、Swagger 描述或后续扩展，应创建明确命名的业务 `*Query`。
- `SimpleTypeQuery<T>` 注释里写明 “feign 下不可用泛型”；Feign 请求体不要使用这个泛型包装类。
- `*BodyQuery` 的单值字段名固定为 `body`。
- `*ListQuery` 的集合字段名固定为 `list`。
- `DateBetweenQuery` 和 `TimeBetweenQuery` 只表达 from/to，不内置范围合法性校验。

### DTO

| 类 | 包 | 字段 | 用途 |
| --- | --- | --- | --- |
| `KeyValuePair` | `com.fairychar.bag.pojo.dto` | `name: K`, `value: V` | 返回或接收简单键值对列表；例如下拉选项、枚举展示、统计项映射 |

### 通用 Query

| 类 | 包 | 字段 | 用途 |
| --- | --- | --- | --- |
| `SimpleTypeQuery` | `com.fairychar.bag.pojo.query` | `value: T`，带 `@NotNull` | 接收一个泛型值的简单 JSON 请求体；Feign 下不要使用 |
| `DateBetweenQuery` | `com.fairychar.bag.pojo.query` | `from: LocalDate`, `to: LocalDate`，`@JsonFormat(pattern = Consts.SIMPLE_DATE_FORMAT)` | 日期范围查询，例如按天筛选报表、列表 |
| `TimeBetweenQuery` | `com.fairychar.bag.pojo.query` | `from: LocalDateTime`, `to: LocalDateTime`，`@JsonFormat(pattern = Consts.SIMPLE_DATETIME_FORMAT)` | 日期时间范围查询，例如按时间戳筛选记录 |

### 单值 JSON 请求体

| 类 | 包 | 字段 | Swagger schema | 用途 |
| --- | --- | --- | --- | --- |
| `StringBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: String` | `StringBody`, `String类型Json请求体` | 请求体只需要一个字符串值 |
| `LongBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: Long` | `LongBody`, `Long类型Json请求体` | 请求体只需要一个 Long 值，例如 id |
| `IntegerBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: Integer` | `IntegerBody`, `Integer类型Json请求体` | 请求体只需要一个 Integer 值 |
| `ShortBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: Short` | `ShortBody`, `Short类型Json请求体` | 请求体只需要一个 Short 值 |
| `ByteBodyQuery` | `com.fairychar.bag.pojo.query.body` | `body: Byte` | `ByteBody`, `Byte类型Json请求体` | 请求体只需要一个 Byte 值 |

### 集合 JSON 请求体

| 类 | 包 | 字段 | Swagger schema | 用途 |
| --- | --- | --- | --- | --- |
| `StringListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<String>` | `StringList`, `String类型Json请求集合` | 请求体只需要一个字符串列表 |
| `LongListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<Long>` | `LongList`, `Long类型Json请求集合` | 请求体只需要一个 Long 列表，例如批量 id |
| `IntegerListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<Integer>` | `IntegerList`, `Integer类型Json请求集合` | 请求体只需要一个 Integer 列表 |
| `ShortListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<Short>` | `ShortList`, `Short类型Json请求集合` | 请求体只需要一个 Short 列表 |
| `ByteListQuery` | `com.fairychar.bag.pojo.query.body` | `list: List<Byte>` | `ByteList`, `Byte类型Json请求集合体` | 请求体只需要一个 Byte 列表 |

## 类型与完整签名

- [`com.fairychar.bag.pojo.dto.KeyValuePair`](../../api/pojo-dto.md)
- [`com.fairychar.bag.pojo.query.body.ByteBodyQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.ByteListQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.IntegerBodyQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.IntegerListQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.LongBodyQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.LongListQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.ShortBodyQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.ShortListQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.StringBodyQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.body.StringListQuery`](../../api/pojo-query-body.md)
- [`com.fairychar.bag.pojo.query.DateBetweenQuery`](../../api/pojo-query.md)
- [`com.fairychar.bag.pojo.query.SimpleTypeQuery`](../../api/pojo-query.md)
- [`com.fairychar.bag.pojo.query.TimeBetweenQuery`](../../api/pojo-query.md)
