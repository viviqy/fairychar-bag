# com.fairychar.bag.utils.ReflectUtil.recursiveSearch

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-469a3e950a056c55"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearch

```java
public static <T, I> void recursiveSearch(List<T> source, List<T> ref, String idFiled
            , String pidFiled, I idValue)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:180`; evidence: `declaration-469a3e950a056c55ec298b4caa4d27ac16935b05e644e7f0d3740ac320fac764`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归查询指定id的所有子项/父项

 @param source   源数据
 @param ref      out list
 @param idFiled  代表id的字段名称
 @param pidFiled 代表pid的字段名称;
 @param idValue  id值
 @param <T>      数据类型
 @param <I>      id类型
 @throws NoSuchFieldException
 @throws IllegalAccessException
```
