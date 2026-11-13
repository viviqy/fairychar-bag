# com.fairychar.security.core.rbac.pojo.query.AddRoleHasMenuQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AddRoleHasMenuQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9498c20ed899455a"></a>
## com.fairychar.security.core.rbac.pojo.query.AddRoleHasMenuQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddRoleHasMenuQuery")
public class AddRoleHasMenuQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddRoleHasMenuQuery.java:21`; evidence: `declaration-9498c20ed899455a7028d9067832b3346abd58cc50ef89264104ad6bcefe9524`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色菜单关联(RoleHasMenu)表实体类

 @author chiyo
```


## Fields

<a id="symbol-aaea64db16dda02a"></a>
### roleId

```java
@Schema(description = "\u89d2\u8272id")
@NotNull
private Integer roleId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddRoleHasMenuQuery.java:32`; evidence: `declaration-aaea64db16dda02a69bafb6ef378c6224b45dc34bc279adcc116eff618ab1ca3`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色id
```


<a id="symbol-78f1c6aa2b1a7bef"></a>
### menuId

```java
@Schema(description = "\u83dc\u5355id")
@NotNull
private Integer menuId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddRoleHasMenuQuery.java:38`; evidence: `declaration-78f1c6aa2b1a7bef8b63eff0f4185cf7da6ed695df32ec75316791086a782da8`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单id
```
