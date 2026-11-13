# com.fairychar.bag.utils.RedisLockUtil.tryLock

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RedisLockUtil.java.md)

[Lexical owner](RedisLockUtil.md#symbol-bcdef019e661f466)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d13aebb2a8abadd8"></a>
## com.fairychar.bag.utils.RedisLockUtil.tryLock

```java
public static void tryLock(RLock lock, Action beforeSearch, Action searchAgain, Action action, int time, TimeUnit timeUnit)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/RedisLockUtil.java:105`; evidence: `declaration-d13aebb2a8abadd89fd3226717cf751946c5b88ac2b17690f765189df561d3c1`.
Owner: `com.fairychar.bag.utils.RedisLockUtil`; visibility: `public` (explicit).
