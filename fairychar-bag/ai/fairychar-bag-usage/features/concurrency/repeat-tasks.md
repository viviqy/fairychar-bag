# 重复任务编排

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## RepeatTaskExecutor

位置: `com.fairychar.bag.extension.concurrent.RepeatTaskExecutor`

多个任务组成一个批次，同一批次所有任务都执行完后进入下一批次。

```java
RepeatTaskExecutor executor = RepeatTaskExecutor.createCycle(
        List.of(
                () -> syncA(),
                () -> syncB()
        ),
        "sync"
);

executor.start(
        e -> log.warn("interrupted", e),
        e -> log.warn("timeout", e),
        e -> log.warn("broken", e),
        10_000
);
```

注意:

- 每个 action 在自己的线程中无限循环。
- 每轮结束后在 `CyclicBarrier` 等待。
- `stop()` 会 `cyclicBarrier.reset()`，触发任务退出。
- `getExecutedTimes()` 是各 action 通过 barrier 后分别递增的计数，不应直接当成完整批次数；异常或未在 barrier 等待的任务也不保证被 `stop()` 立即终止。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `RepeatTaskExecutor` | 各任务循环和 barrier 同步；stop 重置 barrier，不关闭外部执行器，也不保证打断正在执行的 action | 使用业务有停止信号、取消和终止等待的调度器，不以 stop 返回断言所有任务已退出 |

## 类型与完整签名

- [`com.fairychar.bag.extension.concurrent.RepeatTaskExecutor`](../../api/extension-concurrent.md)
