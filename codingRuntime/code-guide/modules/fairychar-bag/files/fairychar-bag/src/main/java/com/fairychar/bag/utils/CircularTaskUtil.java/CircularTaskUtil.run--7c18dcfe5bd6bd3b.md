# com.fairychar.bag.utils.CircularTaskUtil.run

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../CircularTaskUtil.java.md)

[Lexical owner](CircularTaskUtil.md#symbol-cbb142f118352cac)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9bc2e61e16cab4d5"></a>
## com.fairychar.bag.utils.CircularTaskUtil.run

```java
public static boolean run(Supplier<Boolean> task, boolean condition, int maxRound, int maxMillis)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/CircularTaskUtil.java:36`; evidence: `declaration-9bc2e61e16cab4d58f0579f0f96077649308db7d48503e146901eedce12d792e`.
Owner: `com.fairychar.bag.utils.CircularTaskUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
循环执行任务,当匹配条件相等,或者超过最大循环次数或超过最大执行时间时退出

 @param task      执行任务
 @param condition 成功条件
 @param maxRound  最大循环次数(0为无限)
 @param maxMillis 最大执行时间,无法根据时间打断supplier方法体,仅在下一次重新循环时计算时间(单位毫秒)(0为无限)
 @return True为执行成功, false为失败
```
