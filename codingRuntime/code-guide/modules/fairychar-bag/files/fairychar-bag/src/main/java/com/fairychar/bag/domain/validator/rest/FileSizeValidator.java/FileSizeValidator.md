# com.fairychar.bag.domain.validator.rest.FileSizeValidator

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FileSizeValidator.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3b532a52b7d001d9"></a>
## com.fairychar.bag.domain.validator.rest.FileSizeValidator

```java
public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/FileSizeValidator.java:14`; evidence: `declaration-3b532a52b7d001d9abe40193fcbfd1f480c6758b0241e0f540ec2d0dc89d73c7`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
文件大小范围校验器

 @author chiyo
 @since 1.3.2
```


## Fields

<a id="symbol-66a12cb9326379b5"></a>
### unit

```java
private FileSize.Unit unit
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/FileSizeValidator.java:16`; evidence: `declaration-66a12cb9326379b567cb536bb39b85b6a67850dcdf8eb16f20a44ccbf6d3ea8c`.
Visibility: `private` (explicit).
Type: `FileSize.Unit`.
No initializer recorded.

<a id="symbol-f5d7fa14d91f0cbc"></a>
### min

```java
private long min
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/FileSizeValidator.java:17`; evidence: `declaration-f5d7fa14d91f0cbcf88aec64aa550f4a864e41e023042157f419d218d405b551`.
Visibility: `private` (explicit).
Type: `long`.
No initializer recorded.

<a id="symbol-19c16ccd1ab1b85f"></a>
### max

```java
private long max
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/FileSizeValidator.java:18`; evidence: `declaration-19c16ccd1ab1b85f6408abad9601ab3ecd44a28c627be094525eee88b218a2ef`.
Visibility: `private` (explicit).
Type: `long`.
No initializer recorded.

## Members

- [initialize](FileSizeValidator.initialize.md#symbol-49555a3ba897bd2a) — `function`, source line 21
- [isValid](FileSizeValidator.isValid.md#symbol-c479d101bedb8cdb) — `function`, source line 29
