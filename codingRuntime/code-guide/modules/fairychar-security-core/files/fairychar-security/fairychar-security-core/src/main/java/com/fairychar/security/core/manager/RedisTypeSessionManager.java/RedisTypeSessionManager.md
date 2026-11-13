# com.fairychar.security.core.manager.RedisTypeSessionManager

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RedisTypeSessionManager.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3e441ebf629b1db3"></a>
## com.fairychar.security.core.manager.RedisTypeSessionManager

```java
@AllArgsConstructor
public class RedisTypeSessionManager
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/manager/RedisTypeSessionManager.java:15`; evidence: `declaration-3e441ebf629b1db3898cee4ff76a8a4a3a1691e99b9054ac07c5433f2d66fcde`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
redis session管理器,管理用户登录状态

 @author chiyo <br>
```


## Fields

<a id="symbol-c7f2277ed760ab78"></a>
### sessionRepository

```java
private final FindByIndexNameSessionRepository sessionRepository
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/manager/RedisTypeSessionManager.java:18`; evidence: `declaration-c7f2277ed760ab78db872c0e8c0dd2e94817ee29aec893772d4e8e26eea59ccc`.
Visibility: `private` (explicit).
Type: `FindByIndexNameSessionRepository`.
No initializer recorded.

## Members

- [logout](RedisTypeSessionManager.logout.md#symbol-010d20fad6ff8557) — `function`, source line 26
- [multiLogout](RedisTypeSessionManager.multiLogout.md#symbol-17a120353b8079d8) — `function`, source line 37
