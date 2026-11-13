# com.fairychar.security.core.rbac.mapper.UserHasRoleMapper.pageAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UserHasRoleMapper.java.md)

[Lexical owner](UserHasRoleMapper.md#symbol-4f95e15934606118)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-96427abae6faf521"></a>
## com.fairychar.security.core.rbac.mapper.UserHasRoleMapper.pageAllSelective

```java
Page<UserHasRole> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") UserHasRole userHasRole)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/UserHasRoleMapper.java:68`; evidence: `declaration-96427abae6faf521a5d65d657f72126a53f0aac3f75a46cbb637cf221229e3fe`.
Owner: `com.fairychar.security.core.rbac.mapper.UserHasRoleMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询UserHasRole所有数据指定column

 @param page        分页参数
 @param userHasRole {@see UserHasRole}查询条件
 @return 查询结果 {@see UserHasRole}
```
