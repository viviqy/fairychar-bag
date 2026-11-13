# com.fairychar.security.core.rbac.pojo.query.SysApiQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-7f2d30576c421f95"></a>
## com.fairychar.security.core.rbac.pojo.query.SysApiQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysApiQuery")
public class SysApiQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysApiQuery.java:19`; evidence: `declaration-7f2d30576c421f95977b18e84760c10c2c4b9e818a137e400c5e0426f3d8cacf`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(SysApi)表实体类

 @author chiyo
```


## Fields

<a id="symbol-a4c6c480399d2635"></a>
### id

```java
@Schema(description = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysApiQuery.java:27`; evidence: `declaration-a4c6c480399d26353ed6d35efc9561e078b5e6b1488df12e49da5590efc9ec07`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-9a41dc3704188b24"></a>
### ids

```java
@Schema(description = "\u6392\u9664\u7684ids")
private List<Long> ids
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysApiQuery.java:30`; evidence: `declaration-9a41dc3704188b243977ad2332ac5cc0239f25c8a547a8479d471cf1a7eaa399`.
Visibility: `private` (explicit).
Type: `List<Long>`.
No initializer recorded.

<a id="symbol-5d4c640a747ad888"></a>
### httpMethod

```java
@Schema(description = "http\u8bf7\u6c42\u65b9\u6cd5")
private String httpMethod
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysApiQuery.java:35`; evidence: `declaration-5d4c640a747ad888117ebea2e00a552cbf07a8469f1cff8b089a36ff5563a2bc`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
http请求方法
```


<a id="symbol-11b884ce04d3c9b7"></a>
### uri

```java
@Schema(description = "\u8bf7\u6c42\u63a5\u53e3\u8def\u5f84,\u4f7f\u7528antMatch\u65b9\u5f0f")
private String uri
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysApiQuery.java:40`; evidence: `declaration-11b884ce04d3c9b77fae0f0d2d6d0e37a04bc9c0bc6b4175c6f0c2f4c17dae18`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
请求接口路径,使用antMatch方式
```


<a id="symbol-69e9f8e9e9906af5"></a>
### description

```java
@Schema(description = "\u63a5\u53e3\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysApiQuery.java:45`; evidence: `declaration-69e9f8e9e9906af51001d63b45c2209c5b2e11047ecef1fc7cb1c426478cf82a`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
接口描述
```


<a id="symbol-aa633507a60dfef3"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysApiQuery.java:50`; evidence: `declaration-aa633507a60dfef3b5f5ec4755c50c3a181e873da99082c1ec6841b3ff18f975`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-964da661c532ae02"></a>
### pageQuery

```java
@Schema(description = "\u5206\u9875\u53c2\u6570")
private Page pageQuery = new Page()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysApiQuery.java:55`; evidence: `declaration-964da661c532ae02273f23118058cf399b6d0d4e73299dd486eca435b414ea65`.
Visibility: `private` (explicit).
Type: `Page`.

Source docstring (unreviewed):
```text
分页请求参数
```
