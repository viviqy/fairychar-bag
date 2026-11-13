# com.fairychar.bag.utils.RequestUtil.getAttribute

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RequestUtil.java.md)

[Lexical owner](RequestUtil.md#symbol-d9b74dfb44a5947c)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-0273b35a649fa14e"></a>
## com.fairychar.bag.utils.RequestUtil.getAttribute

```java
public static <T> T getAttribute(String keyName, Class<T> clazz)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/RequestUtil.java:90`; evidence: `declaration-0273b35a649fa14e9340638c04d1321b891a54bc9b4f8e9b6253326ac7c8908b`.
Owner: `com.fairychar.bag.utils.RequestUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
从当前thread的request获取属性

 @param keyName 键名
 @param clazz   clazz
 @return {@link T}
```
