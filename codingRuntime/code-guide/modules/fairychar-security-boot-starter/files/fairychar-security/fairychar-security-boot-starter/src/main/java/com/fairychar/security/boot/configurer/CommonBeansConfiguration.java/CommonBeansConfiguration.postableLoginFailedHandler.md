# com.fairychar.security.boot.configurer.CommonBeansConfiguration.postableLoginFailedHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../CommonBeansConfiguration.java.md)

[Lexical owner](CommonBeansConfiguration.md#symbol-5624342e4deb0c82)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-434d8df62c5d85e1"></a>
## com.fairychar.security.boot.configurer.CommonBeansConfiguration.postableLoginFailedHandler

```java
@Bean
    @ConditionalOnMissingBean(value = {AuthenticationFailureHandler.class})
    AuthenticationFailureHandler postableLoginFailedHandler()
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/CommonBeansConfiguration.java:51`; evidence: `declaration-434d8df62c5d85e16addfc2bcd883ba5af47b6f96879b18203e0f1cca017b0a6`.
Owner: `com.fairychar.security.boot.configurer.CommonBeansConfiguration`; visibility: `package-private` (language default or unknown).
