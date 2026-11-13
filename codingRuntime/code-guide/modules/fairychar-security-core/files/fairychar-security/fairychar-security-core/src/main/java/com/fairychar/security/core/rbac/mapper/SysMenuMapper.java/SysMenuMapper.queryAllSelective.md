# com.fairychar.security.core.rbac.mapper.SysMenuMapper.queryAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysMenuMapper.java.md)

[Lexical owner](SysMenuMapper.md#symbol-3a323c4c40df7700)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-50d21e090af6d497"></a>
## com.fairychar.security.core.rbac.mapper.SysMenuMapper.queryAllSelective

```java
List<SysMenu> queryAllSelective(@Param("fields") String[] fields, @Param("e") SysMenu sysMenu)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysMenuMapper.java:50`; evidence: `declaration-50d21e090af6d497258687ddf46ee23bf58d134010665f665ec8dba1c820172e`.
Owner: `com.fairychar.security.core.rbac.mapper.SysMenuMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询SysMenu所有数据指定column

 @param sysMenu {@see SysMenu}查询条件
 @return 查询结果 {@see SysMenu}
```
