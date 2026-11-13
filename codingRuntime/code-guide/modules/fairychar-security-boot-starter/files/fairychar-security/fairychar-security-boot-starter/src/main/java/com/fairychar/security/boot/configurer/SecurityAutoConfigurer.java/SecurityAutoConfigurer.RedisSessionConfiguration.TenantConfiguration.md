# com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.TenantConfiguration

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAutoConfigurer.java.md)

[Lexical owner](SecurityAutoConfigurer.RedisSessionConfiguration.md#symbol-abd4dc8f99b72a20)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-74ebbd6405a10cc2"></a>
## com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.TenantConfiguration

```java
@Configuration
        @ConditionalOnProperty(name = "fairychar.security.plugins.tenant.enable", havingValue = "true")
        @EnableConfigurationProperties(FairycharSecurityProperties.class)
        protected static class TenantConfiguration
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:235`; evidence: `declaration-74ebbd6405a10cc23add9a5b6c22d4258a7cbcd7071c4fcd0ee7db19d98b2f0e`.
Owner: `com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration`; visibility: `protected` (explicit).

## Fields

<a id="symbol-ede055b6d267e158"></a>
### securityProperties

```java
@Autowired
private FairycharSecurityProperties securityProperties
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:240`; evidence: `declaration-ede055b6d267e1586f3886e64eb8b6ca0cff18e71109e92906e510a293c17c69`.
Visibility: `private` (explicit).
Type: `FairycharSecurityProperties`.
No initializer recorded.

## Members

- [securityContextTenantHandler](SecurityAutoConfigurer.RedisSessionConfiguration.TenantConfiguration.securityContextTenantHandler.md#symbol-697f820670480fab) — `function`, source line 243
- [mybatisPlusInterceptor](SecurityAutoConfigurer.RedisSessionConfiguration.TenantConfiguration.mybatisPlusInterceptor.md#symbol-04b0fad1f6df85b7) — `function`, source line 250
- [mybatisPlusInterceptorMarker](SecurityAutoConfigurer.RedisSessionConfiguration.TenantConfiguration.mybatisPlusInterceptorMarker.md#symbol-2c900b360042ca60) — `function`, source line 258
