# com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.jsonAuthenticationFilter

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAutoConfigurer.java.md)

[Lexical owner](SecurityAutoConfigurer.RedisSessionConfiguration.md#symbol-abd4dc8f99b72a20)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9727497485eafb55"></a>
## com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.jsonAuthenticationFilter

```java
@Bean
        @ConditionalOnMissingBean(JsonAuthenticationFilter.class)
        JsonAuthenticationFilter jsonAuthenticationFilter(AuthenticationManager authenticationManager) throws Exception
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:140`; evidence: `declaration-9727497485eafb55aecca09ce57aa92dc1ce572503a721905ef883c37e302589`.
Owner: `com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration`; visibility: `package-private` (language default or unknown).
