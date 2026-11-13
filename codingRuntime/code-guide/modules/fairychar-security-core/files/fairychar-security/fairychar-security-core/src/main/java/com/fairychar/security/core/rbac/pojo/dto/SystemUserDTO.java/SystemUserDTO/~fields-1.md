# com.fairychar.security.core.rbac.pojo.dto.SystemUserDTO fields

Snapshot: `snapshot-20261113T014229Z-bb422342`

[Owner / index](../SystemUserDTO.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-36846984aaef03f3"></a>
### id

```java
@Schema(description = "ID")
@JsonFormat(shape = JsonFormat.Shape.STRING)
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:29`; evidence: `declaration-36846984aaef03f331b24d70545b7b7b83e59960c7dfe3294074ab0e553153e6`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-b639c402fa26ba56"></a>
### uid

```java
@Schema(description = "uid")
private Long uid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:35`; evidence: `declaration-b639c402fa26ba56f626580e957ad7de59ce615a31ceb91e809a1a1364c15a1f`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
uid
```


<a id="symbol-dc443694bca0c47f"></a>
### username

```java
@Schema(description = "\u7528\u6237\u540d")
private String username
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:40`; evidence: `declaration-dc443694bca0c47fcb76a3e678ea7e4c2d4b446ee90b81d3d3b2c234f8be1e44`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
用户名
```


<a id="symbol-177f759ce2d7cd71"></a>
### nickName

```java
@Schema(description = "\u6635\u79f0")
private String nickName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:45`; evidence: `declaration-177f759ce2d7cd71bbc11009466c3a65d376a21cb92547779faf07b133322628`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
昵称
```


<a id="symbol-ef02f6816ea9b5f5"></a>
### gender

```java
@Schema(description = "\u6027\u522b")
private String gender
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:50`; evidence: `declaration-ef02f6816ea9b5f58fec93ea3f19314df1848ea5ef7bf67c9cb701c5a3e99827`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
性别
```


<a id="symbol-ffa9b2a5bda6fdfe"></a>
### phone

```java
@Schema(description = "\u624b\u673a\u53f7\u7801")
private String phone
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:55`; evidence: `declaration-ffa9b2a5bda6fdfe9946be0957190f06c38586482d678721da058c3ff20a6f20`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
手机号码
```


<a id="symbol-8e6a2ed3e23be607"></a>
### email

```java
@Schema(description = "\u90ae\u7bb1")
private String email
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:60`; evidence: `declaration-8e6a2ed3e23be607ebfa1caa3650115fde7e212857fb8cfd9f643e485a63e6f0`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
邮箱
```


<a id="symbol-331300e81631219c"></a>
### avatarPath

```java
@Schema(description = "\u5934\u50cf\u8def\u5f84")
private String avatarPath
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:65`; evidence: `declaration-331300e81631219cd0cd63b7205f7142111894d72fdaad61e0e1c252d9e39e96`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
头像路径
```


<a id="symbol-0ec105c26531c972"></a>
### password

```java
@Schema(description = "\u5bc6\u7801")
private String password
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:70`; evidence: `declaration-0ec105c26531c9728720b6b7ab4d87de6d293bbfcfbb5b9c9f62536b52d8760e`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
密码
```


<a id="symbol-2520a0f76bcbed97"></a>
### enabled

```java
@Schema(description = "\u72b6\u6001\uff1a1\u542f\u7528\u30010\u7981\u7528")
private Boolean enabled
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:75`; evidence: `declaration-2520a0f76bcbed97c140b1302e31c0aac0a8032a6c307e7e7b9a2b0496233fe8`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
状态：1启用、0禁用
```


<a id="symbol-f748b2e6a84ea301"></a>
### pwdResetTime

```java
@Schema(description = "\u4fee\u6539\u5bc6\u7801\u7684\u65f6\u95f4")
private LocalDateTime pwdResetTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:80`; evidence: `declaration-f748b2e6a84ea30143608d92b74e9170099630fbc37074c5153b594d8bde6643`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改密码的时间
```


<a id="symbol-9703528e186f6f79"></a>
### expired

```java
@Schema(description = "\u662f\u5426\u8fc7\u671f")
private Boolean expired
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:85`; evidence: `declaration-9703528e186f6f793a8ce36add4fe52a3aeb04dc97f9ee003a19a87ce173623d`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否过期
```


<a id="symbol-868722085e17367a"></a>
### locked

```java
@Schema(description = "\u662f\u5426\u88ab\u51bb\u7ed3")
private Boolean locked
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:90`; evidence: `declaration-868722085e17367ac6e726d4d5f615b24ce31f08f63c05bac5b8eb734b9227ec`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否被冻结
```


<a id="symbol-a4d1078a7b018330"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:95`; evidence: `declaration-a4d1078a7b018330f2edabd60875aac1b75e0f876678f5d1f52f178bd9e09dcc`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-a1582e4097edf9b3"></a>
### sysMark

```java
@Schema(description = "\u7cfb\u7edf\u7528\u6237\u6807\u8bc6(\u5982\u529f\u80fd\u7aef,\u540e\u53f0\u7aef)")
private String sysMark
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:100`; evidence: `declaration-a1582e4097edf9b32964ab71facd6269940c193df8744cb13b0500169a435067`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
系统用户标识(如功能端,后台端)
```


<a id="symbol-f980b08b78894d9c"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:105`; evidence: `declaration-f980b08b78894d9cb69d8336a7a37a0a1f1701788a21f4c753c45fee4c940aec`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-8522114c20907f83"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:110`; evidence: `declaration-8522114c20907f8329ed7e0fc3bfd1472e7432e8561d271015378d36f51db1ac`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-d831384c04238040"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:115`; evidence: `declaration-d831384c0423804074f83719129273ec79adfaebfbc3fa390533314562988d90`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-ef9c7e21274089cf"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:120`; evidence: `declaration-ef9c7e21274089cfed017d4feb2fe579a0fa849bbdcda40fa61809ef728d1c68`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-ba512b76cac23718"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:125`; evidence: `declaration-ba512b76cac237189a1d3232703e6d30045b504a22ae01cd1459e6671df20a84`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-fb7387fa2099cef2"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemUserDTO.java:131`; evidence: `declaration-fb7387fa2099cef2faba3ccae1b374c6d1909d09eeaaef8ad49afb5dd63a4f3e`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```
