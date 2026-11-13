# com.fairychar.security.core.rbac.pojo.query.AddSystemRoleQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AddSystemRoleQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-188dc5e53ec5379d"></a>
## com.fairychar.security.core.rbac.pojo.query.AddSystemRoleQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddSystemRoleQuery")
public class AddSystemRoleQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSystemRoleQuery.java:20`; evidence: `declaration-188dc5e53ec5379dea671427dc458db42a904d633527e3d2052ad4901a8fdb6a`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色表(SystemRole)表实体类

 @author chiyo
```


## Fields

<a id="symbol-ca29729deef5906f"></a>
### roleCode

```java
@Schema(description = "\u89d2\u8272\u6807\u8bc6\u552f\u4e00code\u6807\u8bc6")
private String roleCode
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSystemRoleQuery.java:31`; evidence: `declaration-ca29729deef5906f737c1e49332dff70e60289546268e1b490487aedcaf25814`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色标识唯一code标识
```


<a id="symbol-7e465ca48088e661"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSystemRoleQuery.java:36`; evidence: `declaration-7e465ca48088e66113d483bc0af472035d1fe399e007be8eca143a96aee9bc58`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-5be5c72230ae4add"></a>
### name

```java
@Schema(description = "\u540d\u79f0")
@NotNull
@NotBlank
private String name
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSystemRoleQuery.java:41`; evidence: `declaration-5be5c72230ae4add80a5ffbfb31c545070ad1afdade0546cc473627226f0b872`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
名称
```


<a id="symbol-8d7f289037bb3e49"></a>
### level

```java
@Schema(description = "\u89d2\u8272\u7ea7\u522b(0\u4ee3\u8868root)")
@NotNull
@Min(0)
private Integer level
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSystemRoleQuery.java:48`; evidence: `declaration-8d7f289037bb3e49f2d189f26a4b58feb06116eea03e7a81bce0b2123d6c8092`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色级别(0代表root)
```


<a id="symbol-4aa88761395b30fc"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
@NotNull
@NotBlank
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSystemRoleQuery.java:55`; evidence: `declaration-4aa88761395b30fc76a5ea31a7f5f9eb3cac833ff3a482f9c2aaf19da38eff46`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```
