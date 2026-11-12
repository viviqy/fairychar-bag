# 任务测试辅助

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## TaskTestUtil

位置: `com.fairychar.bag.utils.test.TaskTestUtil`

用于测试或压测辅助，不建议生产业务依赖。

```java
ExecutorService executor = TaskTestUtil.createThreadPool("demo", 8);
long cost = TaskTestUtil.batchRunSync(() -> service.call(), 100, executor);
TaskTestUtil.concurrentRunAsync(List.of(action1, action2));
```

常用方法:

- `createThreadPool(poolName, size)`
- `createThreadPoolByCpuCore(poolName)`
- `createThreadPoolByCpuCore(poolName, multi)`
- `concurrentRunAsync(actions)`
- `batchRunSync(actions, executor)`
- `batchRunAsync(actions, executor)`
- `getWasteMillis(action, round)`

## 类型与完整签名

- [`com.fairychar.bag.utils.test.TaskTestUtil`](../../api/utils-test.md)
