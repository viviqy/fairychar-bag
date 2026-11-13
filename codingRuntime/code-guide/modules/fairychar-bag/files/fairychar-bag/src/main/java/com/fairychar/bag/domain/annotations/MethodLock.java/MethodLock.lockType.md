# com.fairychar.bag.domain.annotations.MethodLock.lockType

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MethodLock.java.md)

[Lexical owner](MethodLock.md#symbol-ebf8ee2b07d94f0d)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-7f2cfdbfa2c0e8b0"></a>
## com.fairychar.bag.domain.annotations.MethodLock.lockType

```java
Type lockType() default Type.DEFAULT
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/annotations/MethodLock.java:23`; evidence: `declaration-7f2cfdbfa2c0e8b0d2e672ada43849b8eba2591e74e57aaafb7ce4cee9708f42`.
Owner: `com.fairychar.bag.domain.annotations.MethodLock`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
<p>使用锁类型local=本地锁,redis=redis分布式锁,ZK=zookeeper分布式锁</p>
 默认为DEFAULT,如果为DEFAULT代表使用全局设置

 @return {@link Type}
```
