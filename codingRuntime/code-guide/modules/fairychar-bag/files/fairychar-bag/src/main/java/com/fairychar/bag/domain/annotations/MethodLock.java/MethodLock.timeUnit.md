# com.fairychar.bag.domain.annotations.MethodLock.timeUnit

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MethodLock.java.md)

[Lexical owner](MethodLock.md#symbol-ebf8ee2b07d94f0d)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-58fe1370e6e9ae01"></a>
## com.fairychar.bag.domain.annotations.MethodLock.timeUnit

```java
TimeUnit timeUnit() default TimeUnit.NANOSECONDS
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/annotations/MethodLock.java:51`; evidence: `declaration-58fe1370e6e9ae01ef4a913c917130aa23fe4421475fb2681e898b439dc43bd9`.
Owner: `com.fairychar.bag.domain.annotations.MethodLock`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
仅在乐观锁或分布式锁情况下使用,TimeUnit.NANOSECONDS为使用全局默认(应该不会有纳秒锁的业务)

 @return {@link TimeUnit}
```
