# com.fairychar.bag.extension.concurrent.RepeatTaskExecutor.start

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RepeatTaskExecutor.java.md)

[Lexical owner](RepeatTaskExecutor.md#symbol-9484b628c8390536)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-16cdf5fea61bb30a"></a>
## com.fairychar.bag.extension.concurrent.RepeatTaskExecutor.start

```java
public void start(Consumer<InterruptedException> onInterrupted, Consumer<TimeoutException> onTimeout,
                      Consumer<BrokenBarrierException> onBroken, long waitMillis)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RepeatTaskExecutor.java:67`; evidence: `declaration-16cdf5fea61bb30a88f1ae2fc6b76ee98a4d5c8dcd41764b1c1dc5cbef8bda7a`.
Owner: `com.fairychar.bag.extension.concurrent.RepeatTaskExecutor`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
启动任务执行

 @param onInterrupted 当任务被打断时的异常处理
 @param onTimeout     当任务超时时的异常处理
 @param onBroken      当任务被终止时的异常处理
 @param waitMillis    当前批次中执行完的任务等待未执行完的任务的最长毫秒数(超时会触发{@link BrokenBarrierException})
```
