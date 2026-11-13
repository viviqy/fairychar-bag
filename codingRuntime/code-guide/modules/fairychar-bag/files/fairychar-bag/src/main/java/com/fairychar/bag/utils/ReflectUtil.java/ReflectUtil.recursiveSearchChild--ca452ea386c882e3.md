# com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

[Lexical owner](ReflectUtil.md#symbol-48aef98147402949)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-1bf16700b8f80130"></a>
## com.fairychar.bag.utils.ReflectUtil.recursiveSearchChild

```java
public static <T, P> List<T> recursiveSearchChild(String idField, P pidValue, Function<List<P>, List<T>> childSearchSupplier)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:135`; evidence: `declaration-1bf16700b8f80130c8eaaa56174e026b7fac4881e03922978397b4d1743326fd`.
Owner: `com.fairychar.bag.utils.ReflectUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
递归搜索子项
 <pre>
     {@code
         List<Relation> datas = List.of(
                 new Relation(1, 0),
                 new Relation(2, 1),
                 new Relation(3, 1),
                 new Relation(4, 2),
                 new Relation(5, 2),
                 new Relation(6, 3),
                 new Relation(7, 6),
                 new Relation(8, 7)
         );
         List<Relation> r1s = ReflectUtil.recursiveSearchChild("id", 1, ids -> {
             List<Relation> list = datas.stream().filter(s -> ids.contains(s.getPid())).toList();
             return list;
         });
     }
 </pre>

 @param pidValue            PID 值
 @param idField             id 字段
 @param childSearchSupplier 子项搜索供应商
 @return {@link List }<{@link T }>
```
