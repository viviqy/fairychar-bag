# com.fairychar.security.core.rbac.pojo.query.RoleHasMenuQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RoleHasMenuQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-27da718c7bd34809"></a>
## com.fairychar.security.core.rbac.pojo.query.RoleHasMenuQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "RoleHasMenuQuery")
public class RoleHasMenuQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:20`; evidence: `declaration-27da718c7bd348098e78ca434b4892b09fe464a1ab0e51c7c5f8a4d7be2d91b8`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色菜单关联(RoleHasMenu)表实体类

 @author chiyo
```


## Fields

<a id="symbol-1cd2151a8202b5f9"></a>
### id

```java
@Schema(description = "")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:29`; evidence: `declaration-1cd2151a8202b5f9a54d967d7437caabd2bb0a0d984a9f0a517164a7b38cc574`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-6cde7be83e8602ae"></a>
### roleId

```java
@Schema(description = "\u89d2\u8272id")
private Integer roleId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:34`; evidence: `declaration-6cde7be83e8602aeabed4579c4b3b518373dfcffe38ae454dfeab55b624aa3de`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色id
```


<a id="symbol-bfcacfa94f051808"></a>
### menuId

```java
@Schema(description = "\u83dc\u5355id")
private Integer menuId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:39`; evidence: `declaration-bfcacfa94f051808ca0afcb9ab67d93fe4657ac7ec99f0faaf0102806aacc5fe`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单id
```


<a id="symbol-953097928ccc9bd1"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:44`; evidence: `declaration-953097928ccc9bd179911e37f42700c934465605f970ad807ba7f51b1b88fefb`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-2c554c22a86c8df2"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:49`; evidence: `declaration-2c554c22a86c8df27101be77727ea68f72cb419bb3bdb33f9dba83ec06faafae`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-1f4ae9ff08d7c854"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u4eba")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:54`; evidence: `declaration-1f4ae9ff08d7c854bca48973fdad75e0850b239696e779c28f089ba1b6b5c617`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人
```


<a id="symbol-6fc3c4feafb59806"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:59`; evidence: `declaration-6fc3c4feafb5980625bebf997bbfbcf98467a70197af849e6c0f0a9d28bd7c88`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-624500f4bbba6d75"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:64`; evidence: `declaration-624500f4bbba6d75d99c8138b56c4e9275c17ee5918f7dfbf6380c9d48eed550`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-962b66b3d916c7ae"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:70`; evidence: `declaration-962b66b3d916c7ae026845da5d9ec1c2df5c1a53886d1ba302d6a679475d3ef0`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-bc6de016d41cfd2d"></a>
### pageQuery

```java
@Schema(description = "\u5206\u9875\u53c2\u6570")
private Page pageQuery = new Page()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/RoleHasMenuQuery.java:76`; evidence: `declaration-bc6de016d41cfd2d26bb566e07d6b4182219913d50b7b22ffef17734b64ea4e0`.
Visibility: `private` (explicit).
Type: `Page`.

Source docstring (unreviewed):
```text
分页请求参数
```
