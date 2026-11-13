# com.fairychar.security.core.rbac.mapper.SystemUserMapper.pageAll

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemUserMapper.java.md)

[Lexical owner](SystemUserMapper.md#symbol-4d2d540f0d83f11f)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-b41b05dca030d14f"></a>
## com.fairychar.security.core.rbac.mapper.SystemUserMapper.pageAll

```java
Page<SystemUser> pageAll(@Param("page") IPage page, @Param("e") SystemUser systemUser)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SystemUserMapper.java:59`; evidence: `declaration-b41b05dca030d14fe66f4b86c2a2a82b5a0659833c4cf2cca17554d58519690b`.
Owner: `com.fairychar.security.core.rbac.mapper.SystemUserMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SystemUser所有数据

 @param page       分页参数
 @param systemUser {@see SystemUser}查询条件
 @return 查询结果 {@see SystemUser}
```
