# com.fairychar.security.core.rbac.service.SystemRoleService.pageByRoot

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemRoleService.java.md)

[Lexical owner](SystemRoleService.md#symbol-5f1752eb668845ab)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-55b6459215fd712e"></a>
## com.fairychar.security.core.rbac.service.SystemRoleService.pageByRoot

```java
@Override
    public Page<SystemRoleDTO> pageByRoot(SystemRoleQuery sysApiQuery)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SystemRoleService.java:45`; evidence: `declaration-55b6459215fd712eb43d48ba84e9baeeb26c1b6e4318c9049d67ef1a4ae311f8`.
Owner: `com.fairychar.security.core.rbac.service.SystemRoleService`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
条件匹配分页查询SysMenu所有数据

 @param sysApiQuery {@link SystemRoleQuery}查询条件
 @return 查询结果 {@link SystemRoleDTO}
```
