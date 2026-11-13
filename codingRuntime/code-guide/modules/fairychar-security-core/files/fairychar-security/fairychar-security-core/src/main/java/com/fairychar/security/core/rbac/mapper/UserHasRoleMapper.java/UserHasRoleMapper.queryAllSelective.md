# com.fairychar.security.core.rbac.mapper.UserHasRoleMapper.queryAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UserHasRoleMapper.java.md)

[Lexical owner](UserHasRoleMapper.md#symbol-4f95e15934606118)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-008983cf1bd37fd2"></a>
## com.fairychar.security.core.rbac.mapper.UserHasRoleMapper.queryAllSelective

```java
List<UserHasRole> queryAllSelective(@Param("fields") String[] fields, @Param("e") UserHasRole userHasRole)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/UserHasRoleMapper.java:50`; evidence: `declaration-008983cf1bd37fd215d1a92ffd82a07f1cd011046bea9a292d31800cdafc3f08`.
Owner: `com.fairychar.security.core.rbac.mapper.UserHasRoleMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询UserHasRole所有数据指定column

 @param userHasRole {@see UserHasRole}查询条件
 @return 查询结果 {@see UserHasRole}
```
