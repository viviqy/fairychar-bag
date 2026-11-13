# com.fairychar.security.core.rbac.pojo.dto.RoleHasMenuDTO

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RoleHasMenuDTO.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f78e00583a52f148"></a>
## com.fairychar.security.core.rbac.pojo.dto.RoleHasMenuDTO

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "RoleHasMenuDTO")
public class RoleHasMenuDTO implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:18`; evidence: `declaration-f78e00583a52f148ab084e54ddb412065c5f586a8901572e2d6cc1b65563a473`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色菜单关联(RoleHasMenu)表实体类

 @author chiyo
```


## Fields

<a id="symbol-bd82485a6edada9d"></a>
### id

```java
@Schema(description = "")
@JsonFormat(shape = JsonFormat.Shape.STRING)
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:27`; evidence: `declaration-bd82485a6edada9d24bf0acf2a01eac6334b1047a4e769d403ff0c4a4262f09a`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-52f70be72bae09c2"></a>
### roleId

```java
@Schema(description = "\u89d2\u8272id")
private Integer roleId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:33`; evidence: `declaration-52f70be72bae09c2ef2d52f6a62b7b4004dccac469b59a480a9fd0ad954c9fe1`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色id
```


<a id="symbol-e86bd7fc9f9810f6"></a>
### menuId

```java
@Schema(description = "\u83dc\u5355id")
private Integer menuId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:38`; evidence: `declaration-e86bd7fc9f9810f6f610d17e0281199c1b320dbc35a5b24293ac11967569528a`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单id
```


<a id="symbol-7f73ad9391fed089"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:43`; evidence: `declaration-7f73ad9391fed08972e77cc5ed08ecd63e191df1865cf9d485338f5b0d962933`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-a77f01840517db44"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:48`; evidence: `declaration-a77f01840517db444596b120098a1b7ab0e8e077de9172eaf5eb1a03bd3c1d5b`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-1ed400e61f1e7308"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u4eba")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:53`; evidence: `declaration-1ed400e61f1e73084e29dc66b6a6443978c5dcbd72a4adc4440abd6c740c3139`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人
```


<a id="symbol-98695d81e9c64eac"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:58`; evidence: `declaration-98695d81e9c64eac95e017fbc4b15a12d900dcdd757080f54e0b9a630e46c3be`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-dadc5a222dd41ccf"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:63`; evidence: `declaration-dadc5a222dd41ccf078e2c189773c7f47cfadc00ffcf9e9c422101e17c284095`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-89ef1e119cb72cbd"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/RoleHasMenuDTO.java:69`; evidence: `declaration-89ef1e119cb72cbdb53e387d7a69ca7205a6c2baeffa2a839885a33ca9f433c2`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```
