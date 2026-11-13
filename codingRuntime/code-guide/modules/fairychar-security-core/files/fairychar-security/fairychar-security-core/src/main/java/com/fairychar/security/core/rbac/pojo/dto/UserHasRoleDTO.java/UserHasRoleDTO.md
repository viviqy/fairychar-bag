# com.fairychar.security.core.rbac.pojo.dto.UserHasRoleDTO

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UserHasRoleDTO.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ca7dc0d66c9b5604"></a>
## com.fairychar.security.core.rbac.pojo.dto.UserHasRoleDTO

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "UserHasRoleDTO")
public class UserHasRoleDTO implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:18`; evidence: `declaration-ca7dc0d66c9b5604ab97e009af75cc5ca7719e1a11ecae79c9b086481f9ccf87`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
用户角色关联(UserHasRole)表实体类

 @author chiyo
```


## Fields

<a id="symbol-a4d4efaa8d4c8d5c"></a>
### id

```java
@Schema(description = "")
@JsonFormat(shape = JsonFormat.Shape.STRING)
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:27`; evidence: `declaration-a4d4efaa8d4c8d5c689908acd104f2e692c1e3bd76db2d43ba38f9960eb1b3d0`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-10b1f8d5d36c56ee"></a>
### userUid

```java
@Schema(description = "\u7528\u6237ID")
private Long userUid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:33`; evidence: `declaration-10b1f8d5d36c56ee2a2d07b8d0c08fc513395d8566b0de3f6db1576e87545099`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
用户ID
```


<a id="symbol-6dfee98711928153"></a>
### roleId

```java
@Schema(description = "\u89d2\u8272ID")
private Integer roleId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:38`; evidence: `declaration-6dfee98711928153873cd10114b3eecbcbf3bf07c2df3b3d81a47092b0f55dcb`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色ID
```


<a id="symbol-f9701fee3edd4590"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:43`; evidence: `declaration-f9701fee3edd4590913f3579f7cae170272d889135a753eae4879ff22b4f7488`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-9104067db3b6974a"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:48`; evidence: `declaration-9104067db3b6974aed10c16a9cf23fd1e7ab4b7f1156d115cbc3f510f85a85ce`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-636d09f775ee159e"></a>
### updateBy

```java
@Schema(description = "\u4fee\u6539\u4eba")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:53`; evidence: `declaration-636d09f775ee159e417ba7783bccd7e5ce4021c9941329230202340ddbff9f2f`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改人
```


<a id="symbol-de77ae24e17d2a97"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:58`; evidence: `declaration-de77ae24e17d2a97460192ffc0b83b9ede0d0c65ce1eb10501ce92d8d1673050`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-5c99968e48703db3"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:63`; evidence: `declaration-5c99968e48703db3c2a53756b9c38bc0108ffa9dc50ce6b5a3c62229b1d9e349`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-2b9633511cf9a572"></a>
### updateTime

```java
@Schema(description = "\u4fee\u6539\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/UserHasRoleDTO.java:69`; evidence: `declaration-2b9633511cf9a5727c77a7cdece583a29a13cba571f3fa0e8fba4b02bf29033b`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改时间
```
