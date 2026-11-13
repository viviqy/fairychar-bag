# com.fairychar.security.core.rbac.mapper.SysDictMapper.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysDictMapper.java.md)

[Lexical owner](SysDictMapper.md#symbol-43ea2458b45ec5f8)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-4c38b2591110fca2"></a>
## com.fairychar.security.core.rbac.mapper.SysDictMapper.pageAll

```java
Page<SysDict> pageAll(@Param("page") IPage page, @Param("e") SysDict sysDict)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SysDictMapper.java:59`; evidence: `declaration-4c38b2591110fca2fc1244e01542f6d271c5b9ff384bcd3ac1705a11947747e5`.
Owner: `com.fairychar.security.core.rbac.mapper.SysDictMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SysDict所有数据

 @param page    分页参数
 @param sysDict {@see SysDict}查询条件
 @return 查询结果 {@see SysDict}
```
