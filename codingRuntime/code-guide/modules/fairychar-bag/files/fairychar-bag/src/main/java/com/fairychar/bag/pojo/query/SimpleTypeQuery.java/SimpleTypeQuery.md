# com.fairychar.bag.pojo.query.SimpleTypeQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SimpleTypeQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ddaf86efe53c5778"></a>
## com.fairychar.bag.pojo.query.SimpleTypeQuery

```java
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class SimpleTypeQuery<T> implements Serializable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/query/SimpleTypeQuery.java:18`; evidence: `declaration-ddaf86efe53c5778594b366e6976cd752e5716032782443657efef6a394cb80e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
http泛型参数接收实体(feign下不可用泛型)

 @author chiyo
 @since 0.0.1-SNAPSHOT
```


## Fields

<a id="symbol-4151550077214699"></a>
### value

```java
@NotNull
private T value
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/query/SimpleTypeQuery.java:23`; evidence: `declaration-4151550077214699eded8b9d1915b29a0a96a78b6deb83dd68540d904665e774`.
Visibility: `private` (explicit).
Type: `T`.
No initializer recorded.
