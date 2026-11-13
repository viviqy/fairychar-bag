# com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAutoConfigurer.java.md)

[Lexical owner](SecurityAutoConfigurer.md#symbol-77cad787ca19a767)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-abd4dc8f99b72a20"></a>
## com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration

```java
@Configuration
    @EnableConfigurationProperties({FairycharSecurityProperties.class, RedisProperties.class})
    @ConditionalOnProperty(value = "fairychar.security.token-type", havingValue = "redis", matchIfMissing = true)
    protected static class RedisSessionConfiguration
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:76`; evidence: `declaration-abd4dc8f99b72a20cbda310ff4a37a25ae6a3d9562c5af5e8f4688a4d3d423ba`.
Owner: `com.fairychar.security.boot.configurer.SecurityAutoConfigurer`; visibility: `protected` (explicit).

## Fields

<a id="symbol-8565e3edd953a974"></a>
### fairycharSecurityProperties

```java
@Autowired
private FairycharSecurityProperties fairycharSecurityProperties
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:80`; evidence: `declaration-8565e3edd953a974edebf6db8e14133c354d72a64e697636e41d2f4723a332ef`.
Visibility: `private` (explicit).
Type: `FairycharSecurityProperties`.
No initializer recorded.

<a id="symbol-3de74e5d3104afb3"></a>
### authenticationSuccessHandler

```java
@Autowired
private AuthenticationSuccessHandler authenticationSuccessHandler
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:82`; evidence: `declaration-3de74e5d3104afb32e4c4defd19a97e49f565319a8f23eac1a84f50275f83a16`.
Visibility: `private` (explicit).
Type: `AuthenticationSuccessHandler`.
No initializer recorded.

<a id="symbol-91af6e3593fe52ee"></a>
### authenticationFailureHandler

```java
@Autowired
private AuthenticationFailureHandler authenticationFailureHandler
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:84`; evidence: `declaration-91af6e3593fe52eeadca7adb4f34c5389fbd2eebbdbb961fb000df7e926429dd`.
Visibility: `private` (explicit).
Type: `AuthenticationFailureHandler`.
No initializer recorded.

<a id="symbol-0bf468baf2029a95"></a>
### authenticationEntryPoint

```java
@Autowired
private AuthenticationEntryPoint authenticationEntryPoint
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:86`; evidence: `declaration-0bf468baf2029a95cfccb29fa4b9c0c170d8d0dd2b509ba775bb3094cc79cb10`.
Visibility: `private` (explicit).
Type: `AuthenticationEntryPoint`.
No initializer recorded.

<a id="symbol-1270d7e8fa9db4f0"></a>
### accessDeniedHandler

```java
@Autowired
private AccessDeniedHandler accessDeniedHandler
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:88`; evidence: `declaration-1270d7e8fa9db4f0470c1982df5a32ea56f799307f3a758233ac7faaf2be145c`.
Visibility: `private` (explicit).
Type: `AccessDeniedHandler`.
No initializer recorded.

<a id="symbol-eb6e17634afaeafa"></a>
### invalidSessionStrategy

```java
@Autowired
private InvalidSessionStrategy invalidSessionStrategy
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:90`; evidence: `declaration-eb6e17634afaeafa84bee886fe6bc6d8e439165fe9d2bc68f5b17b473c7b38a2`.
Visibility: `private` (explicit).
Type: `InvalidSessionStrategy`.
No initializer recorded.

<a id="symbol-6e3a23adf1d2d0dc"></a>
### indexNameSessionRepository

```java
@Autowired
private FindByIndexNameSessionRepository indexNameSessionRepository
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:92`; evidence: `declaration-6e3a23adf1d2d0dcb4b62c6f7ab2e42606a706331657db0b06d14f5596459c03`.
Visibility: `private` (explicit).
Type: `FindByIndexNameSessionRepository`.
No initializer recorded.

<a id="symbol-f8a83df484e5101e"></a>
### sessionInformationExpiredStrategy

```java
@Autowired
private SessionInformationExpiredStrategy sessionInformationExpiredStrategy
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:94`; evidence: `declaration-f8a83df484e5101e160e53a350997742a4e6457466c0e75a50ca10e4e0600689`.
Visibility: `private` (explicit).
Type: `SessionInformationExpiredStrategy`.
No initializer recorded.

<a id="symbol-0027313d588dcb3d"></a>
### usernameDecrypt

```java
@Autowired(required = false)
private IUsernameDecrypt usernameDecrypt
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:96`; evidence: `declaration-0027313d588dcb3d444a2317608e0833d129dc1e3254b34c600951c045ff266c`.
Visibility: `private` (explicit).
Type: `IUsernameDecrypt`.
No initializer recorded.

<a id="symbol-15e7c034aea10b28"></a>
### passwordDecrypt

```java
@Autowired(required = false)
private IPasswordDecrypt passwordDecrypt
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:98`; evidence: `declaration-15e7c034aea10b28bb4e21befe25eed2228db189367a6142f61e89b26c651ab0`.
Visibility: `private` (explicit).
Type: `IPasswordDecrypt`.
No initializer recorded.

<a id="symbol-189c992ba05c6436"></a>
### verifyCodeFilter

```java
@Autowired(required = false)
private VerifyCodeFilter verifyCodeFilter
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:100`; evidence: `declaration-189c992ba05c643675a9ef8a0565fe48182b7fdd845c0b9a86bd74545a606355`.
Visibility: `private` (explicit).
Type: `VerifyCodeFilter`.
No initializer recorded.

<a id="symbol-ae47e85213a68096"></a>
### logoutSuccessHandler

```java
@Autowired
private LogoutSuccessHandler logoutSuccessHandler
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:102`; evidence: `declaration-ae47e85213a680966e25d7aa2a42544e82a7785b6af89d9187a0096dd9f1d899`.
Visibility: `private` (explicit).
Type: `LogoutSuccessHandler`.
No initializer recorded.

<a id="symbol-ff4f65adc6a37290"></a>
### objectMapper

```java
@Autowired
private ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:104`; evidence: `declaration-ff4f65adc6a372904a74d71a714dd4d129d9bea9177b1a0a5c1335b0e7ac7a21`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-5f6db1005c400ba6"></a>
### apiAuthorityProvider

```java
@Autowired(required = false)
private ApiAuthorityProvider apiAuthorityProvider
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:106`; evidence: `declaration-5f6db1005c400ba69f9d25353b67d40e700b9f3a2b73c51b933a60b7fa4b1ffe`.
Visibility: `private` (explicit).
Type: `ApiAuthorityProvider`.
No initializer recorded.

## Members

- [sessionManager](SecurityAutoConfigurer.RedisSessionConfiguration.sessionManager.md#symbol-051144d61ad5341f) — `function`, source line 109
- [reWriteDatabaseCustomizer](SecurityAutoConfigurer.RedisSessionConfiguration.reWriteDatabaseCustomizer.md#symbol-7f174a8d57f6aba2) — `function`, source line 122
- [springSessionBackedSessionRegistry](SecurityAutoConfigurer.RedisSessionConfiguration.springSessionBackedSessionRegistry.md#symbol-058456f7efb3a8e0) — `function`, source line 128
- [httpSessionIdResolver](SecurityAutoConfigurer.RedisSessionConfiguration.httpSessionIdResolver.md#symbol-21d9df2a9f074e8c) — `function`, source line 134
- [jsonAuthenticationFilter](SecurityAutoConfigurer.RedisSessionConfiguration.jsonAuthenticationFilter.md#symbol-9727497485eafb55) — `function`, source line 140
- [sessionInformationExpiredStrategy](SecurityAutoConfigurer.RedisSessionConfiguration.sessionInformationExpiredStrategy.md#symbol-4c4c248aa43f382a) — `function`, source line 157
- [simpleInvalidSessionStrategy](SecurityAutoConfigurer.RedisSessionConfiguration.simpleInvalidSessionStrategy.md#symbol-3dcdcd821c9726af) — `function`, source line 164
- [verifyCodeFilter](SecurityAutoConfigurer.RedisSessionConfiguration.verifyCodeFilter.md#symbol-c3623c99d3111bc0) — `function`, source line 171
- [authenticationManagerBean](SecurityAutoConfigurer.RedisSessionConfiguration.authenticationManagerBean.md#symbol-5f670ac49940b411) — `function`, source line 178
- [configure](SecurityAutoConfigurer.RedisSessionConfiguration.configure.md#symbol-67e9c8cb3d2dfc77) — `function`, source line 185
- [apiPermissionFilter](SecurityAutoConfigurer.RedisSessionConfiguration.apiPermissionFilter.md#symbol-3e86cc4ca4514a3e) — `function`, source line 217
- [securityAuditObjectHandler](SecurityAutoConfigurer.RedisSessionConfiguration.securityAuditObjectHandler.md#symbol-d6155292a0527399) — `function`, source line 227
- [TenantConfiguration](SecurityAutoConfigurer.RedisSessionConfiguration.TenantConfiguration.md#symbol-74ebbd6405a10cc2) — `class`, source line 235
