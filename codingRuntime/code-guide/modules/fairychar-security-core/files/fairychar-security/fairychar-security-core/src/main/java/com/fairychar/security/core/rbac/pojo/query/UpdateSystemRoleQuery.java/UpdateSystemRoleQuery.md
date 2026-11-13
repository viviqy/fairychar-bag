# com.fairychar.security.core.rbac.pojo.query.UpdateSystemRoleQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UpdateSystemRoleQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-fd5ad6151e54c9ed"></a>
## com.fairychar.security.core.rbac.pojo.query.UpdateSystemRoleQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "UpdateSystemRoleQuery")
public class UpdateSystemRoleQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSystemRoleQuery.java:18`; evidence: `declaration-fd5ad6151e54c9ed97b9df207229893028dd1e427834828747862ea7995d377c`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色表(SystemRole)表实体类

 @author chiyo
```


## Fields

<a id="symbol-afb1966d1d326913"></a>
### id

```java
@Schema(description = "ID")
@NotNull
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSystemRoleQuery.java:29`; evidence: `declaration-afb1966d1d326913b1461ddb05ddea4f3ae97dbdc0be6225e65d5d3e9b938bc7`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-8c7d9d08526cf9b4"></a>
### roleCode

```java
@Schema(description = "\u89d2\u8272\u6807\u8bc6\u552f\u4e00code\u6807\u8bc6")
private String roleCode
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSystemRoleQuery.java:35`; evidence: `declaration-8c7d9d08526cf9b4093c84bcc5bf75340bb1abb4dc19c6ff6a81cc3134d15101`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色标识唯一code标识
```


<a id="symbol-d517b880c7371993"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSystemRoleQuery.java:40`; evidence: `declaration-d517b880c7371993b2d9bdd97cbd8907631580986471dbf90fb67777ec98b9d3`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-6572599652578e73"></a>
### name

```java
@Schema(description = "\u540d\u79f0")
private String name
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSystemRoleQuery.java:45`; evidence: `declaration-6572599652578e738f8f28b19b665a2fc8d6e54368f15a469079e09b6a1453b2`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
名称
```


<a id="symbol-d439a5f176950cbc"></a>
### level

```java
@Schema(description = "\u89d2\u8272\u7ea7\u522b(0\u4ee3\u8868root)")
private Integer level
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSystemRoleQuery.java:50`; evidence: `declaration-d439a5f176950cbc88857f9a54e63927dbb971774774857c5075256f61d5d5d2`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色级别(0代表root)
```


<a id="symbol-16d0a368e148b70b"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSystemRoleQuery.java:55`; evidence: `declaration-16d0a368e148b70baa72c5aa0e114970ad15388876dfd8521f43c96b09915255`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```
