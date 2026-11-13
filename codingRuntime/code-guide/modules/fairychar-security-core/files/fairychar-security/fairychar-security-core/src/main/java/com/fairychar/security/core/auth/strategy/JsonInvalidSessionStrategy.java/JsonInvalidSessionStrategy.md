# com.fairychar.security.core.auth.strategy.JsonInvalidSessionStrategy

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../JsonInvalidSessionStrategy.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-80ace4c05339d7bf"></a>
## com.fairychar.security.core.auth.strategy.JsonInvalidSessionStrategy

```java
@AllArgsConstructor
@RequiredArgsConstructor
public class JsonInvalidSessionStrategy implements InvalidSessionStrategy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/strategy/JsonInvalidSessionStrategy.java:22`; evidence: `declaration-80ace4c05339d7bfd53cbcd1843ffdb8508c2bf336d9ea9bf41f594a450febba`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
非法token访问策略处理器

 @author chiyo <br>
 @since 1.0
```


## Fields

<a id="symbol-3d7aa85273a07316"></a>
### objectMapper

```java
private final ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/strategy/JsonInvalidSessionStrategy.java:25`; evidence: `declaration-3d7aa85273a073168012262754514451692fefc814b8eeaa4c7c2dd4d482edf0`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-cc9139458990043f"></a>
### httpStatus

```java
private int httpStatus = 401
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/strategy/JsonInvalidSessionStrategy.java:26`; evidence: `declaration-cc9139458990043fa421af8e30b5b39d90a739e61b1a93107bc91344234ad3c3`.
Visibility: `private` (explicit).
Type: `int`.

## Members

- [onInvalidSessionDetected](JsonInvalidSessionStrategy.onInvalidSessionDetected.md#symbol-adcc8fd7ec81f565) — `function`, source line 28
