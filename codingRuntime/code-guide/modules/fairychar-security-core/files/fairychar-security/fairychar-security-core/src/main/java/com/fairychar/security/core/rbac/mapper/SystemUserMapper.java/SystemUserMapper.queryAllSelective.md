# com.fairychar.security.core.rbac.mapper.SystemUserMapper.queryAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemUserMapper.java.md)

[Lexical owner](SystemUserMapper.md#symbol-4d2d540f0d83f11f)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-e58d53444944cdbb"></a>
## com.fairychar.security.core.rbac.mapper.SystemUserMapper.queryAllSelective

```java
List<SystemUser> queryAllSelective(@Param("fields") String[] fields, @Param("e") SystemUser systemUser)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SystemUserMapper.java:50`; evidence: `declaration-e58d53444944cdbb392f6dac1f633ca7295cb13afc2d2e5212e11a1f25620d0e`.
Owner: `com.fairychar.security.core.rbac.mapper.SystemUserMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询SystemUser所有数据指定column

 @param systemUser {@see SystemUser}查询条件
 @return 查询结果 {@see SystemUser}
```
