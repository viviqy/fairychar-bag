# com.fairychar.security.core.auth.handler.PostableLoginFailureHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../PostableLoginFailureHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9532267df400b628"></a>
## com.fairychar.security.core.auth.handler.PostableLoginFailureHandler

```java
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class PostableLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLoginFailureHandler.java:26`; evidence: `declaration-9532267df400b628dc25a238d727960dc07c60bb1d1206d11f6fc9935ef70e09`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于Json返回参数的简单登录失败处理器

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-b373b90d898d693a"></a>
### mapper

```java
private final ObjectMapper mapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLoginFailureHandler.java:30`; evidence: `declaration-b373b90d898d693a41bc961022d252231e6cbc089c527ab0f9edde16f5d19eeb`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-c002b567ecca9f76"></a>
### postHandlers

```java
private List<IFailurePostHandler> postHandlers = List.of()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLoginFailureHandler.java:31`; evidence: `declaration-c002b567ecca9f761bbe8b1e4f97a14b63e32dc69588c1c75b110f5e5b5badff`.
Visibility: `private` (explicit).
Type: `List<IFailurePostHandler>`.

## Members

- [onAuthenticationFailure](PostableLoginFailureHandler.onAuthenticationFailure.md#symbol-b634eee4f3ae7407) — `function`, source line 33
