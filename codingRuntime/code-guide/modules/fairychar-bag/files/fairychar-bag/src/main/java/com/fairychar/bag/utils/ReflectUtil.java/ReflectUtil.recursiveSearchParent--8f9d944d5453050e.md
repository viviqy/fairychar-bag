# com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-69cf23372d6d4e53"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearchParent

```java
public static <T, I> List<T> recursiveSearchParent(List<T> source, String pidField
            , String idField, I idValue)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:55`; evidence: `declaration-69cf23372d6d4e53ecf9332a1f6820128ed637f32b49176c2355a092761e3887`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归查询指定id的所有子项

 @param source   源数据
 @param pidField 代表id的字段名称
 @param idField  代表pid的字段名称
 @param idValue  id值
 @param <T>      数据类型
 @param <I>      id类型
```
