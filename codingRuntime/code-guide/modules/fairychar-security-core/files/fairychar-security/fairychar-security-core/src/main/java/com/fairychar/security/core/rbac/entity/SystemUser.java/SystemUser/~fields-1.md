# com.fairychar.security.core.rbac.entity.SystemUser fields

Snapshot: `snapshot-20261113T014229Z-bb422342`

[Owner / index](../SystemUser.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-cb5daa283fe1246c"></a>
### id

```java
@Schema(description = "ID")
@TableId(type = IdType.AUTO, value = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:32`; evidence: `declaration-cb5daa283fe1246cbd501426df47e2347da3b26e991f5a84ae85b6b5b407644f`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-c357520ed7edec83"></a>
### uid

```java
@Schema(description = "uid")
@TableField(value = "`uid`")
private Long uid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:38`; evidence: `declaration-c357520ed7edec837cf4099b3e144bce0e44f40cf87068828e53ebdec0c215e8`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
uid
```


<a id="symbol-e10980d6d2fdb83b"></a>
### username

```java
@Schema(description = "\u7528\u6237\u540d")
@TableField(value = "`username`")
private String username
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:44`; evidence: `declaration-e10980d6d2fdb83b3a1429b6bc0b3f7eb6c292a13120951e1797d2533344003c`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
用户名
```


<a id="symbol-bda6e490bcd52f43"></a>
### nickName

```java
@Schema(description = "\u6635\u79f0")
@TableField(value = "`nick_name`")
private String nickName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:50`; evidence: `declaration-bda6e490bcd52f430821beb51c8fc60b856e3d04df14866fbd5c5828f562c236`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
昵称
```


<a id="symbol-681a3c2b95961379"></a>
### gender

```java
@Schema(description = "\u6027\u522b")
@TableField(value = "`gender`")
private String gender
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:56`; evidence: `declaration-681a3c2b9596137913bc03b5be4fcfdbedb66c9fd6ac1de1e8fc993f7ec04ff5`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
性别
```


<a id="symbol-6e31918fdb18cc47"></a>
### phone

```java
@Schema(description = "\u624b\u673a\u53f7\u7801")
@TableField(value = "`phone`")
private String phone
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:62`; evidence: `declaration-6e31918fdb18cc47f112f5471c9ed262a4db1efe60b509a62a5d7867502b266d`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
手机号码
```


<a id="symbol-388b6986f5624b7a"></a>
### email

```java
@Schema(description = "\u90ae\u7bb1")
@TableField(value = "`email`")
private String email
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:68`; evidence: `declaration-388b6986f5624b7a214fed1e52d19451b9c853ebcd142c5a02d0210951073f18`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
邮箱
```


<a id="symbol-6f831bf4e2369c32"></a>
### avatarPath

```java
@Schema(description = "\u5934\u50cf\u8def\u5f84")
@TableField(value = "`avatar_path`")
private String avatarPath
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:74`; evidence: `declaration-6f831bf4e2369c32e03c4517a8de98e9a0a955bb938691f87e402ee33938fb1c`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
头像路径
```


<a id="symbol-c888c9c75fc1135f"></a>
### password

```java
@Schema(description = "\u5bc6\u7801")
@TableField(value = "`password`")
private String password
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:80`; evidence: `declaration-c888c9c75fc1135f297cb9417aa598dad643cdfc84f7b89e1238b682dd1bd41e`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
密码
```


<a id="symbol-49b9739e1a02cb73"></a>
### enabled

```java
@Schema(description = "\u72b6\u6001\uff1a1\u542f\u7528\u30010\u7981\u7528")
@TableField(value = "`enabled`")
private Boolean enabled
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:86`; evidence: `declaration-49b9739e1a02cb7330dabfbe94e569cac7200bce3112811f4fdf66b1e518d29a`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
状态：1启用、0禁用
```


<a id="symbol-25c5d71895b4e5aa"></a>
### pwdResetTime

```java
@Schema(description = "\u4fee\u6539\u5bc6\u7801\u7684\u65f6\u95f4")
@TableField(value = "`pwd_reset_time`")
private LocalDateTime pwdResetTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:92`; evidence: `declaration-25c5d71895b4e5aa10840c5dc300fcb6765c2895b73e9b7e71c8bfad02632936`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改密码的时间
```


<a id="symbol-2a7a6a8ca38ce74c"></a>
### expired

```java
@Schema(description = "\u662f\u5426\u8fc7\u671f")
@TableField(value = "`is_expired`")
private Boolean expired
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:98`; evidence: `declaration-2a7a6a8ca38ce74cc40efb4bebc36261f40bcee122a076f452308de32a667a40`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否过期
```


<a id="symbol-2478a11046945175"></a>
### locked

```java
@Schema(description = "\u662f\u5426\u88ab\u51bb\u7ed3")
@TableField(value = "`is_locked`")
private Boolean locked
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:104`; evidence: `declaration-2478a1104694517544b73e8489240d05ada4d11e034adeff1010c5bb5ddd9cdf`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否被冻结
```


<a id="symbol-b312b8e25009b0a6"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
@TableField(value = "`sort`")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:110`; evidence: `declaration-b312b8e25009b0a6c4b117398b7486ee204ca65cecb8c27167acf5585d2934eb`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-272f64a45c65a571"></a>
### sysMark

```java
@Schema(description = "\u7cfb\u7edf\u7528\u6237\u6807\u8bc6(\u5982\u529f\u80fd\u7aef,\u540e\u53f0\u7aef)")
@TableField(value = "`sys_mark`")
private String sysMark
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:116`; evidence: `declaration-272f64a45c65a571508e335341e15dd930014fd12aa06a8796b764af8dbdda53`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
系统用户标识(如功能端,后台端)
```


<a id="symbol-5c6acbd0898d80f3"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
@TableField(value = "`create_by`", fill = FieldFill.INSERT)
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:122`; evidence: `declaration-5c6acbd0898d80f3c4dbd8617b22ee7c3704e9947e19f8b2ffbe30b8f241dbd1`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-7b398ac5b7d63dfa"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
@TableField(value = "`create_name`", fill = FieldFill.INSERT)
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:128`; evidence: `declaration-7b398ac5b7d63dfa58030c8a9bab773738997e06cbdbfd8d128cdc232c07ae91`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-c2b5cbcf4f669edb"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
@TableField(value = "`update_by`", fill = FieldFill.UPDATE)
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:134`; evidence: `declaration-c2b5cbcf4f669edbb4f784135ec05ffac866e34063d8cb77f769dea9849f98c0`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-81942ceb08b40e03"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
@TableField(value = "`update_name`", fill = FieldFill.UPDATE)
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:140`; evidence: `declaration-81942ceb08b40e0302bfcbf929b64894aaedc0f20711d63c2cff98592d05df32`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-0e810b77f0f959d6"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@TableField(value = "`create_time`")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:146`; evidence: `declaration-0e810b77f0f959d60e371a8a4f0ab85dbd5c3fcb70af53ee1ca90d3a8756cef1`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-e55813cb51979da7"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@TableField(value = "`update_time`")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:152`; evidence: `declaration-e55813cb51979da7de0de2b43ce7094a12d7df3ea85a7990d050c8241424142e`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```
