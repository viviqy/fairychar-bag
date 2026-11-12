# 异步事务协调

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## TransactionUtil

位置: `com.fairychar.bag.utils.TransactionUtil`

用于多个异步事务协同提交/回滚。所有任务执行完后在 `CyclicBarrier` 等待，如果任一任务失败则 `isAllSuccess=false`，各事务在 finally 中标记回滚。

这是提交前协调，不提供跨事务原子提交保证；不作为新项目全局事务设施，具体失败路径和替代方案见本页限制部分。

```java
ExecutorService executor = Executors.newFixedThreadPool(2);
AtomicBoolean allSuccess = new AtomicBoolean(true);
CyclicBarrier barrier = new CyclicBarrier(2);

Future<?> f1 = TransactionUtil.doWithTransactionAsync(
        () -> orderMapper.insert(order),
        allSuccess,
        barrier,
        executor,
        transactionTemplate,
        30
);

Future<?> f2 = TransactionUtil.doWithTransactionAsync(
        () -> stockMapper.deduct(stockId),
        allSuccess,
        barrier,
        executor,
        transactionTemplate,
        30
);

ConcurrentUtil.getFutures(List.of(f1, f2));
```

注意:

- `CyclicBarrier` 的 parties 必须等于参与事务任务数。
- 如果一个任务抛异常，会设置 `isAllSuccess=false`。
- 如果等待超时或 barrier 异常，也会回滚。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `TransactionUtil.doWithTransactionAsync` | 每个任务独立 TransactionTemplate 事务，通过共享标记和 barrier 协调；默认等待 60 秒。action/等待异常可令标记为 false；Future 完成不等于所有事务原子提交，提交阶段失败也无跨事务回滚协议；finally 的 barrier 异常可覆盖原 action 异常 | 不作为全局事务/分布式事务设施。使用业务已有事务边界和一致性方案；提交拒绝、barrier 人数不足、rollback-only 与真实提交失败需分别测试 |

## 类型与完整签名

- [`com.fairychar.bag.utils.TransactionUtil`](../../api/utils--transactionutil.md)
