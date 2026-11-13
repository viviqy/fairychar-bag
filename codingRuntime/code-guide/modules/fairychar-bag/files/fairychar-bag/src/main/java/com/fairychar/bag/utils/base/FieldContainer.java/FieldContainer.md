# com.fairychar.bag.utils.base.FieldContainer

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FieldContainer.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-fcc91a976eef1090"></a>
## com.fairychar.bag.utils.base.FieldContainer

```java
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class FieldContainer
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/base/FieldContainer.java:17`; evidence: `declaration-fcc91a976eef109060af91abada0eeca28199db7ef5a000065b9bbc65bd988db`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>Field容器</p>
 包含Field与其对应Object

 @author chiyo
 @since 1.0.2
```


## Fields

<a id="symbol-28419237724d2e80"></a>
### targetObject

```java
private Object targetObject
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/base/FieldContainer.java:26`; evidence: `declaration-28419237724d2e80fe4d7c56db47fb203ead9dc7dbd416500e8f2d5ff83625ed`.
Visibility: `private` (explicit).
Type: `Object`.
No initializer recorded.

Source docstring (unreviewed):
```text
目标对象
```


<a id="symbol-8f06cbeea4a11430"></a>
### field

```java
private Field field
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/base/FieldContainer.java:30`; evidence: `declaration-8f06cbeea4a11430e76276f15c8f28554565521bf9ace5b38bc74d290bdaa74c`.
Visibility: `private` (explicit).
Type: `Field`.
No initializer recorded.

Source docstring (unreviewed):
```text
字段
```


<a id="symbol-38007823e9db6b0c"></a>
### path

```java
private String path
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/base/FieldContainer.java:35`; evidence: `declaration-38007823e9db6b0c5d561d39c05fc9d6489e095e978cd0985de04ed753362d56`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字段全路径,如A.b.c.name
```
