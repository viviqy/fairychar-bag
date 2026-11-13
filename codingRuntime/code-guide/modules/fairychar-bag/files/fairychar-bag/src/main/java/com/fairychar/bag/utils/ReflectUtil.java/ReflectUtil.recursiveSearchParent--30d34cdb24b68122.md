# com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5aa1397c492a690c"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent

```java
public static <T, I> List<T> recursiveSearchParent(String pidField, List<I> idValues, Function<List<I>, List<T>> parentSearchSupplier)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:103`; evidence: `declaration-5aa1397c492a690cf1770765cf1e37b83c43b1fc5a9158b25ccd7f51bde1b0be`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归搜索父项

 @param idValues             ID 值
 @param pidField             pid 字段
 @param parentSearchSupplier 父项搜索供应商
 @return {@link List }<{@link T }>
```
