# com.fairychar.bag.utils.ReflectUtil.recursiveSearchFieldByAnnotations

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d2332a6b2fc5a89f"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearchFieldByAnnotations

```java
public static Map<Class<? extends Annotation>, List<Field>> recursiveSearchFieldByAnnotations(Class clazz
            , Collection<Class<? extends Annotation>> annotations)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:159`; evidence: `declaration-d2332a6b2fc5a89f07ae1bffe04a640af8035231e88400f7f4148184d4f16920`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归搜索带有指定注解集合的字段。
 它接受一个对象和一个注解类的集合作为输入，并返回一个将每个注解类映射到带有该注解的字段列表的Map。
```
