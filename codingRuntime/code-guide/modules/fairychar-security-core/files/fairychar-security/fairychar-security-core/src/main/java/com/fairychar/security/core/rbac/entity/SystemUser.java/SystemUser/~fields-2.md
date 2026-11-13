# com.fairychar.security.core.rbac.entity.SystemUser fields

Snapshot: `snapshot-20261113T014229Z-bb422342`

[Owner / index](../SystemUser.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d9a3462883de2694"></a>
### groupByCount

```java
@TableField(exist = false)
@Schema(description = "\u5206\u7ec4\u6570\u91cf\u5339\u914d\u5b57\u6bb5,\u548c\u539f\u8868\u65e0\u5173")
private Integer groupByCount
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:158`; evidence: `declaration-d9a3462883de269431416e768bb2d60f25120bc8acc17677acb32898c8debe10`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
分组匹配字符
```


<a id="symbol-bd658ba770e3d6a7"></a>
### ID

```java
public static final String ID = "id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:176`; evidence: `declaration-bd658ba770e3d6a7f17243640699a1195efbfbd06f06ab1de776a4c955956f14`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
id - ID
```


<a id="symbol-5531274620c71a4c"></a>
### UID

```java
public static final String UID = "uid"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:181`; evidence: `declaration-5531274620c71a4c668a510f766098a884c931dc1cc1a808f0ae81918b17abc6`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
uid - uid
```


<a id="symbol-b21bf0b8f0d5b421"></a>
### USERNAME

```java
public static final String USERNAME = "username"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:186`; evidence: `declaration-b21bf0b8f0d5b4215ea53a87f37797124048592fa9485f8e5a6a08fa2b5e0542`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
username - 用户名
```


<a id="symbol-e6a7da5bd3b21491"></a>
### NICK_NAME

```java
public static final String NICK_NAME = "nick_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:191`; evidence: `declaration-e6a7da5bd3b2149159a75f54b4ad59b01172a304ec49799edf8a4e9c69d47a72`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
nick_name - 昵称
```


<a id="symbol-4f17424912a05f6a"></a>
### GENDER

```java
public static final String GENDER = "gender"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:196`; evidence: `declaration-4f17424912a05f6af9e77f6550c5c5779f91e1fbb73a3653493f8894d4b072c8`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
gender - 性别
```


<a id="symbol-22920dc800321899"></a>
### PHONE

```java
public static final String PHONE = "phone"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:201`; evidence: `declaration-22920dc8003218995cac806fe9c8f014725fd570f6a5ea8f2037f3c2eba73598`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
phone - 手机号码
```


<a id="symbol-0a0bf9ac47d282a3"></a>
### EMAIL

```java
public static final String EMAIL = "email"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:206`; evidence: `declaration-0a0bf9ac47d282a3797248e0941e86393e26d18a7193670eb5dfaa57ae105466`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
email - 邮箱
```


<a id="symbol-5ac4e15a03daf954"></a>
### AVATAR_PATH

```java
public static final String AVATAR_PATH = "avatar_path"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:211`; evidence: `declaration-5ac4e15a03daf954cc43ec05152a39485cd41a4be8c9088dd70fcd62497906e0`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
avatar_path - 头像路径
```


<a id="symbol-a43886dca4a32d3b"></a>
### PASSWORD

```java
public static final String PASSWORD = "password"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:216`; evidence: `declaration-a43886dca4a32d3bf5d94cb5d5e46358efd66cffbec3a7810cfddd9ad48bd1dc`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
password - 密码
```


<a id="symbol-50adf6dd25693693"></a>
### ENABLED

```java
public static final String ENABLED = "enabled"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:221`; evidence: `declaration-50adf6dd25693693e2d7bc56fa0c333f25069d5c6bf7fde05c01ee2a8340c673`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
enabled - 状态：1启用、0禁用
```


<a id="symbol-972f4437c463df90"></a>
### PWD_RESET_TIME

```java
public static final String PWD_RESET_TIME = "pwd_reset_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:226`; evidence: `declaration-972f4437c463df906ad9d44e0f051b9b8395bc9d4d3ba6778faadd6629618433`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
pwd_reset_time - 修改密码的时间
```


<a id="symbol-b7d376fea7db5d83"></a>
### IS_EXPIRED

```java
public static final String IS_EXPIRED = "is_expired"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:231`; evidence: `declaration-b7d376fea7db5d83ae91f7bf538e38fc66640d232d2a6a35e493d2eaee7de5f9`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
is_expired - 是否过期
```


<a id="symbol-f297d3b5e48215be"></a>
### IS_LOCKED

```java
public static final String IS_LOCKED = "is_locked"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:236`; evidence: `declaration-f297d3b5e48215be13c2ac8440b2b66417f85b5a2c709855df3e4e532ae00cce`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
is_locked - 是否被冻结
```


<a id="symbol-fbf53946053a0a52"></a>
### SORT

```java
public static final String SORT = "sort"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:241`; evidence: `declaration-fbf53946053a0a52fc9f5ae72f1652b681d3897dad5e1994d2f9fa61264188e1`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
sort - 排序
```


<a id="symbol-aadbbb118f5b25ad"></a>
### SYS_MARK

```java
public static final String SYS_MARK = "sys_mark"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:246`; evidence: `declaration-aadbbb118f5b25ad4ca5ef2ae361b9eae7bd390197180c101b665d34dc46fff0`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
sys_mark - 系统用户标识(如功能端,后台端)
```


<a id="symbol-f6dd013fc53df32a"></a>
### CREATE_BY

```java
public static final String CREATE_BY = "create_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:251`; evidence: `declaration-f6dd013fc53df32aa5f82b8d4d325947bfbee4804adaf2464e594b64dc8a850a`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_by - 创建者
```


<a id="symbol-e0072c25015db3ca"></a>
### CREATE_NAME

```java
public static final String CREATE_NAME = "create_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:256`; evidence: `declaration-e0072c25015db3caceb064b6617c99b066132647a321aede31ca3b3758b24b52`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_name - 创建人名称
```


<a id="symbol-90feb9c8cf54e7d6"></a>
### UPDATE_BY

```java
public static final String UPDATE_BY = "update_by"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:261`; evidence: `declaration-90feb9c8cf54e7d6420903b3630edcae38ee404a22865128ab647639cb792598`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_by - 更新者
```


<a id="symbol-7bb5d52808fbfd39"></a>
### UPDATE_NAME

```java
public static final String UPDATE_NAME = "update_name"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:266`; evidence: `declaration-7bb5d52808fbfd396564a5793672ff54f7c750ec7aff25b0f42a854a8eefd508`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_name - 更新人名称
```


<a id="symbol-970821901f7f70a7"></a>
### CREATE_TIME

```java
public static final String CREATE_TIME = "create_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:271`; evidence: `declaration-970821901f7f70a7d6e51773811bbf0565b40a704bb2c4989bcd7a83bad83241`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
create_time - 创建日期
```


<a id="symbol-ba334f599fa4b46e"></a>
### UPDATE_TIME

```java
public static final String UPDATE_TIME = "update_time"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SystemUser.java:276`; evidence: `declaration-ba334f599fa4b46e8a2d1bd7ecad07584e0a49f7f8d15f4c6e4e9b73f95240ce`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
update_time - 更新时间
```
