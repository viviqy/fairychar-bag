# com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.securityAuditObjectHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecurityAutoConfigurer.java.md)

[Lexical owner](SecurityAutoConfigurer.RedisSessionConfiguration.md#symbol-abd4dc8f99b72a20)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d6155292a0527399"></a>
## com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration.securityAuditObjectHandler

```java
@Bean
        @ConditionalOnProperty(name = "fairychar.security.plugins.audit.enable", havingValue = "true")
        SecurityAuditObjectHandler securityAuditObjectHandler()
```

Source: `fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/SecurityAutoConfigurer.java:227`; evidence: `declaration-d6155292a0527399c40b1466013aa87ee30fa9ee0ab2b63a9c224b6322c861f8`.
Owner: `com.fairychar.security.boot.configurer.SecurityAutoConfigurer.RedisSessionConfiguration`; visibility: `package-private` (language default or unknown).
