# com.fairychar.bag.domain.validator.rest.TimeValidator

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../TimeValidator.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9e416a10427d2d44"></a>
## com.fairychar.bag.domain.validator.rest.TimeValidator

```java
public class TimeValidator implements ConstraintValidator<TimeBetween, String>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/TimeValidator.java:16`; evidence: `declaration-9e416a10427d2d44873bd96ab64fec5347b0abc87a397bb6669e48e99704b690`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
时间范围校验器

 @author chiyo
 @since 1.3.2
```


## Fields

<a id="symbol-fee3448fdd28861a"></a>
### pattern

```java
private String pattern
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/TimeValidator.java:18`; evidence: `declaration-fee3448fdd28861ac1db5fa4cf2ef26eea1034ee6a7e4f4ff55607a08bc18d26`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-fc87cd18e5db5d74"></a>
### min

```java
private String min
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/TimeValidator.java:19`; evidence: `declaration-fc87cd18e5db5d746047981a1d157165197947a67bc8f0efca8482f18e9276bd`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-d1d3ee8ed93844f3"></a>
### max

```java
private String max
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/TimeValidator.java:20`; evidence: `declaration-d1d3ee8ed93844f3825c6392ec468801ce254f3ed5b0dafce8081b837b8d5c69`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-d948274af435d8e4"></a>
### NOW

```java
private static final String NOW = "now"
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/TimeValidator.java:22`; evidence: `declaration-d948274af435d8e473dd2539ace82d636083e65b02b2ab1bc16b3a7f986d3aac`.
Visibility: `private` (explicit).
Type: `String`.

## Members

- [initialize](TimeValidator.initialize.md#symbol-a52ace4f87e4ceed) — `function`, source line 24
- [isValid](TimeValidator.isValid.md#symbol-76bb878bac68c88d) — `function`, source line 32
