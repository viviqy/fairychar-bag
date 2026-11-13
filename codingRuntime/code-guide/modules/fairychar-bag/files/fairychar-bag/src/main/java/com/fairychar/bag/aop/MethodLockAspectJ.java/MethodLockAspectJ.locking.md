# com.fairychar.bag.aop.MethodLockAspectJ.locking

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MethodLockAspectJ.java.md)

[Lexical owner](MethodLockAspectJ.md#symbol-d5c300d3c2da2fab)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3cc30b8f49912431"></a>
## com.fairychar.bag.aop.MethodLockAspectJ.locking

```java
@Around("@annotation(methodLock)")
    public Object locking(JoinPoint joinPoint, MethodLock methodLock) throws Throwable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/MethodLockAspectJ.java:66`; evidence: `declaration-3cc30b8f4991243184371fcb6d492125cf35338b9cd45945153b1fce5bc2c7df`.
Owner: `com.fairychar.bag.aop.MethodLockAspectJ`; visibility: `public` (explicit).
