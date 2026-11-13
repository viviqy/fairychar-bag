# com.fairychar.security.core.rbac.entity.UserHasRole

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UserHasRole.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3ad180393fd5142f"></a>
## com.fairychar.security.core.rbac.entity.UserHasRole

```java
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("user_has_role")
@Schema(description = "UserHasRole")
public class UserHasRole extends Model<UserHasRole>
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:20`; evidence: `declaration-3ad180393fd5142f7471d0efbe875b19a9911c4c9a17d022febcf40f0b40b9d4`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
用户角色关联(UserHasRole)表实体类

 @author chiyo
```


## Fields

<a id="symbol-997626bc7f175ea4"></a>
### id

```java
@Schema(description = "")
@TableId(type = IdType.AUTO, value = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:30`; evidence: `declaration-997626bc7f175ea425059c2b384cfa94a19c034e2c8cbb2aab08fbe1ea16b610`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-2dcd3e46dc853e0f"></a>
### userUid

```java
@Schema(description = "\u7528\u6237ID")
@TableField(value = "`user_uid`")
private Long userUid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:36`; evidence: `declaration-2dcd3e46dc853e0f34bea7b53246dc65886f2f1927b16fd7be12b6060d1605d2`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
用户ID
```


<a id="symbol-c6b7ab38ce95f8d9"></a>
### roleId

```java
@Schema(description = "\u89d2\u8272ID")
@TableField(value = "`role_id`")
private Integer roleId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:42`; evidence: `declaration-c6b7ab38ce95f8d9c6b2fc3f9fc0f7443473ad1409e9bdc0e5179d155cc23b04`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色ID
```


<a id="symbol-34fad47fcb57f535"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
@TableField(value = "`create_by`", fill = FieldFill.INSERT)
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:48`; evidence: `declaration-34fad47fcb57f53579d50f96c2b6042101fc1ffe6190272e1d13b895d239b668`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-5cbf8f9b4fc343ee"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
@TableField(value = "`create_name`", fill = FieldFill.INSERT)
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:54`; evidence: `declaration-5cbf8f9b4fc343ee610f41deacdbece48b4db59dbe72d50a29aaf30d1a3d6c70`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-e0b5df56d80706de"></a>
### updateBy

```java
@Schema(description = "\u4fee\u6539\u4eba")
@TableField(value = "`update_by`", fill = FieldFill.UPDATE)
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:60`; evidence: `declaration-e0b5df56d80706de9058de819b8308e8e9c9b2b0ceb4b478c49829446897af49`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改人
```


<a id="symbol-71346d02caf3c5d3"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
@TableField(value = "`update_name`", fill = FieldFill.UPDATE)
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:66`; evidence: `declaration-71346d02caf3c5d3a9d14811f0cecff611692acb42a8cd7a5ea12fdcd1675291`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-957646ddcc2248aa"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@TableField(value = "`create_time`")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:72`; evidence: `declaration-957646ddcc2248aa6aadd551df4bcc7d2bc9e086f53d25beaa620b3162f955d6`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-c128b0fd3290545a"></a>
### updateTime

```java
@Schema(description = "\u4fee\u6539\u65f6\u95f4")
@TableField(value = "`update_time`")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:78`; evidence: `declaration-c128b0fd3290545acd1b4632dae8f6f29563c937a85cc69ff288a34b8038d829`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改时间
```


<a id="symbol-bd3a80807098ab5c"></a>
### groupByCount

```java
@TableField(exist = false)
@Schema(description = "\u5206\u7ec4\u6570\u91cf\u5339\u914d\u5b57\u6bb5,\u548c\u539f\u8868\u65e0\u5173")
private Integer groupByCount
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:84`; evidence: `declaration-bd3a80807098ab5c81d7eba627858086797396d6ca8fdecd3e589eb0a529f51a`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
分组匹配字符
```


<a id="symbol-6d39a2c8c3ba4c9e"></a>
### ID

```java
public static final String ID = "id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:102`; evidence: `declaration-6d39a2c8c3ba4c9ea82a3d0803bdeccd738a1523a5356ab6ea0b0a8eba70414e`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
id -
```


<a id="symbol-0c7e75a6a9ac4370"></a>
### USER_UID

```java
public static final String USER_UID = "user_uid"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:107`; evidence: `declaration-0c7e75a6a9ac437060d0622e973134f2995214369273278e28a16519eb8fb82d`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
user_uid - 用户ID
```


<a id="symbol-f0bfe6c45c833b36"></a>
### ROLE_ID

```java
public static final String ROLE_ID = "role_id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:112`; evidence: `declaration-f0bfe6c45c833b365eccdef4d72bdf30ba315e6a848886ef2f9adbee525f6c37`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
role_id - 角色ID
```


<a id="symbol-a00b9af1bcefbc9a"></a>
### CREATE_BY

```java
public static final String CREATE_BY = "create_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:117`; evidence: `declaration-a00b9af1bcefbc9a777689b844a48635ca11ff19c2e269617a07a3e3c8675f23`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_by - 创建人
```


<a id="symbol-7dd6269ad0f50089"></a>
### CREATE_NAME

```java
public static final String CREATE_NAME = "create_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:122`; evidence: `declaration-7dd6269ad0f50089c7fa68f2df9ce96de72134fa5f060268078ed5e5c71e0918`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_name - 创建人名称
```


<a id="symbol-8e615d3423bd9e84"></a>
### UPDATE_BY

```java
public static final String UPDATE_BY = "update_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:127`; evidence: `declaration-8e615d3423bd9e84654d5178fae20255c0d2065ea42d85c5ab4f656e894e4a7a`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_by - 修改人
```


<a id="symbol-8f9009336691d98a"></a>
### UPDATE_NAME

```java
public static final String UPDATE_NAME = "update_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:132`; evidence: `declaration-8f9009336691d98aac62763d61afdf2b000d42ba1cdee0d66110d913597f4452`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_name - 更新人名称
```


<a id="symbol-1d75582633d5bb6a"></a>
### CREATE_TIME

```java
public static final String CREATE_TIME = "create_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:137`; evidence: `declaration-1d75582633d5bb6ac50878fe7ab0e09c6e01d46cd20d1e781f73a9a71df87614`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_time - 创建时间
```


<a id="symbol-7c2565aedb484a6b"></a>
### UPDATE_TIME

```java
public static final String UPDATE_TIME = "update_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/UserHasRole.java:142`; evidence: `declaration-7c2565aedb484a6badadb680c9fe5a885110ac6a71223531c19e826406609a6a`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_time - 修改时间
```


## Members

- [pkVal](UserHasRole.pkVal.md#symbol-892aa5b78bd3e4ae) — `function`, source line 93
