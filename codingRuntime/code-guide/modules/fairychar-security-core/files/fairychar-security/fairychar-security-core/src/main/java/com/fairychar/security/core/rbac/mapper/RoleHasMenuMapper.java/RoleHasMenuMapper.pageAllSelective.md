# com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper.pageAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RoleHasMenuMapper.java.md)

[Lexical owner](RoleHasMenuMapper.md#symbol-33c2ea78b3e32bb8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ec3002692ac5658b"></a>
## com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper.pageAllSelective

```java
Page<RoleHasMenu> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") RoleHasMenu roleHasMenu)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/RoleHasMenuMapper.java:68`; evidence: `declaration-ec3002692ac5658bdf3ae1a2d08535d4193a30f005d71769eddc41a196c2e052`.
Owner: `com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询RoleHasMenu所有数据指定column

 @param page        分页参数
 @param roleHasMenu {@see RoleHasMenu}查询条件
 @return 查询结果 {@see RoleHasMenu}
```
