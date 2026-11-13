# com.fairychar.security.core.rbac.service.SysApiService.save

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiService.java.md)

[Lexical owner](SysApiService.md#symbol-15dd153bd489c3b6)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-91edaf7e61e9096a"></a>
## com.fairychar.security.core.rbac.service.SysApiService.save

```java
@Override
    @Transactional(rollbackFor = Exception.class)
    public int save(AddSysApiQuery addSysApiQuery)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:66`; evidence: `declaration-91edaf7e61e9096ab03445ff4651d726d68a5f20e821bfca6b112e9d1d083a41`.
Owner: `com.fairychar.security.core.rbac.service.SysApiService`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
插入

 @param addSysApiQuery {@link SysApiQuery}查询条件
 @return 是否成功
```
