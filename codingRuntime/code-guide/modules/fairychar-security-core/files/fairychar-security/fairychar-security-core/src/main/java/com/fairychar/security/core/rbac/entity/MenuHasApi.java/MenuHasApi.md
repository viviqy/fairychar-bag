# com.fairychar.security.core.rbac.entity.MenuHasApi

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MenuHasApi.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f9df118c8be977a9"></a>
## com.fairychar.security.core.rbac.entity.MenuHasApi

```java
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@TableName("menu_has_api")
@Schema(description = "MenuHasApi")
public class MenuHasApi extends Model<MenuHasApi>
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:20`; evidence: `declaration-f9df118c8be977a94c4d08cb8faa43e9aac5eeccf134fa55202b402b109933bc`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(MenuHasApi)表实体类

 @author chiyo
```


## Fields

<a id="symbol-c20754bd0598eee6"></a>
### id

```java
@Schema(description = "\u4e3b\u952e")
@TableId(type = IdType.AUTO, value = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:32`; evidence: `declaration-c20754bd0598eee6f1a3b9526c9c35151690c2eae34d78ad4ddadab62c505b33`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
主键
```


<a id="symbol-4f98518bd643fd25"></a>
### menuId

```java
@Schema(description = "\u5173\u8054\u83dc\u5355id")
@TableField(value = "`menu_id`")
private Integer menuId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:38`; evidence: `declaration-4f98518bd643fd2585c4244a627e304a985fa5016ce74adf549efc4c9cc64b28`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
关联菜单id
```


<a id="symbol-648815fa37bcb167"></a>
### apiId

```java
@Schema(description = "\u5173\u8054\u63a5\u53e3id")
@TableField(value = "`api_id`")
private Integer apiId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:44`; evidence: `declaration-648815fa37bcb16729f244eba8dbf1da3767d3db989e36cf444ce21452e453c6`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
关联接口id
```


<a id="symbol-be59ea0538ec677c"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
@TableField(value = "`create_by`", fill = FieldFill.INSERT)
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:50`; evidence: `declaration-be59ea0538ec677c7432c9d13a0f26647f7b9e4d01334d02145c90ed2307f728`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-f45d7033df812d65"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
@TableField(value = "`create_name`", fill = FieldFill.INSERT)
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:56`; evidence: `declaration-f45d7033df812d652ad109c19d073ef9e11c2a28337257e4ecf0197cffde9924`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-6f7adca90ab48043"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u4eba")
@TableField(value = "`update_by`", fill = FieldFill.UPDATE)
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:62`; evidence: `declaration-6f7adca90ab480438dc158c4fa79d68fc78ba42b6a569f7707062791b580ea0b`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人
```


<a id="symbol-bbff9d6f93670aaf"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
@TableField(value = "`update_name`", fill = FieldFill.UPDATE)
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:68`; evidence: `declaration-bbff9d6f93670aaff0744d27f7f62154ca59bf87bb9d200f82ba2824ecfa1116`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-ae648301c4e72780"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@TableField(value = "`create_time`")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:74`; evidence: `declaration-ae648301c4e727802bf35cf79af855732bf081bbc5ee02ee294b532e1996fd2b`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-ac2892f71220033d"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@TableField(value = "`update_time`")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:80`; evidence: `declaration-ac2892f71220033df859cacbebf72f2ea5c740a254a8beab79d351a56809e593`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-bf646caf4508cfc3"></a>
### groupByCount

```java
@TableField(exist = false)
@Schema(description = "\u5206\u7ec4\u6570\u91cf\u5339\u914d\u5b57\u6bb5,\u548c\u539f\u8868\u65e0\u5173")
private Integer groupByCount
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:86`; evidence: `declaration-bf646caf4508cfc37143caaaf19b1b1ef158ffdf625e4b113a7e81b439d18ad8`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
分组匹配字符
```


<a id="symbol-266b019c60286877"></a>
### ID

```java
public static final String ID = "id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:104`; evidence: `declaration-266b019c60286877ec8eb404cb53b75c5df9ade38f42ac6435aa2e5398cad7f4`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
id - 主键
```


<a id="symbol-bb449d4bf355a869"></a>
### MENU_ID

```java
public static final String MENU_ID = "menu_id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:109`; evidence: `declaration-bb449d4bf355a8692dd405c3daeb47a9687136780b7eed00738d7416ace1e185`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
menu_id - 关联菜单id
```


<a id="symbol-cd5711b16af4aa7a"></a>
### API_ID

```java
public static final String API_ID = "api_id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:114`; evidence: `declaration-cd5711b16af4aa7a48156f47e42f9ee23142421f0dbdf89537779f70b1abd1c5`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
api_id - 关联接口id
```


<a id="symbol-0eb46e7a49651456"></a>
### CREATE_BY

```java
public static final String CREATE_BY = "create_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:119`; evidence: `declaration-0eb46e7a4965145633a23fc7d1ccc4e8da68ce17730a87f1acb3b558949d07b7`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_by - 创建人
```


<a id="symbol-566afc95d1b60c37"></a>
### CREATE_NAME

```java
public static final String CREATE_NAME = "create_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:124`; evidence: `declaration-566afc95d1b60c37364e7abae171be31da96b7607675e60159604fa1a2d766ae`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_name - 创建人名称
```


<a id="symbol-ba7eb9b742884bac"></a>
### UPDATE_BY

```java
public static final String UPDATE_BY = "update_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:129`; evidence: `declaration-ba7eb9b742884bac5a1e77276e73cb387ea28abfe5a3ae399006dcea6ec9aa23`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_by - 更新人
```


<a id="symbol-04d012d0b56e60b7"></a>
### UPDATE_NAME

```java
public static final String UPDATE_NAME = "update_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:134`; evidence: `declaration-04d012d0b56e60b7f3f4a2c6f4c0526aa2f4c5db9a5dce5d8155b02ec20cbddc`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_name - 更新人名称
```


<a id="symbol-9e407069a0ff5372"></a>
### CREATE_TIME

```java
public static final String CREATE_TIME = "create_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:139`; evidence: `declaration-9e407069a0ff537215ab1a13a632ddac4168321be82691775cef7a9704cfcb10`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_time - 创建时间
```


<a id="symbol-56dc7b11f0eba1f6"></a>
### UPDATE_TIME

```java
public static final String UPDATE_TIME = "update_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/MenuHasApi.java:144`; evidence: `declaration-56dc7b11f0eba1f6b7ba9e4280e7eed847b1d371d5e9c829f1f970940a84a231`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_time - 更新时间
```


## Members

- [pkVal](MenuHasApi.pkVal.md#symbol-35a3a7d798a9965b) — `function`, source line 95
