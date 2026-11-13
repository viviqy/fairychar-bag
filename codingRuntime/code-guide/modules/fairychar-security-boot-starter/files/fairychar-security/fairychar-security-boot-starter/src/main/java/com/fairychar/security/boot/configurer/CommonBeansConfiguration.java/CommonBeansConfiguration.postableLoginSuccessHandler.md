# com.fairychar.security.boot.configurer.CommonBeansConfiguration.postableLoginSuccessHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../CommonBeansConfiguration.java.md)

[Lexical owner](CommonBeansConfiguration.md#symbol-5624342e4deb0c82)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-977f4607ffe34e61"></a>
## com.fairychar.security.boot.configurer.CommonBeansConfiguration.postableLoginSuccessHandler

```java
@Bean
    @ConditionalOnMissingBean(value = {AuthenticationSuccessHandler.class})
    AuthenticationSuccessHandler postableLoginSuccessHandler()
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/CommonBeansConfiguration.java:41`; evidence: `declaration-977f4607ffe34e61975c24ac09154db3700d97b48d6fa45c37abad486cde4e8b`.
Owner: `com.fairychar.security.boot.configurer.CommonBeansConfiguration`; visibility: `package-private` (language default or unknown).
