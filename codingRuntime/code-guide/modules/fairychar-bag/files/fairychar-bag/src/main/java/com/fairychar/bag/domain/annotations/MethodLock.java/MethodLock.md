# com.fairychar.bag.domain.annotations.MethodLock

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MethodLock.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ebf8ee2b07d94f0d"></a>
## com.fairychar.bag.domain.annotations.MethodLock

```java
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodLock
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/annotations/MethodLock.java:12`; evidence: `declaration-ebf8ee2b07d94f0da9b5b7a1936c475ac55f36f685bfceab3275c970b9306db8`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2020/6/2 10:37

 @author chiyo
 @since 1.0
```


## Members

- [lockType](MethodLock.lockType.md#symbol-7f2cfdbfa2c0e8b0) — `function`, source line 23
- [enable](MethodLock.enable.md#symbol-f9344a6ae5d07e7d) — `function`, source line 30
- [timeout](MethodLock.timeout.md#symbol-d65c978605828466) — `function`, source line 37
- [optimistic](MethodLock.optimistic.md#symbol-4b3c1e1e452b2fa4) — `function`, source line 44
- [timeUnit](MethodLock.timeUnit.md#symbol-58fe1370e6e9ae01) — `function`, source line 51
- [nameExpression](MethodLock.nameExpression.md#symbol-17430c4d8d6cff9f) — `function`, source line 58
- [distributedPrefix](MethodLock.distributedPrefix.md#symbol-de7716d7a75e4095) — `function`, source line 66
- [Type](MethodLock.Type.md#symbol-2712794f733f61b0) — `enum`, source line 68
