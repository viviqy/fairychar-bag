# com.fairychar.bag.utils.ReflectUtil.compareAndSwapInteger

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-bd32f0fd0ba85f7f"></a>
## com.fairychar.bag.utils.ReflectUtil.compareAndSwapInteger

```java
public static void compareAndSwapInteger(Integer a, Integer b)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:343`; evidence: `declaration-bd32f0fd0ba85f7f471197f92fba7dc0916f7a700e6f54394ccc30ba129ea134`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
通过unsafe交换Integer a和Integer b的值,使用时需要注意a,b没有被其他线程修改
 否则可能出现某个成功或者全部失败

 @param a a
 @param b b
```
