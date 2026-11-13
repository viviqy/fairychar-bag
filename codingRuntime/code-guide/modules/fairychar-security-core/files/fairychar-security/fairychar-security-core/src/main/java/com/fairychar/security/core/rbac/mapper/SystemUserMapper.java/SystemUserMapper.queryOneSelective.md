# com.fairychar.security.core.rbac.mapper.SystemUserMapper.queryOneSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemUserMapper.java.md)

[Lexical owner](SystemUserMapper.md#symbol-4d2d540f0d83f11f)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3b0c182f2e14a48c"></a>
## com.fairychar.security.core.rbac.mapper.SystemUserMapper.queryOneSelective

```java
SystemUser queryOneSelective(@Param("fields") String[] fields, @Param("e") SystemUser systemUser)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SystemUserMapper.java:34`; evidence: `declaration-3b0c182f2e14a48c8bbd790d9282c59ea32a8daebbb158185465294f7319ce4f`.
Owner: `com.fairychar.security.core.rbac.mapper.SystemUserMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询SystemUser单条数据指定column

 @param systemUser {@see SystemUser}查询条件
 @return 查询结果 {@see SystemUser}
```
