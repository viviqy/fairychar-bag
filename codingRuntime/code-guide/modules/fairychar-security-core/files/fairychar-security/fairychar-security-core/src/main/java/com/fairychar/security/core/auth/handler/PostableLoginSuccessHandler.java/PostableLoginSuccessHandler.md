# com.fairychar.security.core.auth.handler.PostableLoginSuccessHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../PostableLoginSuccessHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-a65146fc06bd8189"></a>
## com.fairychar.security.core.auth.handler.PostableLoginSuccessHandler

```java
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class PostableLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLoginSuccessHandler.java:25`; evidence: `declaration-a65146fc06bd8189ae011f6f60b1a5e7617ea21423402de364aa4c214ff919aa`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于Json返回参数的简单登录成功返回器

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-2f9ba421b4905eb1"></a>
### mapper

```java
private final ObjectMapper mapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLoginSuccessHandler.java:29`; evidence: `declaration-2f9ba421b4905eb1cb41452452ee87ba11b370cff190eac78152c8db5137dd0d`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-915d4ca39a105990"></a>
### postHandlers

```java
private List<ISuccessPostHandler> postHandlers = List.of()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLoginSuccessHandler.java:30`; evidence: `declaration-915d4ca39a105990fe25676db84f9f30272a9cd3ea24fda5d3a534afca831797`.
Visibility: `private` (explicit).
Type: `List<ISuccessPostHandler>`.

## Members

- [onAuthenticationSuccess](PostableLoginSuccessHandler.onAuthenticationSuccess.md#symbol-d7a17f616e5ffa86) — `function`, source line 32
