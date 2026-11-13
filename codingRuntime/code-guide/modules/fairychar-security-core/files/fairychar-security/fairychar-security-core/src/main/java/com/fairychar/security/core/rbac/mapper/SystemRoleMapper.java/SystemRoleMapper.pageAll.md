# com.fairychar.security.core.rbac.mapper.SystemRoleMapper.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemRoleMapper.java.md)

[Lexical owner](SystemRoleMapper.md#symbol-c4b6438b72f4b9e1)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f9a8df275f191c22"></a>
## com.fairychar.security.core.rbac.mapper.SystemRoleMapper.pageAll

```java
Page<SystemRole> pageAll(@Param("page") IPage page, @Param("e") SystemRole systemRole)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SystemRoleMapper.java:59`; evidence: `declaration-f9a8df275f191c22e0204bbcd36c5460513ae9c20d026419e4b786ec14ef965d`.
Owner: `com.fairychar.security.core.rbac.mapper.SystemRoleMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SystemRole所有数据

 @param page       分页参数
 @param systemRole {@see SystemRole}查询条件
 @return 查询结果 {@see SystemRole}
```
