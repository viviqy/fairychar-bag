# Redis Gzip 字符串序列化

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## GzipStringSerializer

位置: `com.fairychar.bag.beans.redis.GzipStringSerializer`

用途: value 字符串序列化时 Gzip 压缩，反序列化时解压；多行文本会丢失换行，不是任意文本的保真存储。null、空串和损坏数据行为见下方输入输出表。

```java
template.setValueSerializer(new GzipStringSerializer());
```

## 输入、输出与失败

**前置与输入**：类型位于 `com.fairychar.bag.beans.redis`；自行设置到业务 RedisTemplate 的正确 key/value 位置，不能假设仅创建 Bean 就替换现有数据格式。序列化器本身可离线调用，不要求启动 Redis；接入存储后的数据兼容需要真实 Redis 验证。
| 方法 | 输入 → 输出 | 失败与限制 |
| --- | --- | --- |
| `new GzipStringSerializer().serialize` | null → null；`""` → 有效 gzip 字节；非空字符串 → UTF-8 gzip | null 与空字符串不同；不是直接写入普通 UTF-8 文本 |
| `GzipStringSerializer.deserialize` | null / 零长度数组 → null；gzip 空文本 → `""`；多行文本解压会删除换行 | 损坏/非 gzip 数据 → `FBException`，不会自动降级普通字符串；不提供解压输出大小限制 |

替换序列化器不会迁移存量数据；上线前验证新旧数据、多客户端及空值兼容。序列化器不管理 Redis 连接。

不提供解压输出大小上限；需保真存储或处理不可信压缩输入时不采用。

## 类型与完整签名

- [`com.fairychar.bag.beans.redis.GzipStringSerializer`](../../api/beans-redis.md)
