# com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ff36729b6eaf6e25"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent

```java
public static <T, I> List<T> recursiveSearchParent(String pidField, I idValue, Function<List<I>, List<T>> parentSearchSupplier)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:88`; evidence: `declaration-ff36729b6eaf6e255971360391a56b74481381e5fc72789aabcf4b122373b32a`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归搜索父项

 @param idValue              PID 值
 @param pidField             id 字段
 @param parentSearchSupplier 父项搜索供应商
 @return {@link List }<{@link T }>
```
