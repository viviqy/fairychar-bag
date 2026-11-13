# com.fairychar.security.core.rbac.service.SysApiService.updateById

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiService.java.md)

[Lexical owner](SysApiService.md#symbol-15dd153bd489c3b6)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5e3f1c43795743d2"></a>
## com.fairychar.security.core.rbac.service.SysApiService.updateById

```java
@Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(UpdateSysApiQuery updateSysApiQuery)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:89`; evidence: `declaration-5e3f1c43795743d234bd872b5e46ff3f5976c4d8959a3b33246b91296ba13d6e`.
Owner: `com.fairychar.security.core.rbac.service.SysApiService`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
更新

 @param updateSysApiQuery {@link SysApiQuery}查询条件
 @return 是否成功
```
