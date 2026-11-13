# com.fairychar.security.core.auth.filter.ApiPermissionFilter

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ApiPermissionFilter.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-1e753aa0a7b5460a"></a>
## com.fairychar.security.core.auth.filter.ApiPermissionFilter

```java
@Slf4j
@RequiredArgsConstructor
public class ApiPermissionFilter extends OncePerRequestFilter
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/ApiPermissionFilter.java:28`; evidence: `declaration-1e753aa0a7b5460acdb1793f005394b5b48fa89c3caf9b8a25ce2a9344ec4c5a`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<pre>接口权限拦截器</pre>

 @author chiyo <br>
 @since 1.3.3
```


## Fields

<a id="symbol-754c5236f69bf910"></a>
### ignorePaths

```java
private final Set<String> ignorePaths
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/ApiPermissionFilter.java:35`; evidence: `declaration-754c5236f69bf910b01ad1d9f5023da4c62a01bde30bc77af73f23b64da3f4e3`.
Visibility: `private` (explicit).
Type: `Set<String>`.
No initializer recorded.

Source docstring (unreviewed):
```text
需要忽略的路径,采用antMatch方式
```


<a id="symbol-a2793a2e900e1e71"></a>
### accessDeniedHandler

```java
private final AccessDeniedHandler accessDeniedHandler
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/ApiPermissionFilter.java:36`; evidence: `declaration-a2793a2e900e1e71b11d3dd031a867907eccb0701b1e709a1caacbe74243a2ae`.
Visibility: `private` (explicit).
Type: `AccessDeniedHandler`.
No initializer recorded.

<a id="symbol-ed7fea1ded737d0d"></a>
### apiAuthorityProvider

```java
private final ApiAuthorityProvider apiAuthorityProvider
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/ApiPermissionFilter.java:37`; evidence: `declaration-ed7fea1ded737d0dcc5633ce0cbd2c4b44cad2dde226a6fd589ebb702216566c`.
Visibility: `private` (explicit).
Type: `ApiAuthorityProvider`.
No initializer recorded.

<a id="symbol-d26580c97eedeed7"></a>
### antPathMatcher

```java
private final AntPathMatcher antPathMatcher = new AntPathMatcher()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/ApiPermissionFilter.java:39`; evidence: `declaration-d26580c97eedeed7faa5e97079d2dfa550884841ffc6e44b63cac94130634222`.
Visibility: `private` (explicit).
Type: `AntPathMatcher`.

## Members

- [doFilterInternal](ApiPermissionFilter.doFilterInternal.md#symbol-bb3288d0406b6248) — `function`, source line 41
