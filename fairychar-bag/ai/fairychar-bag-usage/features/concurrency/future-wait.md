# Future 顺序等待

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## ConcurrentUtil

位置: `com.fairychar.bag.utils.ConcurrentUtil`

```java
ConcurrentUtil.getFutures(futures);
```

逐个 `Future.get()`:

- `InterruptedException`: 恢复中断标记并抛 `FBException`。
- `ExecutionException`: 抛 `FBException`。

## 输入、效果与失败契约

**前置与输入**：非 null Future 列表且元素非 null，任务已由业务提交；调用线程允许阻塞，不在 Netty event loop 等不可阻塞线程调用。

**效果与返回**：按列表顺序调用每个 Future.get，全部成功时返回 void，丢弃结果。某个 Future 很慢会阻塞后续结果读取；没有整体超时，不负责提交或调度。

**失败**：任务 ExecutionException 包装成 `FBException`；等待 InterruptedException 时恢复调用线程中断标记再抛 `FBException`。已取消任务的 CancellationException 直接传播。遇第一个异常就返回异常，不再逐个等待，也不取消剩余任务。

**副作用与资源**：不关闭线程池，不撤销成功任务的副作用，不提供事务一致性。业务负责取消、清理、deadline 和线程池关闭；需要结果或总超时时优先业务自己按 deadline 等待。

**输入 → 输出**：两个已成功的 Future → void；第一个失败、第二个未完成 → 立即抛 FBException，第二个仍继续执行。

## 类型与完整签名

- [`com.fairychar.bag.utils.ConcurrentUtil`](../../api/utils--concurrentutil.md)
