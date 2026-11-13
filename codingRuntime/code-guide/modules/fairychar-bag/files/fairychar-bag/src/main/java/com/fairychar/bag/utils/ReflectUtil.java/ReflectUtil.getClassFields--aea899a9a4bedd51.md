# com.fairychar.bag.utils.ReflectUtil.getClassFields

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-4179a1bd282bb1be"></a>
## com.fairychar.bag.utils.ReflectUtil.getClassFields

```java
public static Set<Field> getClassFields(Class<?> clazz, boolean getParent, boolean getStatic, boolean getFinal)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:429`; evidence: `declaration-4179a1bd282bb1beda00858e13413b080e25a02edf7182de98b37ab1a86f7815`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
获取类的字段

 @param clazz     类类型
 @param getParent 是否获取获取父类字段
 @param getStatic 是否获取静态字段
 @param getFinal  是否获得final字段
 @return {@link Set }<{@link Field }>
```
