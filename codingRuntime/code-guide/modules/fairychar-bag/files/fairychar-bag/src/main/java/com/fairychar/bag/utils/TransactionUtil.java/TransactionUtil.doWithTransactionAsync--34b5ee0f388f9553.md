# com.fairychar.bag.utils.TransactionUtil.doWithTransactionAsync

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../TransactionUtil.java.md)

[Lexical owner](TransactionUtil.md#symbol-79742a5e717c49e8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-fef90c2a18d86071"></a>
## com.fairychar.bag.utils.TransactionUtil.doWithTransactionAsync

```java
public static Future<?> doWithTransactionAsync(Action action, AtomicBoolean isAllSuccess, CyclicBarrier cyclicBarrier
            , ExecutorService executor, TransactionTemplate transactionTemplate, int timeoutSeconds)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/TransactionUtil.java:28`; evidence: `declaration-fef90c2a18d86071552a9abcf10dedf95dfcd10469000fc2b9bccfe782dc0043`.
Owner: `com.fairychar.bag.utils.TransactionUtil`; visibility: `public` (explicit).
