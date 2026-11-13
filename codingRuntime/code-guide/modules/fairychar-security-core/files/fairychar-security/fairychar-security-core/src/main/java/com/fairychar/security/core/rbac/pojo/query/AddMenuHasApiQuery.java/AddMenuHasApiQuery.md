# com.fairychar.security.core.rbac.pojo.query.AddMenuHasApiQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AddMenuHasApiQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-e11c78af3d5e488e"></a>
## com.fairychar.security.core.rbac.pojo.query.AddMenuHasApiQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddMenuHasApiQuery")
public class AddMenuHasApiQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddMenuHasApiQuery.java:21`; evidence: `declaration-e11c78af3d5e488e180189589ce62a85d40910027f7f9329da894733aa55c441`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(MenuHasApi)表实体类

 @author chiyo
```


## Fields

<a id="symbol-d9c22e84bccabe07"></a>
### menuId

```java
@Schema(description = "\u5173\u8054\u83dc\u5355id")
@NotNull
private Integer menuId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddMenuHasApiQuery.java:33`; evidence: `declaration-d9c22e84bccabe070bc5208a9d2a2b43a5c636aef97bc5fa5db78630c11016ae`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
关联菜单id
```


<a id="symbol-59967201b0465440"></a>
### apiId

```java
@Schema(description = "\u5173\u8054\u63a5\u53e3id")
@NotNull
private Integer apiId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddMenuHasApiQuery.java:39`; evidence: `declaration-59967201b0465440d85e9eaded30195cd8abf4d52e50eeb8e46314091658864f`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
关联接口id
```
