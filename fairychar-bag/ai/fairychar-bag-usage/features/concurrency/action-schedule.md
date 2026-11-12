# 动作调度器

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## ActionSchedule / AbstractScheduleAction

- `ActionSchedule(taskName, period, action)` 是任务状态载体，period 为毫秒；工作状态和最近提交时间提供 atomic 引用，不是不可变 DTO。
- `ActionSchedule.compareTo` 当前按任务名“相等返回 1、不等返回 0”，不符合常规排序比较契约，不要直接用于有序集合或排序。
- `AbstractScheduleAction.doAction()` 由业务实现；`doAction0()` 包装执行并记录当前线程，供 `interrupt(Thread)` / `interruptAll()` 发中断信号。
- 中断是协作式请求，不保证正在运行的业务任务立即停止；任务需正确响应中断，不能吞掉后继续无限循环。

`RunState` 是这些组件共享的状态枚举：`NONE`、`UN_INITIALIZE`、`STARTING`、`STARTED`、`WORKING`、`STOPPING`、`STOPPED`。不同组件使用的状态子集不同，不能把读到 `STOPPED` 自动等同于所有外部资源已经释放。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `ActionSelectorTemplate` / `ActionSchedule` | 有状态和循环驱动的调度能力，graceful 入口不等于所有任务完成或所有线程结束；不可仅凭 shutdown 方法名断言释放 | 未建立启动、失败、重复停止和终止屏障前不作为业务默认调度设施；采用现有 Spring/业务调度器 |

## 类型与完整签名

- [`com.fairychar.bag.domain.abstracts.AbstractScheduleAction`](../../api/domain-abstracts.md)
- [`com.fairychar.bag.extension.concurrent.ActionSchedule`](../../api/extension-concurrent.md)
