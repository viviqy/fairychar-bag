# com.fairychar.security.core.auth.entrypoint.MappedExceptionAuthenticationEntryPoint

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MappedExceptionAuthenticationEntryPoint.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-80c543327b08a3f8"></a>
## com.fairychar.security.core.auth.entrypoint.MappedExceptionAuthenticationEntryPoint

```java
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class MappedExceptionAuthenticationEntryPoint implements AuthenticationEntryPoint
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/entrypoint/MappedExceptionAuthenticationEntryPoint.java:24`; evidence: `declaration-80c543327b08a3f807b1a6462e7cf6bad1711ba6324d8076380ab4a8b6e9b29e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
认证流程异常出口点

 @author chiyo <br>
 @since 1.3.3
```


## Fields

<a id="symbol-9bf375d5c6b4b1fe"></a>
### objectMapper

```java
private final ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/entrypoint/MappedExceptionAuthenticationEntryPoint.java:28`; evidence: `declaration-9bf375d5c6b4b1fee79cf9b9e9611aea6ba324c0d62f96a85550d448bf0a45c9`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-5c236bdb31d32f1e"></a>
### httpStatus

```java
private int httpStatus = 401
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/entrypoint/MappedExceptionAuthenticationEntryPoint.java:29`; evidence: `declaration-5c236bdb31d32f1e8e642eb87227fbed1cf0addd1dd9ae9cf2892b98503ced2b`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-c8207e1ea97ad0be"></a>
### authenticationExceptionMap

```java
private final Map<AuthenticationException, HttpResult> authenticationExceptionMap
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/entrypoint/MappedExceptionAuthenticationEntryPoint.java:30`; evidence: `declaration-c8207e1ea97ad0be82fa16916594e30662ac7816875a4f64fe49d6bfe25f8358`.
Visibility: `private` (explicit).
Type: `Map<AuthenticationException, HttpResult>`.
No initializer recorded.

## Members

- [commence](MappedExceptionAuthenticationEntryPoint.commence.md#symbol-cac656221c716dfe) — `function`, source line 32
