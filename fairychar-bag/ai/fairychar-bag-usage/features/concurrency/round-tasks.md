# 分轮任务编排

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## RoundTaskExecutor

位置: `com.fairychar.bag.extension.concurrent.RoundTaskExecutor`

将多个任务链按下标分轮同步执行。第 0 轮所有链的第 0 个任务完成后，才进入第 1 轮。

```java
List<List<Action>> chains = new ArrayList<>();
chains.add(new ArrayList<>(List.of(() -> stepA1(), () -> stepA2())));
chains.add(new ArrayList<>(List.of(() -> stepB1(), () -> stepB2())));

RoundTaskExecutor executor = RoundTaskExecutor.boxedTaskList(chains);
executor.start();
```

`boxedTaskList` 会把短链补空 action，使所有链长度一致。

- 输入任务列表必须非空且内部列表可修改；补齐操作会修改调用方的短链列表。
- `awaitTaskDone()` 是注册一个 Phaser 参与者并等待一次阶段推进，不等于可靠等待所有任务链全部完成。结束后调用还可能阻塞，不宜用于新项目的“全部任务完成”判断。
- `getExecuteRound()`、`getExecutedRound()`、`getExecutedTaskCount()` 返回的是 `AtomicInteger` 引用；不要从业务侧随意改写状态。
- `stop()` 强制终止 Phaser，但不关闭内部线程池；不要据此认为线程资源已释放。新项目有严格资源治理需求时优先采用业务可控的执行器。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `RoundTaskExecutor` | 补齐时修改短任务链，awaitTaskDone 只是阶段等待；stop 不关闭内部执行器，计数 getter 暴露可变 AtomicInteger | 不作为可靠“全部完成”屏障；优先业务 Future/CompletableFuture 与明确关闭策略 |

## 类型与完整签名

- [`com.fairychar.bag.extension.concurrent.RoundTaskExecutor`](../../api/extension-concurrent.md)
