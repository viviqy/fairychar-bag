# com.fairychar.bag.utils.RedisLockUtil.lock

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RedisLockUtil.java.md)

[Lexical owner](RedisLockUtil.md#symbol-bcdef019e661f466)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-bc3149eed8ecee12"></a>
## com.fairychar.bag.utils.RedisLockUtil.lock

```java
public static void lock(RLock lock, Action checkIsPresent, Action action, int time, TimeUnit timeUnit)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/RedisLockUtil.java:23`; evidence: `declaration-bc3149eed8ecee129f0a44ed9836b87bc3c40351ea26bd5f6796af30d5e4d814`.
Owner: `com.fairychar.bag.utils.RedisLockUtil`; visibility: `public` (explicit).
