# com.fairychar.security.core.rbac.pojo.query.AddUserHasRoleQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AddUserHasRoleQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-2aab6825f93ef704"></a>
## com.fairychar.security.core.rbac.pojo.query.AddUserHasRoleQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddUserHasRoleQuery")
public class AddUserHasRoleQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddUserHasRoleQuery.java:18`; evidence: `declaration-2aab6825f93ef7042343954976427f5c1f341a5f4b5c99605d5bb3fad1513578`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
用户角色关联(UserHasRole)表实体类

 @author chiyo
```


## Fields

<a id="symbol-1483d190e4e552ce"></a>
### userUid

```java
@Schema(description = "\u7528\u6237ID")
@NotNull
private Long userUid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddUserHasRoleQuery.java:29`; evidence: `declaration-1483d190e4e552ce05217dcee7c8d523f3a81ed548b89e01ad64e0d1bb3ff99f`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
用户ID
```


<a id="symbol-e4df0e46729c6c82"></a>
### roleId

```java
@Schema(description = "\u89d2\u8272ID")
@NotNull
private Integer roleId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddUserHasRoleQuery.java:35`; evidence: `declaration-e4df0e46729c6c82a10956fcfd8c13a5c728408aa2177cabdf7451df26f237b2`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色ID
```
