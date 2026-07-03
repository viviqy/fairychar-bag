# MethodLock Examples

> 返回示例入口: [02-web-rest-aop-and-lock-examples.md](02-web-rest-aop-and-lock-examples.md)。说明和约束见 `../references/02e-method-lock.md`。

## Example 1: 开启方法锁切面

```yaml
fairychar:
  bag:
    aop:
      lock:
        enable: true
        default-lock: LOCAL
        global-timeout: 2
        time-unit: SECONDS
```

## Example 2: 本地锁

```java
@Service
class OrderService {
    @MethodLock(lockType = MethodLock.Type.LOCAL, nameExpression = "'order:' + #orderId")
    public void updateLocal(Long orderId) {
        // 同 JVM 内同 orderId 串行
    }
}
```

## Example 3: Redis 分布式锁

```java
@MethodLock(
        lockType = MethodLock.Type.REDIS,
        optimistic = true,
        timeout = 3,
        timeUnit = TimeUnit.SECONDS,
        distributedPrefix = "fairychar:order:",
        nameExpression = "'stock:' + #skuId"
)
public void deductStock(Long skuId) {
    // 未在 3 秒内拿到锁时抛 FailToGetLockException
}
```

## Example 4: ZooKeeper 分布式锁

```java
@MethodLock(
        lockType = MethodLock.Type.ZK,
        optimistic = false,
        distributedPrefix = "/fairychar/order/",
        nameExpression = "'pay:' + #orderId"
)
public void pay(Long orderId) {
    // 悲观阻塞直到拿到锁
}
```
