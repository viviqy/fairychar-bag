# com.fairychar.security.core.rbac.entity.SysDict fields

Snapshot: `snapshot-20261113T014229Z-bb422342`

[Owner / index](../SysDict.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-35955a48ba49077c"></a>
### id

```java
@Schema(description = "ID")
@TableId(type = IdType.AUTO, value = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:32`; evidence: `declaration-35955a48ba49077cf2f11a1f99f3c2c0dea7c24f17525f3d1abad9382c68af52`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-4306333c82ed279c"></a>
### uid

```java
@Schema(description = "\u5b57\u5178uid")
@TableField(value = "`uid`")
private Long uid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:38`; evidence: `declaration-4306333c82ed279c14e575ac47e54cadc9ba05f864ea6d534b9b177752ec9166`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典uid
```


<a id="symbol-8055a878dfb74072"></a>
### label

```java
@Schema(description = "\u5b57\u5178\u6807\u7b7e")
@TableField(value = "`label`")
private String label
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:44`; evidence: `declaration-8055a878dfb740725e29d1aec22bb31369022a17cff9b69c9a9eadb7b8ac3108`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典标签
```


<a id="symbol-a882fd6881dac441"></a>
### labelValue

```java
@Schema(description = "\u5b57\u5178\u503c")
@TableField(value = "`label_value`")
private String labelValue
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:50`; evidence: `declaration-a882fd6881dac44133d6f6cebd25dc18a70d744248bff18bf013fe3835cc5b61`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典值
```


<a id="symbol-78abefd1c3ed7519"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
@TableField(value = "`description`")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:56`; evidence: `declaration-78abefd1c3ed751946e722e960b733b76de3d1b7d8aa9a4dde26693f48c7d46e`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```


<a id="symbol-a96d018effe63bd1"></a>
### dictSort

```java
@Schema(description = "\u6392\u5e8f")
@TableField(value = "`dict_sort`")
private Integer dictSort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:62`; evidence: `declaration-a96d018effe63bd1922d539b51fe46990c4d782c2984b1e6e9153937de2f217f`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-6c979959206f97b9"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
@TableField(value = "`create_by`", fill = FieldFill.INSERT)
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:68`; evidence: `declaration-6c979959206f97b9608ea4f11d9a951511219617051e46d38877631abdb1799b`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-0826f6e570337636"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
@TableField(value = "`create_name`", fill = FieldFill.INSERT)
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:74`; evidence: `declaration-0826f6e5703376363d4f64f504c121920c98caa2d2f8086534c7dfbf0d7b8c95`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-80542b5c9738dab0"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
@TableField(value = "`update_by`", fill = FieldFill.UPDATE)
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:80`; evidence: `declaration-80542b5c9738dab08ba8e0d2cc74ad319a49a95874178b869667ccfbc65dc2ed`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-1dee451510dcc861"></a>
### updateName

```java
@Schema(description = "\u4fee\u6539\u4eba\u540d\u79f0")
@TableField(value = "`update_name`", fill = FieldFill.UPDATE)
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:86`; evidence: `declaration-1dee451510dcc861bb28663ec2dee08cefc65bc79bc11d607a62693c1c1d32fc`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改人名称
```


<a id="symbol-8f2f0d62ede50326"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@TableField(value = "`create_time`")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:92`; evidence: `declaration-8f2f0d62ede50326b7fed9933972b1903c2fa943e9141da79d0df6cbe47916d0`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-6239d93bbfba7b8a"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@TableField(value = "`update_time`")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:98`; evidence: `declaration-6239d93bbfba7b8a63d58caff5a46a58a371c3319601e31b9bb8c3918b0f5919`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-5549f0849981d21f"></a>
### groupByCount

```java
@TableField(exist = false)
@Schema(description = "\u5206\u7ec4\u6570\u91cf\u5339\u914d\u5b57\u6bb5,\u548c\u539f\u8868\u65e0\u5173")
private Integer groupByCount
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:104`; evidence: `declaration-5549f0849981d21f8228d6f269de05cabf22eafafeb3a5aca36c4de4b7d0e0df`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
分组匹配字符
```


<a id="symbol-6c08c08e67a6c82f"></a>
### ID

```java
public static final String ID = "id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:122`; evidence: `declaration-6c08c08e67a6c82f50d03e819197cc39f2e7d89a08fd3b969d29b4187d1096dc`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
id - ID
```


<a id="symbol-5881f6c276450158"></a>
### UID

```java
public static final String UID = "uid"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:127`; evidence: `declaration-5881f6c276450158e9ad4a3ab09c0151859feae36242b1de7a497c310bfadd0e`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
uid - 字典uid
```


<a id="symbol-f0fcdbc7fb71e033"></a>
### LABEL

```java
public static final String LABEL = "label"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:132`; evidence: `declaration-f0fcdbc7fb71e03315808d0edf00507c12adc3574ceb3dc9454a4af848f6dd50`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
label - 字典标签
```


<a id="symbol-084e1e6df944ab5e"></a>
### LABEL_VALUE

```java
public static final String LABEL_VALUE = "label_value"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:137`; evidence: `declaration-084e1e6df944ab5e885d198a01583731bb97d702a56c4526d5984f14ba083120`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
label_value - 字典值
```


<a id="symbol-195b306e977ffa69"></a>
### DESCRIPTION

```java
public static final String DESCRIPTION = "description"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:142`; evidence: `declaration-195b306e977ffa6933621e988f0f5ebcf5f6d385bcbb3dec83a6916dd6913c0c`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
description - 描述
```


<a id="symbol-0468f861b5c0ef2a"></a>
### DICT_SORT

```java
public static final String DICT_SORT = "dict_sort"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:147`; evidence: `declaration-0468f861b5c0ef2ab28cd57836889ac71a583f39566c96b6c1079b6a2014d58a`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
dict_sort - 排序
```


<a id="symbol-b089a7dd089e761c"></a>
### CREATE_BY

```java
public static final String CREATE_BY = "create_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:152`; evidence: `declaration-b089a7dd089e761cdff68d2ac915af5ae3a3123db9b00fc284c11bbf2153286d`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_by - 创建者
```


<a id="symbol-47f4188b32430b36"></a>
### CREATE_NAME

```java
public static final String CREATE_NAME = "create_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:157`; evidence: `declaration-47f4188b32430b369aaa643fb1365a5af61e7f2efa962ab288ab87d11dc9f22e`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_name - 创建人名称
```


<a id="symbol-d81a532b63036fb8"></a>
### UPDATE_BY

```java
public static final String UPDATE_BY = "update_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:162`; evidence: `declaration-d81a532b63036fb8261a894b13f21056cd22ffaa7585aa3e72fbe04e0dc63d61`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_by - 更新者
```


<a id="symbol-e6b1e0c41bbc3b1f"></a>
### UPDATE_NAME

```java
public static final String UPDATE_NAME = "update_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysDict.java:167`; evidence: `declaration-e6b1e0c41bbc3b1fb751f6cd78ff2eabaed4041b7e8e5d9b50f177e1975b3384`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_name - 修改人名称
```
