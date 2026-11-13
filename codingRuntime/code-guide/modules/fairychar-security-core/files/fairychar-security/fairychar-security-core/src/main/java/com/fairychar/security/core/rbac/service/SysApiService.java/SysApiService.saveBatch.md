# com.fairychar.security.core.rbac.service.SysApiService.saveBatch

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiService.java.md)

[Lexical owner](SysApiService.md#symbol-15dd153bd489c3b6)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9100e5481975317f"></a>
## com.fairychar.security.core.rbac.service.SysApiService.saveBatch

```java
@Override
    @Transactional(rollbackFor = Exception.class)
    public List<SysApi> saveBatch(List<AddSysApiQuery> batch)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:121`; evidence: `declaration-9100e5481975317f0f0289061077601a3aade37ff4bbbdb43e124c5d59e1802a`.
Owner: `com.fairychar.security.core.rbac.service.SysApiService`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
批量新增

 @param batch 新增数据
 @return 是否成功
```
