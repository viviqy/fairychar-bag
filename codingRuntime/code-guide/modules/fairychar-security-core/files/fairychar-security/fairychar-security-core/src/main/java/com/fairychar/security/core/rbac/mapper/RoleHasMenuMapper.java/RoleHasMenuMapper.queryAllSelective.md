# com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper.queryAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RoleHasMenuMapper.java.md)

[Lexical owner](RoleHasMenuMapper.md#symbol-33c2ea78b3e32bb8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9a6f5b5003f49368"></a>
## com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper.queryAllSelective

```java
List<RoleHasMenu> queryAllSelective(@Param("fields") String[] fields, @Param("e") RoleHasMenu roleHasMenu)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/RoleHasMenuMapper.java:50`; evidence: `declaration-9a6f5b5003f493685487cd848b8c3c6944026db4c3e1ba86337d7fc74372e2eb`.
Owner: `com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询RoleHasMenu所有数据指定column

 @param roleHasMenu {@see RoleHasMenu}查询条件
 @return 查询结果 {@see RoleHasMenu}
```
