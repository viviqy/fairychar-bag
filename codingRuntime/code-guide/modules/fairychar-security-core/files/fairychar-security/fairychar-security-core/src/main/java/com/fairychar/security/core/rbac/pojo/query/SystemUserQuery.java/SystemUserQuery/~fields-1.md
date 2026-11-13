# com.fairychar.security.core.rbac.pojo.query.SystemUserQuery fields

Snapshot: `snapshot-20261113T014229Z-bb422342`

[Owner / index](../SystemUserQuery.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-2fdbb046c909e937"></a>
### id

```java
@Schema(description = "ID")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:31`; evidence: `declaration-2fdbb046c909e9371dfc5d3be2116a5ea34d428e06f65502300e0a7fb1d99f56`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-9d44e928aed39b87"></a>
### uid

```java
@Schema(description = "uid")
private Long uid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:36`; evidence: `declaration-9d44e928aed39b874447c35d46f30e2dff613f40e502c8351eb77ea8298298b4`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
uid
```


<a id="symbol-e778bee29e1502cf"></a>
### username

```java
@Schema(description = "\u7528\u6237\u540d")
private String username
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:41`; evidence: `declaration-e778bee29e1502cf00dbf26f05c3c73fba7518f8f40e557e3bdd5bb9b316e634`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
用户名
```


<a id="symbol-ebc97d5bbab12a3d"></a>
### nickName

```java
@Schema(description = "\u6635\u79f0")
private String nickName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:46`; evidence: `declaration-ebc97d5bbab12a3d0491d59cabed959cd8e2da39d7590576098d1aa662e5da68`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
昵称
```


<a id="symbol-819724988139b75b"></a>
### gender

```java
@Schema(description = "\u6027\u522b")
private String gender
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:51`; evidence: `declaration-819724988139b75b024b1c9cf58cf8f0e0a9937ddf88189435649fdef2f6350f`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
性别
```


<a id="symbol-ec42da51c8fa643f"></a>
### phone

```java
@Schema(description = "\u624b\u673a\u53f7\u7801")
private String phone
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:56`; evidence: `declaration-ec42da51c8fa643ffcaceb6dfe5b4c742737ad6f243937ffa19c1415af981c92`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
手机号码
```


<a id="symbol-a7bff71ad17a4d19"></a>
### email

```java
@Schema(description = "\u90ae\u7bb1")
private String email
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:61`; evidence: `declaration-a7bff71ad17a4d195936732db3a3a5fb54ed2ed7f13a3a6c842f67df08a0e786`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
邮箱
```


<a id="symbol-fcfd81f4a19fea08"></a>
### avatarPath

```java
@Schema(description = "\u5934\u50cf\u8def\u5f84")
private String avatarPath
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:66`; evidence: `declaration-fcfd81f4a19fea08fb99ee2ddad8e1094159c2446835df08454812971152f84e`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
头像路径
```


<a id="symbol-a8fe0f7636b583c8"></a>
### password

```java
@Schema(description = "\u5bc6\u7801")
private String password
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:71`; evidence: `declaration-a8fe0f7636b583c86e7d29638d3a0897379851eac7bd7f27df40e9dd23633efc`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
密码
```


<a id="symbol-b09e1920eb9c79c6"></a>
### enabled

```java
@Schema(description = "\u72b6\u6001\uff1a1\u542f\u7528\u30010\u7981\u7528")
private Boolean enabled
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:76`; evidence: `declaration-b09e1920eb9c79c6d8b3b381fbeb443ba16d66d1a1b6fd911e5c76d8747a7f40`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
状态：1启用、0禁用
```


<a id="symbol-3fcb69a73ef25198"></a>
### pwdResetTime

```java
@Schema(description = "\u4fee\u6539\u5bc6\u7801\u7684\u65f6\u95f4")
private LocalDateTime pwdResetTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:81`; evidence: `declaration-3fcb69a73ef25198723d3dca49c0f10e50d1d273ff2e6dccc2f2bf1fd4f25b7c`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改密码的时间
```


<a id="symbol-c74e3d232c16975a"></a>
### expired

```java
@Schema(description = "\u662f\u5426\u8fc7\u671f")
private Boolean expired
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:86`; evidence: `declaration-c74e3d232c16975ad5ca4c47c3bd5c460f7a1cd3c8fe63c4b0bf90d60b0cb9a3`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否过期
```


<a id="symbol-0165bcbef4d72352"></a>
### locked

```java
@Schema(description = "\u662f\u5426\u88ab\u51bb\u7ed3")
private Boolean locked
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:91`; evidence: `declaration-0165bcbef4d72352a533a4c7763e001e5d6a5c753aef63bfc9c093888d927d30`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否被冻结
```


<a id="symbol-48b93b2806aee39c"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:96`; evidence: `declaration-48b93b2806aee39cd0a670db9988177c4cd1cf003c59c97e9651f41fd4581b62`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-390f9f9906e58dda"></a>
### sysMark

```java
@Schema(description = "\u7cfb\u7edf\u7528\u6237\u6807\u8bc6(\u5982\u529f\u80fd\u7aef,\u540e\u53f0\u7aef)")
private String sysMark
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:101`; evidence: `declaration-390f9f9906e58dda667d06156179c45260ffb4325a2cd868839ab60cbfc24c0a`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
系统用户标识(如功能端,后台端)
```


<a id="symbol-9e56e704027b87a6"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:106`; evidence: `declaration-9e56e704027b87a67b5c4012b0f2535559da8baadd36cd65d38b36e9dad2572c`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-1c68f7663d59aae7"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:111`; evidence: `declaration-1c68f7663d59aae74b778134eaab895868b64cd52719112ce6f82244270a5b84`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-afb722515d5e9be7"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:116`; evidence: `declaration-afb722515d5e9be7b0e61ac8f6ae1d92254fbf5d0f4db82789262d72722c8cf6`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-0c7e547661a0efb7"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:121`; evidence: `declaration-0c7e547661a0efb78e71c3ed4d334f3affa7092e4919f46dc5296c9330626479`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-45d00df4875a956a"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:126`; evidence: `declaration-45d00df4875a956a449858112a160ce29ae03f94da2dba41807933c51085b91f`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-2cd6634d8740f5e2"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:132`; evidence: `declaration-2cd6634d8740f5e275dab3c591adda25c7a68d65eed9c48f2d795c8b0a84c513`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-d096e4dff7d572b7"></a>
### pageQuery

```java
@Schema(description = "\u5206\u9875\u53c2\u6570")
private Page pageQuery = new Page()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemUserQuery.java:138`; evidence: `declaration-d096e4dff7d572b7165df5edb9a6211b7705e0aaa28ca6d666318790e24fc085`.
Visibility: `private` (explicit).
Type: `Page`.

Source docstring (unreviewed):
```text
分页请求参数
```
