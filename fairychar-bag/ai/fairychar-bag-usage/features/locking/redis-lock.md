# Redis 手动锁

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## RedisLockUtil

位置: `com.fairychar.bag.utils.RedisLockUtil`

悲观锁:

```java
RLock lock = redissonClient.getLock("user:" + userId);
RedisLockUtil.lock(lock, () -> {
    // 业务逻辑
});
```

带双检查:

```java
RedisLockUtil.lock(
        lock,
        () -> checkCacheBeforeLock(),
        () -> checkCacheAfterLock(),
        () -> loadDbAndPutCache(),
        30,
        TimeUnit.SECONDS
);
```

乐观锁:

```java
RedisLockUtil.tryLock(lock, () -> updateStock(), 3, TimeUnit.SECONDS);
```

语义:

- `lock(...)`: 调用 Redisson `lock()` 或 `lock(time, unit)`，获取不到时阻塞。
- `tryLock(...)`: 获取失败抛 `FailToGetLockException`。
- `beforeSearch`: 加锁前执行。
- `searchAgain`: 加锁后再次检查，典型用于缓存击穿双检查。
- `action`: 真正业务动作。
- finally 中会判断 `isHeldByCurrentThread()` 后解锁。

带 time 的 `lock` 参数是租期，带 time 的 `tryLock` 参数是等待时间；回调正常返回不会提前结束业务动作。获取失败、中断及外层可重入锁释放风险如下，不要按同名 time 参数推断统一语义。

## 获取等待、租期与失败

| 入口 | 确定顺序与时间含义 | 失败 |
| --- | --- | --- |
| `RedisLockUtil.lock` 无 time | beforeSearch → `lock()` → searchAgain → action | 阻塞获取；回调/客户端异常向外传播 |
| `RedisLockUtil.lock(...,time,unit)` | 同上，但调用 `lock(time,unit)`；time 是持锁租期，不是获取等待上限 | 获取仍可能阻塞；租期到期时业务可能尚未完成，不能声称整个方法始终受锁保护 |
| `RedisLockUtil.tryLock` 无 time | beforeSearch → 立即 tryLock；成功再 searchAgain → action | 未拿到锁抛 `FailToGetLockException`，不执行后两步 |
| `RedisLockUtil.tryLock(...,time,unit)` | time 是最多等待锁的时间，使用两个参数的 tryLock，不指定租期 | false → `FailToGetLockException`；InterruptedException 包装 RuntimeException，工具不恢复中断标记 |

**前置与输入**：RLock 和被执行回调非 null、time 非负且 unit 非 null。锁由业务按资源选择并管理；调用是同步的，不自动启动事务。`@MethodLock` 的前置配置与 Bean 见 [方法锁](method-lock.md)。

**副作用与资源**：两个 check 回调是 Action，不返回是否命中；正常返回后仍继续执行，不能把它们误当缓存模板的提前返回判断。`checkIsPresent` 重载会在锁前和锁后调用同一个 Action。finally 只要当前线程持锁就 unlock，即使异常发生在锁前；已持有同一个可重入锁时，可能释放外层的一次持有计数，禁止把它当可任意嵌套的封装。

**最小验证**：锁调用顺序、获取失败时不执行业务、回调异常时释放锁、不同资源锁名；Redis 真实环境还要验证租期、断连和长任务。客户端由业务关闭。锁不代替数据库约束或幂等策略。

## 类型与完整签名

- [`com.fairychar.bag.domain.exceptions.FailToGetLockException`](../../api/domain-exceptions--failtogetlockexception.md)
- [`com.fairychar.bag.utils.RedisLockUtil`](../../api/utils--redislockutil.md)
