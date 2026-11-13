# com.fairychar.bag.utils.CollectionUtil.splitList

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../CollectionUtil.java.md)

[Lexical owner](CollectionUtil.md#symbol-d03551b7bef6b891)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-29c39a5049266805"></a>
## com.fairychar.bag.utils.CollectionUtil.splitList

```java
public static <T> List<List<T>> splitList(List<T> originalList, int numberOfParts)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/CollectionUtil.java:20`; evidence: `declaration-29c39a504926680518a4d9e4123c09272d528bab17187d33810f1f2657059a0d`.
Owner: `com.fairychar.bag.utils.CollectionUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
将一个 List 尽量平均分成指定份数

 @param originalList  原始列表
 @param numberOfParts 指定数量
 @return {@link List }<{@link List }<{@link T }>>
```
