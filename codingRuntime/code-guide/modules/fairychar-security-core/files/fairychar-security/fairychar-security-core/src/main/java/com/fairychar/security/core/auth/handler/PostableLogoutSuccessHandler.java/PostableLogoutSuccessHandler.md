# com.fairychar.security.core.auth.handler.PostableLogoutSuccessHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../PostableLogoutSuccessHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-4d91a77e5f0e7230"></a>
## com.fairychar.security.core.auth.handler.PostableLogoutSuccessHandler

```java
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class PostableLogoutSuccessHandler implements LogoutSuccessHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLogoutSuccessHandler.java:22`; evidence: `declaration-4d91a77e5f0e7230ed1ba1073538521ae97f2368e187d55dcc33df0f7e36c286`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
@author chiyo <br>
 @since 1.3.3
```


## Fields

<a id="symbol-70f109c6593074d4"></a>
### objectMapper

```java
private final ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLogoutSuccessHandler.java:26`; evidence: `declaration-70f109c6593074d43e3dbf90f475e041901930471951717e51958761a765f6f6`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-c6f8ab1ee5096ff3"></a>
### postHandlers

```java
private List<ILogoutPostHandler> postHandlers = List.of()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/handler/PostableLogoutSuccessHandler.java:27`; evidence: `declaration-c6f8ab1ee5096ff365c97deb2984779697fb448bc5c4a32e108ee39acdbc7c55`.
Visibility: `private` (explicit).
Type: `List<ILogoutPostHandler>`.

## Members

- [onLogoutSuccess](PostableLogoutSuccessHandler.onLogoutSuccess.md#symbol-ef8eb1b73ba0b3ea) — `function`, source line 29
