# com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f8bcc455eaa0e67d"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild

```java
public static <T, P> List<T> recursiveSearchChild(String idField, List<P> pidValues, Function<List<P>, List<T>> childSearchSupplier)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:149`; evidence: `declaration-f8bcc455eaa0e67d5c38dd2bcacc561ff3aa1a31036653a789d02bdc39f05d9a`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归搜索子项

 @param pidValues           PID 值
 @param idField             id 字段
 @param childSearchSupplier 子项搜索供应商
 @return {@link List }<{@link T }>
```
