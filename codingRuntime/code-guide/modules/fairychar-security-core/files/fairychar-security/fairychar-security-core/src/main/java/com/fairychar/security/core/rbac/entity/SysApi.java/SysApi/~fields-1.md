# com.fairychar.security.core.rbac.entity.SysApi fields

Snapshot: `snapshot-20261113T014229Z-bb422342`

[Owner / index](../SysApi.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8d5f3700ae914318"></a>
### id

```java
@Schema(description = "")
@TableId(type = IdType.AUTO, value = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:30`; evidence: `declaration-8d5f3700ae914318f73d024eec878ad445ccb5a74533aef10513638432b6331b`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-7535406d3deeb34a"></a>
### httpMethod

```java
@Schema(description = "http\u8bf7\u6c42\u65b9\u6cd5")
@TableField(value = "`http_method`")
private String httpMethod
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:36`; evidence: `declaration-7535406d3deeb34a939d019a98a5a51ffb801ee1f145d0dbec672a4792801d29`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
http请求方法
```


<a id="symbol-6b2625db8f5d2e29"></a>
### uri

```java
@Schema(description = "\u8bf7\u6c42\u63a5\u53e3\u8def\u5f84,\u4f7f\u7528antMatch\u65b9\u5f0f")
@TableField(value = "`uri`")
private String uri
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:42`; evidence: `declaration-6b2625db8f5d2e295f7f68e41a225339230a935680c3a24ac9f248054d8bb322`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
请求接口路径,使用antMatch方式
```


<a id="symbol-1fc799ba8929475c"></a>
### description

```java
@Schema(description = "\u63a5\u53e3\u63cf\u8ff0")
@TableField(value = "`description`")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:48`; evidence: `declaration-1fc799ba8929475c662a07ab518834e96876b270fc70af66895ae35ebb944cb8`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
接口描述
```


<a id="symbol-8baa5d92ddc3c607"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
@TableField(value = "`sort`")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:54`; evidence: `declaration-8baa5d92ddc3c607fc734e6f0ad936d2762c4ccfc7cff27eb5305c40be930465`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-fac894d6605d987b"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
@TableField(value = "`create_by`", fill = FieldFill.INSERT)
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:60`; evidence: `declaration-fac894d6605d987bd8718043b7a5fd2c7b9cd80d7b0358da7c7424e91801e91f`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-70845b45802e704b"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
@TableField(value = "`create_name`", fill = FieldFill.INSERT)
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:66`; evidence: `declaration-70845b45802e704b7f19080e97fe99175d6d3cc85e75977b6fe026a32492233d`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-e22fedd9f8b366e0"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u4eba")
@TableField(value = "`update_by`", fill = FieldFill.UPDATE)
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:72`; evidence: `declaration-e22fedd9f8b366e022c66c0a4d5d32978d32ce79ed21d87322593dc2743cc5c5`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人
```


<a id="symbol-e717de613e32fe29"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
@TableField(value = "`update_name`", fill = FieldFill.UPDATE)
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:78`; evidence: `declaration-e717de613e32fe291786110a4384ca5ce1d7aab83f6bf4036580f61f5f7f80f0`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-f2be8baaddd8bd82"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@TableField(value = "`create_time`")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:84`; evidence: `declaration-f2be8baaddd8bd82c25ed6905304708ead65b3c79845c25880af6228765a43d4`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-ceafb12e5efd1476"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@TableField(value = "`update_time`")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:90`; evidence: `declaration-ceafb12e5efd1476c3b5396ea2d84ba629610686177780d133bc42bcc3191ba5`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-1d5de56462612a96"></a>
### groupByCount

```java
@TableField(exist = false)
@Schema(description = "\u5206\u7ec4\u6570\u91cf\u5339\u914d\u5b57\u6bb5,\u548c\u539f\u8868\u65e0\u5173")
private Integer groupByCount
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:96`; evidence: `declaration-1d5de56462612a962cecb0a376bf505d3f2b054b3e1c1e04b9982a3734bc666d`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
分组匹配字符
```


<a id="symbol-3af68e6f822d66c0"></a>
### ID

```java
public static final String ID = "id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:114`; evidence: `declaration-3af68e6f822d66c0fdda45ece51e62f71d54f05e6faceb2c5ecd1bde5a9f4653`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
id -
```


<a id="symbol-f9c4c07260309d8d"></a>
### HTTP_METHOD

```java
public static final String HTTP_METHOD = "http_method"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:119`; evidence: `declaration-f9c4c07260309d8d0e4fa327d3497a55eb6fdfb40741c7336cfd575829697849`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
http_method - http请求方法
```


<a id="symbol-9c0f653fb678f41a"></a>
### URI

```java
public static final String URI = "uri"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:124`; evidence: `declaration-9c0f653fb678f41ac1d3caa13c121ca108b76698fe1cb62c6522e786f2695008`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
uri - 请求接口路径,使用antMatch方式
```


<a id="symbol-abe32e0dbbd89bcf"></a>
### DESCRIPTION

```java
public static final String DESCRIPTION = "description"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:129`; evidence: `declaration-abe32e0dbbd89bcf5bf9312524e5a5c705a21780c9fe6598631280f2fb724323`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
description - 接口描述
```


<a id="symbol-836d13b4e22d5c9f"></a>
### SORT

```java
public static final String SORT = "sort"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:134`; evidence: `declaration-836d13b4e22d5c9f28f46303fb16949c52a08ae9e13d609dc05d78fb74097e78`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
sort - 排序
```


<a id="symbol-2bcfe7b63e15ab15"></a>
### CREATE_BY

```java
public static final String CREATE_BY = "create_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:139`; evidence: `declaration-2bcfe7b63e15ab153b3a5e91d4995fecc3d4f8c28b359e13242493c995564ae9`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_by - 创建人
```


<a id="symbol-26bdf9690e217281"></a>
### CREATE_NAME

```java
public static final String CREATE_NAME = "create_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:144`; evidence: `declaration-26bdf9690e2172816ebf074665dde2131b96dd95d25fdcba5b39cd9a3a512bd3`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_name - 创建人名称
```


<a id="symbol-7ba87064573cbc19"></a>
### UPDATE_BY

```java
public static final String UPDATE_BY = "update_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:149`; evidence: `declaration-7ba87064573cbc19b2a1a0760642f4e8fcf0c6da27a5c26b1d39d0ae27108268`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_by - 更新人
```


<a id="symbol-809884ba01b7b2d7"></a>
### UPDATE_NAME

```java
public static final String UPDATE_NAME = "update_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:154`; evidence: `declaration-809884ba01b7b2d721833aa36ec68a17cca44554c9dbe41f9c0ebcbbe8bfd924`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_name - 更新人名称
```


<a id="symbol-7a42c203275b5224"></a>
### CREATE_TIME

```java
public static final String CREATE_TIME = "create_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:159`; evidence: `declaration-7a42c203275b52246033e67a709e506429464e37f203d1c441efdc50653387a5`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_time - 创建时间
```


<a id="symbol-01c9e4cf553c2a3e"></a>
### UPDATE_TIME

```java
public static final String UPDATE_TIME = "update_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysApi.java:164`; evidence: `declaration-01c9e4cf553c2a3e03597a59e076f2cda5471eaed34d3cdfe2f4fe112ceae01e`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_time - 更新时间
```
