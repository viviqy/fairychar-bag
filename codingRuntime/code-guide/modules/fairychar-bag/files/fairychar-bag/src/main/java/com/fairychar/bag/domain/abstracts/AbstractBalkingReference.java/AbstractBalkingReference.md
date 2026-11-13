# com.fairychar.bag.domain.abstracts.AbstractBalkingReference

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AbstractBalkingReference.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-664534c2200f0895"></a>
## com.fairychar.bag.domain.abstracts.AbstractBalkingReference

```java
@Slf4j
public abstract class AbstractBalkingReference<T> implements IBalkingReference<T>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/abstracts/AbstractBalkingReference.java:13`; evidence: `declaration-664534c2200f0895dd89cb695bac5862002312c34dade6308e42f5f0439a6d9e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
任务属性状态追踪

 @author chiyo
```


## Fields

<a id="symbol-18e1766416b8522f"></a>
### isChanged

```java
protected AtomicBoolean isChanged = new AtomicBoolean(true)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/abstracts/AbstractBalkingReference.java:15`; evidence: `declaration-18e1766416b8522fda7feca8ab893fb8b64945457fb765a1f1b9c1a71a1941e2`.
Visibility: `protected` (explicit).
Type: `AtomicBoolean`.

<a id="symbol-c9c71faac683a140"></a>
### t

```java
protected T t
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/abstracts/AbstractBalkingReference.java:16`; evidence: `declaration-c9c71faac683a1405763d8e41f09895af529d3d53305dea04ddabbff0ee630e3`.
Visibility: `protected` (explicit).
Type: `T`.
No initializer recorded.

## Members

- [AbstractBalkingReference](AbstractBalkingReference.AbstractBalkingReference.md#symbol-996dcc527543424d) — `constructor`, source line 18
- [save](AbstractBalkingReference.save.md#symbol-4bda6adacb941a62) — `function`, source line 22
- [change](AbstractBalkingReference.change.md#symbol-d4d8b4b0f2cb3f9e) — `function`, source line 36
- [doSave](AbstractBalkingReference.doSave.md#symbol-adf044996ec09775) — `function`, source line 46
