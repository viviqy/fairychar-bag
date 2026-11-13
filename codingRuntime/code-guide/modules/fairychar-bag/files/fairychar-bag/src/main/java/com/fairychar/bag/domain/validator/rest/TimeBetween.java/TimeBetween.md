# com.fairychar.bag.domain.validator.rest.TimeBetween

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../TimeBetween.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-2fdcd48c86101630"></a>
## com.fairychar.bag.domain.validator.rest.TimeBetween

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeValidator.class)
public @interface TimeBetween
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/TimeBetween.java:18`; evidence: `declaration-2fdcd48c861016304fdea56f768e22eca0e9f0cc5375ec0522b400ef691fc285`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
日期范围校验

 @author chiyo
 @since 1.3.2
```


## Members

- [message](TimeBetween.message.md#symbol-e24a45344f540c51) — `function`, source line 23
- [pattern](TimeBetween.pattern.md#symbol-d1a3ed3aa4c94d2d) — `function`, source line 31
- [min](TimeBetween.min.md#symbol-0a36b5af91d9d7d8) — `function`, source line 38
- [max](TimeBetween.max.md#symbol-a18cd9bfa6eae688) — `function`, source line 45
- [groups](TimeBetween.groups.md#symbol-440448110c7ea66d) — `function`, source line 47
- [payload](TimeBetween.payload.md#symbol-2cc6ed93d50223c4) — `function`, source line 49
