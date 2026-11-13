# com.fairychar.security.core.rbac.mapper.SystemRoleMapper.pageAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemRoleMapper.java.md)

[Lexical owner](SystemRoleMapper.md#symbol-c4b6438b72f4b9e1)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-6a6b0c33f1d2c203"></a>
## com.fairychar.security.core.rbac.mapper.SystemRoleMapper.pageAllSelective

```java
Page<SystemRole> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SystemRole systemRole)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SystemRoleMapper.java:68`; evidence: `declaration-6a6b0c33f1d2c203c046defd9e3849155cca01e3820937761fd2467b2bab6579`.
Owner: `com.fairychar.security.core.rbac.mapper.SystemRoleMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SystemRole所有数据指定column

 @param page       分页参数
 @param systemRole {@see SystemRole}查询条件
 @return 查询结果 {@see SystemRole}
```
