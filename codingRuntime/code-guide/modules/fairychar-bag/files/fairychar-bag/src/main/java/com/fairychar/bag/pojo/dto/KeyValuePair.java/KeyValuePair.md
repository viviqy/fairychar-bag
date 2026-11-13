# com.fairychar.bag.pojo.dto.KeyValuePair

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../KeyValuePair.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9fd9cc5814a8b161"></a>
## com.fairychar.bag.pojo.dto.KeyValuePair

```java
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(description = "key-value格式数据")
public class KeyValuePair<K, V> implements Serializable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/dto/KeyValuePair.java:17`; evidence: `declaration-9fd9cc5814a8b161464a4635fc39a2f35faffa94b7a20af391cc776d085e5f1d`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
键值对 DTO

 @author chiyo
```


## Fields

<a id="symbol-f766c0480bb0a33d"></a>
### name

```java
private K name
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/dto/KeyValuePair.java:24`; evidence: `declaration-f766c0480bb0a33d8f561e3b34e5c15b6d3ba0f3e9e140a0c415883417b17956`.
Visibility: `private` (explicit).
Type: `K`.
No initializer recorded.

<a id="symbol-edc34b2c4666a366"></a>
### value

```java
private V value
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/dto/KeyValuePair.java:25`; evidence: `declaration-edc34b2c4666a36679798352750423c0b40829561df44d0fdcf3eaa1c950594c`.
Visibility: `private` (explicit).
Type: `V`.
No initializer recorded.
