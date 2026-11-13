# com.fairychar.security.core.rbac.pojo.query.UpdateSysApiQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UpdateSysApiQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8e150dc8d419c007"></a>
## com.fairychar.security.core.rbac.pojo.query.UpdateSysApiQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "UpdateSysApiQuery")
public class UpdateSysApiQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysApiQuery.java:20`; evidence: `declaration-8e150dc8d419c00747b3b5faab4be594510bc62e938a84081cf93c12aae3fff4`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(SysApi)表实体类

 @author chiyo
```


## Fields

<a id="symbol-f59363aac71c1713"></a>
### id

```java
@Schema(description = "id")
@NotNull(message = "id\u4e0d\u80fd\u4e3anull")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysApiQuery.java:28`; evidence: `declaration-f59363aac71c1713896106a2633503b2e919a2e1e9c02614a2648ba2cb56a817`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-9ee38f6c4924cad5"></a>
### httpMethod

```java
@Schema(description = "http\u8bf7\u6c42\u65b9\u6cd5")
@NotEmpty(message = "\u8bf7\u6c42\u65b9\u6cd5\u4e0d\u80fd\u4e3a\u7a7a")
@In(value = {"GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE"}, message = "http\u8bf7\u6c42\u65b9\u5f0f\u9519\u8bef")
private String httpMethod
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysApiQuery.java:34`; evidence: `declaration-9ee38f6c4924cad5c3fb950ba84310908e072908a75d99e9f0eb019a69d1dae4`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
http请求方法
```


<a id="symbol-e1048c03ab39cb60"></a>
### uri

```java
@Schema(description = "\u8bf7\u6c42\u63a5\u53e3\u8def\u5f84,\u4f7f\u7528antMatch\u65b9\u5f0f")
@NotEmpty(message = "\u8bf7\u6c42\u63a5\u53e3\u4e0d\u80fd\u4e3a\u7a7a")
private String uri
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysApiQuery.java:41`; evidence: `declaration-e1048c03ab39cb604171458ae952dc52295b63863a3c444f61102946ef5c186c`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
请求接口路径,使用antMatch方式
```


<a id="symbol-ef0c9f807a1b8054"></a>
### description

```java
@Schema(description = "\u63a5\u53e3\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysApiQuery.java:47`; evidence: `declaration-ef0c9f807a1b8054efab0ac614894b90fa7e2e8e97b839e058e94dd2deea0fc1`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
接口描述
```


<a id="symbol-8abb33f841c62dc0"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysApiQuery.java:52`; evidence: `declaration-8abb33f841c62dc0f4fe18efccae1023bc0ea4083dc7972febed8aa41c03f4ed`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```
