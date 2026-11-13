# com.fairychar.bag.beans.spring.mvc.EraseValue.value

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../EraseValue.java.md)

[Lexical owner](EraseValue.md#symbol-ad5e2ccafe7a86b8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-4d9acd0bbe603386"></a>
## com.fairychar.bag.beans.spring.mvc.EraseValue.value

```java
Class<?>[] value() default {}
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/EraseValue.java:42`; evidence: `declaration-4d9acd0bbe6033861830eb4a9a38078728cdd17c5fecd34229943affe6cd71c6`.
Owner: `com.fairychar.bag.beans.spring.mvc.EraseValue`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
字段和参数都不指定group时匹配；显式group按Class交集匹配，仅一方为空时不匹配。
 只有匹配的标注字段会被抹除，未标注字段保持原值。

 @return {@link Class}<{@link ?}>{@link []}
```
