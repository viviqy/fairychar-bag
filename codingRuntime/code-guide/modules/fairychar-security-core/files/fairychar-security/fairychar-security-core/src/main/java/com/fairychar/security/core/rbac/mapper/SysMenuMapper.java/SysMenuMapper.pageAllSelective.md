# com.fairychar.security.core.rbac.mapper.SysMenuMapper.pageAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysMenuMapper.java.md)

[Lexical owner](SysMenuMapper.md#symbol-3a323c4c40df7700)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-850892c1f5cecff3"></a>
## com.fairychar.security.core.rbac.mapper.SysMenuMapper.pageAllSelective

```java
Page<SysMenu> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SysMenu sysMenu)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysMenuMapper.java:68`; evidence: `declaration-850892c1f5cecff379c849a1f3fecd0e5040b9e93e37e9cb2393777fbd50ba24`.
Owner: `com.fairychar.security.core.rbac.mapper.SysMenuMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SysMenu所有数据指定column

 @param page    分页参数
 @param sysMenu {@see SysMenu}查询条件
 @return 查询结果 {@see SysMenu}
```
