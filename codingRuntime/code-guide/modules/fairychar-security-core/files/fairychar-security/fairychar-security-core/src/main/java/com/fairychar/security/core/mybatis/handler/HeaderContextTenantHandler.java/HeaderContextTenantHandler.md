# com.fairychar.security.core.mybatis.handler.HeaderContextTenantHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../HeaderContextTenantHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d4e416f08fcbe337"></a>
## com.fairychar.security.core.mybatis.handler.HeaderContextTenantHandler

```java
@Slf4j
public class HeaderContextTenantHandler implements TenantLineHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/HeaderContextTenantHandler.java:25`; evidence: `declaration-d4e416f08fcbe337df29f2995a07bd8b945f0fe49fcb5c0f8703c7e9e87229d3`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
该类实现了MyBatis-Plus的TenantLineHandler接口，用于处理多租户的功能。
 在该类中，通过获取HTTP请求的Header中的用户信息，从中提取出租户ID，并将其作为租户ID的表达式返回。
 除此之外，该类还提供了获取租户ID列名和判断是否忽略某个表的方法。

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-cc59cd871571f578"></a>
### ignoreTables

```java
private final Set<String> ignoreTables
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/HeaderContextTenantHandler.java:40`; evidence: `declaration-cc59cd871571f57815186ed7aeb7720cc2384f493e138223c8640a4dd4fedef8`.
Visibility: `private` (explicit).
Type: `Set<String>`.
No initializer recorded.

<a id="symbol-52058202e5545ab9"></a>
### objectMapper

```java
private final ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/HeaderContextTenantHandler.java:41`; evidence: `declaration-52058202e5545ab954832a95ff99c14cfc69df9d39cadddb7c406c9ddb052df2`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-fca0799d26c71444"></a>
### columnName

```java
private String columnName = "tenant_id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/HeaderContextTenantHandler.java:42`; evidence: `declaration-fca0799d26c71444d95313b13a123e96ffc1f3454a7a2c8d887c8e300b89dfdd`.
Visibility: `private` (explicit).
Type: `String`.

<a id="symbol-e08de0399dc4a5d2"></a>
### header

```java
private String header = "user"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/HeaderContextTenantHandler.java:43`; evidence: `declaration-e08de0399dc4a5d2a2a6d969aa28613d380c52a4f1d39b26d6c023ad7ac88373`.
Visibility: `private` (explicit).
Type: `String`.

## Members

- [HeaderContextTenantHandler](HeaderContextTenantHandler.HeaderContextTenantHandler--1410d1fb4879bf4e.md#symbol-439f4ff32ef8e07d) — `constructor`, source line 28
- [HeaderContextTenantHandler](HeaderContextTenantHandler.HeaderContextTenantHandler--ad312d31736e79ea.md#symbol-13a37dced59e92a1) — `constructor`, source line 33
- [getTenantId](HeaderContextTenantHandler.getTenantId.md#symbol-7e438dca33fd6f48) — `function`, source line 45
- [getTenantIdColumn](HeaderContextTenantHandler.getTenantIdColumn.md#symbol-0bdaba8a423a0c30) — `function`, source line 63
- [ignoreTable](HeaderContextTenantHandler.ignoreTable.md#symbol-c8b0021179f13ad0) — `function`, source line 69
