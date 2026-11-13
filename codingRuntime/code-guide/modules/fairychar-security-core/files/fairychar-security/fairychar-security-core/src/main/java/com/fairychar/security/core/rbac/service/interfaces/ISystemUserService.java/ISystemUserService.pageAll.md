# com.fairychar.security.core.rbac.service.interfaces.ISystemUserService.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ISystemUserService.java.md)

[Lexical owner](ISystemUserService.md#symbol-9662c6f0e4479b58)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-1149993c408a6d10"></a>
## com.fairychar.security.core.rbac.service.interfaces.ISystemUserService.pageAll

```java
Page<SystemUserDTO> pageAll(SystemUserQuery systemUserQuery)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/interfaces/ISystemUserService.java:39`; evidence: `declaration-1149993c408a6d1017511e4341995741d4668ab68fe1d7a2cd18f0b4da744759`.
Owner: `com.fairychar.security.core.rbac.service.interfaces.ISystemUserService`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SystemUser所有数据

 @param systemUserQuery {@link SystemUserQuery}查询条件
 @return 查询结果 {@link SystemUserDTO}
```
