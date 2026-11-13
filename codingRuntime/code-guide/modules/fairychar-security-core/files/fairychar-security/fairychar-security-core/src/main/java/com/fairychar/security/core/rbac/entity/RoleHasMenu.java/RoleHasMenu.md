# com.fairychar.security.core.rbac.entity.RoleHasMenu

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RoleHasMenu.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3916ed1e3f755859"></a>
## com.fairychar.security.core.rbac.entity.RoleHasMenu

```java
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("role_has_menu")
@Schema(description = "RoleHasMenu")
public class RoleHasMenu extends Model<RoleHasMenu>
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:20`; evidence: `declaration-3916ed1e3f755859d72bd9c02031275c0fc93fbaea5c9d583d905825c05e4cc8`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色菜单关联(RoleHasMenu)表实体类

 @author chiyo
```


## Fields

<a id="symbol-36d947d147e8c62e"></a>
### id

```java
@Schema(description = "")
@TableId(type = IdType.AUTO, value = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:30`; evidence: `declaration-36d947d147e8c62ee3728bee97b7eadfc998c8463b881b4ba95fb410a0328cdd`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-58b120925c3ca54b"></a>
### roleId

```java
@Schema(description = "\u89d2\u8272id")
@TableField(value = "`role_id`")
private Integer roleId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:36`; evidence: `declaration-58b120925c3ca54b286c9b3fb8e7ff20884d33928d729cdaa7a9380af2317e4b`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色id
```


<a id="symbol-e45d5a47ffe76ed6"></a>
### menuId

```java
@Schema(description = "\u83dc\u5355id")
@TableField(value = "`menu_id`")
private Integer menuId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:42`; evidence: `declaration-e45d5a47ffe76ed6dbeae2af5d65d547bb7dc22e795440e0008e8a65d7489f8d`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单id
```


<a id="symbol-400202fa117aee01"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
@TableField(value = "`create_by`", fill = FieldFill.INSERT)
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:48`; evidence: `declaration-400202fa117aee0176f2843f8afb0888ebb02a0f7eb12b7e0919fb660cf0d608`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-cd21b95181bb3257"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
@TableField(value = "`create_name`", fill = FieldFill.INSERT)
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:54`; evidence: `declaration-cd21b95181bb325770785509f0548e21a8855b871904257320247b8f8eac132b`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-e4cc6a13dff5b877"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u4eba")
@TableField(value = "`update_by`", fill = FieldFill.UPDATE)
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:60`; evidence: `declaration-e4cc6a13dff5b8774a8a25817b5f89fc6144ebbb38bfde5fb850228b0010b392`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人
```


<a id="symbol-52f900bbc36b0399"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
@TableField(value = "`update_name`", fill = FieldFill.UPDATE)
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:66`; evidence: `declaration-52f900bbc36b0399bc0e06e0472ac4ba97046ba80a74e1b47ac88046fc6dac44`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-bc2bc0c63cd5f05d"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@TableField(value = "`create_time`")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:72`; evidence: `declaration-bc2bc0c63cd5f05d0ed4367fed6c102cad245f9b46d6f595610ef56055d207b6`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-54f296e27f3bb72b"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@TableField(value = "`update_time`")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:78`; evidence: `declaration-54f296e27f3bb72bc9c8a2070b8fe56fae680aad5fd5e5b8d493a54bac202539`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-875b96a2a237f39d"></a>
### groupByCount

```java
@TableField(exist = false)
@Schema(description = "\u5206\u7ec4\u6570\u91cf\u5339\u914d\u5b57\u6bb5,\u548c\u539f\u8868\u65e0\u5173")
private Integer groupByCount
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:84`; evidence: `declaration-875b96a2a237f39df9eb14b02f88321b90909921e56711e4e32374a6fbb4ab6e`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
分组匹配字符
```


<a id="symbol-20c8deeca7ceee3c"></a>
### ID

```java
public static final String ID = "id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:102`; evidence: `declaration-20c8deeca7ceee3ca1c5f5d51e7bcf15d69e116706550b0cf77ccedb3649db82`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
id -
```


<a id="symbol-e6b81f4fed7806dd"></a>
### ROLE_ID

```java
public static final String ROLE_ID = "role_id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:107`; evidence: `declaration-e6b81f4fed7806dd67672cd271e00b65f3defd2dfc7c87590cc8750eda6f64ea`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
role_id - 角色id
```


<a id="symbol-3e8a7d4c03677cc4"></a>
### MENU_ID

```java
public static final String MENU_ID = "menu_id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:112`; evidence: `declaration-3e8a7d4c03677cc480c2afa1e62d2598a4d15a087356459c920bad7fbf488255`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
menu_id - 菜单id
```


<a id="symbol-a276c1500d72c7f6"></a>
### CREATE_BY

```java
public static final String CREATE_BY = "create_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:117`; evidence: `declaration-a276c1500d72c7f614600d6a875e518a68cc6a53d1622b5383576b42a524e368`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_by - 创建人
```


<a id="symbol-e76c4f5e7df7d491"></a>
### CREATE_NAME

```java
public static final String CREATE_NAME = "create_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:122`; evidence: `declaration-e76c4f5e7df7d491c2c6016065eaf8877fbe2b9a6364520ea84ed7944c8c32f1`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_name - 创建人名称
```


<a id="symbol-e0c2f55e2f3ee4a4"></a>
### UPDATE_BY

```java
public static final String UPDATE_BY = "update_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:127`; evidence: `declaration-e0c2f55e2f3ee4a42607dfdce2106d14532efd5897fe2f325199d50f8ac2b8c9`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_by - 更新人
```


<a id="symbol-e9de0d3b08a02c29"></a>
### UPDATE_NAME

```java
public static final String UPDATE_NAME = "update_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:132`; evidence: `declaration-e9de0d3b08a02c292b3f0168786d36beb84ae1ea0c0715c1a8d131d9df91a39f`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_name - 更新人名称
```


<a id="symbol-8e563e9b402540f3"></a>
### CREATE_TIME

```java
public static final String CREATE_TIME = "create_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:137`; evidence: `declaration-8e563e9b402540f382ba3473a4b58768219bde32fbd54315aedc5b8e570aa694`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_time - 创建时间
```


<a id="symbol-9270fe1748ec8cdc"></a>
### UPDATE_TIME

```java
public static final String UPDATE_TIME = "update_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/RoleHasMenu.java:142`; evidence: `declaration-9270fe1748ec8cdc58c22890d7c3b5a70d83acd1ce1db612b3972e2329645042`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_time - 更新时间
```


## Members

- [pkVal](RoleHasMenu.pkVal.md#symbol-cf562a264b9c639d) — `function`, source line 93
