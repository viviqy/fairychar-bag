# com.fairychar.security.core.rbac.pojo.query.AddSysApiQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AddSysApiQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-a6f8fe8c1072b06b"></a>
## com.fairychar.security.core.rbac.pojo.query.AddSysApiQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddSysApiQuery")
public class AddSysApiQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysApiQuery.java:19`; evidence: `declaration-a6f8fe8c1072b06b9905621ec448e29b624dc871a003e5dc4cb80aa6db062d4d`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(SysApi)表实体类

 @author chiyo
```


## Fields

<a id="symbol-60a6d687d434cf71"></a>
### httpMethod

```java
@Schema(description = "http\u8bf7\u6c42\u65b9\u6cd5")
@NotEmpty(message = "\u8bf7\u6c42\u65b9\u6cd5\u4e0d\u80fd\u4e3a\u7a7a")
@In(value = {"GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE"}, message = "http\u8bf7\u6c42\u65b9\u5f0f\u9519\u8bef")
private String httpMethod
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysApiQuery.java:30`; evidence: `declaration-60a6d687d434cf7136b6e96c7a9136d015293d4f4d35cd9426303aa2b28ef114`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
http请求方法
```


<a id="symbol-417808695becb01f"></a>
### uri

```java
@Schema(description = "\u8bf7\u6c42\u63a5\u53e3\u8def\u5f84,\u4f7f\u7528antMatch\u65b9\u5f0f")
@NotEmpty(message = "\u8bf7\u6c42uri\u4e0d\u80fd\u4e3a\u7a7a")
private String uri
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysApiQuery.java:37`; evidence: `declaration-417808695becb01fb39ecd2320f472874b88c6cbfd3c509abb78279abf930f8d`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
请求接口路径,使用antMatch方式
```


<a id="symbol-dd13ab1cb8be11d3"></a>
### description

```java
@Schema(description = "\u63a5\u53e3\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysApiQuery.java:43`; evidence: `declaration-dd13ab1cb8be11d34a54f4044d93777d878cbc8e2bf1b52c24dca13b3bd21bfb`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
接口描述
```


<a id="symbol-f5984e9d295174e3"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort = 0
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysApiQuery.java:48`; evidence: `declaration-f5984e9d295174e3ba4c74b39f529e531af5f359b961dd7004fb1e235028393c`.
Visibility: `private` (explicit).
Type: `Integer`.

Source docstring (unreviewed):
```text
排序
```
