# com.fairychar.security.core.rbac.mapper.UserHasRoleMapper.queryOneSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UserHasRoleMapper.java.md)

[Lexical owner](UserHasRoleMapper.md#symbol-4f95e15934606118)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-1028c855e947b7f0"></a>
## com.fairychar.security.core.rbac.mapper.UserHasRoleMapper.queryOneSelective

```java
UserHasRole queryOneSelective(@Param("fields") String[] fields, @Param("e") UserHasRole userHasRole)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/UserHasRoleMapper.java:34`; evidence: `declaration-1028c855e947b7f000480162ee2b15458d42203d342570ecd18eed7c642b6448`.
Owner: `com.fairychar.security.core.rbac.mapper.UserHasRoleMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询UserHasRole单条数据指定column

 @param userHasRole {@see UserHasRole}查询条件
 @return 查询结果 {@see UserHasRole}
```
