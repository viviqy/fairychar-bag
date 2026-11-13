# com.fairychar.bag.extension.concurrent.AssignableFactory.doWorkFuture

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AssignableFactory.java.md)

[Lexical owner](AssignableFactory.md#symbol-0413ab1eb7890a91)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5fbb3d3de4e2fc39"></a>
## com.fairychar.bag.extension.concurrent.AssignableFactory.doWorkFuture

```java
public <T> Future<T> doWorkFuture(Supplier<T> supplier, int workers) throws ExecutionException, InterruptedException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/AssignableFactory.java:123`; evidence: `declaration-5fbb3d3de4e2fc39e91815b25a04ff7fdea70935645f77fd72555bcee2e1c903`.
Owner: `com.fairychar.bag.extension.concurrent.AssignableFactory`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
异步执行任务

 @param supplier 任务提供
 @param workers  分配工人数
 @param <T>
 @return {@link Future}
 @throws ExecutionException   {@link ExecutionException}
 @throws InterruptedException {@link InterruptedException}
```
