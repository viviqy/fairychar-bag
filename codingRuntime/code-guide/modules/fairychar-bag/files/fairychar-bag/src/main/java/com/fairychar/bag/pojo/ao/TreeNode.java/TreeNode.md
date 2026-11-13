# com.fairychar.bag.pojo.ao.TreeNode

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../TreeNode.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-b1e1d21df8acbd58"></a>
## com.fairychar.bag.pojo.ao.TreeNode

```java
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class TreeNode<T> implements Serializable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/TreeNode.java:18`; evidence: `declaration-b1e1d21df8acbd58d522b6abe96c617d4bb32ffba15df6ca456c86a6430876f2`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/12/8 23:39

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-cc8e488769af429b"></a>
### serialVersionUID

```java
private static final long serialVersionUID = 374862911861656958L
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/TreeNode.java:23`; evidence: `declaration-cc8e488769af429b93f1b6e882935003abcd8bcb0c4b09bf4acd599027533f84`.
Visibility: `private` (explicit).
Type: `long`.

<a id="symbol-76166e51e5b2ca7a"></a>
### current

```java
@JsonUnwrapped
private T current
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/TreeNode.java:24`; evidence: `declaration-76166e51e5b2ca7aa328134d0a9dce6ae221d9a59a54702eedd129553ad5aa9a`.
Visibility: `private` (explicit).
Type: `T`.
No initializer recorded.

<a id="symbol-1cf182f7a5f45441"></a>
### child

```java
private List<TreeNode<T>> child
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/ao/TreeNode.java:26`; evidence: `declaration-1cf182f7a5f45441a0bf898ed16cda859ac397b5055bea3aeafd2cbaafc2ccbf`.
Visibility: `private` (explicit).
Type: `List<TreeNode<T>>`.
No initializer recorded.
