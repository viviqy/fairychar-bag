# com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RoleHasMenuMapper.java.md)

[Lexical owner](RoleHasMenuMapper.md#symbol-33c2ea78b3e32bb8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-b695af464e6df636"></a>
## com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper.pageAll

```java
Page<RoleHasMenu> pageAll(@Param("page") IPage page, @Param("e") RoleHasMenu roleHasMenu)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/RoleHasMenuMapper.java:59`; evidence: `declaration-b695af464e6df63674ad0545e9c0990525ccb85bc1077162fe1a9c9ad01162ff`.
Owner: `com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询RoleHasMenu所有数据

 @param page        分页参数
 @param roleHasMenu {@see RoleHasMenu}查询条件
 @return 查询结果 {@see RoleHasMenu}
```
