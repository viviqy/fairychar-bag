# com.fairychar.security.core.rbac.mapper.SysApiMapper.pageAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiMapper.java.md)

[Lexical owner](SysApiMapper.md#symbol-b3ccad596e63057e)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-0c0e980776fc7319"></a>
## com.fairychar.security.core.rbac.mapper.SysApiMapper.pageAllSelective

```java
Page<SysApi> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SysApi sysApi)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysApiMapper.java:69`; evidence: `declaration-0c0e980776fc7319b7b1f84db52561ab019c3c341a373bc064b68ac4f93f00f5`.
Owner: `com.fairychar.security.core.rbac.mapper.SysApiMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SysApi所有数据指定column

 @param page   分页参数
 @param sysApi {@see SysApi}查询条件
 @return 查询结果 {@see SysApi}
```
