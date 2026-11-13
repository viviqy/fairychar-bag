# com.fairychar.security.core.rbac.mapper.SystemRoleMapper.queryOneSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemRoleMapper.java.md)

[Lexical owner](SystemRoleMapper.md#symbol-c4b6438b72f4b9e1)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-e1be5b9b205924e1"></a>
## com.fairychar.security.core.rbac.mapper.SystemRoleMapper.queryOneSelective

```java
SystemRole queryOneSelective(@Param("fields") String[] fields, @Param("e") SystemRole systemRole)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SystemRoleMapper.java:34`; evidence: `declaration-e1be5b9b205924e18ae8cbf054dedbf69c222d46eee513dd0cf9591ab15f4cbe`.
Owner: `com.fairychar.security.core.rbac.mapper.SystemRoleMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询SystemRole单条数据指定column

 @param systemRole {@see SystemRole}查询条件
 @return 查询结果 {@see SystemRole}
```
