# com.fairychar.security.core.rbac.service.SystemUserService.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemUserService.java.md)

[Lexical owner](SystemUserService.md#symbol-3d18f01dd5f00664)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-00d9b50b1b06d6ad"></a>
## com.fairychar.security.core.rbac.service.SystemUserService.pageAll

```java
@Override
    public Page<SystemUserDTO> pageAll(SystemUserQuery systemUserQuery)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SystemUserService.java:59`; evidence: `declaration-00d9b50b1b06d6ad7d592dd94ceab6387911cc0347e1935348204673cabebb7e`.
Owner: `com.fairychar.security.core.rbac.service.SystemUserService`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
条件匹配分页查询SystemUser所有数据
 @param systemUserQuery {@link SystemUserQuery}查询条件
 @return 查询结果 {@link SystemUserDTO}
```
