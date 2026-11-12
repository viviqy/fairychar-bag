# 循环轮询

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## CircularTaskUtil

位置: `com.fairychar.bag.utils.CircularTaskUtil`

```java
boolean ok = CircularTaskUtil.run(
        () -> remoteService.isReady(),
        true,
        100,
        5_000
);
```

参数:

- `task`: 每轮执行的 `Supplier<Boolean>`。
- `condition`: 期望结果。
- `maxRound`: 轮次限制参数，0 表示无限；正值 N 不等于最多执行 N 次，实际边界如下。
- `maxMillis`: 最大耗时毫秒，0 表示无限。

注意: 无法中断正在执行的 supplier，只在下一轮循环前检查超时。

maxRound=N>0 时实际可调用 N+1 次，无等待间隔；不作为精确重试次数或总超时方案，替代方案见本页限制部分。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `CircularTaskUtil.run` | task Boolean 非 null，异常直接传播；无间隔轮询。maxRound=N>0 且一直不匹配时实际可调用 N+1 次；0 为无界。maxMillis 仅轮前检查，不能打断 supplier；负数限制抛 IllegalArgumentException | 不作为有准确次数/总超时的通用重试；业务采用显式次数、退避和 deadline；不在请求线程无界循环 |

## 类型与完整签名

- [`com.fairychar.bag.utils.CircularTaskUtil`](../../api/utils--circulartaskutil.md)
