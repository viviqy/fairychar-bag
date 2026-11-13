# com.fairychar.security.core.auth.strategy.JsonSessionExpiredStrategy

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../JsonSessionExpiredStrategy.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-cfc6615116178680"></a>
## com.fairychar.security.core.auth.strategy.JsonSessionExpiredStrategy

```java
@Slf4j
@RequiredArgsConstructor
public class JsonSessionExpiredStrategy implements SessionInformationExpiredStrategy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/strategy/JsonSessionExpiredStrategy.java:23`; evidence: `declaration-cfc66151161786801c7db9486a5ab22980ac054c846f5d3b81dfec6ee03c2958`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
过期的token访问策略处理器

 @author chiyo <br>
 @since 1.3.3
```


## Fields

<a id="symbol-af49d1fd7948e622"></a>
### sessionRepository

```java
private final FindByIndexNameSessionRepository sessionRepository
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/strategy/JsonSessionExpiredStrategy.java:26`; evidence: `declaration-af49d1fd7948e62294b1dda9620acc08cbc652aaa33a86998d6924f34639bd09`.
Visibility: `private` (explicit).
Type: `FindByIndexNameSessionRepository`.
No initializer recorded.

<a id="symbol-203516af94413c8f"></a>
### httpStatus

```java
private int httpStatus = 401
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/strategy/JsonSessionExpiredStrategy.java:27`; evidence: `declaration-203516af94413c8f30901a48b67a4a4405830ba17176450164a87195c8be9cca`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-d577bb33a01d6cd5"></a>
### objectMapper

```java
private final ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/strategy/JsonSessionExpiredStrategy.java:28`; evidence: `declaration-d577bb33a01d6cd56b23c73a876eafb52291bacd630d600a78c98ab313ea7e3d`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

## Members

- [onExpiredSessionDetected](JsonSessionExpiredStrategy.onExpiredSessionDetected.md#symbol-b6637ce3f4f17579) — `function`, source line 30
