# com.fairychar.security.core.rbac.mapper.SysApiMapper.queryAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiMapper.java.md)

[Lexical owner](SysApiMapper.md#symbol-b3ccad596e63057e)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-4ed1937771b9ad23"></a>
## com.fairychar.security.core.rbac.mapper.SysApiMapper.queryAllSelective

```java
List<SysApi> queryAllSelective(@Param("fields") String[] fields, @Param("e") SysApi sysApi)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysApiMapper.java:51`; evidence: `declaration-4ed1937771b9ad23eb5721eeb194a1db76c9e54b66de42198023c145eae09907`.
Owner: `com.fairychar.security.core.rbac.mapper.SysApiMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询SysApi所有数据指定column

 @param sysApi {@see SysApi}查询条件
 @return 查询结果 {@see SysApi}
```
