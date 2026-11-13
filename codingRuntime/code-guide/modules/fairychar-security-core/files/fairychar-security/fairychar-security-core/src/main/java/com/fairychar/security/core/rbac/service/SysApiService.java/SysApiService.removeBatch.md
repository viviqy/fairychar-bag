# com.fairychar.security.core.rbac.service.SysApiService.removeBatch

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiService.java.md)

[Lexical owner](SysApiService.md#symbol-15dd153bd489c3b6)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3772736c9c7cd395"></a>
## com.fairychar.security.core.rbac.service.SysApiService.removeBatch

```java
@Override
    @Transactional(rollbackFor = Exception.class)
    public void removeBatch(List<Integer> ids)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:189`; evidence: `declaration-3772736c9c7cd3959984556943f0587eed9a2739329c980bcfc2279c98971514`.
Owner: `com.fairychar.security.core.rbac.service.SysApiService`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
批量删除

 @param ids IDS
```
