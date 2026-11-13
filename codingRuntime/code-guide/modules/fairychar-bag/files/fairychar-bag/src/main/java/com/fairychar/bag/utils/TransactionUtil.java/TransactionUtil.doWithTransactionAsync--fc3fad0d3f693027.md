# com.fairychar.bag.utils.TransactionUtil.doWithTransactionAsync

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../TransactionUtil.java.md)

[Lexical owner](TransactionUtil.md#symbol-79742a5e717c49e8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8f0c1dc2605f4592"></a>
## com.fairychar.bag.utils.TransactionUtil.doWithTransactionAsync

```java
public static Future<?> doWithTransactionAsync(Action action, AtomicBoolean isAllSuccess, CyclicBarrier cyclicBarrier
            , ExecutorService executor, TransactionTemplate transactionTemplate)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/TransactionUtil.java:23`; evidence: `declaration-8f0c1dc2605f4592eb3220142de974b1d81270208f7fcfaa4bb1d5b573a10e83`.
Owner: `com.fairychar.bag.utils.TransactionUtil`; visibility: `public` (explicit).
