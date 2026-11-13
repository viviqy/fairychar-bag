# com.fairychar.security.core.rbac.mapper.SysDictMapper.queryAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysDictMapper.java.md)

[Lexical owner](SysDictMapper.md#symbol-43ea2458b45ec5f8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8b7cd95edfd7f46d"></a>
## com.fairychar.security.core.rbac.mapper.SysDictMapper.queryAllSelective

```java
List<SysDict> queryAllSelective(@Param("fields") String[] fields, @Param("e") SysDict sysDict)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysDictMapper.java:50`; evidence: `declaration-8b7cd95edfd7f46d23e97cdc589327e956954ea9c155b6d3befc95e6acc240ca`.
Owner: `com.fairychar.security.core.rbac.mapper.SysDictMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询SysDict所有数据指定column

 @param sysDict {@see SysDict}查询条件
 @return 查询结果 {@see SysDict}
```
