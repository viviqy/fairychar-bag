# com.fairychar.security.core.rbac.mapper.SystemUserMapper.pageAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemUserMapper.java.md)

[Lexical owner](SystemUserMapper.md#symbol-4d2d540f0d83f11f)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-b8ee9706ce024038"></a>
## com.fairychar.security.core.rbac.mapper.SystemUserMapper.pageAllSelective

```java
Page<SystemUser> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SystemUser systemUser)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/SystemUserMapper.java:68`; evidence: `declaration-b8ee9706ce024038d321f60adb01dbb1744d303dc16c29d47440bad4f5aee96a`.
Owner: `com.fairychar.security.core.rbac.mapper.SystemUserMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询SystemUser所有数据指定column

 @param page       分页参数
 @param systemUser {@see SystemUser}查询条件
 @return 查询结果 {@see SystemUser}
```
