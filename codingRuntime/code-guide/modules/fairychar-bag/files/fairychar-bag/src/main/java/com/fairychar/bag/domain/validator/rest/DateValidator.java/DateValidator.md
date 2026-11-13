# com.fairychar.bag.domain.validator.rest.DateValidator

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../DateValidator.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-7a24e2ab2d03fe9e"></a>
## com.fairychar.bag.domain.validator.rest.DateValidator

```java
public class DateValidator implements ConstraintValidator<DateBetween, String>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/DateValidator.java:16`; evidence: `declaration-7a24e2ab2d03fe9e391a0a842a707cf8da8b3f6a7e8cfe72bd5f7d9c29dc97e1`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
日期范围校验器

 @author chiyo
 @since 1.3.2
```


## Fields

<a id="symbol-a5a22008d8e7dca8"></a>
### pattern

```java
private String pattern
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/DateValidator.java:18`; evidence: `declaration-a5a22008d8e7dca8a0a246124e5da7ba928a85d7e397ea52390c6afbb7d72930`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-5c3301995fa43049"></a>
### min

```java
private String min
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/DateValidator.java:19`; evidence: `declaration-5c3301995fa43049eca69f4a7730c80960ea0f3ea50ad394d109b2cbe953e4b0`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-afbba414100c1f2e"></a>
### max

```java
private String max
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/DateValidator.java:20`; evidence: `declaration-afbba414100c1f2e1e83b3d0c6e77351e9f9162ebd777d646415f8ff5577b698`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-2685250117d7b5a8"></a>
### NOW

```java
private static final String NOW = "now"
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/DateValidator.java:22`; evidence: `declaration-2685250117d7b5a8c6e45a82e8f8404d2c0435916ba7973af1e570c872d54db9`.
Visibility: `private` (explicit).
Type: `String`.

## Members

- [initialize](DateValidator.initialize.md#symbol-3ac7961c7ec03131) — `function`, source line 24
- [isValid](DateValidator.isValid.md#symbol-855e0dc89001430e) — `function`, source line 32
