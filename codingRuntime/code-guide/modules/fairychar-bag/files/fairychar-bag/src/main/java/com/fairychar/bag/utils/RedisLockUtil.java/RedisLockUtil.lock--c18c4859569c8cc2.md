# com.fairychar.bag.utils.RedisLockUtil.lock

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RedisLockUtil.java.md)

[Lexical owner](RedisLockUtil.md#symbol-bcdef019e661f466)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-263ce570709a8f63"></a>
## com.fairychar.bag.utils.RedisLockUtil.lock

```java
public static void lock(RLock lock, Action beforeSearch, Action searchAgain, Action action, int time, TimeUnit timeUnit)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/RedisLockUtil.java:55`; evidence: `declaration-263ce570709a8f630705274f081478e568cdf9dd564ba56b7e36d5e3a9c74b7d`.
Owner: `com.fairychar.bag.utils.RedisLockUtil`; visibility: `public` (explicit).
