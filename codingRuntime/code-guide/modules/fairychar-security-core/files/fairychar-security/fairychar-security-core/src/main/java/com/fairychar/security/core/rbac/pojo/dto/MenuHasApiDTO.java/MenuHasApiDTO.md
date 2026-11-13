# com.fairychar.security.core.rbac.pojo.dto.MenuHasApiDTO

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MenuHasApiDTO.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-6321071936a01241"></a>
## com.fairychar.security.core.rbac.pojo.dto.MenuHasApiDTO

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "MenuHasApiDTO")
public class MenuHasApiDTO implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:18`; evidence: `declaration-6321071936a012414baccbf74306450f2dcf9fc092b1a7d7b68d15f130ff9262`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(MenuHasApi)表实体类

 @author chiyo
```


## Fields

<a id="symbol-2cfb64e4b83d8846"></a>
### id

```java
@Schema(description = "\u4e3b\u952e")
@JsonFormat(shape = JsonFormat.Shape.STRING)
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:29`; evidence: `declaration-2cfb64e4b83d88461b7d13e39f1ecfe73c477b7f5b09eba3f9fe0bc4a70da61e`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
主键
```


<a id="symbol-a14794879e1c0a35"></a>
### menuId

```java
@Schema(description = "\u5173\u8054\u83dc\u5355id")
private Integer menuId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:35`; evidence: `declaration-a14794879e1c0a358a8f2531e88b06c62d78ef4dfe5c805f4b38bef0970b902d`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
关联菜单id
```


<a id="symbol-9e31767572b70f7e"></a>
### apiId

```java
@Schema(description = "\u5173\u8054\u63a5\u53e3id")
private Integer apiId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:40`; evidence: `declaration-9e31767572b70f7ea0587fd03ba0a6d6cda094d460da2feb21d6b3f74e8aabf8`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
关联接口id
```


<a id="symbol-4bbe8d7acc213893"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:45`; evidence: `declaration-4bbe8d7acc213893f7fa7464781e55136c7a09ddea4d2cd0c3af360ce1560eb8`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-b63ef97285d60223"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:50`; evidence: `declaration-b63ef97285d60223deef883471acd5af9491144cf6d8659bda5d8647f1171291`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-b1ca5149b9edee84"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u4eba")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:55`; evidence: `declaration-b1ca5149b9edee841895a4c8aa110b896dbb5f921bcc66ce071c26a61bd395b0`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人
```


<a id="symbol-887343006234329c"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:60`; evidence: `declaration-887343006234329c85e320e0fb8f9990bad4b29a324d016f299cd7c3de78e489`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-ecd33862051be2a2"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:65`; evidence: `declaration-ecd33862051be2a223c907cf638755c6928712e8a0ac61ad0f21f7e93bf1eec7`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-4d9c3c1363c05c6e"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/MenuHasApiDTO.java:71`; evidence: `declaration-4d9c3c1363c05c6e695e5b1e759898213a2823b5b9f6b6750bb1d597c3a242dd`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```
