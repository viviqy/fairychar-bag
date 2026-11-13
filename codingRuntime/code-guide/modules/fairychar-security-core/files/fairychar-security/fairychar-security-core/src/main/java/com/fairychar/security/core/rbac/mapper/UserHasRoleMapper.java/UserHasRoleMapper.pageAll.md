# com.fairychar.security.core.rbac.mapper.UserHasRoleMapper.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UserHasRoleMapper.java.md)

[Lexical owner](UserHasRoleMapper.md#symbol-4f95e15934606118)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-c974e28c4434ec64"></a>
## com.fairychar.security.core.rbac.mapper.UserHasRoleMapper.pageAll

```java
Page<UserHasRole> pageAll(@Param("page") IPage page, @Param("e") UserHasRole userHasRole)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/UserHasRoleMapper.java:59`; evidence: `declaration-c974e28c4434ec646be1da771dd245b29c452d25c992807d8eec25b9b486e3d6`.
Owner: `com.fairychar.security.core.rbac.mapper.UserHasRoleMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询UserHasRole所有数据

 @param page        分页参数
 @param userHasRole {@see UserHasRole}查询条件
 @return 查询结果 {@see UserHasRole}
```
