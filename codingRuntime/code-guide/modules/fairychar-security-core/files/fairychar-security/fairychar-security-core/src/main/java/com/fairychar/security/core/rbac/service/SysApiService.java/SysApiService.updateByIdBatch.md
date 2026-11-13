# com.fairychar.security.core.rbac.service.SysApiService.updateByIdBatch

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiService.java.md)

[Lexical owner](SysApiService.md#symbol-15dd153bd489c3b6)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-b76a692696f6677d"></a>
## com.fairychar.security.core.rbac.service.SysApiService.updateByIdBatch

```java
@Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateByIdBatch(List<UpdateSysApiQuery> batch)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:154`; evidence: `declaration-b76a692696f6677dc2e82b4fc79f98f98a4333ddef9f9ae5dd76cae8ffd806a2`.
Owner: `com.fairychar.security.core.rbac.service.SysApiService`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
更新

 @param batch {@link SysApiQuery}查询条件
 @return 是否成功
```
