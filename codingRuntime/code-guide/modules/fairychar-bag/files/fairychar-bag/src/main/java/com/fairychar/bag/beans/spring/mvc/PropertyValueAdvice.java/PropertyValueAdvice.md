# com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../PropertyValueAdvice.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-dd99889bcca1ee3c"></a>
## com.fairychar.bag.beans.spring.mvc.PropertyValueAdvice

```java
@Slf4j
@AllArgsConstructor
public abstract class PropertyValueAdvice<T extends Annotation> extends RequestBodyAdviceAdapter
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/PropertyValueAdvice.java:22`; evidence: `declaration-dd99889bcca1ee3c9adda41935234dcec5ac8d24c7bb1162c8434f1badee25e5`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
http请求体property代理解析器

 @author chiyo
 @since 1.0.2
```


## Fields

<a id="symbol-889c35f32f9bcab0"></a>
### annotation

```java
protected Class<T> annotation
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/PropertyValueAdvice.java:27`; evidence: `declaration-889c35f32f9bcab0dc24479545846978442cc210fda4b2d37e8ad9d13b956760`.
Visibility: `protected` (explicit).
Type: `Class<T>`.
No initializer recorded.

## Members

- [supports](PropertyValueAdvice.supports.md#symbol-6171ac17a8e2cd9a) — `function`, source line 29
- [afterBodyRead](PropertyValueAdvice.afterBodyRead.md#symbol-7f0075cbc1d6df61) — `function`, source line 34
- [handle](PropertyValueAdvice.handle.md#symbol-4fa93dcedc4d5f24) — `function`, source line 53
- [handleUnannotatedField](PropertyValueAdvice.handleUnannotatedField.md#symbol-90348d0852e2fbbd) — `function`, source line 55
- [matchesGroups](PropertyValueAdvice.matchesGroups.md#symbol-92dfc31fdf0202b5) — `function`, source line 58
- [eraseValue](PropertyValueAdvice.eraseValue.md#symbol-d0f1b77c1a8f3277) — `function`, source line 73
