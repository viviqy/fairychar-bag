# Redis key 前缀序列化

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## PrefixStringSerializer

位置: `com.fairychar.bag.beans.redis.PrefixStringSerializer`

用途: 在 Redis key 序列化时自动加前缀。反序列化不会去掉前缀；业务不要假设序列化和反序列化会还原原 key。

```java
RedisTemplate<String, Object> template = new RedisTemplate<>();
template.setKeySerializer(new PrefixStringSerializer("my-service:"));
```

## 输入、输出与失败

**前置与输入**：类型位于 `com.fairychar.bag.beans.redis`；自行设置到业务 RedisTemplate 的正确 key/value 位置，不能假设仅创建 Bean 就替换现有数据格式。序列化器本身可离线调用，不要求启动 Redis；接入存储后的数据兼容需要真实 Redis 验证。
| 方法 | 输入 → 输出 | 失败与限制 |
| --- | --- | --- |
| `new PrefixStringSerializer("app:").serialize` | null → null；`""` → `"app:"` 的 UTF-8 字节；`"id"` → `"app:id"` | 业务必须传非 null prefix；单参数构造不立即校验 null，序列化非 null 文本时会 NPE |
| `PrefixStringSerializer(Charset,prefix)` | 显式字符集；非 null prefix | null prefix 在构造时抛 `BeanCreationException`；字符集须非 null |
| `PrefixStringSerializer.deserialize` | null / 零长度数组 → null；其他字节直接按对应字符集解码 | 不移除前缀，所以 `deserialize(serialize("id")) → "app:id"`，不是 `"id"` |

替换序列化器不会迁移存量数据；上线前验证新旧数据、多客户端及空值兼容。序列化器不管理 Redis 连接。

## 类型与完整签名

- [`com.fairychar.bag.beans.redis.PrefixStringSerializer`](../../api/beans-redis.md)
