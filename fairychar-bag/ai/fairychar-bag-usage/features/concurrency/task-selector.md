# 定时任务选择器

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## ActionSelectorTemplate

位置: `com.fairychar.bag.template.ActionSelectorTemplate`

轻量定时任务选择器。

```java
ActionSelectorTemplate template = new ActionSelectorTemplate();
template.setTimePause(100);

template.put("refresh-cache", 5_000, () -> refreshCache());
template.put("sync-user", 10_000, new AbstractScheduleAction() {
    @Override
    public void doAction() {
        syncUser();
    }
});

template.start();
```

行为:

- `boss` 单线程轮询任务。
- `worker` 默认大小为 CPU 核心数。
- `period` 单位是毫秒。
- 同一个任务如果上次还在执行，本轮会跳过，不会并发重入。
- `remove(taskName, true)` 会中断该任务当前执行线程。
- `shutdownGracefully()` 和 `shutdownNow()` 用于停止。

注意：`shutdownGracefully()` 与 `shutdownNow()` 都只允许在 `WORKING` 状态调用，未启动或重复停止会抛异常。graceful 路径仅 shutdown boss 而不主动结束无限轮询，也没有等待 worker 完成的过程；不要把它理解为已经等待所有任务退出。`shutdownNow()` 发出线程中断，但仍依赖任务协作响应。严格生命周期场景应先验证资源是否真正退出，或使用业务已有调度器。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `ActionSelectorTemplate` / `ActionSchedule` | 有状态和循环驱动的调度能力，graceful 入口不等于所有任务完成或所有线程结束；不可仅凭 shutdown 方法名断言释放 | 未建立启动、失败、重复停止和终止屏障前不作为业务默认调度设施；采用现有 Spring/业务调度器 |

## 类型与完整签名

- [`com.fairychar.bag.template.ActionSelectorTemplate`](../../api/template.md)
