# com.fairychar.bag.domain.validator.rest.FileSize

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FileSize.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-89c2864f9e0eece2"></a>
## com.fairychar.bag.domain.validator.rest.FileSize

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileSizeValidator.class)
public @interface FileSize
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/FileSize.java:20`; evidence: `declaration-89c2864f9e0eece21854c7606e66b223b08818d5447159fe91a500bf09da2cd9`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
文件大小校验

 @author chiyo
 @since 1.3.2
```


## Members

- [message](FileSize.message.md#symbol-8b52e7db243519bc) — `function`, source line 25
- [unit](FileSize.unit--83e97cd56b53e54a.md#symbol-ac6ddec0d75499f4) — `function`, source line 32
- [min](FileSize.min.md#symbol-8721853b7ee32fa3) — `function`, source line 39
- [max](FileSize.max.md#symbol-3bce6229af138f71) — `function`, source line 46
- [groups](FileSize.groups.md#symbol-5a572ef653784e9a) — `function`, source line 48
- [payload](FileSize.payload.md#symbol-1c6fb20292ecdf5f) — `function`, source line 50
- [Unit](FileSize.Unit--afa890cce0ff50d2.md#symbol-fd84cfa15ad74031) — `enum`, source line 52
