# com.fairychar.bag.utils.ReflectUtil.recursiveSearchFieldValueByAnnotations

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9d21290c3ec39e78"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearchFieldValueByAnnotations

```java
public static Map<Class<? extends Annotation>, List<FieldContainer>> recursiveSearchFieldValueByAnnotations(Object e
            , Collection<Class<? extends Annotation>> annotations)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:37`; evidence: `declaration-9d21290c3ec39e78ebf9a3e32cd6c8d2586f9731fa00855e2689cfc8c267f88b`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归搜索带有指定注解的字段值
 该代码以对象和注解类的集合作为输入，并返回一个包含注解作为键和字段容器列表作为值的映射。
 字段容器包含有关带有指定注解的字段的信息。
 支持字段为集合类{@link Collection},{@link Map}支持,如果为集合类则会循环解析获取所有集合内对象的字段
```
