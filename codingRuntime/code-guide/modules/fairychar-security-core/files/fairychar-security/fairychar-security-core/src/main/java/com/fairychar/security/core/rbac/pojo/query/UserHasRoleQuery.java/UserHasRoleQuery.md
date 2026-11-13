# com.fairychar.security.core.rbac.pojo.query.UserHasRoleQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UserHasRoleQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-eaf7b7b450e545ea"></a>
## com.fairychar.security.core.rbac.pojo.query.UserHasRoleQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "UserHasRoleQuery")
public class UserHasRoleQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:20`; evidence: `declaration-eaf7b7b450e545ea189898aec5abfe2bb63266c4792c1aac71e780e4feea8de9`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
用户角色关联(UserHasRole)表实体类

 @author chiyo
```


## Fields

<a id="symbol-9da7114eac1ee07f"></a>
### id

```java
@Schema(description = "")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:29`; evidence: `declaration-9da7114eac1ee07f743a5b5d12558da7088ba8f5f9378ed5f8950076b9f2bc13`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-980fdba57fe8beca"></a>
### userUid

```java
@Schema(description = "\u7528\u6237ID")
private Long userUid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:34`; evidence: `declaration-980fdba57fe8becaee0db0ad16613d208bd729d35013f9fb18068dc5698d1a63`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
用户ID
```


<a id="symbol-a01df8938bf76e43"></a>
### roleId

```java
@Schema(description = "\u89d2\u8272ID")
private Integer roleId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:39`; evidence: `declaration-a01df8938bf76e43668d8e8f678ea5cf49f49e0a29aff646f0b3ca1abb51e884`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色ID
```


<a id="symbol-0485b0f629afd978"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:44`; evidence: `declaration-0485b0f629afd9781d17784f18410e6fd2c0235da47e5d7e41ed498894a10591`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-8dd1d9489c7e39c9"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:49`; evidence: `declaration-8dd1d9489c7e39c96a564d5b7952ad88d8f9fd30f5ad1d52ff5f13f047d08c17`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-d565d525b7edebf0"></a>
### updateBy

```java
@Schema(description = "\u4fee\u6539\u4eba")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:54`; evidence: `declaration-d565d525b7edebf08a54c52e1f952521760aed72d955f6b122b0b17d93d151f1`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改人
```


<a id="symbol-82e9e1c372819245"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:59`; evidence: `declaration-82e9e1c372819245bdfc123df62d05e8943237bfb0e43cc13e55a79e5fbc6fba`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-b4af91f2b5890049"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:64`; evidence: `declaration-b4af91f2b5890049662f71849049036db4da81fb28d468a3acb6a6283842d52f`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-3e16d9c688ea01ca"></a>
### updateTime

```java
@Schema(description = "\u4fee\u6539\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:70`; evidence: `declaration-3e16d9c688ea01ca15b2891484657a5b4ac93131f8dbbfdc100d9793b3e10d60`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改时间
```


<a id="symbol-bdf4a55e1c40a384"></a>
### pageQuery

```java
@Schema(description = "\u5206\u9875\u53c2\u6570")
private Page pageQuery = new Page()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UserHasRoleQuery.java:76`; evidence: `declaration-bdf4a55e1c40a384e1c6f0e0700dbef76a7d7b3269b66c8faac86c2dc1d9b929`.
Visibility: `private` (explicit).
Type: `Page`.

Source docstring (unreviewed):
```text
分页请求参数
```
