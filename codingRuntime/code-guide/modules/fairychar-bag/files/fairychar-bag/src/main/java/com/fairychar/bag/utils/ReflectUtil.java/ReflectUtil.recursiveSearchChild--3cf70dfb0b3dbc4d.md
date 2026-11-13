# com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3619067e19d2763d"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild

```java
public static <T, I> List<T> recursiveSearchChild(List<T> source, String idField
            , String pidField, I idValue)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:72`; evidence: `declaration-3619067e19d2763db4a6f68fc02d55f904233a9c8bbd89dc1e2d8de028f56d92`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归查询指定id的所有子项

 @param source   源数据
 @param idField  代表id的字段名称
 @param pidField 代表pid的字段名称
 @param idValue  id值
 @param <T>      数据类型
 @param <I>      id类型
```
