# com.fairychar.security.core.rbac.mapper.SysApiMapper.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiMapper.java.md)

[Lexical owner](SysApiMapper.md#symbol-b3ccad596e63057e)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-bf7ff4b9b4e90a62"></a>
## com.fairychar.security.core.rbac.mapper.SysApiMapper.pageAll

```java
Page<SysApi> pageAll(@Param("page") IPage page, @Param("e") SysApi sysApi)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysApiMapper.java:60`; evidence: `declaration-bf7ff4b9b4e90a629418fd64ec19a021901db90bb7824466689d8c4262d93618`.
Owner: `com.fairychar.security.core.rbac.mapper.SysApiMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SysApi所有数据

 @param page   分页参数
 @param sysApi {@see SysApi}查询条件
 @return 查询结果 {@see SysApi}
```
