# com.fairychar.security.core.rbac.mapper.SysMenuMapper.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysMenuMapper.java.md)

[Lexical owner](SysMenuMapper.md#symbol-3a323c4c40df7700)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5fca03ce5d0519d1"></a>
## com.fairychar.security.core.rbac.mapper.SysMenuMapper.pageAll

```java
Page<SysMenu> pageAll(@Param("page") IPage page, @Param("e") SysMenu sysMenu)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysMenuMapper.java:59`; evidence: `declaration-5fca03ce5d0519d11340f869a80d6e8a15fc0f343f6a80ee33f74444a5a480c4`.
Owner: `com.fairychar.security.core.rbac.mapper.SysMenuMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SysMenu所有数据

 @param page    分页参数
 @param sysMenu {@see SysMenu}查询条件
 @return 查询结果 {@see SysMenu}
```
