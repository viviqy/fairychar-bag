# com.fairychar.bag.utils.ReflectUtil.compareAndSwapLong

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-348289234fa74b7d"></a>
## com.fairychar.bag.utils.ReflectUtil.compareAndSwapLong

```java
public static void compareAndSwapLong(Long a, Long b)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:321`; evidence: `declaration-348289234fa74b7dc772e3efcc03f2aa0e38f120809953ed852e2db6e2244456`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
通过unsafe交换Long a和Long b的值,使用时需要注意a,b没有被其他线程修改
 否则可能出现某个成功或者全部失败

 @param a a
 @param b b
```
