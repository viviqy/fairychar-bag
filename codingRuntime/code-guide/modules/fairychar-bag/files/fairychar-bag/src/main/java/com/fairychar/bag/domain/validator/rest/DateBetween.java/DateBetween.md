# com.fairychar.bag.domain.validator.rest.DateBetween

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../DateBetween.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-03da94f83726d57e"></a>
## com.fairychar.bag.domain.validator.rest.DateBetween

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface DateBetween
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/DateBetween.java:18`; evidence: `declaration-03da94f83726d57ec95c2b6b8fc1268303b46bd6177e8eb7ae403c5993ad4aac`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
日期范围校验

 @author chiyo
 @since 1.3.2
```


## Members

- [message](DateBetween.message.md#symbol-230cf68dcaaccde2) — `function`, source line 23
- [pattern](DateBetween.pattern.md#symbol-cae36e116b0d9b9e) — `function`, source line 31
- [min](DateBetween.min.md#symbol-206e1182369f0a7c) — `function`, source line 38
- [max](DateBetween.max.md#symbol-23ad6c0e05fec783) — `function`, source line 45
- [groups](DateBetween.groups.md#symbol-394087b0846d8a16) — `function`, source line 47
- [payload](DateBetween.payload.md#symbol-9cc542ff855d7a48) — `function`, source line 49
