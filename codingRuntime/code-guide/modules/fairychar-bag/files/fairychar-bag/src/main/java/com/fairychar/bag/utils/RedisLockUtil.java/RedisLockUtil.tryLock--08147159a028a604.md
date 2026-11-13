# com.fairychar.bag.utils.RedisLockUtil.tryLock

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RedisLockUtil.java.md)

[Lexical owner](RedisLockUtil.md#symbol-bcdef019e661f466)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-dd758e7fdd622a8c"></a>
## com.fairychar.bag.utils.RedisLockUtil.tryLock

```java
public static void tryLock(RLock lock, Action checkIsPresent, Action action, int time, TimeUnit timeUnit)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/RedisLockUtil.java:75`; evidence: `declaration-dd758e7fdd622a8c8b964cd73a7b25d1aac0b453ddf798b2507a857cf2d8f4c2`.
Owner: `com.fairychar.bag.utils.RedisLockUtil`; visibility: `public` (explicit).
