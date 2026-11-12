# 条件装配注解

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：仅在已说明范围内按需使用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 条件装配注解

位置: `com.fairychar.bag.domain.conditional`

| 注解 | 作用 |
| --- | --- |
| `@ConditionalOnSystemProperty` | 按 JVM system property 判断 |
| `@ConditionalOnSystemOS` | 按操作系统判断 |
| `@ConditionalOnRandomNumber` | 按随机数范围判断 |
| `@ConditionalOnPingHost` | 按 host ping 可达性判断 |
| `@ConditionalOnDateTime` | 按时间判断 |

这些注解用于 Spring Bean 条件装配。写新自动配置时，优先使用 Spring Boot 自带 `@ConditionalOnProperty`；只有确实需要这些特殊条件时再使用。

完整属性和默认值见 [conditional API](../../api/domain-conditional.md)。其中 `ConditionalOnDateTime.lower/upper`、`ConditionalOnSystemOS.os/condition`、`ConditionalOnPingHost.host/result` 是必要属性，不能省略；时间/网络/随机条件只参与装配判断，不是持续运行的开关或健康检查。

## 类型与完整签名

- [`com.fairychar.bag.domain.conditional.ConditionalOnDateTime`](../../api/domain-conditional.md)
- [`com.fairychar.bag.domain.conditional.ConditionalOnPingHost`](../../api/domain-conditional.md)
- [`com.fairychar.bag.domain.conditional.ConditionalOnRandomNumber`](../../api/domain-conditional.md)
- [`com.fairychar.bag.domain.conditional.ConditionalOnSystemOS.OS`](../../api/domain-conditional.md)
- [`com.fairychar.bag.domain.conditional.ConditionalOnSystemOS`](../../api/domain-conditional.md)
- [`com.fairychar.bag.domain.conditional.ConditionalOnSystemProperty`](../../api/domain-conditional.md)
