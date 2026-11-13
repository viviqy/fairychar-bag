# com.fairychar.security.core.rbac.mapper.SystemRoleMapper.queryAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemRoleMapper.java.md)

[Lexical owner](SystemRoleMapper.md#symbol-c4b6438b72f4b9e1)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-84ac7a28fd19a053"></a>
## com.fairychar.security.core.rbac.mapper.SystemRoleMapper.queryAllSelective

```java
List<SystemRole> queryAllSelective(@Param("fields") String[] fields, @Param("e") SystemRole systemRole)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SystemRoleMapper.java:50`; evidence: `declaration-84ac7a28fd19a05358073aff3175599d8d628d2bf82a8aafc7ec143999344cbf`.
Owner: `com.fairychar.security.core.rbac.mapper.SystemRoleMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询SystemRole所有数据指定column

 @param systemRole {@see SystemRole}查询条件
 @return 查询结果 {@see SystemRole}
```
