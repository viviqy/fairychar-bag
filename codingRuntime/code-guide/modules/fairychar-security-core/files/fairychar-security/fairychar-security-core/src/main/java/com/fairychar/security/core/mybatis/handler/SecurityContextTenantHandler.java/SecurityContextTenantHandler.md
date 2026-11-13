# com.fairychar.security.core.mybatis.handler.SecurityContextTenantHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityContextTenantHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-03bb16a4774db930"></a>
## com.fairychar.security.core.mybatis.handler.SecurityContextTenantHandler

```java
@Slf4j
public class SecurityContextTenantHandler implements TenantLineHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/SecurityContextTenantHandler.java:22`; evidence: `declaration-03bb16a4774db9309c67f2625c31eeb70c73e10f78b12d9bc83159c31220b11f`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
该类实现了MyBatis Plus的TenantLineHandler接口，用于处理多租户的行级权限。
 通过SecurityContextHolder获取当前认证的用户信息，从中获取租户ID，并将其作为SQL语句的租户ID条件。
 可以设置忽略的表和租户ID列名。

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-80de387b80d9ea02"></a>
### ignoreTables

```java
private final Set<String> ignoreTables
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/SecurityContextTenantHandler.java:34`; evidence: `declaration-80de387b80d9ea02530bc369d42daa98f37518820a8bff33ebaac9cc665c32f8`.
Visibility: `private` (explicit).
Type: `Set<String>`.
No initializer recorded.

<a id="symbol-dca765c0c461ce16"></a>
### columnName

```java
private String columnName = "tenant_id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/SecurityContextTenantHandler.java:35`; evidence: `declaration-dca765c0c461ce162bf4f3e1a12c0aee3a9304a21fd6d6bdcfbe7187a372eb5c`.
Visibility: `private` (explicit).
Type: `String`.

## Members

- [SecurityContextTenantHandler](SecurityContextTenantHandler.SecurityContextTenantHandler--0fd14f71089fbde2.md#symbol-166e7892b8a46da3) — `constructor`, source line 25
- [SecurityContextTenantHandler](SecurityContextTenantHandler.SecurityContextTenantHandler--6bbdf825ac73defe.md#symbol-228993611425e440) — `constructor`, source line 29
- [getTenantId](SecurityContextTenantHandler.getTenantId.md#symbol-ab8d51fa2e88ef44) — `function`, source line 37
- [getTenantIdColumn](SecurityContextTenantHandler.getTenantIdColumn.md#symbol-77b85210a3fe23ce) — `function`, source line 46
- [ignoreTable](SecurityContextTenantHandler.ignoreTable.md#symbol-57b9ec036b2ea9cc) — `function`, source line 52
