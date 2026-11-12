# 缓存双检查读取

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## CacheOperateTemplate

位置: `com.fairychar.bag.template.CacheOperateTemplate`

本地锁缓存读取:

```java
User user = CacheOperateTemplate.get(
        () -> localCache.get(id),
        () -> userMapper.selectById(id),
        value -> localCache.put(id, value),
        ("user:" + id).intern()
);
```

Redis 分布式锁缓存读取:

```java
User user = CacheOperateTemplate.get(
        () -> redisTemplate.opsForValue().get("user:" + id),
        () -> userMapper.selectById(id),
        value -> redisTemplate.opsForValue().set("user:" + id, value),
        redissonClient.getLock("lock:user:" + id)
);
```

语义:

1. 先读缓存。
2. 缓存为空则加锁。
3. 锁内再次读缓存。
4. 仍为空则读 DB。
5. DB 非空时写缓存并返回。
6. DB 为空时返回 null，不写缓存。

## CacheOperateTemplate.get

**前置与输入**：三个回调非 null。Object 重载应传所有同 key 调用共享的非 null 锁；RLock 重载传已经初始化客户端产生的同 key 分布式锁。不管理过期时间，不自动生成锁名。

**效果与返回**：调用线程同步执行：读缓存；命中非 null 立即返回同一对象引用，不加锁；未命中则加锁再读；仍未命中才读 DB；DB 非 null 时先调用 putCache，再返回 DB 对象。DB 为 null 时返回 null，不调用 putCache，因此无空值防穿透能力。

**失败**：读缓存、读 DB、写缓存或锁异常不吞掉，也不自动重试；写缓存失败时调用失败，不保证把已读 DB 值返回。null Object 锁只有走到缓存未命中时才失败，不能依赖命中路径隐藏错误配置。

**副作用与资源**：本地重载只保护当前 JVM 的同一锁对象；分布式重载使用无显式等待期限的 `lock()`，finally 当前线程持锁时解锁。不关闭客户端、执行器或业务事务。返回值没有复制，回调必须承担实际缓存写入、序列化和 TTL 策略。

**输入 → 输出**：第一次缓存 null、第二次 null、DB="v" → 两次缓存读取、一次 DB 读取、一次写入、返回 `"v"`；第二次缓存已为 `"other"` → 不调用 DB/put；DB=null → null 且不写缓存。

## 类型与完整签名

- [`com.fairychar.bag.template.CacheOperateTemplate`](../../api/template.md)
