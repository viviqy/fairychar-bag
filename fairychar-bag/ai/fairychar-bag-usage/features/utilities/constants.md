# 常量 Consts

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：可直接采用（明确可用字段）**。字符串、容量、日期、OAuth2 和正则；TB/PB 溢出常量不可使用。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 基础字符串和容量

| 字段 | 类型 | 实际值 | 使用决策 |
| --- | --- | --- | --- |
| `EMPTY_STR` | `String` | `""` | 空字符串；不是 null，也不是空白字符串判断规则 |
| `NONE` | `String` | `"none"` | 字面字符串，只有协议明确约定此值时使用；不是通用缺省值 |
| `KB_PER_B` | `long` | `1024` | 二进制 KiB 字节数；不是十进制 1000 |
| `MB_PER_B` | `long` | `1048576` | 二进制 MiB 字节数 |
| `GB_PER_B` | `long` | `1073741824` | 二进制 GiB 字节数 |
| `TB_PER_B` | `long` | `0` | 不使用；容量计算改用 `1L << 40` |
| `PB_PER_B` | `long` | `0` | 不使用；容量计算改用 `1L << 50` |

容量乘法使用 long 并考虑溢出，例如 `Math.multiplyExact(size, Consts.MB_PER_B)`。十进制 GB 应按业务协议使用 `1_000_000_000L`，不要因常量名称含 GB 就混用口径。

## 日期时间

| 字段 | 类型 | 值 / 含义 |
| --- | --- | --- |
| `SIMPLE_DATETIME_FORMAT` | `String` | `"yyyy-MM-dd HH:mm:ss"` |
| `SIMPLE_DATE_TIME_FORMATTER` | `DateTimeFormatter` | 对应上述日期时间格式 |
| `SIMPLE_DATE_FORMAT` | `String` | `"yyyy-MM-dd"` |
| `SIMPLE_DATE_FORMATTER` | `DateTimeFormatter` | 对应上述日期格式 |
| `MYSQL_MAX_DATETIME` | `LocalDateTime` | `9999-12-31T23:59:59` |
| `MYSQL_MAX_TIMESTAMP` | `LocalDateTime` | `2038-01-19T03:14:07` |

这些格式和 `LocalDateTime` 不包含时区或偏移信息，不直接用于表达 UTC 瞬间。两个 MYSQL 字段是 SDK 提供的边界常量，不是数据库配置探测或写入成功保证；业务仍按实际列类型、精度、时区和驱动做写入验证，不自动作为“永不过期”默认值。

## OAuth2 字符串

嵌套类：`com.fairychar.bag.domain.Consts.OAuth2`。以下都是 `String`，只提供协议字面量，不会配置认证流程，也不代表某模式适合新项目；认证方案沿用业务已选方案，不因存在常量而启用对应模式。

| 字段 | 值 |
| --- | --- |
| `AUTHORIZATION_CODE` | `"authorization_code"` |
| `PASSWORD` | `"password"` |
| `CLIENT_CREDENTIALS` | `"client_credentials"` |
| `IMPLICIT` | `"implicit"` |
| `REFRESH_TOKEN` | `"refresh_token"` |

## 正则

嵌套类：`com.fairychar.bag.domain.Consts.Regex`。两个字段都是 `String`；需要时由业务编译成 Pattern，不把名称当作严格校验保证。

| 字段 | 实际边界 | 禁止用途 |
| --- | --- | --- |
| `IP` | 四段 1–3 位数字，不限制每段为 0–255；例如 `999.999.999.999` 也匹配 | 严格 IP 校验、网络访问授权 |
| `URL` | 仅 http/https 简单域名和有限字符路径格式；不覆盖带端口、常见查询参数等 URL | 完整 URL 解析、SSRF 防护、安全域名判断 |

严格地址和网络访问校验使用业务选定的解析及安全策略，不用这两个简单正则代替。

## 最小用法与验证

```java
import com.fairychar.bag.domain.Consts;
import java.time.LocalDateTime;

long uploadLimitBytes = Math.multiplyExact(10L, Consts.MB_PER_B);
String displayTime = LocalDateTime.of(2026, 1, 2, 3, 4, 5)
        .format(Consts.SIMPLE_DATE_TIME_FORMATTER);
```

这是方法体片段，不是完整应用。业务断言应验证 `uploadLimitBytes == 10485760L`、`displayTime.equals("2026-01-02 03:04:05")`，并覆盖单位口径、超大容量及日期时区策略。已有常量不满足契约时选择业务替代，不改动 SDK。

## 类型与完整签名

- [`com.fairychar.bag.domain.Consts.OAuth2`](../../api/domain.md)
- [`com.fairychar.bag.domain.Consts.Regex`](../../api/domain.md)
- [`com.fairychar.bag.domain.Consts`](../../api/domain.md)
