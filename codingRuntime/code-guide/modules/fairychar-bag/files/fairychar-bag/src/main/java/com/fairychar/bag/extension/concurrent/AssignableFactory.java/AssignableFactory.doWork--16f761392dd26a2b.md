# com.fairychar.bag.extension.concurrent.AssignableFactory.doWork

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AssignableFactory.java.md)

[Lexical owner](AssignableFactory.md#symbol-0413ab1eb7890a91)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ed94050e7142cd90"></a>
## com.fairychar.bag.extension.concurrent.AssignableFactory.doWork

```java
public <T> T doWork(Supplier<T> supplier, int workers) throws ExecutionException, InterruptedException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/AssignableFactory.java:108`; evidence: `declaration-ed94050e7142cd9028aae83f83c9d96e75ff99f1cf0e432c2dc74a0ca6c3280c`.
Owner: `com.fairychar.bag.extension.concurrent.AssignableFactory`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
阻塞方法执行任务,并等待返回结果

 @param supplier 任务提供
 @param workers  分配工人数
 @param <T>      返回泛型
 @return <T> T
 @throws ExecutionException   {@link ExecutionException}
 @throws InterruptedException {@link InterruptedException}
```
