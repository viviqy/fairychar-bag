# com.fairychar.security.core.rbac.entity.SystemRole fields

Snapshot: `snapshot-20261113T014229Z-bb422342`

[Owner / index](../SystemRole.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5c36fa4ac7e7e6f2"></a>
### id

```java
@Schema(description = "ID")
@TableId(type = IdType.AUTO, value = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:32`; evidence: `declaration-5c36fa4ac7e7e6f2a5021f5deaec7314e4a4c3102783e48609ddc4eb410d4a25`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-1bde715cb3c82e72"></a>
### roleCode

```java
@Schema(description = "\u89d2\u8272\u6807\u8bc6\u552f\u4e00code\u6807\u8bc6")
@TableField(value = "`role_code`")
private String roleCode
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:38`; evidence: `declaration-1bde715cb3c82e72a78da63b4393afcae4220118d5102a9537dd4d60c189b809`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色标识唯一code标识
```


<a id="symbol-10a3afe674a6ccd8"></a>
### name

```java
@Schema(description = "\u540d\u79f0")
@TableField(value = "`name`")
private String name
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:44`; evidence: `declaration-10a3afe674a6ccd8cf2b06d6e9ab4b632a64ca7e692e273fc08dd21edcd348cf`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
名称
```


<a id="symbol-954a4ccac9a752f8"></a>
### level

```java
@Schema(description = "\u89d2\u8272\u7ea7\u522b(0\u4ee3\u8868root)")
@TableField(value = "`level`")
private Integer level
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:50`; evidence: `declaration-954a4ccac9a752f8c275421a90b0dddf6bf458a560bbcbb239712a274c823b72`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色级别(0代表root)
```


<a id="symbol-7613fb67979ac00c"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
@TableField(value = "`enable`")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:56`; evidence: `declaration-7613fb67979ac00c7d861db4141e221d22c64aa76e0ae55a6ae96552a4e8b634`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-43bba1ed6498bd2f"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
@TableField(value = "`description`")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:62`; evidence: `declaration-43bba1ed6498bd2f5e829d51e0ffe7b6ab1d4ee9e7eb537d5f0dc966c0ff834d`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```


<a id="symbol-5a1e115b8ccf110b"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
@TableField(value = "`create_by`", fill = FieldFill.INSERT)
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:68`; evidence: `declaration-5a1e115b8ccf110bec42ecbcbaec8c701ca4ae695a78ffcf3979c6910aa6d788`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-545d85b8530950c4"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
@TableField(value = "`create_name`", fill = FieldFill.INSERT)
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:74`; evidence: `declaration-545d85b8530950c4af72905b12168a396d014564c6e360979e7069eae5d8e149`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-1ec84abc83537722"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
@TableField(value = "`update_by`", fill = FieldFill.UPDATE)
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:80`; evidence: `declaration-1ec84abc8353772260c6e6078c214a817eafac94722a6024e0726962672e8aed`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-7a299e14c5649b07"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
@TableField(value = "`update_name`", fill = FieldFill.UPDATE)
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:86`; evidence: `declaration-7a299e14c5649b07be467f53921ec27fd979c37b175a6a21a3c7779b33efab79`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-a8f528f2a2991cc9"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@TableField(value = "`create_time`")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:92`; evidence: `declaration-a8f528f2a2991cc9bd4be9b4c193d2d1b54a68a7030263fc4ab64338c72801d2`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-dc5c29cc4cd9ee41"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@TableField(value = "`update_time`")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:98`; evidence: `declaration-dc5c29cc4cd9ee41b7a337e3cf73ac5f02f3d321ceff270aaa464c7c7d5700cc`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-b80c04aaae075d59"></a>
### groupByCount

```java
@TableField(exist = false)
@Schema(description = "\u5206\u7ec4\u6570\u91cf\u5339\u914d\u5b57\u6bb5,\u548c\u539f\u8868\u65e0\u5173")
private Integer groupByCount
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:104`; evidence: `declaration-b80c04aaae075d5942415a02d3b7532d0b5d60ccdf53b5bbc14b8dfef788f46f`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
分组匹配字符
```


<a id="symbol-e4b523730c258318"></a>
### ID

```java
public static final String ID = "id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:122`; evidence: `declaration-e4b523730c258318ae55189d97e15773260b6f1587dc795b8126977a15d45bcd`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
id - ID
```


<a id="symbol-35795ac509352387"></a>
### ROLE_CODE

```java
public static final String ROLE_CODE = "role_code"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:127`; evidence: `declaration-35795ac50935238701ca14ac9861498bacca0304192f041f1fdb3e48a5e7999b`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
role_code - 角色标识唯一code标识
```


<a id="symbol-634c6e657875687f"></a>
### NAME

```java
public static final String NAME = "name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:132`; evidence: `declaration-634c6e657875687f1038a1f5dcae7b85a5aa93d64ff0fcf486ca39ae1ae62783`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
name - 名称
```


<a id="symbol-061340b70595be23"></a>
### LEVEL

```java
public static final String LEVEL = "level"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:137`; evidence: `declaration-061340b70595be23c6e79f365a31203679494666f09ef6b6c3fa144f980f4bee`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
level - 角色级别(0代表root)
```


<a id="symbol-641796aa1b2240bb"></a>
### ENABLE

```java
public static final String ENABLE = "enable"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:142`; evidence: `declaration-641796aa1b2240bb9e076be783e52d3334d509b53eb9fcb823951c315685dae8`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
enable - 是否启用
```


<a id="symbol-416aaff59912aa60"></a>
### DESCRIPTION

```java
public static final String DESCRIPTION = "description"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:147`; evidence: `declaration-416aaff59912aa60195317dface0ef470534454d9d6dbf8c46b95c53b7f03d80`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
description - 描述
```


<a id="symbol-bde146bc77f3e271"></a>
### CREATE_BY

```java
public static final String CREATE_BY = "create_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:152`; evidence: `declaration-bde146bc77f3e271a83c352c0c7a9e8cc100cf8ca49ead236a507a5f086f48aa`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_by - 创建者
```


<a id="symbol-4f351ad66e904217"></a>
### CREATE_NAME

```java
public static final String CREATE_NAME = "create_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:157`; evidence: `declaration-4f351ad66e904217f6183988b11bb3413a883b8de6d47a0bb34f98bde049b040`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_name - 创建人名称
```


<a id="symbol-496891e633965c2d"></a>
### UPDATE_BY

```java
public static final String UPDATE_BY = "update_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:162`; evidence: `declaration-496891e633965c2d6f9fb9a8a1f3e827b6d5a81131556ff98d4a3c7fe57a14d2`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_by - 更新者
```


<a id="symbol-b11b0f42bd882f7c"></a>
### UPDATE_NAME

```java
public static final String UPDATE_NAME = "update_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemRole.java:167`; evidence: `declaration-b11b0f42bd882f7c71124485039ed3af02bd4a89695436ac97859fbc5312a3b9`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_name - 更新人名称
```
