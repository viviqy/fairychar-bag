# com.fairychar.security.core.rbac.mapper.SysDictMapper.pageAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysDictMapper.java.md)

[Lexical owner](SysDictMapper.md#symbol-43ea2458b45ec5f8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-18f1eeeffd69775d"></a>
## com.fairychar.security.core.rbac.mapper.SysDictMapper.pageAllSelective

```java
Page<SysDict> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SysDict sysDict)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysDictMapper.java:68`; evidence: `declaration-18f1eeeffd69775d4a79da46f8bf8ccdf64d8cc536adfc15041276275e3dde0b`.
Owner: `com.fairychar.security.core.rbac.mapper.SysDictMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SysDict所有数据指定column

 @param page    分页参数
 @param sysDict {@see SysDict}查询条件
 @return 查询结果 {@see SysDict}
```
