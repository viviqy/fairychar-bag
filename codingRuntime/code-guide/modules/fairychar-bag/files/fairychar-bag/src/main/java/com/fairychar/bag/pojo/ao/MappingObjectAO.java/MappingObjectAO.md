# com.fairychar.bag.pojo.ao.MappingObjectAO

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MappingObjectAO.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-6f27163b3189c226"></a>
## com.fairychar.bag.pojo.ao.MappingObjectAO

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "MappingObjectAO", description = "前端Map渲染对象")
public class MappingObjectAO<K, V> implements Serializable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MappingObjectAO.java:19`; evidence: `declaration-6f27163b3189c2269382f5b74e05caf10a3ca5bef7948d07d774b2cf72aaaee9`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
http前端响应树接口AO类

 @author chiyo
 @since 0.0.1-SNAPSHOT
```


## Fields

<a id="symbol-378278bb3be17e74"></a>
### key

```java
private K key
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MappingObjectAO.java:25`; evidence: `declaration-378278bb3be17e74cb1c59fc5d01f426069af7a0a24783e2544568d846037514`.
Visibility: `private` (explicit).
Type: `K`.
No initializer recorded.

<a id="symbol-f1f1d99dd07da344"></a>
### count

```java
private long count
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MappingObjectAO.java:26`; evidence: `declaration-f1f1d99dd07da344a2638af97d0e58d8af512fb7c69a196f451d0b7b4abadd16`.
Visibility: `private` (explicit).
Type: `long`.
No initializer recorded.

<a id="symbol-73daed9b9a5f0d0a"></a>
### values

```java
private List<V> values
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MappingObjectAO.java:27`; evidence: `declaration-73daed9b9a5f0d0a67bf3e5219f3eb27fabc0ea0505ba90938908623b1e3ac23`.
Visibility: `private` (explicit).
Type: `List<V>`.
No initializer recorded.
