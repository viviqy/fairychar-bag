# com.fairychar.security.core.auth.filter.VerifyCodeFilter

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../VerifyCodeFilter.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-dc7ec0511e68dcc7"></a>
## com.fairychar.security.core.auth.filter.VerifyCodeFilter

```java
@RequiredArgsConstructor
public class VerifyCodeFilter extends OncePerRequestFilter
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/VerifyCodeFilter.java:23`; evidence: `declaration-dc7ec0511e68dcc77a163111b35817ce45e17cd2560eb79f8dd63db68d14be1f`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
验证码校验过滤器<br>
 需要实现{@link ICodeVerifier}的bean

 @author chiyo
```


## Fields

<a id="symbol-bc3ee47190a6f61b"></a>
### verifyUrls

```java
private final Set<String> verifyUrls
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/VerifyCodeFilter.java:25`; evidence: `declaration-bc3ee47190a6f61bfdf6e298945f8621669bb25f063e792dc72f52697574b5ca`.
Visibility: `private` (explicit).
Type: `Set<String>`.
No initializer recorded.

<a id="symbol-009df0f258f04967"></a>
### authenticationFailureHandler

```java
private final AuthenticationFailureHandler authenticationFailureHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/VerifyCodeFilter.java:26`; evidence: `declaration-009df0f258f049671e0f4b9200e3bf719307e41dd8e8be08bcb2f09763f8f3f6`.
Visibility: `private` (explicit).
Type: `AuthenticationFailureHandler`.
No initializer recorded.

<a id="symbol-74c7e1c83eb77aa9"></a>
### codeVerifier

```java
private final ICodeVerifier codeVerifier
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/VerifyCodeFilter.java:27`; evidence: `declaration-74c7e1c83eb77aa9cd072b114d61f0b287875b838a3089c44c344fba21231672`.
Visibility: `private` (explicit).
Type: `ICodeVerifier`.
No initializer recorded.

<a id="symbol-ee6a47ca3e3e1845"></a>
### antPathMatcher

```java
private AntPathMatcher antPathMatcher = new AntPathMatcher()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/VerifyCodeFilter.java:28`; evidence: `declaration-ee6a47ca3e3e18458f7faf41f1ffeaa172cc1cb1ee34572f4eb0fded40cfe436`.
Visibility: `private` (explicit).
Type: `AntPathMatcher`.

## Members

- [doFilterInternal](VerifyCodeFilter.doFilterInternal.md#symbol-5e05efcd742e487e) — `function`, source line 30
