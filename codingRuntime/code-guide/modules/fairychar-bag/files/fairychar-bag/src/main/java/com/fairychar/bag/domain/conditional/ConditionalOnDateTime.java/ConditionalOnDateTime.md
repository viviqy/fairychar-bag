# com.fairychar.bag.domain.conditional.ConditionalOnDateTime

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ConditionalOnDateTime.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8fbadcaa54ed7e2a"></a>
## com.fairychar.bag.domain.conditional.ConditionalOnDateTime

```java
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(OnDateTimeCondition.class)
public @interface ConditionalOnDateTime
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/conditional/ConditionalOnDateTime.java:12`; evidence: `declaration-8fbadcaa54ed7e2ad7193035e0e289037d1e3156cffb86e3e6da6fa511bc7c5f`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于时间的Bean条件判断器,仅当当前时间在区间内的情况下Bean才会初始化

 @author chiyo
```


## Members

- [lower](ConditionalOnDateTime.lower.md#symbol-b9399e903233ead3) — `function`, source line 22
- [upper](ConditionalOnDateTime.upper.md#symbol-4ad47d90e08dc0d9) — `function`, source line 29
- [pattern](ConditionalOnDateTime.pattern.md#symbol-560304b4dd594b6c) — `function`, source line 36
