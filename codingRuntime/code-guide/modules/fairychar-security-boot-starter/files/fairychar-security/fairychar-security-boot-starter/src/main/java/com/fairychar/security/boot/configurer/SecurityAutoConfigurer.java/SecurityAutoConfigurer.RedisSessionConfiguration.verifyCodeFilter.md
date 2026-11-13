# com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.verifyCodeFilter

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAutoConfigurer.java.md)

[Lexical owner](SecurityAutoConfigurer.RedisSessionConfiguration.md#symbol-abd4dc8f99b72a20)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-c3623c99d3111bc0"></a>
## com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.verifyCodeFilter

```java
@Bean
        @ConditionalOnProperty(value = "fairychar.security.standard.filter.verifyCode.enable", havingValue = "true")
        VerifyCodeFilter verifyCodeFilter(ICodeVerifier codeVerifier)
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:171`; evidence: `declaration-c3623c99d3111bc02f7b8055b6d299a8aba508298c5e9a612bf13f596f249cce`.
Owner: `com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration`; visibility: `package-private` (language default or unknown).
