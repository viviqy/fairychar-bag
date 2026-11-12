# 注解方法锁

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。通过 Spring 代理使用本地、Redis 或 ZooKeeper 方法锁。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## @MethodLock

位置: `com.fairychar.bag.domain.annotations.MethodLock`

用途: 方法级锁切面。可按注解配置本地锁、Redis 分布式锁或 ZooKeeper 分布式锁，用于防重复执行、串行化同一业务资源操作、保护临界区。

SDK 自动提供切面实现；调用方只需配置开关、准备所选锁类型需要的 Bean 并使用 `@MethodLock`，无需手动创建、注册或调用内部切面。

开启方式:

| 配置项 | 说明 |
| --- | --- |
| `fairychar.bag.aop.lock.enable=true` | 开启方法锁切面 |
| `fairychar.bag.aop.lock.default-lock` | 全局默认锁类型 |
| `fairychar.bag.aop.lock.global-timeout` | 全局乐观锁等待时间 |
| `fairychar.bag.aop.lock.time-unit` | 全局等待时间单位 |

属性说明:

| 属性 | 默认值 | 说明 |
| --- | --- | --- |
| `lockType` | `DEFAULT` | `DEFAULT` 使用全局 `default-lock`，可选 `LOCAL`、`REDIS`、`ZK` |
| `enable` | `true` | false 时直接执行原方法 |
| `timeout` | `-1` | 乐观锁等待时间，`-1` 使用全局 |
| `optimistic` | `false` | true 使用 `tryLock/acquire(timeout)`，false 阻塞获取锁 |
| `timeUnit` | `NANOSECONDS` | 作为“使用全局单位”的哨兵值 |
| `nameExpression` | `""` | SpEL 表达式；业务使用必须显式填写有效表达式，不依赖空值默认行为 |
| `distributedPrefix` | `fairychar:lock:` | Redis key 前缀或 ZK path 前缀 |

## 锁类型

| 锁类型 | 依赖 | 行为 | 适用场景 |
| --- | --- | --- | --- |
| `LOCAL` | 无外部依赖 | 当前 JVM 内用 `ConcurrentHashMap<String, ReentrantLock>` 保存锁实例 | 单实例应用、单 JVM 临界区 |
| `REDIS` | Spring 容器内必须有 `RedissonClient` | 使用 Redisson 锁实现跨 JVM 分布式锁 | 多实例部署、同一业务资源跨节点互斥 |
| `ZK` | Spring 容器内必须有 `CuratorFramework` | 使用 ZooKeeper 锁实现跨 JVM 分布式锁 | 已使用 ZK 做协调服务的系统 |
| `DEFAULT` | 取决于全局配置 | 使用 `fairychar.bag.aop.lock.default-lock` | 统一项目默认策略，个别方法再覆盖 |

## nameExpression

`nameExpression` 决定锁名。默认空字符串存在解析失败风险；业务使用必须显式填写有效 SpEL 表达式，不依赖空值默认行为。

使用约束:

- 需要按业务资源加锁时应设置 `nameExpression`，例如按用户 id、订单 id、任务 id 加锁。
- `nameExpression` 使用 SpEL 解析方法参数。
- 常量字符串要写成 SpEL 字符串字面量，也就是外层表达式内包含引号。
- `nameExpression` 没有 `#` 时会按普通 SpEL 表达式求值，常量字符串如果没有写成字符串字面量，可能被当成属性名解析。
- Redis 和 ZK 锁最终还会叠加 `distributedPrefix`。
- 固定锁名也必须显式填写，例如 `nameExpression = "'orders:update'"`。按资源隔离时使用业务资源标识，不省略该属性。

## optimistic 和 timeout

| 配置 | 行为 | 使用建议 |
| --- | --- | --- |
| `optimistic=false` | 阻塞获取锁，拿到锁后执行方法 | 临界区必须执行，调用方可以等待 |
| `optimistic=true` | 尝试在 timeout 内获取锁，超时则失败 | 防重复提交、限时任务、避免请求线程长时间阻塞 |
| `timeout=-1` | 使用全局 timeout | 项目内统一等待策略 |
| `timeUnit=NANOSECONDS` | 使用全局 time-unit | 注解默认哨兵值，不代表实际按纳秒等待 |

## 实现约束

- Redis 模式从 `SpringContextHolder` 取 `RedissonClient`。
- ZK 模式从 `SpringContextHolder` 取 `CuratorFramework`。
- 本地锁使用 `ConcurrentHashMap<String, ReentrantLock>` 保存锁实例。
- 分布式锁前缀默认是 `fairychar:lock:`，业务项目如有 key 命名规范应显式配置。
- 方法抛异常时锁应由切面释放；业务代码不要自己释放注解锁。

## 选择建议

| 场景 | 推荐 |
| --- | --- |
| 单机后台任务、单实例管理接口 | `LOCAL` |
| 多实例接口防重复提交 | `REDIS` |
| 项目已有 ZK 且 Redis 不适合作为锁依赖 | `ZK` |
| 只想全项目统一切换锁类型 | 注解用 `DEFAULT`，配置里改 `default-lock` |
| 只是校验参数或读缓存 | 通常不需要 `@MethodLock` |

## 获取等待、租期与失败

| 入口 | 确定顺序与时间含义 | 失败 |
| --- | --- | --- |
| `@MethodLock(optimistic=true)` | 尝试等待注解或全局 timeout；具体锁类型决定失败方式 | LOCAL 等待失败为 TimeoutException；REDIS/ZK 返回未拿到锁时为 `FailToGetLockException`；客户端本身还可抛其他异常，不要一律当 RestException |
| `@MethodLock(optimistic=false)` | LOCAL 阻塞且可中断；REDIS/ZK 阻塞获取 | timeout 不是统一的方法执行超时；不自动取消业务方法 |

## 示例：开启方法锁切面

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

## 示例：本地锁

```java
@Service
class OrderService {
    @MethodLock(lockType = MethodLock.Type.LOCAL, nameExpression = "'order:' + #orderId")
    public void updateLocal(Long orderId) {
        // 同 JVM 内同 orderId 串行
    }
}
```

## 示例：Redis 分布式锁

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

## 示例：ZooKeeper 分布式锁

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

## 业务验收

经另一 Bean 调用真实 Spring 代理，使用屏障与临界区计数断言同锁名最大并发为 1；异常后可再获得锁。Redis/ZK 另外验证多实例互斥和超时。

## 完整可编译示例

[锁 Service](../../examples/SdkLockService.java) 以固定 SpEL 锁名演示本地互斥。由其他业务 Bean 注入后调用；若使用 [演示 Controller](../../examples/SdkFeatureController.java)，它还带请求日志，需要日志配置和 handler Bean。

## 类型与完整签名

- [`com.fairychar.bag.domain.annotations.MethodLock.Type`](../../api/domain-annotations.md)
- [`com.fairychar.bag.domain.annotations.MethodLock`](../../api/domain-annotations.md)
