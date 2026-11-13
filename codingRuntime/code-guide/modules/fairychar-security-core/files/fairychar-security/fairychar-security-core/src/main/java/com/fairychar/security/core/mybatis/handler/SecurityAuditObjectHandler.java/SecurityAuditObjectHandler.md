# com.fairychar.security.core.mybatis.handler.SecurityAuditObjectHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAuditObjectHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-78cdb8b8a4fc8e6d"></a>
## com.fairychar.security.core.mybatis.handler.SecurityAuditObjectHandler

```java
public class SecurityAuditObjectHandler implements MetaObjectHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/SecurityAuditObjectHandler.java:18`; evidence: `declaration-78cdb8b8a4fc8e6d791c8267ba7a38c663ace8807188b9c2144f3d82b0a6b35c`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于spring security的mybatis用户审计操作拦截赋值器

 @author chiyo
 @since 1.3.3
```


## Fields

<a id="symbol-127b424abebdc89f"></a>
### createBy

```java
private final String createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/SecurityAuditObjectHandler.java:34`; evidence: `declaration-127b424abebdc89fcc72e0388f2250ca1cf7e36a7f4c4df177b30e6e44e04601`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-5ff0bd2c5eb304b1"></a>
### createTime

```java
private final String createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/SecurityAuditObjectHandler.java:35`; evidence: `declaration-5ff0bd2c5eb304b191b0aeb8a8ce763c55e592a84f5d2409d6a3977a27a96a59`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-026846113eab7926"></a>
### updateBy

```java
private final String updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/SecurityAuditObjectHandler.java:36`; evidence: `declaration-026846113eab792671ca481ef72476f17783c04bb12f1ed8d640659067a819dc`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-715940522b949e1c"></a>
### updateTime

```java
private final String updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/mybatis/handler/SecurityAuditObjectHandler.java:37`; evidence: `declaration-715940522b949e1ca2b33bcd77a53737e0c4370b73089b2614cdb8e25426921c`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

## Members

- [SecurityAuditObjectHandler](SecurityAuditObjectHandler.SecurityAuditObjectHandler--855c1ba3be2ef783.md#symbol-9a0f8aee827eb57f) — `constructor`, source line 20
- [SecurityAuditObjectHandler](SecurityAuditObjectHandler.SecurityAuditObjectHandler--a14889bcb3e0ba7a.md#symbol-c7907f6c3b0fe417) — `constructor`, source line 27
- [insertFill](SecurityAuditObjectHandler.insertFill.md#symbol-2b0188195addad9f) — `function`, source line 39
- [updateFill](SecurityAuditObjectHandler.updateFill.md#symbol-f8149e2de36365df) — `function`, source line 53
