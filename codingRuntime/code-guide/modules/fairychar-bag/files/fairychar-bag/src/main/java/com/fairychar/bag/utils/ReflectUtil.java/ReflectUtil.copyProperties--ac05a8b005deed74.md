# com.fairychar.bag.utils.ReflectUtil.copyProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-2df9f1133652cff5"></a>
## com.fairychar.bag.utils.ReflectUtil.copyProperties

```java
public static <T> T copyProperties(Object source, Class<T> tClass, boolean matchNull)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:476`; evidence: `declaration-2df9f1133652cff5d3497f5b371b90b4d6bbf78926f0dfefbaa0b04d07af09ae`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
复制属性,此方法会调用目标对象的无参构造函数,要保证有此方法

 @param source    源对象
 @param tClass    目标对象class
 @param matchNull 是否copy null值的字段
```
