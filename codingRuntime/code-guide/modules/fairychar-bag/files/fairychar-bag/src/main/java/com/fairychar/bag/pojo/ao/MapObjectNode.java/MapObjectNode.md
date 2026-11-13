# com.fairychar.bag.pojo.ao.MapObjectNode

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MapObjectNode.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-a7a43601af2609c1"></a>
## com.fairychar.bag.pojo.ao.MapObjectNode

```java
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class MapObjectNode<T>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MapObjectNode.java:17`; evidence: `declaration-a7a43601af2609c14617e847b311a6df4416f04e0978f00daf62b01a067d375b`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
http前端树形父子接口渲染类

 @author chiyo
 @since 0.0.1
```


## Fields

<a id="symbol-3f0c997f7d9f55f2"></a>
### name

```java
private String name
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MapObjectNode.java:22`; evidence: `declaration-3f0c997f7d9f55f2f1c43fbb1187014fe50e87b514415bb4c80e053c422e5f0a`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-7cc1cd85487af318"></a>
### count

```java
private long count
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MapObjectNode.java:23`; evidence: `declaration-7cc1cd85487af3180182a32ada5cd8a5cabbcc4d7906eafb0875c0d81acb3b3b`.
Visibility: `private` (explicit).
Type: `long`.
No initializer recorded.

<a id="symbol-69434b91da0ffffb"></a>
### value

```java
@JsonInclude(JsonInclude.Include.NON_NULL)
private List<T> value
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MapObjectNode.java:24`; evidence: `declaration-69434b91da0ffffb61f127df8114636d25bdedb557a9c41a11d3c97f6fe34a57`.
Visibility: `private` (explicit).
Type: `List<T>`.
No initializer recorded.

<a id="symbol-5f976c0af0e66cd0"></a>
### child

```java
@JsonInclude(JsonInclude.Include.NON_NULL)
private List<MapObjectNode<T>> child
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/MapObjectNode.java:26`; evidence: `declaration-5f976c0af0e66cd0ca763c09aac60cb1c763cd8b29a1a84d9c013086d1b7d606`.
Visibility: `private` (explicit).
Type: `List<MapObjectNode<T>>`.
No initializer recorded.
