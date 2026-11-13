# com.fairychar.security.boot.configurer.CommonBeansConfiguration

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../CommonBeansConfiguration.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5624342e4deb0c82"></a>
## com.fairychar.security.boot.configurer.CommonBeansConfiguration

```java
@Configuration
@EnableConfigurationProperties(FairycharSecurityProperties.class)
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class CommonBeansConfiguration
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/CommonBeansConfiguration.java:28`; evidence: `declaration-5624342e4deb0c823fb520913dc9ccec4d145bb9714362eb8fcacf29a5804601`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
安全认证基础Bean配置

 @author chiyo <br>
```


### Reviewed responsibility
Security bean configuration declares conditional bean methods for authentication success/failure, access denial, authentication entry point and logout success. Success/failure/logout factories pass optional post-handler lists when present; the entry-point factory supplies an empty mapping. Source annotations enable FairycharSecurityProperties and request ordering after RedisAutoConfiguration; effective runtime activation is not established.

Confidence: `high`; evidence: `936115b79404d231064734b2d3848d0aa6f75730109bf9071172d4c96b8eb25c` in claims.jsonl.
Unknowns: Resource-based auto-configuration discovery is outside scope; Dependency injection and bean-condition evaluation remain runtime unknowns; Handler side effects were not transitively reviewed

## Fields

<a id="symbol-69465392c49fe6fc"></a>
### objectMapper

```java
@Autowired
private ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/CommonBeansConfiguration.java:32`; evidence: `declaration-69465392c49fe6fcb8184855224221464ef8aedd805297f3d7fd461eb02eb1d1`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-718fafebb5920f47"></a>
### successPostHandler

```java
@Autowired(required = false)
private List<ISuccessPostHandler> successPostHandler
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/CommonBeansConfiguration.java:34`; evidence: `declaration-718fafebb5920f4710f3983ba6532cc6965147c7047f9dbe20f1fb90b6ebf0f0`.
Visibility: `private` (explicit).
Type: `List<ISuccessPostHandler>`.
No initializer recorded.

<a id="symbol-6d7d3ec714540dc1"></a>
### failurePostHandlers

```java
@Autowired(required = false)
private List<IFailurePostHandler> failurePostHandlers
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/CommonBeansConfiguration.java:36`; evidence: `declaration-6d7d3ec714540dc1a58c70bb5a4c468eccf9866b1dd0681ebfada9bbc0571133`.
Visibility: `private` (explicit).
Type: `List<IFailurePostHandler>`.
No initializer recorded.

<a id="symbol-1d1e5e9085d3399f"></a>
### logoutPostHandlers

```java
@Autowired(required = false)
private List<ILogoutPostHandler> logoutPostHandlers
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/CommonBeansConfiguration.java:38`; evidence: `declaration-1d1e5e9085d3399f769558d93426ea7ed9d5181d026bc4d79900efee08f6510e`.
Visibility: `private` (explicit).
Type: `List<ILogoutPostHandler>`.
No initializer recorded.

## Members

- [postableLoginSuccessHandler](CommonBeansConfiguration.postableLoginSuccessHandler.md#symbol-977f4607ffe34e61) — `function`, source line 41
- [postableLoginFailedHandler](CommonBeansConfiguration.postableLoginFailedHandler.md#symbol-434d8df62c5d85e1) — `function`, source line 51
- [postableAccessDeniedHandler](CommonBeansConfiguration.postableAccessDeniedHandler.md#symbol-a846d16fd251efcc) — `function`, source line 61
- [mappedExceptionAuthenticationEntryPoint](CommonBeansConfiguration.mappedExceptionAuthenticationEntryPoint.md#symbol-0fe7bea1b8e2fc6e) — `function`, source line 67
- [postableLogoutSuccessHandler](CommonBeansConfiguration.postableLogoutSuccessHandler.md#symbol-a091b7137d24689d) — `function`, source line 73
