# com.fairychar.bag.domain.annotations.RequestLog

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RequestLog.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-311b4354c281fd68"></a>
## com.fairychar.bag.domain.annotations.RequestLog

```java
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RequestLog
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/annotations/RequestLog.java:11`; evidence: `declaration-311b4354c281fd6875e03aea2d614d61e0e8e430c96a608b2227abb60c741d3e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>接口请求日志拦截</p>

 @author chiyo
 @since 0.0.1-SNAPSHOT
```


## Members

- [enable](RequestLog.enable.md#symbol-8abf3790fb51dee2) — `function`, source line 17
- [loggingLevel](RequestLog.loggingLevel.md#symbol-0e0ddc52b80ed16f) — `function`, source line 22
- [beforeHandler](RequestLog.beforeHandler.md#symbol-933598acd9aa0dd4) — `function`, source line 29
- [afterHandler](RequestLog.afterHandler.md#symbol-954183cf2748627e) — `function`, source line 36
- [Level](RequestLog.Level.md#symbol-9ade329bff367b91) — `enum`, source line 39
