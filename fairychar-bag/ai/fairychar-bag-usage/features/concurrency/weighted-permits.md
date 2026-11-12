# 加权许可调度

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## AssignableFactory

位置: `com.fairychar.bag.extension.concurrent.AssignableFactory`

用于按“资源权重”分配并发许可。

```java
ExecutorService executor = Executors.newFixedThreadPool(8);
AssignableFactory factory = AssignableFactory.recruitWorkers(3, executor);

factory.doWork(() -> callA(), 2);
factory.doWork(() -> callB(), 1);

Future<String> future = factory.doWorkFuture(() -> loadData(), 1);
```

语义:

- 内部使用 `Semaphore`。
- `workers` 表示本任务占用多少许可。
- `recruitWorkers(int workers)` 无外部线程池版本已废弃。
- `getAvailableWorkers()` 返回当前可用许可数，不是线程池空闲线程数，也不是下一次提交一定不阻塞的承诺。
- 使用外部线程池版本时，由业务负责线程池关闭；避免任务权重超过总许可数导致无限等待。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `AssignableFactory` | 异步先提交执行器再 acquire；许可等待不受 timeoutCallback 限制，该回调未调用。acquire 中断时仍在 finally release，会使许可数不可靠；吞掉 InterruptedException。supplier 同步重载通过 Future.get 等待 | 不作为可靠限流默认方案。业务用可控 Semaphore 和执行器，只有成功 acquire 才 release；权重必须正且不大于总额，业务关闭执行器 |

## 类型与完整签名

- [`com.fairychar.bag.extension.concurrent.AssignableFactory`](../../api/extension-concurrent.md)
