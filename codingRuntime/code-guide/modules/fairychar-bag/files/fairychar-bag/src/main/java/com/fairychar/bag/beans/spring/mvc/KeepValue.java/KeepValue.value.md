# com.fairychar.bag.beans.spring.mvc.KeepValue.value

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../KeepValue.java.md)

[Lexical owner](KeepValue.md#symbol-892edb387046cbc8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-903f07142fcd2ed9"></a>
## com.fairychar.bag.beans.spring.mvc.KeepValue.value

```java
Class<?>[] value() default {}
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/KeepValue.java:43`; evidence: `declaration-903f07142fcd2ed9444889d54029d6bd305c2bc5b00851f0bc944c9a9211b116`.
Owner: `com.fairychar.bag.beans.spring.mvc.KeepValue`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
字段和参数都不指定group时匹配；显式group按Class交集匹配，仅一方为空时不匹配。
 只有匹配的标注字段会被保留，未标注字段和group不匹配的字段均抹除。

 @return {@link Class}<{@link ?}>{@link []}
```
