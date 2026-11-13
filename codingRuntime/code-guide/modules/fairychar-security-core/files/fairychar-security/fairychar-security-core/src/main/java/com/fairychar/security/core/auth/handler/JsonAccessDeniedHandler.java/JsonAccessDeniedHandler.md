# com.fairychar.security.core.auth.handler.JsonAccessDeniedHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../JsonAccessDeniedHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-288bea5f86116510"></a>
## com.fairychar.security.core.auth.handler.JsonAccessDeniedHandler

```java
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class JsonAccessDeniedHandler implements AccessDeniedHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/JsonAccessDeniedHandler.java:23`; evidence: `declaration-288bea5f86116510884300f44a0ab01477146953f037095f0b49c93701414bd6`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
统一权限拦截处理器,用于处理账号的越权操作

 @author chiyo <br>
 @since 1.0
```


## Fields

<a id="symbol-8bc24edbe597aece"></a>
### objectMapper

```java
private final ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/JsonAccessDeniedHandler.java:27`; evidence: `declaration-8bc24edbe597aecedbfc37c5d430d21501bc347d9f1c0c043a0139fde3a446bf`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-b565cab495f3b5c2"></a>
### httpStatus

```java
private int httpStatus = 403
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/JsonAccessDeniedHandler.java:28`; evidence: `declaration-b565cab495f3b5c280f41112e6389a8ae895732b2303c49611a23ceb87e57448`.
Visibility: `private` (explicit).
Type: `int`.

## Members

- [handle](JsonAccessDeniedHandler.handle.md#symbol-1bc2158a5553aad3) — `function`, source line 30
